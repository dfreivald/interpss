//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.04 at 05:26:16 PM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClassicMachineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassicMachineXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="genName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basePower" type="{http://www.ieee.org/odm/Schema}ActivePowerXmlType" minOccurs="0"/>
 *         &lt;element name="xd1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="H" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="D" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassicMachineXmlType", propOrder = {
    "genName",
    "desc",
    "basePower",
    "xd1",
    "h",
    "d"
})
public class ClassicMachineXmlType {

    protected String genName;
    protected String desc;
    protected ActivePowerXmlType basePower;
    protected double xd1;
    @XmlElement(name = "H")
    protected double h;
    @XmlElement(name = "D")
    protected double d;

    /**
     * Gets the value of the genName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenName() {
        return genName;
    }

    /**
     * Sets the value of the genName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenName(String value) {
        this.genName = value;
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
     *     {@link ActivePowerXmlType }
     *     
     */
    public ActivePowerXmlType getBasePower() {
        return basePower;
    }

    /**
     * Sets the value of the basePower property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public void setBasePower(ActivePowerXmlType value) {
        this.basePower = value;
    }

    /**
     * Gets the value of the xd1 property.
     * 
     */
    public double getXd1() {
        return xd1;
    }

    /**
     * Sets the value of the xd1 property.
     * 
     */
    public void setXd1(double value) {
        this.xd1 = value;
    }

    /**
     * Gets the value of the h property.
     * 
     */
    public double getH() {
        return h;
    }

    /**
     * Sets the value of the h property.
     * 
     */
    public void setH(double value) {
        this.h = value;
    }

    /**
     * Gets the value of the d property.
     * 
     */
    public double getD() {
        return d;
    }

    /**
     * Sets the value of the d property.
     * 
     */
    public void setD(double value) {
        this.d = value;
    }

}
