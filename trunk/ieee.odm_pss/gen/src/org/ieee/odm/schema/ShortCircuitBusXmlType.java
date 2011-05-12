//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.11 at 02:43:09 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		
 * 
 * <p>Java class for ShortCircuitBusXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShortCircuitBusXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}LoadflowBusXmlType">
 *       &lt;group ref="{http://www.ieee.org/odm/Schema/2008}ShortCircuitBusDataGroup"/>
 *       &lt;attribute name="scCode" use="required" type="{http://www.ieee.org/odm/Schema/2008}ShortCircuitBusEnumType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShortCircuitBusXmlType", propOrder = {
    "scGenData",
    "scShuntLoadData",
    "scSwithedShuntLoadData"
})
@XmlSeeAlso({
    DStabBusXmlType.class
})
public class ShortCircuitBusXmlType
    extends LoadflowBusXmlType
{

    protected ScGenDataXmlType scGenData;
    protected org.ieee.odm.schema.ScSimpleBusXmlType.ScShuntLoadData scShuntLoadData;
    protected org.ieee.odm.schema.ScSimpleBusXmlType.ScSwithedShuntLoadData scSwithedShuntLoadData;
    @XmlAttribute(required = true)
    protected ShortCircuitBusEnumType scCode;

    /**
     * Gets the value of the scGenData property.
     * 
     * @return
     *     possible object is
     *     {@link ScGenDataXmlType }
     *     
     */
    public ScGenDataXmlType getScGenData() {
        return scGenData;
    }

    /**
     * Sets the value of the scGenData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScGenDataXmlType }
     *     
     */
    public void setScGenData(ScGenDataXmlType value) {
        this.scGenData = value;
    }

    /**
     * Gets the value of the scShuntLoadData property.
     * 
     * @return
     *     possible object is
     *     {@link org.ieee.odm.schema.ScSimpleBusXmlType.ScShuntLoadData }
     *     
     */
    public org.ieee.odm.schema.ScSimpleBusXmlType.ScShuntLoadData getScShuntLoadData() {
        return scShuntLoadData;
    }

    /**
     * Sets the value of the scShuntLoadData property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.ieee.odm.schema.ScSimpleBusXmlType.ScShuntLoadData }
     *     
     */
    public void setScShuntLoadData(org.ieee.odm.schema.ScSimpleBusXmlType.ScShuntLoadData value) {
        this.scShuntLoadData = value;
    }

    /**
     * Gets the value of the scSwithedShuntLoadData property.
     * 
     * @return
     *     possible object is
     *     {@link org.ieee.odm.schema.ScSimpleBusXmlType.ScSwithedShuntLoadData }
     *     
     */
    public org.ieee.odm.schema.ScSimpleBusXmlType.ScSwithedShuntLoadData getScSwithedShuntLoadData() {
        return scSwithedShuntLoadData;
    }

    /**
     * Sets the value of the scSwithedShuntLoadData property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.ieee.odm.schema.ScSimpleBusXmlType.ScSwithedShuntLoadData }
     *     
     */
    public void setScSwithedShuntLoadData(org.ieee.odm.schema.ScSimpleBusXmlType.ScSwithedShuntLoadData value) {
        this.scSwithedShuntLoadData = value;
    }

    /**
     * Gets the value of the scCode property.
     * 
     * @return
     *     possible object is
     *     {@link ShortCircuitBusEnumType }
     *     
     */
    public ShortCircuitBusEnumType getScCode() {
        return scCode;
    }

    /**
     * Sets the value of the scCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortCircuitBusEnumType }
     *     
     */
    public void setScCode(ShortCircuitBusEnumType value) {
        this.scCode = value;
    }

}
