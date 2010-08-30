//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.29 at 07:17:30 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TurbineGovernorXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TurbineGovernorXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="locatedBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="busRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="turbineGovernorType" type="{http://www.ieee.org/odm/Schema/2008}TurbineGovernorEnumType"/>
 *         &lt;element name="turbineGovernorModel" type="{http://www.ieee.org/odm/Schema/2008}GovernorModelXmlType"/>
 *         &lt;element name="tgId" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TurbineGovernorXmlType", propOrder = {
    "locatedBus",
    "busRatedVoltage",
    "turbineGovernorType",
    "turbineGovernorModel",
    "tgId"
})
public class TurbineGovernorXmlType {

    @XmlElement(required = true)
    protected IDRefRecordXmlType locatedBus;
    protected VoltageXmlType busRatedVoltage;
    @XmlElement(required = true)
    protected TurbineGovernorEnumType turbineGovernorType;
    @XmlElement(required = true)
    protected GovernorModelXmlType turbineGovernorModel;
    protected IDRefRecordXmlType tgId;

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
     * Gets the value of the turbineGovernorType property.
     * 
     * @return
     *     possible object is
     *     {@link TurbineGovernorEnumType }
     *     
     */
    public TurbineGovernorEnumType getTurbineGovernorType() {
        return turbineGovernorType;
    }

    /**
     * Sets the value of the turbineGovernorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurbineGovernorEnumType }
     *     
     */
    public void setTurbineGovernorType(TurbineGovernorEnumType value) {
        this.turbineGovernorType = value;
    }

    /**
     * Gets the value of the turbineGovernorModel property.
     * 
     * @return
     *     possible object is
     *     {@link GovernorModelXmlType }
     *     
     */
    public GovernorModelXmlType getTurbineGovernorModel() {
        return turbineGovernorModel;
    }

    /**
     * Sets the value of the turbineGovernorModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovernorModelXmlType }
     *     
     */
    public void setTurbineGovernorModel(GovernorModelXmlType value) {
        this.turbineGovernorModel = value;
    }

    /**
     * Gets the value of the tgId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getTgId() {
        return tgId;
    }

    /**
     * Sets the value of the tgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setTgId(IDRefRecordXmlType value) {
        this.tgId = value;
    }

}
