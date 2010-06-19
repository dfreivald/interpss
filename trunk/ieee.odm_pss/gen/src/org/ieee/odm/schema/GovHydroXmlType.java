//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.19 at 07:37:24 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovHydroXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GovHydroXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basePower" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="basePowerUnit" type="{http://www.ieee.org/odm/Schema}ApparentPowerUnitType"/>
 *         &lt;element name="PMAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="R" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T1" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="T2" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="T3" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="U0" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="UC" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="turbine" type="{http://www.ieee.org/odm/Schema}TurbineXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GovHydroXmlType", propOrder = {
    "name",
    "desc",
    "basePower",
    "basePowerUnit",
    "pmax",
    "pmin",
    "r",
    "t1",
    "t2",
    "t3",
    "u0",
    "uc",
    "turbine"
})
public class GovHydroXmlType {

    @XmlElement(required = true)
    protected String name;
    protected String desc;
    @XmlElement(required = true)
    protected String basePower;
    @XmlElement(required = true)
    protected ApparentPowerUnitType basePowerUnit;
    @XmlElement(name = "PMAX")
    protected double pmax;
    @XmlElement(name = "PMIN")
    protected double pmin;
    @XmlElement(name = "R")
    protected double r;
    @XmlElement(name = "T1", required = true)
    protected TimePeriodXmlType t1;
    @XmlElement(name = "T2", required = true)
    protected TimePeriodXmlType t2;
    @XmlElement(name = "T3", required = true)
    protected TimePeriodXmlType t3;
    @XmlElement(name = "U0")
    protected double u0;
    @XmlElement(name = "UC")
    protected double uc;
    protected TurbineXmlType turbine;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the basePower property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasePower() {
        return basePower;
    }

    /**
     * Sets the value of the basePower property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasePower(String value) {
        this.basePower = value;
    }

    /**
     * Gets the value of the basePowerUnit property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerUnitType }
     *     
     */
    public ApparentPowerUnitType getBasePowerUnit() {
        return basePowerUnit;
    }

    /**
     * Sets the value of the basePowerUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerUnitType }
     *     
     */
    public void setBasePowerUnit(ApparentPowerUnitType value) {
        this.basePowerUnit = value;
    }

    /**
     * Gets the value of the pmax property.
     * 
     */
    public double getPMAX() {
        return pmax;
    }

    /**
     * Sets the value of the pmax property.
     * 
     */
    public void setPMAX(double value) {
        this.pmax = value;
    }

    /**
     * Gets the value of the pmin property.
     * 
     */
    public double getPMIN() {
        return pmin;
    }

    /**
     * Sets the value of the pmin property.
     * 
     */
    public void setPMIN(double value) {
        this.pmin = value;
    }

    /**
     * Gets the value of the r property.
     * 
     */
    public double getR() {
        return r;
    }

    /**
     * Sets the value of the r property.
     * 
     */
    public void setR(double value) {
        this.r = value;
    }

    /**
     * Gets the value of the t1 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT1() {
        return t1;
    }

    /**
     * Sets the value of the t1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT1(TimePeriodXmlType value) {
        this.t1 = value;
    }

    /**
     * Gets the value of the t2 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT2() {
        return t2;
    }

    /**
     * Sets the value of the t2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT2(TimePeriodXmlType value) {
        this.t2 = value;
    }

    /**
     * Gets the value of the t3 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT3() {
        return t3;
    }

    /**
     * Sets the value of the t3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT3(TimePeriodXmlType value) {
        this.t3 = value;
    }

    /**
     * Gets the value of the u0 property.
     * 
     */
    public double getU0() {
        return u0;
    }

    /**
     * Sets the value of the u0 property.
     * 
     */
    public void setU0(double value) {
        this.u0 = value;
    }

    /**
     * Gets the value of the uc property.
     * 
     */
    public double getUC() {
        return uc;
    }

    /**
     * Sets the value of the uc property.
     * 
     */
    public void setUC(double value) {
        this.uc = value;
    }

    /**
     * Gets the value of the turbine property.
     * 
     * @return
     *     possible object is
     *     {@link TurbineXmlType }
     *     
     */
    public TurbineXmlType getTurbine() {
        return turbine;
    }

    /**
     * Sets the value of the turbine property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurbineXmlType }
     *     
     */
    public void setTurbine(TurbineXmlType value) {
        this.turbine = value;
    }

}
