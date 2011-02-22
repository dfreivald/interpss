//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.20 at 12:17:33 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StaticLoadModelXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StaticLoadModelXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="staticLoadType" type="{http://www.ieee.org/odm/Schema/2008}StaticLoadModelEnumType"/>
 *         &lt;element name="switchVolt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="switchDeadZone" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StaticLoadModelXmlType", propOrder = {
    "staticLoadType",
    "switchVolt",
    "switchDeadZone"
})
public class StaticLoadModelXmlType {

    @XmlElement(required = true)
    protected StaticLoadModelEnumType staticLoadType;
    protected Double switchVolt;
    protected Double switchDeadZone;

    /**
     * Gets the value of the staticLoadType property.
     * 
     * @return
     *     possible object is
     *     {@link StaticLoadModelEnumType }
     *     
     */
    public StaticLoadModelEnumType getStaticLoadType() {
        return staticLoadType;
    }

    /**
     * Sets the value of the staticLoadType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaticLoadModelEnumType }
     *     
     */
    public void setStaticLoadType(StaticLoadModelEnumType value) {
        this.staticLoadType = value;
    }

    /**
     * Gets the value of the switchVolt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSwitchVolt() {
        return switchVolt;
    }

    /**
     * Sets the value of the switchVolt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSwitchVolt(Double value) {
        this.switchVolt = value;
    }

    /**
     * Gets the value of the switchDeadZone property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSwitchDeadZone() {
        return switchDeadZone;
    }

    /**
     * Sets the value of the switchDeadZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSwitchDeadZone(Double value) {
        this.switchDeadZone = value;
    }

}
