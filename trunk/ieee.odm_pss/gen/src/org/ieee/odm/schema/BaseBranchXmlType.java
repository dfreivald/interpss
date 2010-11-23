//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.23 at 07:20:34 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseBranchXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseBranchXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}CimConnectionRecordType">
 *       &lt;sequence>
 *         &lt;element name="fromBus" type="{http://www.ieee.org/odm/Schema/2008}BusRefRecordXmlType"/>
 *         &lt;element name="toBus" type="{http://www.ieee.org/odm/Schema/2008}BusRefRecordXmlType"/>
 *         &lt;element name="tertiaryBus" type="{http://www.ieee.org/odm/Schema/2008}BusRefRecordXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="circuitId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseBranchXmlType", propOrder = {
    "fromBus",
    "toBus",
    "tertiaryBus"
})
@XmlSeeAlso({
    DcBranchXmlType.class,
    BreakerDistBranchXmlType.class,
    FeederDistBranchXmlType.class,
    ReactorDistBranchXmlType.class,
    DCLineData2TXmlType.class,
    XFormerDistBranchXmlType.class,
    BranchXmlType.class
})
public abstract class BaseBranchXmlType
    extends CimConnectionRecordType
{

    @XmlElement(required = true)
    protected BusRefRecordXmlType fromBus;
    @XmlElement(required = true)
    protected BusRefRecordXmlType toBus;
    protected BusRefRecordXmlType tertiaryBus;
    @XmlAttribute
    protected String circuitId;

    /**
     * Gets the value of the fromBus property.
     * 
     * @return
     *     possible object is
     *     {@link BusRefRecordXmlType }
     *     
     */
    public BusRefRecordXmlType getFromBus() {
        return fromBus;
    }

    /**
     * Sets the value of the fromBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusRefRecordXmlType }
     *     
     */
    public void setFromBus(BusRefRecordXmlType value) {
        this.fromBus = value;
    }

    /**
     * Gets the value of the toBus property.
     * 
     * @return
     *     possible object is
     *     {@link BusRefRecordXmlType }
     *     
     */
    public BusRefRecordXmlType getToBus() {
        return toBus;
    }

    /**
     * Sets the value of the toBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusRefRecordXmlType }
     *     
     */
    public void setToBus(BusRefRecordXmlType value) {
        this.toBus = value;
    }

    /**
     * Gets the value of the tertiaryBus property.
     * 
     * @return
     *     possible object is
     *     {@link BusRefRecordXmlType }
     *     
     */
    public BusRefRecordXmlType getTertiaryBus() {
        return tertiaryBus;
    }

    /**
     * Sets the value of the tertiaryBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusRefRecordXmlType }
     *     
     */
    public void setTertiaryBus(BusRefRecordXmlType value) {
        this.tertiaryBus = value;
    }

    /**
     * Gets the value of the circuitId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCircuitId() {
        return circuitId;
    }

    /**
     * Sets the value of the circuitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCircuitId(String value) {
        this.circuitId = value;
    }

}
