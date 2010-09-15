//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.15 at 01:46:12 PM MST 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StudyCaseXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StudyCaseXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}IDRecordXmlType">
 *       &lt;sequence>
 *         &lt;element name="schemaVersion" type="{http://www.ieee.org/odm/Schema/2008}ODMSchemaVersionEnumType"/>
 *         &lt;element name="contentInfo" type="{http://www.ieee.org/odm/Schema/2008}ContentInfoXmlType" minOccurs="0"/>
 *         &lt;element ref="{http://www.ieee.org/odm/Schema/2008}baseCase"/>
 *         &lt;element name="modificationList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="modification" type="{http://www.ieee.org/odm/Schema/2008}ModifyRecordXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="scenarioList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="scenario" type="{http://www.ieee.org/odm/Schema/2008}ScenarioXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "StudyCaseXmlType", propOrder = {
    "schemaVersion",
    "contentInfo",
    "baseCase",
    "modificationList",
    "scenarioList"
})
public class StudyCaseXmlType
    extends IDRecordXmlType
{

    @XmlElement(required = true)
    protected ODMSchemaVersionEnumType schemaVersion;
    protected ContentInfoXmlType contentInfo;
    @XmlElementRef(name = "baseCase", namespace = "http://www.ieee.org/odm/Schema/2008", type = JAXBElement.class)
    protected JAXBElement<? extends NetworkXmlType> baseCase;
    protected StudyCaseXmlType.ModificationList modificationList;
    protected StudyCaseXmlType.ScenarioList scenarioList;

    /**
     * Gets the value of the schemaVersion property.
     * 
     * @return
     *     possible object is
     *     {@link ODMSchemaVersionEnumType }
     *     
     */
    public ODMSchemaVersionEnumType getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * Sets the value of the schemaVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ODMSchemaVersionEnumType }
     *     
     */
    public void setSchemaVersion(ODMSchemaVersionEnumType value) {
        this.schemaVersion = value;
    }

    /**
     * Gets the value of the contentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContentInfoXmlType }
     *     
     */
    public ContentInfoXmlType getContentInfo() {
        return contentInfo;
    }

    /**
     * Sets the value of the contentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentInfoXmlType }
     *     
     */
    public void setContentInfo(ContentInfoXmlType value) {
        this.contentInfo = value;
    }

    /**
     * Base case power network data for power system simulation purpose
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NetworkXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LoadflowNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ShortCircuitNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DStabNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NetworkXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OpfNetworkXmlType }{@code >}
     *     
     */
    public JAXBElement<? extends NetworkXmlType> getBaseCase() {
        return baseCase;
    }

    /**
     * Base case power network data for power system simulation purpose
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NetworkXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LoadflowNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ShortCircuitNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DStabNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NetworkXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OpfNetworkXmlType }{@code >}
     *     
     */
    public void setBaseCase(JAXBElement<? extends NetworkXmlType> value) {
        this.baseCase = ((JAXBElement<? extends NetworkXmlType> ) value);
    }

    /**
     * Gets the value of the modificationList property.
     * 
     * @return
     *     possible object is
     *     {@link StudyCaseXmlType.ModificationList }
     *     
     */
    public StudyCaseXmlType.ModificationList getModificationList() {
        return modificationList;
    }

    /**
     * Sets the value of the modificationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudyCaseXmlType.ModificationList }
     *     
     */
    public void setModificationList(StudyCaseXmlType.ModificationList value) {
        this.modificationList = value;
    }

    /**
     * Gets the value of the scenarioList property.
     * 
     * @return
     *     possible object is
     *     {@link StudyCaseXmlType.ScenarioList }
     *     
     */
    public StudyCaseXmlType.ScenarioList getScenarioList() {
        return scenarioList;
    }

    /**
     * Sets the value of the scenarioList property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudyCaseXmlType.ScenarioList }
     *     
     */
    public void setScenarioList(StudyCaseXmlType.ScenarioList value) {
        this.scenarioList = value;
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
     *         &lt;element name="modification" type="{http://www.ieee.org/odm/Schema/2008}ModifyRecordXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "modification"
    })
    public static class ModificationList {

        protected List<ModifyRecordXmlType> modification;

        /**
         * Gets the value of the modification property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the modification property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getModification().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ModifyRecordXmlType }
         * 
         * 
         */
        public List<ModifyRecordXmlType> getModification() {
            if (modification == null) {
                modification = new ArrayList<ModifyRecordXmlType>();
            }
            return this.modification;
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
     *         &lt;element name="scenario" type="{http://www.ieee.org/odm/Schema/2008}ScenarioXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "scenario"
    })
    public static class ScenarioList {

        protected List<ScenarioXmlType> scenario;

        /**
         * Gets the value of the scenario property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the scenario property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getScenario().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ScenarioXmlType }
         * 
         * 
         */
        public List<ScenarioXmlType> getScenario() {
            if (scenario == null) {
                scenario = new ArrayList<ScenarioXmlType>();
            }
            return this.scenario;
        }

    }

}
