//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.03 at 08:21:20 PM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExcBPAFJXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExcBPAFJXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exciterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TR" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="EFDMAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="EFDMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TB" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="TC" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="KA" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TA" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="KF" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TF" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="KC" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VRMAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VRMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExcBPAFJXmlType", propOrder = {
    "exciterName",
    "desc",
    "tr",
    "efdmax",
    "efdmin",
    "tb",
    "tc",
    "ka",
    "ta",
    "kf",
    "tf",
    "kc",
    "vrmax",
    "vrmin"
})
public class ExcBPAFJXmlType {

    protected String exciterName;
    protected String desc;
    @XmlElement(name = "TR")
    protected TimePeriodXmlType tr;
    @XmlElement(name = "EFDMAX")
    protected double efdmax;
    @XmlElement(name = "EFDMIN")
    protected double efdmin;
    @XmlElement(name = "TB", required = true)
    protected TimePeriodXmlType tb;
    @XmlElement(name = "TC", required = true)
    protected TimePeriodXmlType tc;
    @XmlElement(name = "KA")
    protected double ka;
    @XmlElement(name = "TA", required = true)
    protected TimePeriodXmlType ta;
    @XmlElement(name = "KF")
    protected double kf;
    @XmlElement(name = "TF", required = true)
    protected TimePeriodXmlType tf;
    @XmlElement(name = "KC")
    protected double kc;
    @XmlElement(name = "VRMAX")
    protected double vrmax;
    @XmlElement(name = "VRMIN")
    protected double vrmin;

    /**
     * Gets the value of the exciterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExciterName() {
        return exciterName;
    }

    /**
     * Sets the value of the exciterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExciterName(String value) {
        this.exciterName = value;
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
     * Gets the value of the tr property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTR() {
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
    public void setTR(TimePeriodXmlType value) {
        this.tr = value;
    }

    /**
     * Gets the value of the efdmax property.
     * 
     */
    public double getEFDMAX() {
        return efdmax;
    }

    /**
     * Sets the value of the efdmax property.
     * 
     */
    public void setEFDMAX(double value) {
        this.efdmax = value;
    }

    /**
     * Gets the value of the efdmin property.
     * 
     */
    public double getEFDMIN() {
        return efdmin;
    }

    /**
     * Sets the value of the efdmin property.
     * 
     */
    public void setEFDMIN(double value) {
        this.efdmin = value;
    }

    /**
     * Gets the value of the tb property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTB() {
        return tb;
    }

    /**
     * Sets the value of the tb property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTB(TimePeriodXmlType value) {
        this.tb = value;
    }

    /**
     * Gets the value of the tc property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTC() {
        return tc;
    }

    /**
     * Sets the value of the tc property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTC(TimePeriodXmlType value) {
        this.tc = value;
    }

    /**
     * Gets the value of the ka property.
     * 
     */
    public double getKA() {
        return ka;
    }

    /**
     * Sets the value of the ka property.
     * 
     */
    public void setKA(double value) {
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
    public TimePeriodXmlType getTA() {
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
    public void setTA(TimePeriodXmlType value) {
        this.ta = value;
    }

    /**
     * Gets the value of the kf property.
     * 
     */
    public double getKF() {
        return kf;
    }

    /**
     * Sets the value of the kf property.
     * 
     */
    public void setKF(double value) {
        this.kf = value;
    }

    /**
     * Gets the value of the tf property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTF() {
        return tf;
    }

    /**
     * Sets the value of the tf property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTF(TimePeriodXmlType value) {
        this.tf = value;
    }

    /**
     * Gets the value of the kc property.
     * 
     */
    public double getKC() {
        return kc;
    }

    /**
     * Sets the value of the kc property.
     * 
     */
    public void setKC(double value) {
        this.kc = value;
    }

    /**
     * Gets the value of the vrmax property.
     * 
     */
    public double getVRMAX() {
        return vrmax;
    }

    /**
     * Sets the value of the vrmax property.
     * 
     */
    public void setVRMAX(double value) {
        this.vrmax = value;
    }

    /**
     * Gets the value of the vrmin property.
     * 
     */
    public double getVRMIN() {
        return vrmin;
    }

    /**
     * Sets the value of the vrmin property.
     * 
     */
    public void setVRMIN(double value) {
        this.vrmin = value;
    }

}
