//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.21 at 03:20:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SequenceBusDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SequenceBusDataXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="genData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="potiveZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType"/>
 *                   &lt;element name="negativeZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *                   &lt;element name="zeroZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *                   &lt;element name="grounding" type="{http://www.ieee.org/odm/Schema/2008}GroundingXmlType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="shuntLoadData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="negativeZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *                   &lt;element name="zeroZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="swithedShuntLoadData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="zeroZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="scCode" use="required" type="{http://www.ieee.org/odm/Schema/2008}ShortCircuitBusEnumType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequenceBusDataXmlType", propOrder = {
    "genData",
    "shuntLoadData",
    "swithedShuntLoadData"
})
public class SequenceBusDataXmlType {

    protected SequenceBusDataXmlType.GenData genData;
    protected SequenceBusDataXmlType.ShuntLoadData shuntLoadData;
    protected SequenceBusDataXmlType.SwithedShuntLoadData swithedShuntLoadData;
    @XmlAttribute(required = true)
    protected ShortCircuitBusEnumType scCode;

    /**
     * Gets the value of the genData property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceBusDataXmlType.GenData }
     *     
     */
    public SequenceBusDataXmlType.GenData getGenData() {
        return genData;
    }

    /**
     * Sets the value of the genData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceBusDataXmlType.GenData }
     *     
     */
    public void setGenData(SequenceBusDataXmlType.GenData value) {
        this.genData = value;
    }

    /**
     * Gets the value of the shuntLoadData property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceBusDataXmlType.ShuntLoadData }
     *     
     */
    public SequenceBusDataXmlType.ShuntLoadData getShuntLoadData() {
        return shuntLoadData;
    }

    /**
     * Sets the value of the shuntLoadData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceBusDataXmlType.ShuntLoadData }
     *     
     */
    public void setShuntLoadData(SequenceBusDataXmlType.ShuntLoadData value) {
        this.shuntLoadData = value;
    }

    /**
     * Gets the value of the swithedShuntLoadData property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceBusDataXmlType.SwithedShuntLoadData }
     *     
     */
    public SequenceBusDataXmlType.SwithedShuntLoadData getSwithedShuntLoadData() {
        return swithedShuntLoadData;
    }

    /**
     * Sets the value of the swithedShuntLoadData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceBusDataXmlType.SwithedShuntLoadData }
     *     
     */
    public void setSwithedShuntLoadData(SequenceBusDataXmlType.SwithedShuntLoadData value) {
        this.swithedShuntLoadData = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="potiveZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType"/>
     *         &lt;element name="negativeZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
     *         &lt;element name="zeroZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
     *         &lt;element name="grounding" type="{http://www.ieee.org/odm/Schema/2008}GroundingXmlType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "potiveZ",
        "negativeZ",
        "zeroZ",
        "grounding"
    })
    public static class GenData {

        @XmlElement(required = true)
        protected ZXmlType potiveZ;
        protected ZXmlType negativeZ;
        protected ZXmlType zeroZ;
        protected GroundingXmlType grounding;

        /**
         * Gets the value of the potiveZ property.
         * 
         * @return
         *     possible object is
         *     {@link ZXmlType }
         *     
         */
        public ZXmlType getPotiveZ() {
            return potiveZ;
        }

        /**
         * Sets the value of the potiveZ property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZXmlType }
         *     
         */
        public void setPotiveZ(ZXmlType value) {
            this.potiveZ = value;
        }

        /**
         * Gets the value of the negativeZ property.
         * 
         * @return
         *     possible object is
         *     {@link ZXmlType }
         *     
         */
        public ZXmlType getNegativeZ() {
            return negativeZ;
        }

        /**
         * Sets the value of the negativeZ property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZXmlType }
         *     
         */
        public void setNegativeZ(ZXmlType value) {
            this.negativeZ = value;
        }

        /**
         * Gets the value of the zeroZ property.
         * 
         * @return
         *     possible object is
         *     {@link ZXmlType }
         *     
         */
        public ZXmlType getZeroZ() {
            return zeroZ;
        }

        /**
         * Sets the value of the zeroZ property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZXmlType }
         *     
         */
        public void setZeroZ(ZXmlType value) {
            this.zeroZ = value;
        }

        /**
         * Gets the value of the grounding property.
         * 
         * @return
         *     possible object is
         *     {@link GroundingXmlType }
         *     
         */
        public GroundingXmlType getGrounding() {
            return grounding;
        }

        /**
         * Sets the value of the grounding property.
         * 
         * @param value
         *     allowed object is
         *     {@link GroundingXmlType }
         *     
         */
        public void setGrounding(GroundingXmlType value) {
            this.grounding = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="negativeZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
     *         &lt;element name="zeroZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "negativeZ",
        "zeroZ"
    })
    public static class ShuntLoadData {

        protected ZXmlType negativeZ;
        protected ZXmlType zeroZ;

        /**
         * Gets the value of the negativeZ property.
         * 
         * @return
         *     possible object is
         *     {@link ZXmlType }
         *     
         */
        public ZXmlType getNegativeZ() {
            return negativeZ;
        }

        /**
         * Sets the value of the negativeZ property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZXmlType }
         *     
         */
        public void setNegativeZ(ZXmlType value) {
            this.negativeZ = value;
        }

        /**
         * Gets the value of the zeroZ property.
         * 
         * @return
         *     possible object is
         *     {@link ZXmlType }
         *     
         */
        public ZXmlType getZeroZ() {
            return zeroZ;
        }

        /**
         * Sets the value of the zeroZ property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZXmlType }
         *     
         */
        public void setZeroZ(ZXmlType value) {
            this.zeroZ = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="zeroZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "zeroZ"
    })
    public static class SwithedShuntLoadData {

        protected ZXmlType zeroZ;

        /**
         * Gets the value of the zeroZ property.
         * 
         * @return
         *     possible object is
         *     {@link ZXmlType }
         *     
         */
        public ZXmlType getZeroZ() {
            return zeroZ;
        }

        /**
         * Sets the value of the zeroZ property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZXmlType }
         *     
         */
        public void setZeroZ(ZXmlType value) {
            this.zeroZ = value;
        }

    }

}
