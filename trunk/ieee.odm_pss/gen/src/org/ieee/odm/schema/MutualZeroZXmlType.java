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
 * <p>Java class for MutualZeroZXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MutualZeroZXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="branchFromBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="branchToBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="branchCirId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zM" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="bIJ1pu" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bIJ2pu" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bKL1pu" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bKL2pu" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MutualZeroZXmlType", propOrder = {
    "branchFromBus",
    "branchToBus",
    "branchCirId",
    "zm",
    "bij1Pu",
    "bij2Pu",
    "bkl1Pu",
    "bkl2Pu"
})
public class MutualZeroZXmlType {

    @XmlElement(required = true)
    protected IDRefRecordXmlType branchFromBus;
    @XmlElement(required = true)
    protected IDRefRecordXmlType branchToBus;
    protected String branchCirId;
    @XmlElement(name = "zM")
    protected ZXmlType zm;
    @XmlElement(name = "bIJ1pu")
    protected Double bij1Pu;
    @XmlElement(name = "bIJ2pu")
    protected Double bij2Pu;
    @XmlElement(name = "bKL1pu")
    protected Double bkl1Pu;
    @XmlElement(name = "bKL2pu")
    protected Double bkl2Pu;

    /**
     * Gets the value of the branchFromBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getBranchFromBus() {
        return branchFromBus;
    }

    /**
     * Sets the value of the branchFromBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setBranchFromBus(IDRefRecordXmlType value) {
        this.branchFromBus = value;
    }

    /**
     * Gets the value of the branchToBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getBranchToBus() {
        return branchToBus;
    }

    /**
     * Sets the value of the branchToBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setBranchToBus(IDRefRecordXmlType value) {
        this.branchToBus = value;
    }

    /**
     * Gets the value of the branchCirId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchCirId() {
        return branchCirId;
    }

    /**
     * Sets the value of the branchCirId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchCirId(String value) {
        this.branchCirId = value;
    }

    /**
     * Gets the value of the zm property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZM() {
        return zm;
    }

    /**
     * Sets the value of the zm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZM(ZXmlType value) {
        this.zm = value;
    }

    /**
     * Gets the value of the bij1Pu property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBIJ1Pu() {
        return bij1Pu;
    }

    /**
     * Sets the value of the bij1Pu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBIJ1Pu(Double value) {
        this.bij1Pu = value;
    }

    /**
     * Gets the value of the bij2Pu property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBIJ2Pu() {
        return bij2Pu;
    }

    /**
     * Sets the value of the bij2Pu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBIJ2Pu(Double value) {
        this.bij2Pu = value;
    }

    /**
     * Gets the value of the bkl1Pu property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBKL1Pu() {
        return bkl1Pu;
    }

    /**
     * Sets the value of the bkl1Pu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBKL1Pu(Double value) {
        this.bkl1Pu = value;
    }

    /**
     * Gets the value of the bkl2Pu property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBKL2Pu() {
        return bkl2Pu;
    }

    /**
     * Sets the value of the bkl2Pu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBKL2Pu(Double value) {
        this.bkl2Pu = value;
    }

}
