//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.05 at 10:02:19 AM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		bus record for loadflow study
 * 		
 * 
 * <p>Java class for LoadflowBusXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoadflowBusXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BusXmlType">
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
 *         &lt;element name="svcData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="svcList" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="svc" type="{http://www.ieee.org/odm/Schema/2008}StaticVarCompensatorXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
 *         &lt;element name="powerInjection" type="{http://www.ieee.org/odm/Schema/2008}PowerXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadflowBusXmlType", propOrder = {
    "voltage",
    "angle",
    "genData",
    "loadData",
    "shuntCompensatorData",
    "shuntY",
    "svcData",
    "powerInjection"
})
@XmlSeeAlso({
    ShortCircuitBusXmlType.class,
    OpfGenBusXmlType.class
})
public class LoadflowBusXmlType
    extends BusXmlType
{

    protected VoltageXmlType voltage;
    protected AngleXmlType angle;
    protected LoadflowBusXmlType.GenData genData;
    protected LoadflowBusXmlType.LoadData loadData;
    protected ShuntCompensatorDataXmlType shuntCompensatorData;
    protected YXmlType shuntY;
    protected LoadflowBusXmlType.SvcData svcData;
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
     *     {@link LoadflowBusXmlType.GenData }
     *     
     */
    public LoadflowBusXmlType.GenData getGenData() {
        return genData;
    }

    /**
     * Sets the value of the genData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadflowBusXmlType.GenData }
     *     
     */
    public void setGenData(LoadflowBusXmlType.GenData value) {
        this.genData = value;
    }

    /**
     * Gets the value of the loadData property.
     * 
     * @return
     *     possible object is
     *     {@link LoadflowBusXmlType.LoadData }
     *     
     */
    public LoadflowBusXmlType.LoadData getLoadData() {
        return loadData;
    }

    /**
     * Sets the value of the loadData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadflowBusXmlType.LoadData }
     *     
     */
    public void setLoadData(LoadflowBusXmlType.LoadData value) {
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
     * Gets the value of the svcData property.
     * 
     * @return
     *     possible object is
     *     {@link LoadflowBusXmlType.SvcData }
     *     
     */
    public LoadflowBusXmlType.SvcData getSvcData() {
        return svcData;
    }

    /**
     * Sets the value of the svcData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadflowBusXmlType.SvcData }
     *     
     */
    public void setSvcData(LoadflowBusXmlType.SvcData value) {
        this.svcData = value;
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
        protected LoadflowBusXmlType.GenData.ContributeGenList contributeGenList;

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
         *     {@link LoadflowBusXmlType.GenData.ContributeGenList }
         *     
         */
        public LoadflowBusXmlType.GenData.ContributeGenList getContributeGenList() {
            return contributeGenList;
        }

        /**
         * Sets the value of the contributeGenList property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadflowBusXmlType.GenData.ContributeGenList }
         *     
         */
        public void setContributeGenList(LoadflowBusXmlType.GenData.ContributeGenList value) {
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
        protected LoadflowBusXmlType.LoadData.ContributeLoadList contributeLoadList;

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
         *     {@link LoadflowBusXmlType.LoadData.ContributeLoadList }
         *     
         */
        public LoadflowBusXmlType.LoadData.ContributeLoadList getContributeLoadList() {
            return contributeLoadList;
        }

        /**
         * Sets the value of the contributeLoadList property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadflowBusXmlType.LoadData.ContributeLoadList }
         *     
         */
        public void setContributeLoadList(LoadflowBusXmlType.LoadData.ContributeLoadList value) {
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
     *         &lt;element name="svcList" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="svc" type="{http://www.ieee.org/odm/Schema/2008}StaticVarCompensatorXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "svcList"
    })
    public static class SvcData {

        protected LoadflowBusXmlType.SvcData.SvcList svcList;

        /**
         * Gets the value of the svcList property.
         * 
         * @return
         *     possible object is
         *     {@link LoadflowBusXmlType.SvcData.SvcList }
         *     
         */
        public LoadflowBusXmlType.SvcData.SvcList getSvcList() {
            return svcList;
        }

        /**
         * Sets the value of the svcList property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadflowBusXmlType.SvcData.SvcList }
         *     
         */
        public void setSvcList(LoadflowBusXmlType.SvcData.SvcList value) {
            this.svcList = value;
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
         *         &lt;element name="svc" type="{http://www.ieee.org/odm/Schema/2008}StaticVarCompensatorXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
            "svc"
        })
        public static class SvcList {

            protected List<StaticVarCompensatorXmlType> svc;

            /**
             * Gets the value of the svc property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the svc property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSvc().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link StaticVarCompensatorXmlType }
             * 
             * 
             */
            public List<StaticVarCompensatorXmlType> getSvc() {
                if (svc == null) {
                    svc = new ArrayList<StaticVarCompensatorXmlType>();
                }
                return this.svc;
            }

        }

    }

}
