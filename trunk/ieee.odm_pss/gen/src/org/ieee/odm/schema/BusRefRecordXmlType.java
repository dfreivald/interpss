//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.10 at 08:49:57 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusRefRecordXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusRefRecordXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="windingType" type="{http://www.ieee.org/odm/Schema/2008}BusWindingEnumType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusRefRecordXmlType")
public class BusRefRecordXmlType
    extends IDRefRecordXmlType
{

    @XmlAttribute
    protected BusWindingEnumType windingType;

    /**
     * Gets the value of the windingType property.
     * 
     * @return
     *     possible object is
     *     {@link BusWindingEnumType }
     *     
     */
    public BusWindingEnumType getWindingType() {
        return windingType;
    }

    /**
     * Sets the value of the windingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusWindingEnumType }
     *     
     */
    public void setWindingType(BusWindingEnumType value) {
        this.windingType = value;
    }

}
