//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.21 at 03:39:47 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MachineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MachineXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="genId" type="{http://www.ieee.org/odm/Schema}IDRecordXmlType" minOccurs="0"/>
 *         &lt;element name="ownerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ratedVoltage" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="generatorType" type="{http://www.ieee.org/odm/Schema}GeneratorEnumType"/>
 *         &lt;element name="generatorModel" type="{http://www.ieee.org/odm/Schema}MachineModelSelectionXmlType"/>
 *         &lt;element name="pContributionPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="qContributionPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MachineXmlType", propOrder = {
    "genId",
    "ownerName",
    "ratedVoltage",
    "generatorType",
    "generatorModel",
    "pContributionPercent",
    "qContributionPercent"
})
public class MachineXmlType {

    protected IDRecordXmlType genId;
    protected String ownerName;
    protected VoltageXmlType ratedVoltage;
    @XmlElement(required = true)
    protected GeneratorEnumType generatorType;
    @XmlElement(required = true)
    protected MachineModelSelectionXmlType generatorModel;
    protected Double pContributionPercent;
    protected Double qContributionPercent;

    /**
     * Gets the value of the genId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRecordXmlType }
     *     
     */
    public IDRecordXmlType getGenId() {
        return genId;
    }

    /**
     * Sets the value of the genId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRecordXmlType }
     *     
     */
    public void setGenId(IDRecordXmlType value) {
        this.genId = value;
    }

    /**
     * Gets the value of the ownerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the value of the ownerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerName(String value) {
        this.ownerName = value;
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
     * Gets the value of the generatorType property.
     * 
     * @return
     *     possible object is
     *     {@link GeneratorEnumType }
     *     
     */
    public GeneratorEnumType getGeneratorType() {
        return generatorType;
    }

    /**
     * Sets the value of the generatorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneratorEnumType }
     *     
     */
    public void setGeneratorType(GeneratorEnumType value) {
        this.generatorType = value;
    }

    /**
     * Gets the value of the generatorModel property.
     * 
     * @return
     *     possible object is
     *     {@link MachineModelSelectionXmlType }
     *     
     */
    public MachineModelSelectionXmlType getGeneratorModel() {
        return generatorModel;
    }

    /**
     * Sets the value of the generatorModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link MachineModelSelectionXmlType }
     *     
     */
    public void setGeneratorModel(MachineModelSelectionXmlType value) {
        this.generatorModel = value;
    }

    /**
     * Gets the value of the pContributionPercent property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPContributionPercent() {
        return pContributionPercent;
    }

    /**
     * Sets the value of the pContributionPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPContributionPercent(Double value) {
        this.pContributionPercent = value;
    }

    /**
     * Gets the value of the qContributionPercent property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getQContributionPercent() {
        return qContributionPercent;
    }

    /**
     * Sets the value of the qContributionPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setQContributionPercent(Double value) {
        this.qContributionPercent = value;
    }

}
