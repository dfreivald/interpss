//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.28 at 12:18:44 AM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DynamicBusDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DynamicBusDataXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="machineList" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="machine" type="{http://www.ieee.org/odm/Schema/2008}DynamicGeneratorXmlType"/>
 *                   &lt;element name="exciter" type="{http://www.ieee.org/odm/Schema/2008}ExciterModelXmlType" minOccurs="0"/>
 *                   &lt;element name="governor" type="{http://www.ieee.org/odm/Schema/2008}GovernorModelXmlType" minOccurs="0"/>
 *                   &lt;element name="stabilizer" type="{http://www.ieee.org/odm/Schema/2008}StabilizerModelXmlType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dynamicLoad" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="location" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicLocationEnumType"/>
 *                   &lt;element name="LoadXmlType" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicTypeEnumType"/>
 *                   &lt;element name="LoadModel" type="{http://www.ieee.org/odm/Schema/2008}DynamicLoadModelSelectionXmlType"/>
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
@XmlType(name = "DynamicBusDataXmlType", propOrder = {
    "machineList",
    "dynamicLoad"
})
public class DynamicBusDataXmlType {

    protected List<DynamicBusDataXmlType.MachineList> machineList;
    protected DynamicBusDataXmlType.DynamicLoad dynamicLoad;

    /**
     * Gets the value of the machineList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the machineList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMachineList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DynamicBusDataXmlType.MachineList }
     * 
     * 
     */
    public List<DynamicBusDataXmlType.MachineList> getMachineList() {
        if (machineList == null) {
            machineList = new ArrayList<DynamicBusDataXmlType.MachineList>();
        }
        return this.machineList;
    }

    /**
     * Gets the value of the dynamicLoad property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicBusDataXmlType.DynamicLoad }
     *     
     */
    public DynamicBusDataXmlType.DynamicLoad getDynamicLoad() {
        return dynamicLoad;
    }

    /**
     * Sets the value of the dynamicLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicBusDataXmlType.DynamicLoad }
     *     
     */
    public void setDynamicLoad(DynamicBusDataXmlType.DynamicLoad value) {
        this.dynamicLoad = value;
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
     *         &lt;element name="location" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicLocationEnumType"/>
     *         &lt;element name="LoadXmlType" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicTypeEnumType"/>
     *         &lt;element name="LoadModel" type="{http://www.ieee.org/odm/Schema/2008}DynamicLoadModelSelectionXmlType"/>
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
        "location",
        "loadXmlType",
        "loadModel"
    })
    public static class DynamicLoad {

        @XmlElement(required = true)
        protected LoadCharacteristicLocationEnumType location;
        @XmlElement(name = "LoadXmlType", required = true)
        protected LoadCharacteristicTypeEnumType loadXmlType;
        @XmlElement(name = "LoadModel", required = true)
        protected DynamicLoadModelSelectionXmlType loadModel;

        /**
         * Gets the value of the location property.
         * 
         * @return
         *     possible object is
         *     {@link LoadCharacteristicLocationEnumType }
         *     
         */
        public LoadCharacteristicLocationEnumType getLocation() {
            return location;
        }

        /**
         * Sets the value of the location property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadCharacteristicLocationEnumType }
         *     
         */
        public void setLocation(LoadCharacteristicLocationEnumType value) {
            this.location = value;
        }

        /**
         * Gets the value of the loadXmlType property.
         * 
         * @return
         *     possible object is
         *     {@link LoadCharacteristicTypeEnumType }
         *     
         */
        public LoadCharacteristicTypeEnumType getLoadXmlType() {
            return loadXmlType;
        }

        /**
         * Sets the value of the loadXmlType property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadCharacteristicTypeEnumType }
         *     
         */
        public void setLoadXmlType(LoadCharacteristicTypeEnumType value) {
            this.loadXmlType = value;
        }

        /**
         * Gets the value of the loadModel property.
         * 
         * @return
         *     possible object is
         *     {@link DynamicLoadModelSelectionXmlType }
         *     
         */
        public DynamicLoadModelSelectionXmlType getLoadModel() {
            return loadModel;
        }

        /**
         * Sets the value of the loadModel property.
         * 
         * @param value
         *     allowed object is
         *     {@link DynamicLoadModelSelectionXmlType }
         *     
         */
        public void setLoadModel(DynamicLoadModelSelectionXmlType value) {
            this.loadModel = value;
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
     *         &lt;element name="machine" type="{http://www.ieee.org/odm/Schema/2008}DynamicGeneratorXmlType"/>
     *         &lt;element name="exciter" type="{http://www.ieee.org/odm/Schema/2008}ExciterModelXmlType" minOccurs="0"/>
     *         &lt;element name="governor" type="{http://www.ieee.org/odm/Schema/2008}GovernorModelXmlType" minOccurs="0"/>
     *         &lt;element name="stabilizer" type="{http://www.ieee.org/odm/Schema/2008}StabilizerModelXmlType" minOccurs="0"/>
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
        "machine",
        "exciter",
        "governor",
        "stabilizer"
    })
    public static class MachineList {

        @XmlElement(required = true)
        protected DynamicGeneratorXmlType machine;
        protected ExciterModelXmlType exciter;
        protected GovernorModelXmlType governor;
        protected StabilizerModelXmlType stabilizer;

        /**
         * Gets the value of the machine property.
         * 
         * @return
         *     possible object is
         *     {@link DynamicGeneratorXmlType }
         *     
         */
        public DynamicGeneratorXmlType getMachine() {
            return machine;
        }

        /**
         * Sets the value of the machine property.
         * 
         * @param value
         *     allowed object is
         *     {@link DynamicGeneratorXmlType }
         *     
         */
        public void setMachine(DynamicGeneratorXmlType value) {
            this.machine = value;
        }

        /**
         * Gets the value of the exciter property.
         * 
         * @return
         *     possible object is
         *     {@link ExciterModelXmlType }
         *     
         */
        public ExciterModelXmlType getExciter() {
            return exciter;
        }

        /**
         * Sets the value of the exciter property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExciterModelXmlType }
         *     
         */
        public void setExciter(ExciterModelXmlType value) {
            this.exciter = value;
        }

        /**
         * Gets the value of the governor property.
         * 
         * @return
         *     possible object is
         *     {@link GovernorModelXmlType }
         *     
         */
        public GovernorModelXmlType getGovernor() {
            return governor;
        }

        /**
         * Sets the value of the governor property.
         * 
         * @param value
         *     allowed object is
         *     {@link GovernorModelXmlType }
         *     
         */
        public void setGovernor(GovernorModelXmlType value) {
            this.governor = value;
        }

        /**
         * Gets the value of the stabilizer property.
         * 
         * @return
         *     possible object is
         *     {@link StabilizerModelXmlType }
         *     
         */
        public StabilizerModelXmlType getStabilizer() {
            return stabilizer;
        }

        /**
         * Sets the value of the stabilizer property.
         * 
         * @param value
         *     allowed object is
         *     {@link StabilizerModelXmlType }
         *     
         */
        public void setStabilizer(StabilizerModelXmlType value) {
            this.stabilizer = value;
        }

    }

}
