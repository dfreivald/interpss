//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.24 at 06:07:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for PVModelPointXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PVModelPointXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="volt" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="amp" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PVModelPointXmlType")
public class PVModelPointXmlType {

    @XmlAttribute(required = true)
    protected double volt;
    @XmlAttribute(required = true)
    protected double amp;

    /**
     * Gets the value of the volt property.
     * 
     */
    public double getVolt() {
        return volt;
    }

    /**
     * Sets the value of the volt property.
     * 
     */
    public void setVolt(double value) {
        this.volt = value;
    }

    /**
     * Gets the value of the amp property.
     * 
     */
    public double getAmp() {
        return amp;
    }

    /**
     * Sets the value of the amp property.
     * 
     */
    public void setAmp(double value) {
        this.amp = value;
    }

}
