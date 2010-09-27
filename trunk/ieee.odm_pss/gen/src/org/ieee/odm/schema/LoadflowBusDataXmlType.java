//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.27 at 04:59:51 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoadflowBusDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoadflowBusDataXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="voltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="angle" type="{http://www.ieee.org/odm/Schema/2008}AngleXmlType" minOccurs="0"/>
 *         &lt;element name="genData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="equivGen" type="{http://www.ieee.org/odm/Schema/2008}LoadflowGenDataXmlType" minOccurs="0"/>
 *                   &lt;element name="contributeGenList" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="contributeGen" type="{http://www.ieee.org/odm/Schema/2008}LoadflowGenDataXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="loadData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="equivLoad" type="{http://www.ieee.org/odm/Schema/2008}LoadflowLoadDataXmlType" minOccurs="0"/>
 *                   &lt;element name="contributeLoadList" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="contributeLoad" type="{http://www.ieee.org/odm/Schema/2008}LoadflowLoadDataXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="shuntCompensatorData" type="{http://www.ieee.org/odm/Schema/2008}ShuntCompensatorDataXmlType" minOccurs="0"/>
 *         &lt;element name="shuntY" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="powerInjection" type="{http://www.ieee.org/odm/Schema/2008}PowerXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadflowBusDataXmlType", propOrder = {
    "voltage",
    "angle",
    "genData",
    "loadData",
    "shuntCompensatorData",
    "shuntY",
    "powerInjection"
})
public class LoadflowBusDataXmlType {

    protected VoltageXmlType voltage;
    protected AngleXmlType angle;
    protected LoadflowBusDataXmlType.GenData genData;
    protected LoadflowBusDataXmlType.LoadData loadData;
    protected ShuntCompensatorDataXmlType shuntCompensatorData;
    protected YXmlType shuntY;
    protected PowerXmlType powerInjection;

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
     * Gets the value of the angle property.
     * 
     * @return
     *     possible object is
     *     {@link AngleXmlType }
     *     
     */
    public AngleXmlType getAngle() {
        return angle;
    }

    /**
     * Sets the value of the angle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleXmlType }
     *     
     */
    public void setAngle(AngleXmlType value) {
        this.angle = value;
    }

    /**
     * Gets the value of the genData property.
     * 
     * @return
     *     possible object is
     *     {@link LoadflowBusDataXmlType.GenData }
     *     
     */
    public LoadflowBusDataXmlType.GenData getGenData() {
        return genData;
    }

    /**
     * Sets the value of the genData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadflowBusDataXmlType.GenData }
     *     
     */
    public void setGenData(LoadflowBusDataXmlType.GenData value) {
        this.genData = value;
    }

    /**
     * Gets the value of the loadData property.
     * 
     * @return
     *     possible object is
     *     {@link LoadflowBusDataXmlType.LoadData }
     *     
     */
    public LoadflowBusDataXmlType.LoadData getLoadData() {
        return loadData;
    }

    /**
     * Sets the value of the loadData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadflowBusDataXmlType.LoadData }
     *     
     */
    public void setLoadData(LoadflowBusDataXmlType.LoadData value) {
        this.loadData = value;
    }

    /**
     * Gets the value of the shuntCompensatorData property.
     * 
     * @return
     *     possible object is
     *     {@link ShuntCompensatorDataXmlType }
     *     
     */
    public ShuntCompensatorDataXmlType getShuntCompensatorData() {
        return shuntCompensatorData;
    }

    /**
     * Sets the value of the shuntCompensatorData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShuntCompensatorDataXmlType }
     *     
     */
    public void setShuntCompensatorData(ShuntCompensatorDataXmlType value) {
        this.shuntCompensatorData = value;
    }

    /**
     * Gets the value of the shuntY property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getShuntY() {
        return shuntY;
    }

    /**
     * Sets the value of the shuntY property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setShuntY(YXmlType value) {
        this.shuntY = value;
    }

    /**
     * Gets the value of the powerInjection property.
     * 
     * @return
     *     possible object is
     *     {@link PowerXmlType }
     *     
     */
    public PowerXmlType getPowerInjection() {
        return powerInjection;
    }

    /**
     * Sets the value of the powerInjection property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerXmlType }
     *     
     */
    public void setPowerInjection(PowerXmlType value) {
        this.powerInjection = value;
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
     *         &lt;element name="equivGen" type="{http://www.ieee.org/odm/Schema/2008}LoadflowGenDataXmlType" minOccurs="0"/>
     *         &lt;element name="contributeGenList" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="contributeGen" type="{http://www.ieee.org/odm/Schema/2008}LoadflowGenDataXmlType" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "equivGen",
        "contributeGenList"
    })
    public static class GenData {

        protected LoadflowGenDataXmlType equivGen;
        protected LoadflowBusDataXmlType.GenData.ContributeGenList contributeGenList;

        /**
         * Gets the value of the equivGen property.
         * 
         * @return
         *     possible object is
         *     {@link LoadflowGenDataXmlType }
         *     
         */
        public LoadflowGenDataXmlType getEquivGen() {
            return equivGen;
        }

        /**
         * Sets the value of the equivGen property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadflowGenDataXmlType }
         *     
         */
        public void setEquivGen(LoadflowGenDataXmlType value) {
            this.equivGen = value;
        }

        /**
         * Gets the value of the contributeGenList property.
         * 
         * @return
         *     possible object is
         *     {@link LoadflowBusDataXmlType.GenData.ContributeGenList }
         *     
         */
        public LoadflowBusDataXmlType.GenData.ContributeGenList getContributeGenList() {
            return contributeGenList;
        }

        /**
         * Sets the value of the contributeGenList property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadflowBusDataXmlType.GenData.ContributeGenList }
         *     
         */
        public void setContributeGenList(LoadflowBusDataXmlType.GenData.ContributeGenList value) {
            this.contributeGenList = value;
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
         *         &lt;element name="contributeGen" type="{http://www.ieee.org/odm/Schema/2008}LoadflowGenDataXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
            "contributeGen"
        })
        public static class ContributeGenList {

            protected List<LoadflowGenDataXmlType> contributeGen;

            /**
             * Gets the value of the contributeGen property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the contributeGen property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContributeGen().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LoadflowGenDataXmlType }
             * 
             * 
             */
            public List<LoadflowGenDataXmlType> getContributeGen() {
                if (contributeGen == null) {
                    contributeGen = new ArrayList<LoadflowGenDataXmlType>();
                }
                return this.contributeGen;
            }

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
     *         &lt;element name="equivLoad" type="{http://www.ieee.org/odm/Schema/2008}LoadflowLoadDataXmlType" minOccurs="0"/>
     *         &lt;element name="contributeLoadList" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="contributeLoad" type="{http://www.ieee.org/odm/Schema/2008}LoadflowLoadDataXmlType" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "equivLoad",
        "contributeLoadList"
    })
    public static class LoadData {

        protected LoadflowLoadDataXmlType equivLoad;
        protected LoadflowBusDataXmlType.LoadData.ContributeLoadList contributeLoadList;

        /**
         * Gets the value of the equivLoad property.
         * 
         * @return
         *     possible object is
         *     {@link LoadflowLoadDataXmlType }
         *     
         */
        public LoadflowLoadDataXmlType getEquivLoad() {
            return equivLoad;
        }

        /**
         * Sets the value of the equivLoad property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadflowLoadDataXmlType }
         *     
         */
        public void setEquivLoad(LoadflowLoadDataXmlType value) {
            this.equivLoad = value;
        }

        /**
         * Gets the value of the contributeLoadList property.
         * 
         * @return
         *     possible object is
         *     {@link LoadflowBusDataXmlType.LoadData.ContributeLoadList }
         *     
         */
        public LoadflowBusDataXmlType.LoadData.ContributeLoadList getContributeLoadList() {
            return contributeLoadList;
        }

        /**
         * Sets the value of the contributeLoadList property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadflowBusDataXmlType.LoadData.ContributeLoadList }
         *     
         */
        public void setContributeLoadList(LoadflowBusDataXmlType.LoadData.ContributeLoadList value) {
            this.contributeLoadList = value;
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
         *         &lt;element name="contributeLoad" type="{http://www.ieee.org/odm/Schema/2008}LoadflowLoadDataXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
            "contributeLoad"
        })
        public static class ContributeLoadList {

            protected List<LoadflowLoadDataXmlType> contributeLoad;

            /**
             * Gets the value of the contributeLoad property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the contributeLoad property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContributeLoad().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LoadflowLoadDataXmlType }
             * 
             * 
             */
            public List<LoadflowLoadDataXmlType> getContributeLoad() {
                if (contributeLoad == null) {
                    contributeLoad = new ArrayList<LoadflowLoadDataXmlType>();
                }
                return this.contributeLoad;
            }

        }

    }

}
