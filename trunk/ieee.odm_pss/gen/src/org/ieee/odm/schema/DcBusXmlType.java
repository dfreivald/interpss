//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.24 at 04:05:23 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		
 * 
 * <p>Java class for DcBusXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DcBusXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BusXmlType">
 *       &lt;sequence>
 *         &lt;element name="voltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="power" type="{http://www.ieee.org/odm/Schema/2008}ActivePowerXmlType" minOccurs="0"/>
 *         &lt;element name="load" type="{http://www.ieee.org/odm/Schema/2008}ActivePowerXmlType" minOccurs="0"/>
 *         &lt;element name="pvModule" type="{http://www.ieee.org/odm/Schema/2008}PVModuleXmlType" minOccurs="0"/>
 *         &lt;element name="inverter" type="{http://www.ieee.org/odm/Schema/2008}DcAcInverterXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="code" use="required" type="{http://www.ieee.org/odm/Schema/2008}DcBusCodeEnumType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DcBusXmlType", propOrder = {
    "voltage",
    "power",
    "load",
    "pvModule",
    "inverter"
})
public class DcBusXmlType
    extends BusXmlType
{

    protected VoltageXmlType voltage;
    protected ActivePowerXmlType power;
    protected ActivePowerXmlType load;
    protected PVModuleXmlType pvModule;
    protected DcAcInverterXmlType inverter;
    @XmlAttribute(required = true)
    protected DcBusCodeEnumType code;

    /**
     * Gets the value of the voltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getVoltage() {
        return voltage;
    }

    /**
     * Sets the value of the voltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setVoltage(VoltageXmlType value) {
        this.voltage = value;
    }

    /**
     * Gets the value of the power property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public ActivePowerXmlType getPower() {
        return power;
    }

    /**
     * Sets the value of the power property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public void setPower(ActivePowerXmlType value) {
        this.power = value;
    }

    /**
     * Gets the value of the load property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public ActivePowerXmlType getLoad() {
        return load;
    }

    /**
     * Sets the value of the load property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public void setLoad(ActivePowerXmlType value) {
        this.load = value;
    }

    /**
     * Gets the value of the pvModule property.
     * 
     * @return
     *     possible object is
     *     {@link PVModuleXmlType }
     *     
     */
    public PVModuleXmlType getPvModule() {
        return pvModule;
    }

    /**
     * Sets the value of the pvModule property.
     * 
     * @param value
     *     allowed object is
     *     {@link PVModuleXmlType }
     *     
     */
    public void setPvModule(PVModuleXmlType value) {
        this.pvModule = value;
    }

    /**
     * Gets the value of the inverter property.
     * 
     * @return
     *     possible object is
     *     {@link DcAcInverterXmlType }
     *     
     */
    public DcAcInverterXmlType getInverter() {
        return inverter;
    }

    /**
     * Sets the value of the inverter property.
     * 
     * @param value
     *     allowed object is
     *     {@link DcAcInverterXmlType }
     *     
     */
    public void setInverter(DcAcInverterXmlType value) {
        this.inverter = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link DcBusCodeEnumType }
     *     
     */
    public DcBusCodeEnumType getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link DcBusCodeEnumType }
     *     
     */
    public void setCode(DcBusCodeEnumType value) {
        this.code = value;
    }

}
