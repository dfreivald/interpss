//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.12 at 04:33:33 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComplexXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComplexXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="re" type="{http://www.w3.org/2001/XMLSchema}double" default="0.0" />
 *       &lt;attribute name="im" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplexXmlType")
@XmlSeeAlso({
    YXmlType.class,
    ZXmlType.class,
    PowerXmlType.class
})
public class ComplexXmlType {

    @XmlAttribute
    protected Double re;
    @XmlAttribute(required = true)
    protected double im;

    /**
     * Gets the value of the re property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getRe() {
        if (re == null) {
            return  0.0D;
        } else {
            return re;
        }
    }

    /**
     * Sets the value of the re property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRe(Double value) {
        this.re = value;
    }

    /**
     * Gets the value of the im property.
     * 
     */
    public double getIm() {
        return im;
    }

    /**
     * Sets the value of the im property.
     * 
     */
    public void setIm(double value) {
        this.im = value;
    }

}
