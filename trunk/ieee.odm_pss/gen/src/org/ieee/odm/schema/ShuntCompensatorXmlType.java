//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.29 at 07:17:30 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShuntCompensatorXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShuntCompensatorXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cimRdfRec" type="{http://www.ieee.org/odm/Schema/2008}CimRdfXmlType" minOccurs="0"/>
 *         &lt;element name="cimSwitches" type="{http://www.ieee.org/odm/Schema/2008}CimSwitchListXmlType" minOccurs="0"/>
 *         &lt;element name="desiredVoltageRange" type="{http://www.ieee.org/odm/Schema/2008}VoltageLimitXmlType"/>
 *         &lt;element name="bInit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VarPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="block" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="incrementB" type="{http://www.ieee.org/odm/Schema/2008}ReactivePowerXmlType"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="steps" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="remoteControlledBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="vscDcLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bZeroSeqPerSection" type="{http://www.ieee.org/odm/Schema/2008}YUnitType" minOccurs="0"/>
 *         &lt;element name="bPosSeqPerSection" type="{http://www.ieee.org/odm/Schema/2008}YUnitType" minOccurs="0"/>
 *         &lt;element name="gZeroSeqPerSection" type="{http://www.ieee.org/odm/Schema/2008}YUnitType" minOccurs="0"/>
 *         &lt;element name="gPosSeqPerSection" type="{http://www.ieee.org/odm/Schema/2008}YUnitType" minOccurs="0"/>
 *         &lt;element name="maxSections" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="maxVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="minVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="norminalQOutput" type="{http://www.ieee.org/odm/Schema/2008}ReactivePowerXmlType" minOccurs="0"/>
 *         &lt;element name="norminalVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="norminalSwitchedInSections" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="slop" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="reactivePowerPerSec" type="{http://www.ieee.org/odm/Schema/2008}ReactivePowerXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="mode" use="required" type="{http://www.ieee.org/odm/Schema/2008}ShuntCompensatorModeEnumType" />
 *       &lt;attribute name="offLine" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShuntCompensatorXmlType", propOrder = {
    "cimRdfRec",
    "cimSwitches",
    "desiredVoltageRange",
    "bInit",
    "varPercent",
    "block",
    "remoteControlledBus",
    "vscDcLine",
    "bZeroSeqPerSection",
    "bPosSeqPerSection",
    "gZeroSeqPerSection",
    "gPosSeqPerSection",
    "maxSections",
    "maxVoltage",
    "minVoltage",
    "norminalQOutput",
    "norminalVoltage",
    "norminalSwitchedInSections",
    "slop",
    "reactivePowerPerSec"
})
public class ShuntCompensatorXmlType {

    protected CimRdfXmlType cimRdfRec;
    protected CimSwitchListXmlType cimSwitches;
    @XmlElement(required = true)
    protected VoltageLimitXmlType desiredVoltageRange;
    protected double bInit;
    @XmlElement(name = "VarPercent")
    protected Double varPercent;
    @XmlElement(required = true)
    protected List<ShuntCompensatorXmlType.Block> block;
    protected IDRefRecordXmlType remoteControlledBus;
    protected String vscDcLine;
    protected YUnitType bZeroSeqPerSection;
    protected YUnitType bPosSeqPerSection;
    protected YUnitType gZeroSeqPerSection;
    protected YUnitType gPosSeqPerSection;
    protected Long maxSections;
    protected VoltageXmlType maxVoltage;
    protected VoltageXmlType minVoltage;
    protected ReactivePowerXmlType norminalQOutput;
    protected VoltageXmlType norminalVoltage;
    protected Long norminalSwitchedInSections;
    protected Float slop;
    protected ReactivePowerXmlType reactivePowerPerSec;
    @XmlAttribute(required = true)
    protected ShuntCompensatorModeEnumType mode;
    @XmlAttribute(required = true)
    protected boolean offLine;

    /**
     * Gets the value of the cimRdfRec property.
     * 
     * @return
     *     possible object is
     *     {@link CimRdfXmlType }
     *     
     */
    public CimRdfXmlType getCimRdfRec() {
        return cimRdfRec;
    }

    /**
     * Sets the value of the cimRdfRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link CimRdfXmlType }
     *     
     */
    public void setCimRdfRec(CimRdfXmlType value) {
        this.cimRdfRec = value;
    }

    /**
     * Gets the value of the cimSwitches property.
     * 
     * @return
     *     possible object is
     *     {@link CimSwitchListXmlType }
     *     
     */
    public CimSwitchListXmlType getCimSwitches() {
        return cimSwitches;
    }

    /**
     * Sets the value of the cimSwitches property.
     * 
     * @param value
     *     allowed object is
     *     {@link CimSwitchListXmlType }
     *     
     */
    public void setCimSwitches(CimSwitchListXmlType value) {
        this.cimSwitches = value;
    }

    /**
     * Gets the value of the desiredVoltageRange property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageLimitXmlType }
     *     
     */
    public VoltageLimitXmlType getDesiredVoltageRange() {
        return desiredVoltageRange;
    }

    /**
     * Sets the value of the desiredVoltageRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageLimitXmlType }
     *     
     */
    public void setDesiredVoltageRange(VoltageLimitXmlType value) {
        this.desiredVoltageRange = value;
    }

    /**
     * Gets the value of the bInit property.
     * 
     */
    public double getBInit() {
        return bInit;
    }

    /**
     * Sets the value of the bInit property.
     * 
     */
    public void setBInit(double value) {
        this.bInit = value;
    }

    /**
     * Gets the value of the varPercent property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVarPercent() {
        return varPercent;
    }

    /**
     * Sets the value of the varPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVarPercent(Double value) {
        this.varPercent = value;
    }

    /**
     * Gets the value of the block property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the block property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShuntCompensatorXmlType.Block }
     * 
     * 
     */
    public List<ShuntCompensatorXmlType.Block> getBlock() {
        if (block == null) {
            block = new ArrayList<ShuntCompensatorXmlType.Block>();
        }
        return this.block;
    }

    /**
     * Gets the value of the remoteControlledBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getRemoteControlledBus() {
        return remoteControlledBus;
    }

    /**
     * Sets the value of the remoteControlledBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setRemoteControlledBus(IDRefRecordXmlType value) {
        this.remoteControlledBus = value;
    }

    /**
     * Gets the value of the vscDcLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVscDcLine() {
        return vscDcLine;
    }

    /**
     * Sets the value of the vscDcLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVscDcLine(String value) {
        this.vscDcLine = value;
    }

    /**
     * Gets the value of the bZeroSeqPerSection property.
     * 
     * @return
     *     possible object is
     *     {@link YUnitType }
     *     
     */
    public YUnitType getBZeroSeqPerSection() {
        return bZeroSeqPerSection;
    }

    /**
     * Sets the value of the bZeroSeqPerSection property.
     * 
     * @param value
     *     allowed object is
     *     {@link YUnitType }
     *     
     */
    public void setBZeroSeqPerSection(YUnitType value) {
        this.bZeroSeqPerSection = value;
    }

    /**
     * Gets the value of the bPosSeqPerSection property.
     * 
     * @return
     *     possible object is
     *     {@link YUnitType }
     *     
     */
    public YUnitType getBPosSeqPerSection() {
        return bPosSeqPerSection;
    }

    /**
     * Sets the value of the bPosSeqPerSection property.
     * 
     * @param value
     *     allowed object is
     *     {@link YUnitType }
     *     
     */
    public void setBPosSeqPerSection(YUnitType value) {
        this.bPosSeqPerSection = value;
    }

    /**
     * Gets the value of the gZeroSeqPerSection property.
     * 
     * @return
     *     possible object is
     *     {@link YUnitType }
     *     
     */
    public YUnitType getGZeroSeqPerSection() {
        return gZeroSeqPerSection;
    }

    /**
     * Sets the value of the gZeroSeqPerSection property.
     * 
     * @param value
     *     allowed object is
     *     {@link YUnitType }
     *     
     */
    public void setGZeroSeqPerSection(YUnitType value) {
        this.gZeroSeqPerSection = value;
    }

    /**
     * Gets the value of the gPosSeqPerSection property.
     * 
     * @return
     *     possible object is
     *     {@link YUnitType }
     *     
     */
    public YUnitType getGPosSeqPerSection() {
        return gPosSeqPerSection;
    }

    /**
     * Sets the value of the gPosSeqPerSection property.
     * 
     * @param value
     *     allowed object is
     *     {@link YUnitType }
     *     
     */
    public void setGPosSeqPerSection(YUnitType value) {
        this.gPosSeqPerSection = value;
    }

    /**
     * Gets the value of the maxSections property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxSections() {
        return maxSections;
    }

    /**
     * Sets the value of the maxSections property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxSections(Long value) {
        this.maxSections = value;
    }

    /**
     * Gets the value of the maxVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getMaxVoltage() {
        return maxVoltage;
    }

    /**
     * Sets the value of the maxVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setMaxVoltage(VoltageXmlType value) {
        this.maxVoltage = value;
    }

    /**
     * Gets the value of the minVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getMinVoltage() {
        return minVoltage;
    }

    /**
     * Sets the value of the minVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setMinVoltage(VoltageXmlType value) {
        this.minVoltage = value;
    }

    /**
     * Gets the value of the norminalQOutput property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePowerXmlType }
     *     
     */
    public ReactivePowerXmlType getNorminalQOutput() {
        return norminalQOutput;
    }

    /**
     * Sets the value of the norminalQOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePowerXmlType }
     *     
     */
    public void setNorminalQOutput(ReactivePowerXmlType value) {
        this.norminalQOutput = value;
    }

    /**
     * Gets the value of the norminalVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getNorminalVoltage() {
        return norminalVoltage;
    }

    /**
     * Sets the value of the norminalVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setNorminalVoltage(VoltageXmlType value) {
        this.norminalVoltage = value;
    }

    /**
     * Gets the value of the norminalSwitchedInSections property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNorminalSwitchedInSections() {
        return norminalSwitchedInSections;
    }

    /**
     * Sets the value of the norminalSwitchedInSections property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNorminalSwitchedInSections(Long value) {
        this.norminalSwitchedInSections = value;
    }

    /**
     * Gets the value of the slop property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSlop() {
        return slop;
    }

    /**
     * Sets the value of the slop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSlop(Float value) {
        this.slop = value;
    }

    /**
     * Gets the value of the reactivePowerPerSec property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePowerXmlType }
     *     
     */
    public ReactivePowerXmlType getReactivePowerPerSec() {
        return reactivePowerPerSec;
    }

    /**
     * Sets the value of the reactivePowerPerSec property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePowerXmlType }
     *     
     */
    public void setReactivePowerPerSec(ReactivePowerXmlType value) {
        this.reactivePowerPerSec = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link ShuntCompensatorModeEnumType }
     *     
     */
    public ShuntCompensatorModeEnumType getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShuntCompensatorModeEnumType }
     *     
     */
    public void setMode(ShuntCompensatorModeEnumType value) {
        this.mode = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="incrementB" type="{http://www.ieee.org/odm/Schema/2008}ReactivePowerXmlType"/>
     *       &lt;/sequence>
     *       &lt;attribute name="steps" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "incrementB"
    })
    public static class Block {

        @XmlElement(required = true)
        protected ReactivePowerXmlType incrementB;
        @XmlAttribute(required = true)
        protected int steps;

        /**
         * Gets the value of the incrementB property.
         * 
         * @return
         *     possible object is
         *     {@link ReactivePowerXmlType }
         *     
         */
        public ReactivePowerXmlType getIncrementB() {
            return incrementB;
        }

        /**
         * Sets the value of the incrementB property.
         * 
         * @param value
         *     allowed object is
         *     {@link ReactivePowerXmlType }
         *     
         */
        public void setIncrementB(ReactivePowerXmlType value) {
            this.incrementB = value;
        }

        /**
         * Gets the value of the steps property.
         * 
         */
        public int getSteps() {
            return steps;
        }

        /**
         * Sets the value of the steps property.
         * 
         */
        public void setSteps(int value) {
            this.steps = value;
        }

    }

}
