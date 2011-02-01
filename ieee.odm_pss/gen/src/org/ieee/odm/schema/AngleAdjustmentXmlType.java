//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.31 at 09:52:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AngleAdjustmentXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AngleAdjustmentXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}AdjustmentDataXmlType">
 *       &lt;sequence>
 *         &lt;element name="angleLimit" type="{http://www.ieee.org/odm/Schema/2008}AngleLimitXmlType"/>
 *         &lt;element name="angleAdjOnFromSide" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="desiredPowerUnit" type="{http://www.ieee.org/odm/Schema/2008}ActivePowerUnitType"/>
 *         &lt;element name="desiredMeasuredOnFromSide" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="offLine" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AngleAdjustmentXmlType", propOrder = {
    "angleLimit",
    "angleAdjOnFromSide",
    "desiredPowerUnit",
    "desiredMeasuredOnFromSide"
})
public class AngleAdjustmentXmlType
    extends AdjustmentDataXmlType
{

    @XmlElement(required = true)
    protected AngleLimitXmlType angleLimit;
    protected boolean angleAdjOnFromSide;
    @XmlElement(required = true)
    protected ActivePowerUnitType desiredPowerUnit;
    protected boolean desiredMeasuredOnFromSide;
    @XmlAttribute(required = true)
    protected boolean offLine;

    /**
     * Gets the value of the angleLimit property.
     * 
     * @return
     *     possible object is
     *     {@link AngleLimitXmlType }
     *     
     */
    public AngleLimitXmlType getAngleLimit() {
        return angleLimit;
    }

    /**
     * Sets the value of the angleLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleLimitXmlType }
     *     
     */
    public void setAngleLimit(AngleLimitXmlType value) {
        this.angleLimit = value;
    }

    /**
     * Gets the value of the angleAdjOnFromSide property.
     * 
     */
    public boolean isAngleAdjOnFromSide() {
        return angleAdjOnFromSide;
    }

    /**
     * Sets the value of the angleAdjOnFromSide property.
     * 
     */
    public void setAngleAdjOnFromSide(boolean value) {
        this.angleAdjOnFromSide = value;
    }

    /**
     * Gets the value of the desiredPowerUnit property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePowerUnitType }
     *     
     */
    public ActivePowerUnitType getDesiredPowerUnit() {
        return desiredPowerUnit;
    }

    /**
     * Sets the value of the desiredPowerUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePowerUnitType }
     *     
     */
    public void setDesiredPowerUnit(ActivePowerUnitType value) {
        this.desiredPowerUnit = value;
    }

    /**
     * Gets the value of the desiredMeasuredOnFromSide property.
     * 
     */
    public boolean isDesiredMeasuredOnFromSide() {
        return desiredMeasuredOnFromSide;
    }

    /**
     * Sets the value of the desiredMeasuredOnFromSide property.
     * 
     */
    public void setDesiredMeasuredOnFromSide(boolean value) {
        this.desiredMeasuredOnFromSide = value;
    }

    /**
     * Gets the value of the offLine property.
     * 
     */
    public boolean isOffLine() {
        return offLine;
    }

    /**
     * Sets the value of the offLine property.
     * 
     */
    public void setOffLine(boolean value) {
        this.offLine = value;
    }

}
