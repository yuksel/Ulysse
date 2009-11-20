package org.qualipso.factory.indexing;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.jboss.ejb3.annotation.Depends;
import org.jboss.ejb3.annotation.SecurityDomain;
import org.qualipso.factory.FactoryResourceIdentifier;
import org.qualipso.factory.FactoryService;

@MessageDriven(mappedName = "queue/IndexingeQueue", activationConfig = {
	@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/IndexingQueue"),
	@ActivationConfigProperty(propertyName = "messagingType", propertyValue = "javax.jms.MessageListener") })
@Depends ("jboss.mq.destination:service=Queue,name=IndexingQueue")
@SecurityDomain(value = "JBossWSDigest")


public class IndexingMessageBean implements MessageListener{
	
	@Resource
    private MessageDrivenContext ctx;
	
	private Index index;
	
	public void onMessage(Message msg){
		try{
			if (msg.propertyExists("fri")&&msg.propertyExists("action")){
				FactoryResourceIdentifier fri = FactoryResourceIdentifier.deserialize(msg.getStringProperty("fri"));
				if(msg.getStringProperty("action").equals("index"))
					this.index(fri);
				if(msg.getStringProperty("action").equals("reindex"))
					this.reindex(fri);
				if(msg.getStringProperty("action").equals("remove"))
					this.remove(fri);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	private void index(FactoryResourceIdentifier fri) throws IndexingServiceException {
		index.index(toIndexableDocument(fri));
		
	}

	private void reindex(FactoryResourceIdentifier fri) throws IndexingServiceException {
		index.reindex(fri, toIndexableDocument(fri));
		
	}

	private void remove(FactoryResourceIdentifier fri) throws IndexingServiceException {
		index.remove(fri);	
		
	}
	private FactoryService getService(FactoryResourceIdentifier fri) throws IndexingServiceException{
		FactoryService fs = (FactoryService)ctx.lookup(fri.getService());
		if (fs == null)
			throw new IndexingServiceException("Unable to locate Service "+fri.getService());
		else
			return fs;
	}
	private IndexableDocument toIndexableDocument(FactoryResourceIdentifier fri) throws IndexingServiceException{
		FactoryService fs = this.getService(fri);
		String resourceFRI = fri.toString();
		String resourceService = fri.getService();
		String resourceType  = fri.getType();
		String resourceShortName = fri.getId();
		
		
		//TODO
		//	this implem need to be replace by the following
		
		//real
		//this one mean that toIndexableContent must be in the interface
		//FactoryService
		//IndexableContent indexableContent = fs.toIndexableContent(fri);
		
		
		//dummy implem
		IndexableContent indexableContent = new IndexableContent();
		IndexableDocument doc = new IndexableDocument();
		doc.setIndexableContent(indexableContent);
		doc.setResourceService(resourceService);
		doc.setResourceShortName(resourceShortName);
		doc.setResourceType(resourceType);
		doc.setResourceFRI(resourceFRI);
		return doc;
	}


}
