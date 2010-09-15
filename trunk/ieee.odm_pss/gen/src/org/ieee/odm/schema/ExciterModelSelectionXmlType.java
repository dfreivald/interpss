//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.15 at 01:46:12 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExciterModelSelectionXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExciterModelSelectionXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="IEEE1992TypeAC1A" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEE1992TypeAC1AXmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1981TypeAC2" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEE1981TypeAC2XmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1981ST1" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEE1981ST1XmlType" minOccurs="0"/>
 *         &lt;element name="BPAFJ" type="{http://www.ieee.org/odm/Schema/2008}ExcBPAFJXmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1968Type1" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEE1968Type1XmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1968Type1S" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEE1968Type1SXmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1968Type2" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEE1968Type2XmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1968Type3" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEE1968Type3XmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1968Type4" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEE1968Type4XmlType" minOccurs="0"/>
 *         &lt;element name="IEEEModified1968Type1" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEEModified1968Type1XmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1981NewExcSystem" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEE1981NewExcSystemXmlType" minOccurs="0"/>
 *         &lt;element name="IEEETypeDC2" type="{http://www.ieee.org/odm/Schema/2008}ExcIEEETypeDC2XmlType" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExciterModelSelectionXmlType", propOrder = {
    "ieee1992TypeAC1A",
    "ieee1981TypeAC2",
    "ieee1981ST1",
    "bpafj",
    "ieee1968Type1",
    "ieee1968Type1S",
    "ieee1968Type2",
    "ieee1968Type3",
    "ieee1968Type4",
    "ieeeModified1968Type1",
    "ieee1981NewExcSystem",
    "ieeeTypeDC2"
})
public class ExciterModelSelectionXmlType {

    @XmlElement(name = "IEEE1992TypeAC1A")
    protected ExcIEEE1992TypeAC1AXmlType ieee1992TypeAC1A;
    @XmlElement(name = "IEEE1981TypeAC2")
    protected ExcIEEE1981TypeAC2XmlType ieee1981TypeAC2;
    @XmlElement(name = "IEEE1981ST1")
    protected ExcIEEE1981ST1XmlType ieee1981ST1;
    @XmlElement(name = "BPAFJ")
    protected ExcBPAFJXmlType bpafj;
    @XmlElement(name = "IEEE1968Type1")
    protected ExcIEEE1968Type1XmlType ieee1968Type1;
    @XmlElement(name = "IEEE1968Type1S")
    protected ExcIEEE1968Type1SXmlType ieee1968Type1S;
    @XmlElement(name = "IEEE1968Type2")
    protected ExcIEEE1968Type2XmlType ieee1968Type2;
    @XmlElement(name = "IEEE1968Type3")
    protected ExcIEEE1968Type3XmlType ieee1968Type3;
    @XmlElement(name = "IEEE1968Type4")
    protected ExcIEEE1968Type4XmlType ieee1968Type4;
    @XmlElement(name = "IEEEModified1968Type1")
    protected ExcIEEEModified1968Type1XmlType ieeeModified1968Type1;
    @XmlElement(name = "IEEE1981NewExcSystem")
    protected ExcIEEE1981NewExcSystemXmlType ieee1981NewExcSystem;
    @XmlElement(name = "IEEETypeDC2")
    protected ExcIEEETypeDC2XmlType ieeeTypeDC2;

    /**
     * Gets the value of the ieee1992TypeAC1A property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEE1992TypeAC1AXmlType }
     *     
     */
    public ExcIEEE1992TypeAC1AXmlType getIEEE1992TypeAC1A() {
        return ieee1992TypeAC1A;
    }

    /**
     * Sets the value of the ieee1992TypeAC1A property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEE1992TypeAC1AXmlType }
     *     
     */
    public void setIEEE1992TypeAC1A(ExcIEEE1992TypeAC1AXmlType value) {
        this.ieee1992TypeAC1A = value;
    }

    /**
     * Gets the value of the ieee1981TypeAC2 property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEE1981TypeAC2XmlType }
     *     
     */
    public ExcIEEE1981TypeAC2XmlType getIEEE1981TypeAC2() {
        return ieee1981TypeAC2;
    }

    /**
     * Sets the value of the ieee1981TypeAC2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEE1981TypeAC2XmlType }
     *     
     */
    public void setIEEE1981TypeAC2(ExcIEEE1981TypeAC2XmlType value) {
        this.ieee1981TypeAC2 = value;
    }

    /**
     * Gets the value of the ieee1981ST1 property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEE1981ST1XmlType }
     *     
     */
    public ExcIEEE1981ST1XmlType getIEEE1981ST1() {
        return ieee1981ST1;
    }

    /**
     * Sets the value of the ieee1981ST1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEE1981ST1XmlType }
     *     
     */
    public void setIEEE1981ST1(ExcIEEE1981ST1XmlType value) {
        this.ieee1981ST1 = value;
    }

    /**
     * Gets the value of the bpafj property.
     * 
     * @return
     *     possible object is
     *     {@link ExcBPAFJXmlType }
     *     
     */
    public ExcBPAFJXmlType getBPAFJ() {
        return bpafj;
    }

    /**
     * Sets the value of the bpafj property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcBPAFJXmlType }
     *     
     */
    public void setBPAFJ(ExcBPAFJXmlType value) {
        this.bpafj = value;
    }

    /**
     * Gets the value of the ieee1968Type1 property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEE1968Type1XmlType }
     *     
     */
    public ExcIEEE1968Type1XmlType getIEEE1968Type1() {
        return ieee1968Type1;
    }

    /**
     * Sets the value of the ieee1968Type1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEE1968Type1XmlType }
     *     
     */
    public void setIEEE1968Type1(ExcIEEE1968Type1XmlType value) {
        this.ieee1968Type1 = value;
    }

    /**
     * Gets the value of the ieee1968Type1S property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEE1968Type1SXmlType }
     *     
     */
    public ExcIEEE1968Type1SXmlType getIEEE1968Type1S() {
        return ieee1968Type1S;
    }

    /**
     * Sets the value of the ieee1968Type1S property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEE1968Type1SXmlType }
     *     
     */
    public void setIEEE1968Type1S(ExcIEEE1968Type1SXmlType value) {
        this.ieee1968Type1S = value;
    }

    /**
     * Gets the value of the ieee1968Type2 property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEE1968Type2XmlType }
     *     
     */
    public ExcIEEE1968Type2XmlType getIEEE1968Type2() {
        return ieee1968Type2;
    }

    /**
     * Sets the value of the ieee1968Type2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEE1968Type2XmlType }
     *     
     */
    public void setIEEE1968Type2(ExcIEEE1968Type2XmlType value) {
        this.ieee1968Type2 = value;
    }

    /**
     * Gets the value of the ieee1968Type3 property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEE1968Type3XmlType }
     *     
     */
    public ExcIEEE1968Type3XmlType getIEEE1968Type3() {
        return ieee1968Type3;
    }

    /**
     * Sets the value of the ieee1968Type3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEE1968Type3XmlType }
     *     
     */
    public void setIEEE1968Type3(ExcIEEE1968Type3XmlType value) {
        this.ieee1968Type3 = value;
    }

    /**
     * Gets the value of the ieee1968Type4 property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEE1968Type4XmlType }
     *     
     */
    public ExcIEEE1968Type4XmlType getIEEE1968Type4() {
        return ieee1968Type4;
    }

    /**
     * Sets the value of the ieee1968Type4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEE1968Type4XmlType }
     *     
     */
    public void setIEEE1968Type4(ExcIEEE1968Type4XmlType value) {
        this.ieee1968Type4 = value;
    }

    /**
     * Gets the value of the ieeeModified1968Type1 property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEEModified1968Type1XmlType }
     *     
     */
    public ExcIEEEModified1968Type1XmlType getIEEEModified1968Type1() {
        return ieeeModified1968Type1;
    }

    /**
     * Sets the value of the ieeeModified1968Type1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEEModified1968Type1XmlType }
     *     
     */
    public void setIEEEModified1968Type1(ExcIEEEModified1968Type1XmlType value) {
        this.ieeeModified1968Type1 = value;
    }

    /**
     * Gets the value of the ieee1981NewExcSystem property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEE1981NewExcSystemXmlType }
     *     
     */
    public ExcIEEE1981NewExcSystemXmlType getIEEE1981NewExcSystem() {
        return ieee1981NewExcSystem;
    }

    /**
     * Sets the value of the ieee1981NewExcSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEE1981NewExcSystemXmlType }
     *     
     */
    public void setIEEE1981NewExcSystem(ExcIEEE1981NewExcSystemXmlType value) {
        this.ieee1981NewExcSystem = value;
    }

    /**
     * Gets the value of the ieeeTypeDC2 property.
     * 
     * @return
     *     possible object is
     *     {@link ExcIEEETypeDC2XmlType }
     *     
     */
    public ExcIEEETypeDC2XmlType getIEEETypeDC2() {
        return ieeeTypeDC2;
    }

    /**
     * Sets the value of the ieeeTypeDC2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcIEEETypeDC2XmlType }
     *     
     */
    public void setIEEETypeDC2(ExcIEEETypeDC2XmlType value) {
        this.ieeeTypeDC2 = value;
    }

}
