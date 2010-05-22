//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.21 at 05:27:34 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenChangeDynamicEventXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenChangeDynamicEventXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bus" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="busRatedVoltage" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="generatorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationTime" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="operationDelayTime" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="genChange" type="{http://www.ieee.org/odm/Schema}PowerXmlType" minOccurs="0"/>
 *         &lt;element name="genOutage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenChangeDynamicEventXmlType", propOrder = {
    "bus",
    "busRatedVoltage",
    "generatorId",
    "operationTime",
    "operationDelayTime",
    "genChange",
    "genOutage"
})
public class GenChangeDynamicEventXmlType {

    protected IDRefRecordXmlType bus;
    protected VoltageXmlType busRatedVoltage;
    protected String generatorId;
    protected TimePeriodXmlType operationTime;
    protected TimePeriodXmlType operationDelayTime;
    protected PowerXmlType genChange;
    protected Boolean genOutage;

    /**
     * Gets the value of the bus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getBus() {
        return bus;
    }

    /**
     * Sets the value of the bus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setBus(IDRefRecordXmlType value) {
        this.bus = value;
    }

    /**
     * Gets the value of the busRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getBusRatedVoltage() {
        return busRatedVoltage;
    }

    /**
     * Sets the value of the busRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setBusRatedVoltage(VoltageXmlType value) {
        this.busRatedVoltage = value;
    }

    /**
     * Gets the value of the generatorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneratorId() {
        return generatorId;
    }

    /**
     * Sets the value of the generatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneratorId(String value) {
        this.generatorId = value;
    }

    /**
     * Gets the value of the operationTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getOperationTime() {
        return operationTime;
    }

    /**
     * Sets the value of the operationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setOperationTime(TimePeriodXmlType value) {
        this.operationTime = value;
    }

    /**
     * Gets the value of the operationDelayTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getOperationDelayTime() {
        return operationDelayTime;
    }

    /**
     * Sets the value of the operationDelayTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setOperationDelayTime(TimePeriodXmlType value) {
        this.operationDelayTime = value;
    }

    /**
     * Gets the value of the genChange property.
     * 
     * @return
     *     possible object is
     *     {@link PowerXmlType }
     *     
     */
    public PowerXmlType getGenChange() {
        return genChange;
    }

    /**
     * Sets the value of the genChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerXmlType }
     *     
     */
    public void setGenChange(PowerXmlType value) {
        this.genChange = value;
    }

    /**
     * Gets the value of the genOutage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGenOutage() {
        return genOutage;
    }

    /**
     * Sets the value of the genOutage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGenOutage(Boolean value) {
        this.genOutage = value;
    }

}
