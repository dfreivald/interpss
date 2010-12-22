//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.21 at 03:20:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * There are two adj modes: ValueAdjustment and RangeAdjustment. For ValueAdjustment, the desiredValue is used. For RangeAdjustment,
 * 				max and min are used.
 * 
 * <p>Java class for AdjustmentDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdjustmentDataXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}LimitXmlType">
 *       &lt;attribute name="mode" use="required" type="{http://www.ieee.org/odm/Schema/2008}AdjustmentModeEnumType" />
 *       &lt;attribute name="desiredValue" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdjustmentDataXmlType")
@XmlSeeAlso({
    AngleAdjustmentXmlType.class,
    org.ieee.odm.schema.TapAdjustmentXmlType.VoltageAdjData.class,
    org.ieee.odm.schema.TapAdjustmentXmlType.MvarFlowAdjData.class
})
public class AdjustmentDataXmlType
    extends LimitXmlType
{

    @XmlAttribute(required = true)
    protected AdjustmentModeEnumType mode;
    @XmlAttribute(required = true)
    protected double desiredValue;

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link AdjustmentModeEnumType }
     *     
     */
    public AdjustmentModeEnumType getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdjustmentModeEnumType }
     *     
     */
    public void setMode(AdjustmentModeEnumType value) {
        this.mode = value;
    }

    /**
     * Gets the value of the desiredValue property.
     * 
     */
    public double getDesiredValue() {
        return desiredValue;
    }

    /**
     * Sets the value of the desiredValue property.
     * 
     */
    public void setDesiredValue(double value) {
        this.desiredValue = value;
    }

}
