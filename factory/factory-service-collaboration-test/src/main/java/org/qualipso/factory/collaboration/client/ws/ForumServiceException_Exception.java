
package org.qualipso.factory.collaboration.client.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "ForumServiceException", targetNamespace = "http://org.qualipso.factory.ws/service/forum-management")
public class ForumServiceException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ForumServiceException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ForumServiceException_Exception(String message, ForumServiceException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ForumServiceException_Exception(String message, ForumServiceException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.qualipso.factory.collaboration.client.ws.ForumServiceException
     */
    public ForumServiceException getFaultInfo() {
        return faultInfo;
    }

}
