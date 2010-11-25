//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.24 at 04:45:37 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PSXfr3WBranchXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSXfr3WBranchXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}Xfr3WBranchXmlType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.ieee.org/odm/Schema/2008}PSXfrInfoGroup"/>
 *         &lt;element name="tertShiftAngle" type="{http://www.ieee.org/odm/Schema/2008}AngleXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSXfr3WBranchXmlType", propOrder = {
    "fromAngle",
    "toAngle",
    "angleAdjustment",
    "tertShiftAngle"
})
@XmlSeeAlso({
    PSXfr3WShortCircuitXmlType.class
})
public class PSXfr3WBranchXmlType
    extends Xfr3WBranchXmlType
{

    protected AngleXmlType fromAngle;
    protected AngleXmlType toAngle;
    protected AngleAdjustmentXmlType angleAdjustment;
    protected AngleXmlType tertShiftAngle;

    /**
     * Gets the value of the fromAngle property.
     * 
     * @return
     *     possible object is
     *     {@link AngleXmlType }
     *     
     */
    public AngleXmlType getFromAngle() {
        return fromAngle;
    }

    /**
     * Sets the value of the fromAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleXmlType }
     *     
     */
    public void setFromAngle(AngleXmlType value) {
        this.fromAngle = value;
    }

    /**
     * Gets the value of the toAngle property.
     * 
     * @return
     *     possible object is
     *     {@link AngleXmlType }
     *     
     */
    public AngleXmlType getToAngle() {
        return toAngle;
    }

    /**
     * Sets the value of the toAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleXmlType }
     *     
     */
    public void setToAngle(AngleXmlType value) {
        this.toAngle = value;
    }

    /**
     * Gets the value of the angleAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link AngleAdjustmentXmlType }
     *     
     */
    public AngleAdjustmentXmlType getAngleAdjustment() {
        return angleAdjustment;
    }

    /**
     * Sets the value of the angleAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleAdjustmentXmlType }
     *     
     */
    public void setAngleAdjustment(AngleAdjustmentXmlType value) {
        this.angleAdjustment = value;
    }

    /**
     * Gets the value of the tertShiftAngle property.
     * 
     * @return
     *     possible object is
     *     {@link AngleXmlType }
     *     
     */
    public AngleXmlType getTertShiftAngle() {
        return tertShiftAngle;
    }

    /**
     * Sets the value of the tertShiftAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleXmlType }
     *     
     */
    public void setTertShiftAngle(AngleXmlType value) {
        this.tertShiftAngle = value;
    }

}
