//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.23 at 07:20:34 AM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusRecordXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusRecordXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BusXmlType">
 *       &lt;sequence>
 *         &lt;element name="loadflowData" type="{http://www.ieee.org/odm/Schema/2008}LoadflowBusDataXmlType" minOccurs="0"/>
 *         &lt;element name="sequenceData" type="{http://www.ieee.org/odm/Schema/2008}SequenceBusDataXmlType" minOccurs="0"/>
 *         &lt;element name="dynamicData" type="{http://www.ieee.org/odm/Schema/2008}DynamicBusDataXmlType" minOccurs="0"/>
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
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusRecordXmlType", propOrder = {
    "loadflowData",
    "sequenceData",
    "dynamicData",
    "svcData"
})
public class BusRecordXmlType
    extends BusXmlType
{

    protected LoadflowBusDataXmlType loadflowData;
    protected SequenceBusDataXmlType sequenceData;
    protected DynamicBusDataXmlType dynamicData;
    protected BusRecordXmlType.SvcData svcData;

    /**
     * Gets the value of the loadflowData property.
     * 
     * @return
     *     possible object is
     *     {@link LoadflowBusDataXmlType }
     *     
     */
    public LoadflowBusDataXmlType getLoadflowData() {
        return loadflowData;
    }

    /**
     * Sets the value of the loadflowData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadflowBusDataXmlType }
     *     
     */
    public void setLoadflowData(LoadflowBusDataXmlType value) {
        this.loadflowData = value;
    }

    /**
     * Gets the value of the sequenceData property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceBusDataXmlType }
     *     
     */
    public SequenceBusDataXmlType getSequenceData() {
        return sequenceData;
    }

    /**
     * Sets the value of the sequenceData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceBusDataXmlType }
     *     
     */
    public void setSequenceData(SequenceBusDataXmlType value) {
        this.sequenceData = value;
    }

    /**
     * Gets the value of the dynamicData property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicBusDataXmlType }
     *     
     */
    public DynamicBusDataXmlType getDynamicData() {
        return dynamicData;
    }

    /**
     * Sets the value of the dynamicData property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicBusDataXmlType }
     *     
     */
    public void setDynamicData(DynamicBusDataXmlType value) {
        this.dynamicData = value;
    }

    /**
     * Gets the value of the svcData property.
     * 
     * @return
     *     possible object is
     *     {@link BusRecordXmlType.SvcData }
     *     
     */
    public BusRecordXmlType.SvcData getSvcData() {
        return svcData;
    }

    /**
     * Sets the value of the svcData property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusRecordXmlType.SvcData }
     *     
     */
    public void setSvcData(BusRecordXmlType.SvcData value) {
        this.svcData = value;
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

        protected BusRecordXmlType.SvcData.SvcList svcList;

        /**
         * Gets the value of the svcList property.
         * 
         * @return
         *     possible object is
         *     {@link BusRecordXmlType.SvcData.SvcList }
         *     
         */
        public BusRecordXmlType.SvcData.SvcList getSvcList() {
            return svcList;
        }

        /**
         * Sets the value of the svcList property.
         * 
         * @param value
         *     allowed object is
         *     {@link BusRecordXmlType.SvcData.SvcList }
         *     
         */
        public void setSvcList(BusRecordXmlType.SvcData.SvcList value) {
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
