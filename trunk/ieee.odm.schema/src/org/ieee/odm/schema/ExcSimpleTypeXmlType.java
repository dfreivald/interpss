//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.02 at 03:49:36 ���� CST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExcSimpleTypeXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExcSimpleTypeXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}ExciterModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="Rc" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Xc" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Tr" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="Ka" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Ta" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="Vrmax" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Vrmin" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExcSimpleTypeXmlType", propOrder = {
    "rc",
    "xc",
    "tr",
    "ka",
    "ta",
    "vrmax",
    "vrmin"
})
public class ExcSimpleTypeXmlType
    extends ExciterModelXmlType
{

    @XmlElement(name = "Rc", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double rc;
    @XmlElement(name = "Xc", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double xc;
    @XmlElement(name = "Tr", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected TimePeriodXmlType tr;
    @XmlElement(name = "Ka", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double ka;
    @XmlElement(name = "Ta", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType ta;
    @XmlElement(name = "Vrmax", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double vrmax;
    @XmlElement(name = "Vrmin", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double vrmin;

    /**
     * Gets the value of the rc property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRc() {
        return rc;
    }

    /**
     * Sets the value of the rc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRc(Double value) {
        this.rc = value;
    }

    /**
     * Gets the value of the xc property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getXc() {
        return xc;
    }

    /**
     * Sets the value of the xc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setXc(Double value) {
        this.xc = value;
    }

    /**
     * Gets the value of the tr property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTr() {
        return tr;
    }

    /**
     * Sets the value of the tr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTr(TimePeriodXmlType value) {
        this.tr = value;
    }

    /**
     * Gets the value of the ka property.
     * 
     */
    public double getKa() {
        return ka;
    }

    /**
     * Sets the value of the ka property.
     * 
     */
    public void setKa(double value) {
        this.ka = value;
    }

    /**
     * Gets the value of the ta property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTa() {
        return ta;
    }

    /**
     * Sets the value of the ta property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTa(TimePeriodXmlType value) {
        this.ta = value;
    }

    /**
     * Gets the value of the vrmax property.
     * 
     */
    public double getVrmax() {
        return vrmax;
    }

    /**
     * Sets the value of the vrmax property.
     * 
     */
    public void setVrmax(double value) {
        this.vrmax = value;
    }

    /**
     * Gets the value of the vrmin property.
     * 
     */
    public double getVrmin() {
        return vrmin;
    }

    /**
     * Sets the value of the vrmin property.
     * 
     */
    public void setVrmin(double value) {
        this.vrmin = value;
    }

}
