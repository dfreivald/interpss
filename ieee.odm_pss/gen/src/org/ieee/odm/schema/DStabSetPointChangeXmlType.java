//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.23 at 07:20:34 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DStabSetPointChangeXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DStabSetPointChangeXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="refGenerator" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="controllerType" type="{http://www.ieee.org/odm/Schema/2008}MachineControllerEnumType"/>
 *         &lt;element name="changeValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="valueChangeType" type="{http://www.ieee.org/odm/Schema/2008}SetPointChangeEnumType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DStabSetPointChangeXmlType", propOrder = {
    "refGenerator",
    "controllerType",
    "changeValue",
    "valueChangeType"
})
public class DStabSetPointChangeXmlType {

    @XmlElement(required = true)
    protected IDRefRecordXmlType refGenerator;
    @XmlElement(required = true)
    protected MachineControllerEnumType controllerType;
    protected double changeValue;
    @XmlElement(required = true)
    protected SetPointChangeEnumType valueChangeType;

    /**
     * Gets the value of the refGenerator property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getRefGenerator() {
        return refGenerator;
    }

    /**
     * Sets the value of the refGenerator property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setRefGenerator(IDRefRecordXmlType value) {
        this.refGenerator = value;
    }

    /**
     * Gets the value of the controllerType property.
     * 
     * @return
     *     possible object is
     *     {@link MachineControllerEnumType }
     *     
     */
    public MachineControllerEnumType getControllerType() {
        return controllerType;
    }

    /**
     * Sets the value of the controllerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MachineControllerEnumType }
     *     
     */
    public void setControllerType(MachineControllerEnumType value) {
        this.controllerType = value;
    }

    /**
     * Gets the value of the changeValue property.
     * 
     */
    public double getChangeValue() {
        return changeValue;
    }

    /**
     * Sets the value of the changeValue property.
     * 
     */
    public void setChangeValue(double value) {
        this.changeValue = value;
    }

    /**
     * Gets the value of the valueChangeType property.
     * 
     * @return
     *     possible object is
     *     {@link SetPointChangeEnumType }
     *     
     */
    public SetPointChangeEnumType getValueChangeType() {
        return valueChangeType;
    }

    /**
     * Sets the value of the valueChangeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SetPointChangeEnumType }
     *     
     */
    public void setValueChangeType(SetPointChangeEnumType value) {
        this.valueChangeType = value;
    }

}
