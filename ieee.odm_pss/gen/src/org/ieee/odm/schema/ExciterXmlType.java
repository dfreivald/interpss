//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.19 at 08:45:15 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExciterXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExciterXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="locatedBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="busRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="exciterType" type="{http://www.ieee.org/odm/Schema/2008}ExciterEnumType"/>
 *         &lt;element name="exciterModel" type="{http://www.ieee.org/odm/Schema/2008}ExciterModelXmlType"/>
 *         &lt;element name="excId" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExciterXmlType", propOrder = {
    "locatedBus",
    "busRatedVoltage",
    "exciterType",
    "exciterModel",
    "excId"
})
public class ExciterXmlType {

    @XmlElement(required = true)
    protected IDRefRecordXmlType locatedBus;
    protected VoltageXmlType busRatedVoltage;
    @XmlElement(required = true)
    protected ExciterEnumType exciterType;
    @XmlElement(required = true)
    protected ExciterModelXmlType exciterModel;
    protected IDRefRecordXmlType excId;

    /**
     * Gets the value of the locatedBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getLocatedBus() {
        return locatedBus;
    }

    /**
     * Sets the value of the locatedBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setLocatedBus(IDRefRecordXmlType value) {
        this.locatedBus = value;
    }

    /**
     * Gets the value of the busRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getBusRatedVoltage() {
        return busRatedVoltage;
    }

    /**
     * Sets the value of the busRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setBusRatedVoltage(VoltageXmlType value) {
        this.busRatedVoltage = value;
    }

    /**
     * Gets the value of the exciterType property.
     * 
     * @return
     *     possible object is
     *     {@link ExciterEnumType }
     *     
     */
    public ExciterEnumType getExciterType() {
        return exciterType;
    }

    /**
     * Sets the value of the exciterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExciterEnumType }
     *     
     */
    public void setExciterType(ExciterEnumType value) {
        this.exciterType = value;
    }

    /**
     * Gets the value of the exciterModel property.
     * 
     * @return
     *     possible object is
     *     {@link ExciterModelXmlType }
     *     
     */
    public ExciterModelXmlType getExciterModel() {
        return exciterModel;
    }

    /**
     * Sets the value of the exciterModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExciterModelXmlType }
     *     
     */
    public void setExciterModel(ExciterModelXmlType value) {
        this.exciterModel = value;
    }

    /**
     * Gets the value of the excId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getExcId() {
        return excId;
    }

    /**
     * Sets the value of the excId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setExcId(IDRefRecordXmlType value) {
        this.excId = value;
    }

}
