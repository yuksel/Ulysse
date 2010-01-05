
package org.qualipso.factory.git.client.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "git", targetNamespace = "http://org.qualipso.factory.ws/service/git", wsdlLocation = "http://localhost:8080/factory-git/git?wsdl")
public class Git_Service
    extends Service
{

    private final static URL GIT_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(org.qualipso.factory.git.client.ws.Git_Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = org.qualipso.factory.git.client.ws.Git_Service.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/factory-git/git?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/factory-git/git?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        GIT_WSDL_LOCATION = url;
    }

    public Git_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Git_Service() {
        super(GIT_WSDL_LOCATION, new QName("http://org.qualipso.factory.ws/service/git", "git"));
    }

    /**
     * 
     * @return
     *     returns Git
     */
    @WebEndpoint(name = "GITServiceBeanPort")
    public Git getGITServiceBeanPort() {
        return super.getPort(new QName("http://org.qualipso.factory.ws/service/git", "GITServiceBeanPort"), Git.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Git
     */
    @WebEndpoint(name = "GITServiceBeanPort")
    public Git getGITServiceBeanPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://org.qualipso.factory.ws/service/git", "GITServiceBeanPort"), Git.class, features);
    }

}