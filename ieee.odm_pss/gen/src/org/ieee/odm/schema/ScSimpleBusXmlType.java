//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.28 at 12:18:44 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScSimpleBusXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScSimpleBusXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BusXmlType">
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
@XmlType(name = "ScSimpleBusXmlType", propOrder = {
    "scGenData",
    "scShuntLoadData",
    "scSwithedShuntLoadData"
})
public class ScSimpleBusXmlType
    extends BusXmlType
{

    protected ScSimpleBusXmlType.ScGenData scGenData;
    protected ScSimpleBusXmlType.ScShuntLoadData scShuntLoadData;
    protected ScSimpleBusXmlType.ScSwithedShuntLoadData scSwithedShuntLoadData;
    @XmlAttribute(required = true)
    protected ShortCircuitBusEnumType scCode;

    /**
     * Gets the value of the scGenData property.
     * 
     * @return
     *     possible object is
     *     {@link ScSimpleBusXmlType.ScGenData }
     *     
     */
    public ScSimpleBusXmlType.ScGenData getScGenData() {
        return scGenData;
    }

    /**
     * Sets the value of the scGenData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScSimpleBusXmlType.ScGenData }
     *     
     */
    public void setScGenData(ScSimpleBusXmlType.ScGenData value) {
        this.scGenData = value;
    }

    /**
     * Gets the value of the scShuntLoadData property.
     * 
     * @return
     *     possible object is
     *     {@link ScSimpleBusXmlType.ScShuntLoadData }
     *     
     */
    public ScSimpleBusXmlType.ScShuntLoadData getScShuntLoadData() {
        return scShuntLoadData;
    }

    /**
     * Sets the value of the scShuntLoadData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScSimpleBusXmlType.ScShuntLoadData }
     *     
     */
    public void setScShuntLoadData(ScSimpleBusXmlType.ScShuntLoadData value) {
        this.scShuntLoadData = value;
    }

    /**
     * Gets the value of the scSwithedShuntLoadData property.
     * 
     * @return
     *     possible object is
     *     {@link ScSimpleBusXmlType.ScSwithedShuntLoadData }
     *     
     */
    public ScSimpleBusXmlType.ScSwithedShuntLoadData getScSwithedShuntLoadData() {
        return scSwithedShuntLoadData;
    }

    /**
     * Sets the value of the scSwithedShuntLoadData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScSimpleBusXmlType.ScSwithedShuntLoadData }
     *     
     */
    public void setScSwithedShuntLoadData(ScSimpleBusXmlType.ScSwithedShuntLoadData value) {
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
     *         &lt;element name="grounding" type="{http://www.ieee.org/odm/Schema/2008}GroundConnectionXmlType" minOccurs="0"/>
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
        protected GroundConnectionXmlType grounding;

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
         *     {@link GroundConnectionXmlType }
         *     
         */
        public GroundConnectionXmlType getGrounding() {
            return grounding;
        }

        /**
         * Sets the value of the grounding property.
         * 
         * @param value
         *     allowed object is
         *     {@link GroundConnectionXmlType }
         *     
         */
        public void setGrounding(GroundConnectionXmlType value) {
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
