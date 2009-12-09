/*
 * Qualipso Funky Factory
 * Copyright (C) 2006-2010 INRIA
 * http://www.inria.fr - molli@loria.fr
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation. See the GNU
 * Lesser General Public License in LGPL.txt for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *
 * Initial authors :
 *
 * Jérôme Blanchard / INRIA
 * Christophe Bouthier / INRIA
 * Pascal Molli / Nancy Université
 * Gérald Oster / Nancy Université
 */
package org.qualipso.factory.notification;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ws.annotation.EndpointConfig;
import org.jboss.wsf.spi.annotation.WebContext;
import org.qualipso.factory.FactoryException;
import org.qualipso.factory.FactoryNamingConvention;
import org.qualipso.factory.FactoryResource;
import org.qualipso.factory.binding.BindingService;
import org.qualipso.factory.eventqueue.entity.Event;
import org.qualipso.factory.notification.entity.Rule;
import org.qualipso.factory.security.auth.AuthenticationService;
import org.qualipso.factory.security.pap.PAPService;
import org.qualipso.factory.security.pep.PEPService;

/**
 * @author Nicolas HENRY
 * @author Marlène HANTZ
 * @author Jean-François GRAND
 * @author Yiqing LI
 */
@Stateless(name = NotificationService.SERVICE_NAME, mappedName = FactoryNamingConvention.SERVICE_PREFIX + NotificationService.SERVICE_NAME)
@WebService(endpointInterface = "org.qualipso.factory.notification.NotificationService", targetNamespace = FactoryNamingConvention.SERVICE_NAMESPACE
        + NotificationService.SERVICE_NAME, serviceName = NotificationService.SERVICE_NAME)
@WebContext(contextRoot = FactoryNamingConvention.WEB_SERVICE_CORE_MODULE_CONTEXT, urlPattern = FactoryNamingConvention.WEB_SERVICE_URL_PATTERN_PREFIX
        + NotificationService.SERVICE_NAME)
@SOAPBinding(style = Style.RPC)
@SecurityDomain(value = "JBossWSDigest")
@EndpointConfig(configName = "Standard WSSecurity Endpoint")
public class NotificationServiceBean implements NotificationService {

    private static Log logger = LogFactory.getLog(NotificationServiceBean.class);

    private PEPService pep;
    private PAPService pap;
    private BindingService binding;
    private AuthenticationService authentication;
    private SessionContext ctx;
    private EntityManager em;
    @Resource(mappedName = "ConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "queue/EventMessageQueue")
    private static Queue queue;

    public NotificationServiceBean() {
    }

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEntityManager() {
        return this.em;
    }

    @Resource
    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public SessionContext getSessionContext() {
        return this.ctx;
    }

    @EJB
    public void setBindingService(BindingService binding) {
        this.binding = binding;
    }

    public BindingService getBindingService() {
        return this.binding;
    }

    @EJB
    public void setPEPService(PEPService pep) {
        this.pep = pep;
    }

    public PEPService getPEPService() {
        return this.pep;
    }

    @EJB
    public void setPAPService(PAPService pap) {
        this.pap = pap;
    }

    public PAPService getPAPService() {
        return this.pap;
    }

    @EJB
    public void setAuthenticationService(AuthenticationService authentication) {
        this.authentication = authentication;
    }

    public AuthenticationService getAuthenticationService() {
        return this.authentication;
    }

    public static void setConnectionFactory(ConnectionFactory c) {
        connectionFactory = c;
    }

    public static ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public static void setQueue(Queue q) {
        queue = q;
    }

    public static Queue getQueue() {
        return queue;
    }

    @Override
    public FactoryResource findResource(String path) throws FactoryException {
        return null;
    }

    @Override
    public String[] getResourceTypeList() {
        return RESOURCE_TYPE_LIST;
    }

    @Override
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Override
    public void register(String subjectre, String objectre, String targetre, String queuePath) throws NotificationServiceException {
        logger.info("register(...) called");
        if ((subjectre == null) || (objectre == null) || (targetre == null) || (queuePath == null))
            throw new NotificationServiceException("Incorrect arg, should not be null");
        Rule[] tmp = list();
        if (tmp.length != 0) {
            for (int i = 0; i < tmp.length; i++) {
                if ((tmp[i].getObjectre().equals(objectre)) && (tmp[i].getQueuePath().equals(queuePath)) && (tmp[i].getSubjectre().equals(subjectre))
                        && (tmp[i].getTargetre().equals(targetre)))
                    throw new NotificationServiceException("Resource already exists in base");
            }
        }
        Rule r = new Rule();
        r.setSubjectre(subjectre);
        r.setObjectre(objectre);
        r.setTargetre(targetre);
        r.setQueuePath(queuePath);
        r.setId(UUID.randomUUID().toString());
        em.persist(r);
    }

    @Override
    public void unregister(String subjectre, String objectre, String targetre, String queuePath) throws NotificationServiceException {
        if ((subjectre == null) || (objectre == null) || (targetre == null) || (queuePath == null))
            throw new NotificationServiceException("Incorrect arg, should not be null");
        Query q = em.createQuery("delete from Rule where subjectre=:subjectre and objectre=:objectre and targetre=:targetre and queuePath=:queuePath");
        q.setParameter("subjectre", subjectre);
        q.setParameter("objectre", objectre);
        q.setParameter("targetre", targetre);
        q.setParameter("queuePath", queuePath);
        int n = q.executeUpdate();
        if (n != 1) {
            logger.warn("can't unregister " + subjectre + "/" + objectre + "/" + queuePath);
        }
    }

    @Override
    public void throwEvent(Event event) throws NotificationServiceException {
        logger.info("throwEvent(Event event) called");
        if (event == null)
            throw new NotificationServiceException("impossible to throw a null event");
        Connection connection;
        try {
            connection = connectionFactory.createConnection();
            Session session = (Session) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            ObjectMessage om = session.createObjectMessage();
            om.setObject(event);
            MessageProducer messageProducer = session.createProducer(queue);
            messageProducer.send(om);
            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            logger.error("unable to throw event", e);
            throw new NotificationServiceException("unable to throw event", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Rule[] list() throws NotificationServiceException {
        logger.debug("list() called");
        Query q = em.createQuery("select r from Rule r");
        List<Rule> l = q.getResultList();
        Rule[] tab = new Rule[l.size()];
        tab = l.toArray(tab);
        return tab;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Rule[] listMatchingBy(String subject, String object, String target, String queue) throws NotificationServiceException {

        logger.debug("list(String subject, String object, String target, String queue) called");

        if ((subject == null) && (object == null) && (target == null) && (queue == null))
            throw new NotificationServiceException("Incorrect args, all args are null");
        /*
         * StringBuffer query = new StringBuffer("SELECT r FROM Rule r WHERE ");
         * 
         * List<String> argsTitle = new ArrayList<String>();
         * argsTitle.add("subjectre"); argsTitle.add("objectre");
         * argsTitle.add("targetre"); argsTitle.add("queuePath");
         * 
         * List<String> args = new ArrayList<String>(); args.add(subject);
         * args.add(object); args.add(target); args.add(queue);
         * 
         * boolean first = true;
         * 
         * for (String arg : args) { if (arg != null) if (!first)
         * query.append("AND "); query.append("r." +
         * argsTitle.get(args.indexOf(arg)) + " = " + arg + " "); first = false;
         * } Query q = em.createQuery(query.toString());
         */
        Query q = em.createQuery("SELECT r FROM Rule r WHERE r.subjectre=:subjectre AND r.objectre=:objectre AND r.targetre=:targetre AND r.queuePath =:queue");
        q.setParameter("subjectre", subject);
        q.setParameter("objectre", object);
        q.setParameter("targetre", target);
        q.setParameter("queue", queue);
        List<Rule> l = q.getResultList();
        Rule[] tab = new Rule[l.size()];
        tab = l.toArray(tab);
        return tab;

    }

    @Override
    public Rule[] listRE(String subjectre, String objectre, String targetre, String queuere) throws NotificationServiceException {
        // TODO or to remove
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Rule[] listByQueue(String queue) throws NotificationServiceException {
        logger.debug("listByQueue(String queue) called");
        if (queue == null)
            throw new NotificationServiceException("Incorrect arg, targetre should not be null");
        // Query q = em.createQuery("SELECT r FROM Rule r WHERE r.queuePath =" +
        // queue);
        Query q = em.createQuery("SELECT r FROM Rule r WHERE r.queuePath =:queue");
        q.setParameter("queue", queue);
        List<Rule> l = q.getResultList();
        Rule[] tab = new Rule[l.size()];
        tab = l.toArray(tab);
        return tab;
    }

    @Override
    public Rule[] listByQueueRE(String queuere) throws NotificationServiceException {
        // TODO or to remove
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Rule[] listBySubjectRE(String subject) throws NotificationServiceException {
        logger.debug("listBySubject(String subject) called");
        if (subject == null)
            throw new NotificationServiceException("Incorrect arg, subject should not be null");
        // Query q = em.createQuery("SELECT r FROM Rule r WHERE r.subjectre = "
        // + subject);
        Query q = em.createQuery("SELECT r FROM Rule r WHERE r.subjectre =:subject");
        q.setParameter("subject", subject);
        List<Rule> l = q.getResultList();
        Rule[] tab = new Rule[l.size()];
        tab = l.toArray(tab);
        return tab;
    }

    @Override
    public Rule[] listBySubject(String subjectre) throws NotificationServiceException {
        // TODO or to remove
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Rule[] listByObjectRE(String object) throws NotificationServiceException {
        logger.debug("listByObject(String object) called");
        if (object == null)
            throw new NotificationServiceException("Incorrect arg, object should not be null");
        // Query q = em.createQuery("SELECT r FROM Rule r WHERE r.objectre = " +
        // object);
        Query q = em.createQuery("SELECT r FROM Rule r WHERE r.objectre =:object");
        q.setParameter("object", object);
        List<Rule> l = q.getResultList();
        Rule[] tab = new Rule[l.size()];
        tab = l.toArray(tab);
        return tab;
    }

    @Override
    public Rule[] listByObject(String objectre) throws NotificationServiceException {
        logger.debug("listByObjectRE(String objectre) called");
        // TODO or to remove
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Rule[] listByTargetRE(String target) throws NotificationServiceException {
        logger.debug("listByTarget(String target) called");
        if (target == null)
            throw new NotificationServiceException("Incorrect arg, target should not be null");
        // Query q = em.createQuery("SELECT r FROM Rule r WHERE r.targetre = " +
        // target);
        Query q = em.createQuery("SELECT r FROM Rule r WHERE r.targetre =:target");
        q.setParameter("target", target);
        List<Rule> l = q.getResultList();
        Rule[] tab = new Rule[l.size()];
        tab = l.toArray(tab);
        return tab;
    }

    @Override
    public Rule[] listByTarget(String targetre) throws NotificationServiceException {
        // TODO or to remove
        return null;
    }
}
