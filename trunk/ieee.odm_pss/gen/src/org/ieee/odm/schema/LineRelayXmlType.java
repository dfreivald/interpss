//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.11 at 06:23:56 PM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LineRelayXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LineRelayXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lineRelayType" type="{http://www.ieee.org/odm/Schema}LineRelayEnumType"/>
 *         &lt;element name="lineRelayModel" type="{http://www.ieee.org/odm/Schema}LineRelayModelListXmlType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineRelayXmlType", propOrder = {
    "lineRelayType",
    "lineRelayModel"
})
public class LineRelayXmlType {

    @XmlElement(required = true)
    protected LineRelayEnumType lineRelayType;
    @XmlElement(required = true)
    protected LineRelayModelListXmlType lineRelayModel;

    /**
     * Gets the value of the lineRelayType property.
     * 
     * @return
     *     possible object is
     *     {@link LineRelayEnumType }
     *     
     */
    public LineRelayEnumType getLineRelayType() {
        return lineRelayType;
    }

    /**
     * Sets the value of the lineRelayType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineRelayEnumType }
     *     
     */
    public void setLineRelayType(LineRelayEnumType value) {
        this.lineRelayType = value;
    }

    /**
     * Gets the value of the lineRelayModel property.
     * 
     * @return
     *     possible object is
     *     {@link LineRelayModelListXmlType }
     *     
     */
    public LineRelayModelListXmlType getLineRelayModel() {
        return lineRelayModel;
    }

    /**
     * Sets the value of the lineRelayModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineRelayModelListXmlType }
     *     
     */
    public void setLineRelayModel(LineRelayModelListXmlType value) {
        this.lineRelayModel = value;
    }

}
