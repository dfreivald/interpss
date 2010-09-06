//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.05 at 07:56:06 PM GMT-05:00 
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
    "ka",
    "ta",
    "vrmax",
    "vrmin"
})
public class ExcSimpleTypeXmlType
    extends ExciterModelXmlType
{

    @XmlElement(name = "Ka")
    protected double ka;
    @XmlElement(name = "Ta", required = true)
    protected TimePeriodXmlType ta;
    @XmlElement(name = "Vrmax")
    protected double vrmax;
    @XmlElement(name = "Vrmin")
    protected double vrmin;

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
