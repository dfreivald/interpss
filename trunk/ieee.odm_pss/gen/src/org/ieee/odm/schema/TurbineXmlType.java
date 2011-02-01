//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.31 at 09:52:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TurbineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TurbineXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="steamTurbine " type="{http://www.ieee.org/odm/Schema/2008}SteamTurbineXmlType" minOccurs="0"/>
 *         &lt;element name="hydraulicTurbine " type="{http://www.ieee.org/odm/Schema/2008}HydraulicTurbineXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TurbineXmlType", propOrder = {
    "steamTurbine0020",
    "hydraulicTurbine0020"
})
public class TurbineXmlType {

    @XmlElement(name = "steamTurbine ")
    protected SteamTurbineXmlType steamTurbine0020;
    @XmlElement(name = "hydraulicTurbine ")
    protected HydraulicTurbineXmlType hydraulicTurbine0020;

    /**
     * Gets the value of the steamTurbine0020 property.
     * 
     * @return
     *     possible object is
     *     {@link SteamTurbineXmlType }
     *     
     */
    public SteamTurbineXmlType getSteamTurbine_0020() {
        return steamTurbine0020;
    }

    /**
     * Sets the value of the steamTurbine0020 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SteamTurbineXmlType }
     *     
     */
    public void setSteamTurbine_0020(SteamTurbineXmlType value) {
        this.steamTurbine0020 = value;
    }

    /**
     * Gets the value of the hydraulicTurbine0020 property.
     * 
     * @return
     *     possible object is
     *     {@link HydraulicTurbineXmlType }
     *     
     */
    public HydraulicTurbineXmlType getHydraulicTurbine_0020() {
        return hydraulicTurbine0020;
    }

    /**
     * Sets the value of the hydraulicTurbine0020 property.
     * 
     * @param value
     *     allowed object is
     *     {@link HydraulicTurbineXmlType }
     *     
     */
    public void setHydraulicTurbine_0020(HydraulicTurbineXmlType value) {
        this.hydraulicTurbine0020 = value;
    }

}
