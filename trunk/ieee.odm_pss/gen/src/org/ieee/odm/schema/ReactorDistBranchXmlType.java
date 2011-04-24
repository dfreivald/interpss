//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.24 at 04:05:23 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReactorDistBranchXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReactorDistBranchXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}DistBranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="x" type="{http://www.ieee.org/odm/Schema/2008}XXmlType"/>
 *         &lt;element name="ratedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType"/>
 *         &lt;element name="ratedAmp" type="{http://www.ieee.org/odm/Schema/2008}CurrentXmlType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReactorDistBranchXmlType", propOrder = {
    "x",
    "ratedVoltage",
    "ratedAmp"
})
public class ReactorDistBranchXmlType
    extends DistBranchXmlType
{

    @XmlElement(required = true)
    protected XXmlType x;
    @XmlElement(required = true)
    protected VoltageXmlType ratedVoltage;
    @XmlElement(required = true)
    protected CurrentXmlType ratedAmp;

    /**
     * Gets the value of the x property.
     * 
     * @return
     *     possible object is
     *     {@link XXmlType }
     *     
     */
    public XXmlType getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     * 
     * @param value
     *     allowed object is
     *     {@link XXmlType }
     *     
     */
    public void setX(XXmlType value) {
        this.x = value;
    }

    /**
     * Gets the value of the ratedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getRatedVoltage() {
        return ratedVoltage;
    }

    /**
     * Sets the value of the ratedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setRatedVoltage(VoltageXmlType value) {
        this.ratedVoltage = value;
    }

    /**
     * Gets the value of the ratedAmp property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentXmlType }
     *     
     */
    public CurrentXmlType getRatedAmp() {
        return ratedAmp;
    }

    /**
     * Sets the value of the ratedAmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentXmlType }
     *     
     */
    public void setRatedAmp(CurrentXmlType value) {
        this.ratedAmp = value;
    }

}
