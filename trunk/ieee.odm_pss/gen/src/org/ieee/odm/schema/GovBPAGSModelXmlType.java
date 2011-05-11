//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.10 at 08:49:57 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovBPAGSModelXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GovBPAGSModelXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}GovernorModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="Pmax" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Pmin" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="T1" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="T2" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="T3" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="R" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="VELOPEN" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="VELCLOSE" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Epsilon" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GovBPAGSModelXmlType", propOrder = {
    "pmax",
    "pmin",
    "t1",
    "t2",
    "t3",
    "r",
    "velopen",
    "velclose",
    "epsilon"
})
public class GovBPAGSModelXmlType
    extends GovernorModelXmlType
{

    @XmlElement(name = "Pmax")
    protected Double pmax;
    @XmlElement(name = "Pmin")
    protected Double pmin;
    @XmlElement(name = "T1")
    protected TimePeriodXmlType t1;
    @XmlElement(name = "T2")
    protected TimePeriodXmlType t2;
    @XmlElement(name = "T3")
    protected TimePeriodXmlType t3;
    @XmlElement(name = "R")
    protected Double r;
    @XmlElement(name = "VELOPEN")
    protected Double velopen;
    @XmlElement(name = "VELCLOSE")
    protected Double velclose;
    @XmlElement(name = "Epsilon")
    protected Double epsilon;

    /**
     * Gets the value of the pmax property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPmax() {
        return pmax;
    }

    /**
     * Sets the value of the pmax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPmax(Double value) {
        this.pmax = value;
    }

    /**
     * Gets the value of the pmin property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPmin() {
        return pmin;
    }

    /**
     * Sets the value of the pmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPmin(Double value) {
        this.pmin = value;
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
     * Gets the value of the r property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getR() {
        return r;
    }

    /**
     * Sets the value of the r property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setR(Double value) {
        this.r = value;
    }

    /**
     * Gets the value of the velopen property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVELOPEN() {
        return velopen;
    }

    /**
     * Sets the value of the velopen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVELOPEN(Double value) {
        this.velopen = value;
    }

    /**
     * Gets the value of the velclose property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVELCLOSE() {
        return velclose;
    }

    /**
     * Sets the value of the velclose property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVELCLOSE(Double value) {
        this.velclose = value;
    }

    /**
     * Gets the value of the epsilon property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getEpsilon() {
        return epsilon;
    }

    /**
     * Sets the value of the epsilon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setEpsilon(Double value) {
        this.epsilon = value;
    }

}
