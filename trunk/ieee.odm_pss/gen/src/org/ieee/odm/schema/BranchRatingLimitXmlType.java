//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.18 at 03:58:50 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BranchRatingLimitXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BranchRatingLimitXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mva" type="{http://www.ieee.org/odm/Schema/2008}MvaRatingXmlType" minOccurs="0"/>
 *         &lt;element name="current" type="{http://www.ieee.org/odm/Schema/2008}CurrentXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BranchRatingLimitXmlType", propOrder = {
    "mva",
    "current"
})
public class BranchRatingLimitXmlType {

    protected MvaRatingXmlType mva;
    protected CurrentXmlType current;

    /**
     * Gets the value of the mva property.
     * 
     * @return
     *     possible object is
     *     {@link MvaRatingXmlType }
     *     
     */
    public MvaRatingXmlType getMva() {
        return mva;
    }

    /**
     * Sets the value of the mva property.
     * 
     * @param value
     *     allowed object is
     *     {@link MvaRatingXmlType }
     *     
     */
    public void setMva(MvaRatingXmlType value) {
        this.mva = value;
    }

    /**
     * Gets the value of the current property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentXmlType }
     *     
     */
    public CurrentXmlType getCurrent() {
        return current;
    }

    /**
     * Sets the value of the current property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentXmlType }
     *     
     */
    public void setCurrent(CurrentXmlType value) {
        this.current = value;
    }

}
