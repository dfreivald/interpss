//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.20 at 12:17:33 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for InverterLossParamXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InverterLossParamXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="vdc" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="a" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="b" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="c" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InverterLossParamXmlType")
public class InverterLossParamXmlType {

    @XmlAttribute(required = true)
    protected double vdc;
    @XmlAttribute(required = true)
    protected double a;
    @XmlAttribute(required = true)
    protected double b;
    @XmlAttribute(required = true)
    protected double c;

    /**
     * Gets the value of the vdc property.
     * 
     */
    public double getVdc() {
        return vdc;
    }

    /**
     * Sets the value of the vdc property.
     * 
     */
    public void setVdc(double value) {
        this.vdc = value;
    }

    /**
     * Gets the value of the a property.
     * 
     */
    public double getA() {
        return a;
    }

    /**
     * Sets the value of the a property.
     * 
     */
    public void setA(double value) {
        this.a = value;
    }

    /**
     * Gets the value of the b property.
     * 
     */
    public double getB() {
        return b;
    }

    /**
     * Sets the value of the b property.
     * 
     */
    public void setB(double value) {
        this.b = value;
    }

    /**
     * Gets the value of the c property.
     * 
     */
    public double getC() {
        return c;
    }

    /**
     * Sets the value of the c property.
     * 
     */
    public void setC(double value) {
        this.c = value;
    }

}
