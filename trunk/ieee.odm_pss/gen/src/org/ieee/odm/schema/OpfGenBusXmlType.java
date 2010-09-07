//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.06 at 05:03:11 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for OpfGenBusXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpfGenBusXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}LoadflowBusXmlType">
 *       &lt;sequence>
 *         &lt;element name="coeffA" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="coeffB" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="capacityLimit" type="{http://www.ieee.org/odm/Schema/2008}ActivePowerLimitXmlType"/>
 *         &lt;element name="fixedCost" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpfGenBusXmlType", propOrder = {
    "coeffA",
    "coeffB",
    "capacityLimit",
    "fixedCost"
})
public class OpfGenBusXmlType
    extends LoadflowBusXmlType
{

    protected double coeffA;
    protected double coeffB;
    @XmlElement(required = true)
    protected ActivePowerLimitXmlType capacityLimit;
    protected double fixedCost;

    /**
     * Gets the value of the coeffA property.
     * 
     */
    public double getCoeffA() {
        return coeffA;
    }

    /**
     * Sets the value of the coeffA property.
     * 
     */
    public void setCoeffA(double value) {
        this.coeffA = value;
    }

    /**
     * Gets the value of the coeffB property.
     * 
     */
    public double getCoeffB() {
        return coeffB;
    }

    /**
     * Sets the value of the coeffB property.
     * 
     */
    public void setCoeffB(double value) {
        this.coeffB = value;
    }

    /**
     * Gets the value of the capacityLimit property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePowerLimitXmlType }
     *     
     */
    public ActivePowerLimitXmlType getCapacityLimit() {
        return capacityLimit;
    }

    /**
     * Sets the value of the capacityLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePowerLimitXmlType }
     *     
     */
    public void setCapacityLimit(ActivePowerLimitXmlType value) {
        this.capacityLimit = value;
    }

    /**
     * Gets the value of the fixedCost property.
     * 
     */
    public double getFixedCost() {
        return fixedCost;
    }

    /**
     * Sets the value of the fixedCost property.
     * 
     */
    public void setFixedCost(double value) {
        this.fixedCost = value;
    }

}
