//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.18 at 03:58:50 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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

    protected ShortCircuitBusXmlType.ScGenData scGenData;
    protected ShortCircuitBusXmlType.ScShuntLoadData scShuntLoadData;
    protected ShortCircuitBusXmlType.ScSwithedShuntLoadData scSwithedShuntLoadData;
    @XmlAttribute(required = true)
    protected ShortCircuitBusEnumType scCode;

    /**
     * Gets the value of the scGenData property.
     * 
     * @return
     *     possible object is
     *     {@link ShortCircuitBusXmlType.ScGenData }
     *     
     */
    public ShortCircuitBusXmlType.ScGenData getScGenData() {
        return scGenData;
    }

    /**
     * Sets the value of the scGenData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortCircuitBusXmlType.ScGenData }
     *     
     */
    public void setScGenData(ShortCircuitBusXmlType.ScGenData value) {
        this.scGenData = value;
    }

    /**
     * Gets the value of the scShuntLoadData property.
     * 
     * @return
     *     possible object is
     *     {@link ShortCircuitBusXmlType.ScShuntLoadData }
     *     
     */
    public ShortCircuitBusXmlType.ScShuntLoadData getScShuntLoadData() {
        return scShuntLoadData;
    }

    /**
     * Sets the value of the scShuntLoadData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortCircuitBusXmlType.ScShuntLoadData }
     *     
     */
    public void setScShuntLoadData(ShortCircuitBusXmlType.ScShuntLoadData value) {
        this.scShuntLoadData = value;
    }

    /**
     * Gets the value of the scSwithedShuntLoadData property.
     * 
     * @return
     *     possible object is
     *     {@link ShortCircuitBusXmlType.ScSwithedShuntLoadData }
     *     
     */
    public ShortCircuitBusXmlType.ScSwithedShuntLoadData getScSwithedShuntLoadData() {
        return scSwithedShuntLoadData;
    }

    /**
     * Sets the value of the scSwithedShuntLoadData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortCircuitBusXmlType.ScSwithedShuntLoadData }
     *     
     */
    public void setScSwithedShuntLoadData(ShortCircuitBusXmlType.ScSwithedShuntLoadData value) {
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
    public static class ScGenData {

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
    public static class ScShuntLoadData {

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
    public static class ScSwithedShuntLoadData {

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
