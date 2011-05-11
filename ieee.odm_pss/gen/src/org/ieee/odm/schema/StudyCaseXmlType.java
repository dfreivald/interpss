//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.10 at 08:49:57 PM GMT-05:00 
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
 *         &lt;element name="networkCategory" type="{http://www.ieee.org/odm/Schema/2008}NetworkCategoryEnumType"/>
 *         &lt;element name="analysisCategory" type="{http://www.ieee.org/odm/Schema/2008}AnalysisCategoryEnumType"/>
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
 *         &lt;element ref="{http://www.ieee.org/odm/Schema/2008}studyScenario" minOccurs="0"/>
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
    "networkCategory",
    "analysisCategory",
    "baseCase",
    "modificationList",
    "studyScenario"
})
public class StudyCaseXmlType
    extends IDRecordXmlType
{

    @XmlElement(required = true)
    protected ODMSchemaVersionEnumType schemaVersion;
    protected ContentInfoXmlType contentInfo;
    @XmlElement(required = true)
    protected NetworkCategoryEnumType networkCategory;
    @XmlElement(required = true)
    protected AnalysisCategoryEnumType analysisCategory;
    @XmlElementRef(name = "baseCase", namespace = "http://www.ieee.org/odm/Schema/2008", type = JAXBElement.class)
    protected JAXBElement<? extends NetworkXmlType> baseCase;
    protected StudyCaseXmlType.ModificationList modificationList;
    @XmlElementRef(name = "studyScenario", namespace = "http://www.ieee.org/odm/Schema/2008", type = JAXBElement.class)
    protected JAXBElement<? extends StudyScenarioXmlType> studyScenario;

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
     * Gets the value of the networkCategory property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkCategoryEnumType }
     *     
     */
    public NetworkCategoryEnumType getNetworkCategory() {
        return networkCategory;
    }

    /**
     * Sets the value of the networkCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkCategoryEnumType }
     *     
     */
    public void setNetworkCategory(NetworkCategoryEnumType value) {
        this.networkCategory = value;
    }

    /**
     * Gets the value of the analysisCategory property.
     * 
     * @return
     *     possible object is
     *     {@link AnalysisCategoryEnumType }
     *     
     */
    public AnalysisCategoryEnumType getAnalysisCategory() {
        return analysisCategory;
    }

    /**
     * Sets the value of the analysisCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnalysisCategoryEnumType }
     *     
     */
    public void setAnalysisCategory(AnalysisCategoryEnumType value) {
        this.analysisCategory = value;
    }

    /**
     * 
     * 						Base case power network data for power system simulation purpose
     * 						
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DStabNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DistributionNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ShortCircuitNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OpfNetworkXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DcNetworkXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NetworkXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LoadflowNetXmlType }{@code >}
     *     
     */
    public JAXBElement<? extends NetworkXmlType> getBaseCase() {
        return baseCase;
    }

    /**
     * 
     * 						Base case power network data for power system simulation purpose
     * 						
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DStabNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DistributionNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ShortCircuitNetXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OpfNetworkXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DcNetworkXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NetworkXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LoadflowNetXmlType }{@code >}
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
     * 
     * 						A study case might include a list of study scenarios, for example, Loadflow study, SC study ...
     * 						
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IpssStudyScenarioXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link StudyScenarioXmlType }{@code >}
     *     
     */
    public JAXBElement<? extends StudyScenarioXmlType> getStudyScenario() {
        return studyScenario;
    }

    /**
     * 
     * 						A study case might include a list of study scenarios, for example, Loadflow study, SC study ...
     * 						
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IpssStudyScenarioXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link StudyScenarioXmlType }{@code >}
     *     
     */
    public void setStudyScenario(JAXBElement<? extends StudyScenarioXmlType> value) {
        this.studyScenario = ((JAXBElement<? extends StudyScenarioXmlType> ) value);
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

}
