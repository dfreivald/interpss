//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.21 at 05:27:34 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExcrIEEEModified1968Type1XmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExcrIEEEModified1968Type1XmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exciterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KA" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TA" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="VRMAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VRMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KE" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TE" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="KF" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TF" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="EFDMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="E1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="SE1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="E2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="SE2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TR" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExcrIEEEModified1968Type1XmlType", propOrder = {
    "exciterName",
    "desc",
    "ka",
    "ta",
    "vrmax",
    "vrmin",
    "ke",
    "te",
    "kf",
    "tf",
    "efdmin",
    "e1",
    "se1",
    "e2",
    "se2",
    "tr"
})
public class ExcrIEEEModified1968Type1XmlType {

    protected String exciterName;
    protected String desc;
    @XmlElement(name = "KA")
    protected double ka;
    @XmlElement(name = "TA", required = true)
    protected TimePeriodXmlType ta;
    @XmlElement(name = "VRMAX")
    protected double vrmax;
    @XmlElement(name = "VRMIN")
    protected double vrmin;
    @XmlElement(name = "KE")
    protected double ke;
    @XmlElement(name = "TE", required = true)
    protected TimePeriodXmlType te;
    @XmlElement(name = "KF")
    protected double kf;
    @XmlElement(name = "TF", required = true)
    protected TimePeriodXmlType tf;
    @XmlElement(name = "EFDMIN")
    protected double efdmin;
    @XmlElement(name = "E1")
    protected double e1;
    @XmlElement(name = "SE1")
    protected double se1;
    @XmlElement(name = "E2")
    protected double e2;
    @XmlElement(name = "SE2")
    protected double se2;
    @XmlElement(name = "TR")
    protected TimePeriodXmlType tr;

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

    /**
     * Gets the value of the ke property.
     * 
     */
    public double getKE() {
        return ke;
    }

    /**
     * Sets the value of the ke property.
     * 
     */
    public void setKE(double value) {
        this.ke = value;
    }

    /**
     * Gets the value of the te property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTE() {
        return te;
    }

    /**
     * Sets the value of the te property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTE(TimePeriodXmlType value) {
        this.te = value;
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

}
