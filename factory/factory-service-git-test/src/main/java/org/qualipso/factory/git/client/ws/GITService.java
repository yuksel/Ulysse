
package org.qualipso.factory.git.client.ws;

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
@WebService(name = "GITService", targetNamespace = "http://org.qualipso.factory.ws/service/git")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GITService {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws GITServiceException_Exception
     */
    @WebMethod
    public void createGITRepository(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2)
        throws GITServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws GITServiceException_Exception
     */
    @WebMethod
    public void deleteGITRepository(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws GITServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.git.client.ws.FactoryResource
     * @throws FactoryException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public FactoryResource findResource(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws FactoryException_Exception
    ;

    /**
     * 
     * @return
     *     returns org.qualipso.factory.git.client.ws.StringArray
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
     * @param arg0
     * @return
     *     returns org.qualipso.factory.git.client.ws.GITRepository
     * @throws GITServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "git-repository", partName = "git-repository")
    public GITRepository readGITRepository(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws GITServiceException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws GITServiceException_Exception
     */
    @WebMethod
    public void updateGITREpository(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2)
        throws GITServiceException_Exception
    ;

}
