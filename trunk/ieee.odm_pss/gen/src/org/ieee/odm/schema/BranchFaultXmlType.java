//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.03 at 08:21:20 PM PDT 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BranchFaultXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BranchFaultXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="faultCategory" type="{http://www.ieee.org/odm/Schema}FaultCategoryEnumType"/>
 *         &lt;element name="fromBus" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType"/>
 *         &lt;element name="toBus" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="faultedCirId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fromBusRatedV" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="toBusRatedV" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="faultStartTime" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="firstOperationTime" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="secondOperationTime" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="faultDurationTime" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="faultZ" type="{http://www.ieee.org/odm/Schema}ZXmlType" minOccurs="0"/>
 *         &lt;element name="faultLocationFromFromSide" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="permanentFault" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BranchFaultXmlType", propOrder = {
    "faultCategory",
    "fromBus",
    "toBus",
    "faultedCirId",
    "fromBusRatedV",
    "toBusRatedV",
    "faultStartTime",
    "firstOperationTime",
    "secondOperationTime",
    "faultDurationTime",
    "faultZ",
    "faultLocationFromFromSide",
    "permanentFault"
})
public class BranchFaultXmlType {

    @XmlElement(required = true)
    protected FaultCategoryEnumType faultCategory;
    @XmlElement(required = true)
    protected IDRefRecordXmlType fromBus;
    protected IDRefRecordXmlType toBus;
    protected List<String> faultedCirId;
    protected VoltageXmlType fromBusRatedV;
    protected VoltageXmlType toBusRatedV;
    protected TimePeriodXmlType faultStartTime;
    protected TimePeriodXmlType firstOperationTime;
    protected TimePeriodXmlType secondOperationTime;
    protected TimePeriodXmlType faultDurationTime;
    protected ZXmlType faultZ;
    protected Double faultLocationFromFromSide;
    protected Boolean permanentFault;

    /**
     * Gets the value of the faultCategory property.
     * 
     * @return
     *     possible object is
     *     {@link FaultCategoryEnumType }
     *     
     */
    public FaultCategoryEnumType getFaultCategory() {
        return faultCategory;
    }

    /**
     * Sets the value of the faultCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaultCategoryEnumType }
     *     
     */
    public void setFaultCategory(FaultCategoryEnumType value) {
        this.faultCategory = value;
    }

    /**
     * Gets the value of the fromBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getFromBus() {
        return fromBus;
    }

    /**
     * Sets the value of the fromBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setFromBus(IDRefRecordXmlType value) {
        this.fromBus = value;
    }

    /**
     * Gets the value of the toBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getToBus() {
        return toBus;
    }

    /**
     * Sets the value of the toBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setToBus(IDRefRecordXmlType value) {
        this.toBus = value;
    }

    /**
     * Gets the value of the faultedCirId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the faultedCirId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFaultedCirId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFaultedCirId() {
        if (faultedCirId == null) {
            faultedCirId = new ArrayList<String>();
        }
        return this.faultedCirId;
    }

    /**
     * Gets the value of the fromBusRatedV property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getFromBusRatedV() {
        return fromBusRatedV;
    }

    /**
     * Sets the value of the fromBusRatedV property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setFromBusRatedV(VoltageXmlType value) {
        this.fromBusRatedV = value;
    }

    /**
     * Gets the value of the toBusRatedV property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getToBusRatedV() {
        return toBusRatedV;
    }

    /**
     * Sets the value of the toBusRatedV property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setToBusRatedV(VoltageXmlType value) {
        this.toBusRatedV = value;
    }

    /**
     * Gets the value of the faultStartTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getFaultStartTime() {
        return faultStartTime;
    }

    /**
     * Sets the value of the faultStartTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setFaultStartTime(TimePeriodXmlType value) {
        this.faultStartTime = value;
    }

    /**
     * Gets the value of the firstOperationTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getFirstOperationTime() {
        return firstOperationTime;
    }

    /**
     * Sets the value of the firstOperationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setFirstOperationTime(TimePeriodXmlType value) {
        this.firstOperationTime = value;
    }

    /**
     * Gets the value of the secondOperationTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getSecondOperationTime() {
        return secondOperationTime;
    }

    /**
     * Sets the value of the secondOperationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setSecondOperationTime(TimePeriodXmlType value) {
        this.secondOperationTime = value;
    }

    /**
     * Gets the value of the faultDurationTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getFaultDurationTime() {
        return faultDurationTime;
    }

    /**
     * Sets the value of the faultDurationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setFaultDurationTime(TimePeriodXmlType value) {
        this.faultDurationTime = value;
    }

    /**
     * Gets the value of the faultZ property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getFaultZ() {
        return faultZ;
    }

    /**
     * Sets the value of the faultZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setFaultZ(ZXmlType value) {
        this.faultZ = value;
    }

    /**
     * Gets the value of the faultLocationFromFromSide property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFaultLocationFromFromSide() {
        return faultLocationFromFromSide;
    }

    /**
     * Sets the value of the faultLocationFromFromSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFaultLocationFromFromSide(Double value) {
        this.faultLocationFromFromSide = value;
    }

    /**
     * Gets the value of the permanentFault property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPermanentFault() {
        return permanentFault;
    }

    /**
     * Sets the value of the permanentFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPermanentFault(Boolean value) {
        this.permanentFault = value;
    }

}
