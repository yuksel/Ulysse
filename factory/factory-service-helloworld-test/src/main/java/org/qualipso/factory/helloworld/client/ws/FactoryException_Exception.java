
package org.qualipso.factory.helloworld.client.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "FactoryException", targetNamespace = "http://org.qualipso.factory.ws/service/helloworld")
public class FactoryException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private FactoryException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public FactoryException_Exception(String message, FactoryException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public FactoryException_Exception(String message, FactoryException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.qualipso.factory.helloworld.client.ws.FactoryException
     */
    public FactoryException getFaultInfo() {
        return faultInfo;
    }

}
