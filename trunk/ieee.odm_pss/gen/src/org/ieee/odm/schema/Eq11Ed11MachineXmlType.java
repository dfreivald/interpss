//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.28 at 12:18:44 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Eq11Ed11MachineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Eq11Ed11MachineXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}Eq1Ed1MachineXmlType">
 *       &lt;sequence>
 *         &lt;element name="xd11" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Td011" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="xq11" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Tq011" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Eq11Ed11MachineXmlType", propOrder = {
    "xd11",
    "td011",
    "xq11",
    "tq011"
})
public class Eq11Ed11MachineXmlType
    extends Eq1Ed1MachineXmlType
{

    protected double xd11;
    @XmlElement(name = "Td011", required = true)
    protected TimePeriodXmlType td011;
    protected double xq11;
    @XmlElement(name = "Tq011", required = true)
    protected TimePeriodXmlType tq011;

    /**
     * Gets the value of the xd11 property.
     * 
     */
    public double getXd11() {
        return xd11;
    }

    /**
     * Sets the value of the xd11 property.
     * 
     */
    public void setXd11(double value) {
        this.xd11 = value;
    }

    /**
     * Gets the value of the td011 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTd011() {
        return td011;
    }

    /**
     * Sets the value of the td011 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTd011(TimePeriodXmlType value) {
        this.td011 = value;
    }

    /**
     * Gets the value of the xq11 property.
     * 
     */
    public double getXq11() {
        return xq11;
    }

    /**
     * Sets the value of the xq11 property.
     * 
     */
    public void setXq11(double value) {
        this.xq11 = value;
    }

    /**
     * Gets the value of the tq011 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTq011() {
        return tq011;
    }

    /**
     * Sets the value of the tq011 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTq011(TimePeriodXmlType value) {
        this.tq011 = value;
    }

}
