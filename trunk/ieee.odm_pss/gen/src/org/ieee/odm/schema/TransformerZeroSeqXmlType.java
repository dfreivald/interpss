//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.05 at 07:28:10 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransformerZeroSeqXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransformerZeroSeqXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="conectionLocation" type="{http://www.ieee.org/odm/Schema/2008}XfrZeroSeqConnectLocationEnumType"/>
 *         &lt;element name="zG" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="z1" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="z2" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="z3" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformerZeroSeqXmlType", propOrder = {
    "conectionLocation",
    "zg",
    "z1",
    "z2",
    "z3"
})
public class TransformerZeroSeqXmlType {

    @XmlElement(required = true)
    protected XfrZeroSeqConnectLocationEnumType conectionLocation;
    @XmlElement(name = "zG")
    protected ZXmlType zg;
    protected ZXmlType z1;
    protected ZXmlType z2;
    protected ZXmlType z3;

    /**
     * Gets the value of the conectionLocation property.
     * 
     * @return
     *     possible object is
     *     {@link XfrZeroSeqConnectLocationEnumType }
     *     
     */
    public XfrZeroSeqConnectLocationEnumType getConectionLocation() {
        return conectionLocation;
    }

    /**
     * Sets the value of the conectionLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XfrZeroSeqConnectLocationEnumType }
     *     
     */
    public void setConectionLocation(XfrZeroSeqConnectLocationEnumType value) {
        this.conectionLocation = value;
    }

    /**
     * Gets the value of the zg property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZG() {
        return zg;
    }

    /**
     * Sets the value of the zg property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZG(ZXmlType value) {
        this.zg = value;
    }

    /**
     * Gets the value of the z1 property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ1() {
        return z1;
    }

    /**
     * Sets the value of the z1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ1(ZXmlType value) {
        this.z1 = value;
    }

    /**
     * Gets the value of the z2 property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ2() {
        return z2;
    }

    /**
     * Sets the value of the z2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ2(ZXmlType value) {
        this.z2 = value;
    }

    /**
     * Gets the value of the z3 property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ3() {
        return z3;
    }

    /**
     * Sets the value of the z3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ3(ZXmlType value) {
        this.z3 = value;
    }

}
