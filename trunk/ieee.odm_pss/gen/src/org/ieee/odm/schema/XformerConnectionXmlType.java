//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.06 at 05:03:11 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XformerConnectionXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XformerConnectionXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grounding" type="{http://www.ieee.org/odm/Schema/2008}GroundingXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="connection" use="required" type="{http://www.ieee.org/odm/Schema/2008}XformrtConnectionEnumType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XformerConnectionXmlType", propOrder = {
    "grounding"
})
public class XformerConnectionXmlType {

    protected GroundingXmlType grounding;
    @XmlAttribute(required = true)
    protected XformrtConnectionEnumType connection;

    /**
     * Gets the value of the grounding property.
     * 
     * @return
     *     possible object is
     *     {@link GroundingXmlType }
     *     
     */
    public GroundingXmlType getGrounding() {
        return grounding;
    }

    /**
     * Sets the value of the grounding property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroundingXmlType }
     *     
     */
    public void setGrounding(GroundingXmlType value) {
        this.grounding = value;
    }

    /**
     * Gets the value of the connection property.
     * 
     * @return
     *     possible object is
     *     {@link XformrtConnectionEnumType }
     *     
     */
    public XformrtConnectionEnumType getConnection() {
        return connection;
    }

    /**
     * Sets the value of the connection property.
     * 
     * @param value
     *     allowed object is
     *     {@link XformrtConnectionEnumType }
     *     
     */
    public void setConnection(XformrtConnectionEnumType value) {
        this.connection = value;
    }

}
