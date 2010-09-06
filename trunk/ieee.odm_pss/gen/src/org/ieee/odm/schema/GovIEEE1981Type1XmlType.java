//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.05 at 07:28:10 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovIEEE1981Type1XmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GovIEEE1981Type1XmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}GovernorModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="K" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T1" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T2" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T3" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="U0" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="UC" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PMAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T4" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="K1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="K2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T5" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="K3" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="K4" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T6" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="K5" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="K6" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T7" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="K7" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="K8" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GovIEEE1981Type1XmlType", propOrder = {
    "k",
    "t1",
    "t2",
    "t3",
    "u0",
    "uc",
    "pmax",
    "pmin",
    "t4",
    "k1",
    "k2",
    "t5",
    "k3",
    "k4",
    "t6",
    "k5",
    "k6",
    "t7",
    "k7",
    "k8"
})
public class GovIEEE1981Type1XmlType
    extends GovernorModelXmlType
{

    @XmlElement(name = "K")
    protected double k;
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
    @XmlElement(name = "PMAX")
    protected double pmax;
    @XmlElement(name = "PMIN")
    protected double pmin;
    @XmlElement(name = "T4", required = true)
    protected TimePeriodXmlType t4;
    @XmlElement(name = "K1")
    protected double k1;
    @XmlElement(name = "K2")
    protected double k2;
    @XmlElement(name = "T5", required = true)
    protected TimePeriodXmlType t5;
    @XmlElement(name = "K3")
    protected double k3;
    @XmlElement(name = "K4")
    protected double k4;
    @XmlElement(name = "T6", required = true)
    protected TimePeriodXmlType t6;
    @XmlElement(name = "K5")
    protected double k5;
    @XmlElement(name = "K6")
    protected double k6;
    @XmlElement(name = "T7", required = true)
    protected TimePeriodXmlType t7;
    @XmlElement(name = "K7")
    protected double k7;
    @XmlElement(name = "K8")
    protected double k8;

    /**
     * Gets the value of the k property.
     * 
     */
    public double getK() {
        return k;
    }

    /**
     * Sets the value of the k property.
     * 
     */
    public void setK(double value) {
        this.k = value;
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
     * Gets the value of the t4 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT4() {
        return t4;
    }

    /**
     * Sets the value of the t4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT4(TimePeriodXmlType value) {
        this.t4 = value;
    }

    /**
     * Gets the value of the k1 property.
     * 
     */
    public double getK1() {
        return k1;
    }

    /**
     * Sets the value of the k1 property.
     * 
     */
    public void setK1(double value) {
        this.k1 = value;
    }

    /**
     * Gets the value of the k2 property.
     * 
     */
    public double getK2() {
        return k2;
    }

    /**
     * Sets the value of the k2 property.
     * 
     */
    public void setK2(double value) {
        this.k2 = value;
    }

    /**
     * Gets the value of the t5 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT5() {
        return t5;
    }

    /**
     * Sets the value of the t5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT5(TimePeriodXmlType value) {
        this.t5 = value;
    }

    /**
     * Gets the value of the k3 property.
     * 
     */
    public double getK3() {
        return k3;
    }

    /**
     * Sets the value of the k3 property.
     * 
     */
    public void setK3(double value) {
        this.k3 = value;
    }

    /**
     * Gets the value of the k4 property.
     * 
     */
    public double getK4() {
        return k4;
    }

    /**
     * Sets the value of the k4 property.
     * 
     */
    public void setK4(double value) {
        this.k4 = value;
    }

    /**
     * Gets the value of the t6 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT6() {
        return t6;
    }

    /**
     * Sets the value of the t6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT6(TimePeriodXmlType value) {
        this.t6 = value;
    }

    /**
     * Gets the value of the k5 property.
     * 
     */
    public double getK5() {
        return k5;
    }

    /**
     * Sets the value of the k5 property.
     * 
     */
    public void setK5(double value) {
        this.k5 = value;
    }

    /**
     * Gets the value of the k6 property.
     * 
     */
    public double getK6() {
        return k6;
    }

    /**
     * Sets the value of the k6 property.
     * 
     */
    public void setK6(double value) {
        this.k6 = value;
    }

    /**
     * Gets the value of the t7 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT7() {
        return t7;
    }

    /**
     * Sets the value of the t7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT7(TimePeriodXmlType value) {
        this.t7 = value;
    }

    /**
     * Gets the value of the k7 property.
     * 
     */
    public double getK7() {
        return k7;
    }

    /**
     * Sets the value of the k7 property.
     * 
     */
    public void setK7(double value) {
        this.k7 = value;
    }

    /**
     * Gets the value of the k8 property.
     * 
     */
    public double getK8() {
        return k8;
    }

    /**
     * Sets the value of the k8 property.
     * 
     */
    public void setK8(double value) {
        this.k8 = value;
    }

}
