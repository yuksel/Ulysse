
package org.qualipso.factory.client.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "BrowserService", targetNamespace = "http://org.qualipso.factory.ws/service/browser")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BrowserService {


    /**
     * 
     * @param path
     * @return
     *     returns org.qualipso.factory.client.ws.FactoryResource
     * @throws BrowserServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "resource", partName = "resource")
    public FactoryResource findResource(
        @WebParam(name = "path", partName = "path")
        String path)
        throws BrowserServiceException_Exception
    ;

    /**
     * 
     * @return
     *     returns org.qualipso.factory.client.ws.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    public StringArray getResourceTypeList();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    public String getServiceName();

    /**
     * 
     * @param path
     * @return
     *     returns boolean
     * @throws BrowserServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "has-children", partName = "has-children")
    public boolean hasChildren(
        @WebParam(name = "path", partName = "path")
        String path)
        throws BrowserServiceException_Exception
    ;

    /**
     * 
     * @param path
     * @return
     *     returns org.qualipso.factory.client.ws.StringArray
     * @throws BrowserServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "children", partName = "children")
    public StringArray listChildren(
        @WebParam(name = "path", partName = "path")
        String path)
        throws BrowserServiceException_Exception
    ;

    /**
     * 
     * @param typePattern
     * @param path
     * @param servicePattern
     * @return
     *     returns org.qualipso.factory.client.ws.StringArray
     * @throws BrowserServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "children", partName = "children")
    public StringArray listChildrenOfType(
        @WebParam(name = "path", partName = "path")
        String path,
        @WebParam(name = "service-pattern", partName = "service-pattern")
        String servicePattern,
        @WebParam(name = "type-pattern", partName = "type-pattern")
        String typePattern)
        throws BrowserServiceException_Exception
    ;

}
