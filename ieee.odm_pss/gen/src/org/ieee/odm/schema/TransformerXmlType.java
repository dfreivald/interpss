//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.19 at 07:37:24 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransformerXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransformerXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema}BranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="magnitizingY" type="{http://www.ieee.org/odm/Schema}YXmlType" minOccurs="0"/>
 *         &lt;element name="fromTurnRatio" type="{http://www.ieee.org/odm/Schema}TurnRatioXmlType" minOccurs="0"/>
 *         &lt;element name="toTurnRatio" type="{http://www.ieee.org/odm/Schema}TurnRatioXmlType" minOccurs="0"/>
 *         &lt;element name="meterLocation" type="{http://www.ieee.org/odm/Schema}BranchMeterLocationEnumType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformerXmlType", propOrder = {
    "magnitizingY",
    "fromTurnRatio",
    "toTurnRatio",
    "meterLocation"
})
public class TransformerXmlType
    extends BranchXmlType
{

    protected YXmlType magnitizingY;
    protected TurnRatioXmlType fromTurnRatio;
    protected TurnRatioXmlType toTurnRatio;
    protected BranchMeterLocationEnumType meterLocation;

    /**
     * Gets the value of the magnitizingY property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getMagnitizingY() {
        return magnitizingY;
    }

    /**
     * Sets the value of the magnitizingY property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setMagnitizingY(YXmlType value) {
        this.magnitizingY = value;
    }

    /**
     * Gets the value of the fromTurnRatio property.
     * 
     * @return
     *     possible object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public TurnRatioXmlType getFromTurnRatio() {
        return fromTurnRatio;
    }

    /**
     * Sets the value of the fromTurnRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public void setFromTurnRatio(TurnRatioXmlType value) {
        this.fromTurnRatio = value;
    }

    /**
     * Gets the value of the toTurnRatio property.
     * 
     * @return
     *     possible object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public TurnRatioXmlType getToTurnRatio() {
        return toTurnRatio;
    }

    /**
     * Sets the value of the toTurnRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public void setToTurnRatio(TurnRatioXmlType value) {
        this.toTurnRatio = value;
    }

    /**
     * Gets the value of the meterLocation property.
     * 
     * @return
     *     possible object is
     *     {@link BranchMeterLocationEnumType }
     *     
     */
    public BranchMeterLocationEnumType getMeterLocation() {
        return meterLocation;
    }

    /**
     * Sets the value of the meterLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchMeterLocationEnumType }
     *     
     */
    public void setMeterLocation(BranchMeterLocationEnumType value) {
        this.meterLocation = value;
    }

}
