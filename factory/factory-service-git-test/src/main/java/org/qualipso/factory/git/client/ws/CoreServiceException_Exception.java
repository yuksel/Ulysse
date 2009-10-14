
package org.qualipso.factory.git.client.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "CoreServiceException", targetNamespace = "http://org.qualipso.factory.ws/service/core")
public class CoreServiceException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CoreServiceException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public CoreServiceException_Exception(String message, CoreServiceException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public CoreServiceException_Exception(String message, CoreServiceException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.qualipso.factory.git.client.ws.CoreServiceException
     */
    public CoreServiceException getFaultInfo() {
        return faultInfo;
    }

}
