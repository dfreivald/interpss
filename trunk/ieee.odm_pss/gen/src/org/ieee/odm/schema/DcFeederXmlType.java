//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.08 at 09:51:23 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		
 * 
 * <p>Java class for DcFeederXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DcFeederXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="r" type="{http://www.ieee.org/odm/Schema/2008}RXmlType"/>
 *         &lt;element name="length" type="{http://www.ieee.org/odm/Schema/2008}LengthXmlType" minOccurs="0"/>
 *         &lt;element name="gage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DcFeederXmlType", propOrder = {
    "r",
    "length",
    "gage"
})
public class DcFeederXmlType {

    @XmlElement(required = true)
    protected RXmlType r;
    protected LengthXmlType length;
    protected String gage;

    /**
     * Gets the value of the r property.
     * 
     * @return
     *     possible object is
     *     {@link RXmlType }
     *     
     */
    public RXmlType getR() {
        return r;
    }

    /**
     * Sets the value of the r property.
     * 
     * @param value
     *     allowed object is
     *     {@link RXmlType }
     *     
     */
    public void setR(RXmlType value) {
        this.r = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link LengthXmlType }
     *     
     */
    public LengthXmlType getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthXmlType }
     *     
     */
    public void setLength(LengthXmlType value) {
        this.length = value;
    }

    /**
     * Gets the value of the gage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGage() {
        return gage;
    }

    /**
     * Sets the value of the gage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGage(String value) {
        this.gage = value;
    }

}
