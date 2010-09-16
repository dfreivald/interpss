//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.15 at 05:08:12 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for danamicEventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="danamicEventType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ieee.org/odm/Schema/2008}fault"/>
 *         &lt;element name="permanentFault" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="startTime" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="duration" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "danamicEventType", propOrder = {
    "fault",
    "permanentFault",
    "startTime",
    "duration"
})
public class DanamicEventType {

    @XmlElement(required = true)
    protected AcscFaultXmlType fault;
    protected boolean permanentFault;
    @XmlElement(required = true)
    protected TimePeriodXmlType startTime;
    @XmlElement(required = true)
    protected TimePeriodXmlType duration;
    @XmlAttribute
    protected String id;

    /**
     * Gets the value of the fault property.
     * 
     * @return
     *     possible object is
     *     {@link AcscFaultXmlType }
     *     
     */
    public AcscFaultXmlType getFault() {
        return fault;
    }

    /**
     * Sets the value of the fault property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcscFaultXmlType }
     *     
     */
    public void setFault(AcscFaultXmlType value) {
        this.fault = value;
    }

    /**
     * Gets the value of the permanentFault property.
     * 
     */
    public boolean isPermanentFault() {
        return permanentFault;
    }

    /**
     * Sets the value of the permanentFault property.
     * 
     */
    public void setPermanentFault(boolean value) {
        this.permanentFault = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setStartTime(TimePeriodXmlType value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setDuration(TimePeriodXmlType value) {
        this.duration = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
