//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.25 at 11:53:57 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransformerInfoXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransformerInfoXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataOnSystemBase" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="fromRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="toRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="ratedPower" type="{http://www.ieee.org/odm/Schema/2008}ApparentPowerXmlType" minOccurs="0"/>
 *         &lt;element name="fromLossFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="toLossFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="zTableNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformerInfoXmlType", propOrder = {
    "dataOnSystemBase",
    "fromRatedVoltage",
    "toRatedVoltage",
    "ratedPower",
    "fromLossFactor",
    "toLossFactor",
    "zTableNumber"
})
@XmlSeeAlso({
    Transformer3WInfoXmlType.class
})
public class TransformerInfoXmlType {

    protected Boolean dataOnSystemBase;
    protected VoltageXmlType fromRatedVoltage;
    protected VoltageXmlType toRatedVoltage;
    protected ApparentPowerXmlType ratedPower;
    protected Double fromLossFactor;
    protected Double toLossFactor;
    protected Integer zTableNumber;

    /**
     * Gets the value of the dataOnSystemBase property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDataOnSystemBase() {
        return dataOnSystemBase;
    }

    /**
     * Sets the value of the dataOnSystemBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDataOnSystemBase(Boolean value) {
        this.dataOnSystemBase = value;
    }

    /**
     * Gets the value of the fromRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getFromRatedVoltage() {
        return fromRatedVoltage;
    }

    /**
     * Sets the value of the fromRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setFromRatedVoltage(VoltageXmlType value) {
        this.fromRatedVoltage = value;
    }

    /**
     * Gets the value of the toRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getToRatedVoltage() {
        return toRatedVoltage;
    }

    /**
     * Sets the value of the toRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setToRatedVoltage(VoltageXmlType value) {
        this.toRatedVoltage = value;
    }

    /**
     * Gets the value of the ratedPower property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public ApparentPowerXmlType getRatedPower() {
        return ratedPower;
    }

    /**
     * Sets the value of the ratedPower property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public void setRatedPower(ApparentPowerXmlType value) {
        this.ratedPower = value;
    }

    /**
     * Gets the value of the fromLossFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFromLossFactor() {
        return fromLossFactor;
    }

    /**
     * Sets the value of the fromLossFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFromLossFactor(Double value) {
        this.fromLossFactor = value;
    }

    /**
     * Gets the value of the toLossFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getToLossFactor() {
        return toLossFactor;
    }

    /**
     * Sets the value of the toLossFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setToLossFactor(Double value) {
        this.toLossFactor = value;
    }

    /**
     * Gets the value of the zTableNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZTableNumber() {
        return zTableNumber;
    }

    /**
     * Sets the value of the zTableNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZTableNumber(Integer value) {
        this.zTableNumber = value;
    }

}
