//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.21 at 05:19:28 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TielineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TielineXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meteredBus" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType"/>
 *         &lt;element name="meteredArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nonMeteredBus" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType"/>
 *         &lt;element name="nonMeteredArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cirId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TielineXmlType", propOrder = {
    "meteredBus",
    "meteredArea",
    "nonMeteredBus",
    "nonMeteredArea",
    "cirId"
})
public class TielineXmlType {

    @XmlElement(required = true)
    protected IDRefRecordXmlType meteredBus;
    @XmlElement(required = true)
    protected String meteredArea;
    @XmlElement(required = true)
    protected IDRefRecordXmlType nonMeteredBus;
    @XmlElement(required = true)
    protected String nonMeteredArea;
    @XmlElement(required = true)
    protected String cirId;

    /**
     * Gets the value of the meteredBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getMeteredBus() {
        return meteredBus;
    }

    /**
     * Sets the value of the meteredBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setMeteredBus(IDRefRecordXmlType value) {
        this.meteredBus = value;
    }

    /**
     * Gets the value of the meteredArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteredArea() {
        return meteredArea;
    }

    /**
     * Sets the value of the meteredArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteredArea(String value) {
        this.meteredArea = value;
    }

    /**
     * Gets the value of the nonMeteredBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getNonMeteredBus() {
        return nonMeteredBus;
    }

    /**
     * Sets the value of the nonMeteredBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setNonMeteredBus(IDRefRecordXmlType value) {
        this.nonMeteredBus = value;
    }

    /**
     * Gets the value of the nonMeteredArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonMeteredArea() {
        return nonMeteredArea;
    }

    /**
     * Sets the value of the nonMeteredArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonMeteredArea(String value) {
        this.nonMeteredArea = value;
    }

    /**
     * Gets the value of the cirId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCirId() {
        return cirId;
    }

    /**
     * Sets the value of the cirId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCirId(String value) {
        this.cirId = value;
    }

}
