//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.19 at 05:09:52 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransientMachineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransientMachineXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}ClassicMachineXmlType">
 *       &lt;sequence>
 *         &lt;element name="ra" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="xd" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="xq" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Tdo1" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="xq1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Tq01" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="E1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="E2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="SE1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="SE2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="AF" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransientMachineXmlType", propOrder = {
    "ra",
    "xd",
    "xq",
    "tdo1",
    "xq1",
    "tq01",
    "e1",
    "e2",
    "se1",
    "se2",
    "af"
})
@XmlSeeAlso({
    SubTransientMachineXmlType.class
})
public class TransientMachineXmlType
    extends ClassicMachineXmlType
{

    protected double ra;
    protected double xd;
    protected double xq;
    @XmlElement(name = "Tdo1", required = true)
    protected TimePeriodXmlType tdo1;
    protected double xq1;
    @XmlElement(name = "Tq01", required = true)
    protected TimePeriodXmlType tq01;
    @XmlElement(name = "E1")
    protected double e1;
    @XmlElement(name = "E2")
    protected double e2;
    @XmlElement(name = "SE1")
    protected double se1;
    @XmlElement(name = "SE2")
    protected double se2;
    @XmlElement(name = "AF")
    protected Double af;

    /**
     * Gets the value of the ra property.
     * 
     */
    public double getRa() {
        return ra;
    }

    /**
     * Sets the value of the ra property.
     * 
     */
    public void setRa(double value) {
        this.ra = value;
    }

    /**
     * Gets the value of the xd property.
     * 
     */
    public double getXd() {
        return xd;
    }

    /**
     * Sets the value of the xd property.
     * 
     */
    public void setXd(double value) {
        this.xd = value;
    }

    /**
     * Gets the value of the xq property.
     * 
     */
    public double getXq() {
        return xq;
    }

    /**
     * Sets the value of the xq property.
     * 
     */
    public void setXq(double value) {
        this.xq = value;
    }

    /**
     * Gets the value of the tdo1 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTdo1() {
        return tdo1;
    }

    /**
     * Sets the value of the tdo1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTdo1(TimePeriodXmlType value) {
        this.tdo1 = value;
    }

    /**
     * Gets the value of the xq1 property.
     * 
     */
    public double getXq1() {
        return xq1;
    }

    /**
     * Sets the value of the xq1 property.
     * 
     */
    public void setXq1(double value) {
        this.xq1 = value;
    }

    /**
     * Gets the value of the tq01 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTq01() {
        return tq01;
    }

    /**
     * Sets the value of the tq01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTq01(TimePeriodXmlType value) {
        this.tq01 = value;
    }

    /**
     * Gets the value of the e1 property.
     * 
     */
    public double getE1() {
        return e1;
    }

    /**
     * Sets the value of the e1 property.
     * 
     */
    public void setE1(double value) {
        this.e1 = value;
    }

    /**
     * Gets the value of the e2 property.
     * 
     */
    public double getE2() {
        return e2;
    }

    /**
     * Sets the value of the e2 property.
     * 
     */
    public void setE2(double value) {
        this.e2 = value;
    }

    /**
     * Gets the value of the se1 property.
     * 
     */
    public double getSE1() {
        return se1;
    }

    /**
     * Sets the value of the se1 property.
     * 
     */
    public void setSE1(double value) {
        this.se1 = value;
    }

    /**
     * Gets the value of the se2 property.
     * 
     */
    public double getSE2() {
        return se2;
    }

    /**
     * Sets the value of the se2 property.
     * 
     */
    public void setSE2(double value) {
        this.se2 = value;
    }

    /**
     * Gets the value of the af property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAF() {
        return af;
    }

    /**
     * Sets the value of the af property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAF(Double value) {
        this.af = value;
    }

}
