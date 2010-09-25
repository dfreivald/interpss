//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.25 at 10:50:56 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DStabLoadChangeXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DStabLoadChangeXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loadChangeType" type="{http://www.ieee.org/odm/Schema/2008}DStabLoadChangeEnumType"/>
 *         &lt;element name="changeFactor" type="{http://www.ieee.org/odm/Schema/2008}ChangeFactorXmlType"/>
 *         &lt;element name="threshhold" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="delayTime" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DStabLoadChangeXmlType", propOrder = {
    "busId",
    "loadChangeType",
    "changeFactor",
    "threshhold",
    "delayTime"
})
public class DStabLoadChangeXmlType {

    @XmlElement(required = true)
    protected String busId;
    @XmlElement(required = true)
    protected DStabLoadChangeEnumType loadChangeType;
    @XmlElement(required = true)
    protected ChangeFactorXmlType changeFactor;
    protected Double threshhold;
    protected Double delayTime;

    /**
     * Gets the value of the busId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusId() {
        return busId;
    }

    /**
     * Sets the value of the busId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusId(String value) {
        this.busId = value;
    }

    /**
     * Gets the value of the loadChangeType property.
     * 
     * @return
     *     possible object is
     *     {@link DStabLoadChangeEnumType }
     *     
     */
    public DStabLoadChangeEnumType getLoadChangeType() {
        return loadChangeType;
    }

    /**
     * Sets the value of the loadChangeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DStabLoadChangeEnumType }
     *     
     */
    public void setLoadChangeType(DStabLoadChangeEnumType value) {
        this.loadChangeType = value;
    }

    /**
     * Gets the value of the changeFactor property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeFactorXmlType }
     *     
     */
    public ChangeFactorXmlType getChangeFactor() {
        return changeFactor;
    }

    /**
     * Sets the value of the changeFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeFactorXmlType }
     *     
     */
    public void setChangeFactor(ChangeFactorXmlType value) {
        this.changeFactor = value;
    }

    /**
     * Gets the value of the threshhold property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getThreshhold() {
        return threshhold;
    }

    /**
     * Sets the value of the threshhold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setThreshhold(Double value) {
        this.threshhold = value;
    }

    /**
     * Gets the value of the delayTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDelayTime() {
        return delayTime;
    }

    /**
     * Sets the value of the delayTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDelayTime(Double value) {
        this.delayTime = value;
    }

}
