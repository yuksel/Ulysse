
package org.factory.qualipso.service.skillmanagement.org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ControlTopEnableResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "controlTopEnableResult"
})
@XmlRootElement(name = "ControlTopEnableResponse")
public class ControlTopEnableResponse {

    @XmlElement(name = "ControlTopEnableResult")
    protected int controlTopEnableResult;

    /**
     * Gets the value of the controlTopEnableResult property.
     * 
     */
    public int getControlTopEnableResult() {
        return controlTopEnableResult;
    }

    /**
     * Sets the value of the controlTopEnableResult property.
     * 
     */
    public void setControlTopEnableResult(int value) {
        this.controlTopEnableResult = value;
    }

}
