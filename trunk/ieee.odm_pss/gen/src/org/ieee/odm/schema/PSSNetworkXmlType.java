//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.21 at 03:39:47 PM MST 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PSSNetworkXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSSNetworkXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema}IDRecordXmlType">
 *       &lt;sequence>
 *         &lt;element name="networkCategory" type="{http://www.ieee.org/odm/Schema}NetworkCategoryEnumType"/>
 *         &lt;element name="analysisCategory" type="{http://www.ieee.org/odm/Schema}AnalysisCategoryEnumType"/>
 *         &lt;element name="hasLoadflowData" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="basePower" type="{http://www.ieee.org/odm/Schema}ApparentPowerXmlType"/>
 *         &lt;element name="busList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="bus" type="{http://www.ieee.org/odm/Schema}BusRecordXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="branchList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="branch" type="{http://www.ieee.org/odm/Schema}BranchRecordXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dcLineList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dcLint2T" type="{http://www.ieee.org/odm/Schema}DCLineData2TXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="dcLintMT" type="{http://www.ieee.org/odm/Schema}DCLineDataMTXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="areaList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="area" type="{http://www.ieee.org/odm/Schema}NetAreaXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="lossZoneList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="lossZone" type="{http://www.ieee.org/odm/Schema}NetZoneXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="interchangeList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="interchange" type="{http://www.ieee.org/odm/Schema}InterchangeXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="tieLineList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tieline" type="{http://www.ieee.org/odm/Schema}TielineXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="xfrZTable" type="{http://www.ieee.org/odm/Schema}XformerZTableXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSSNetworkXmlType", propOrder = {
    "networkCategory",
    "analysisCategory",
    "hasLoadflowData",
    "basePower",
    "busList",
    "branchList",
    "dcLineList",
    "areaList",
    "lossZoneList",
    "interchangeList",
    "tieLineList",
    "xfrZTable"
})
public class PSSNetworkXmlType
    extends IDRecordXmlType
{

    @XmlElement(required = true)
    protected NetworkCategoryEnumType networkCategory;
    @XmlElement(required = true)
    protected AnalysisCategoryEnumType analysisCategory;
    protected Boolean hasLoadflowData;
    @XmlElement(required = true)
    protected ApparentPowerXmlType basePower;
    @XmlElement(required = true)
    protected PSSNetworkXmlType.BusList busList;
    @XmlElement(required = true)
    protected PSSNetworkXmlType.BranchList branchList;
    protected PSSNetworkXmlType.DcLineList dcLineList;
    protected PSSNetworkXmlType.AreaList areaList;
    protected PSSNetworkXmlType.LossZoneList lossZoneList;
    protected PSSNetworkXmlType.InterchangeList interchangeList;
    protected PSSNetworkXmlType.TieLineList tieLineList;
    protected XformerZTableXmlType xfrZTable;

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
     * Gets the value of the hasLoadflowData property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasLoadflowData() {
        return hasLoadflowData;
    }

    /**
     * Sets the value of the hasLoadflowData property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasLoadflowData(Boolean value) {
        this.hasLoadflowData = value;
    }

    /**
     * Gets the value of the basePower property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public ApparentPowerXmlType getBasePower() {
        return basePower;
    }

    /**
     * Sets the value of the basePower property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public void setBasePower(ApparentPowerXmlType value) {
        this.basePower = value;
    }

    /**
     * Gets the value of the busList property.
     * 
     * @return
     *     possible object is
     *     {@link PSSNetworkXmlType.BusList }
     *     
     */
    public PSSNetworkXmlType.BusList getBusList() {
        return busList;
    }

    /**
     * Sets the value of the busList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PSSNetworkXmlType.BusList }
     *     
     */
    public void setBusList(PSSNetworkXmlType.BusList value) {
        this.busList = value;
    }

    /**
     * Gets the value of the branchList property.
     * 
     * @return
     *     possible object is
     *     {@link PSSNetworkXmlType.BranchList }
     *     
     */
    public PSSNetworkXmlType.BranchList getBranchList() {
        return branchList;
    }

    /**
     * Sets the value of the branchList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PSSNetworkXmlType.BranchList }
     *     
     */
    public void setBranchList(PSSNetworkXmlType.BranchList value) {
        this.branchList = value;
    }

    /**
     * Gets the value of the dcLineList property.
     * 
     * @return
     *     possible object is
     *     {@link PSSNetworkXmlType.DcLineList }
     *     
     */
    public PSSNetworkXmlType.DcLineList getDcLineList() {
        return dcLineList;
    }

    /**
     * Sets the value of the dcLineList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PSSNetworkXmlType.DcLineList }
     *     
     */
    public void setDcLineList(PSSNetworkXmlType.DcLineList value) {
        this.dcLineList = value;
    }

    /**
     * Gets the value of the areaList property.
     * 
     * @return
     *     possible object is
     *     {@link PSSNetworkXmlType.AreaList }
     *     
     */
    public PSSNetworkXmlType.AreaList getAreaList() {
        return areaList;
    }

    /**
     * Sets the value of the areaList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PSSNetworkXmlType.AreaList }
     *     
     */
    public void setAreaList(PSSNetworkXmlType.AreaList value) {
        this.areaList = value;
    }

    /**
     * Gets the value of the lossZoneList property.
     * 
     * @return
     *     possible object is
     *     {@link PSSNetworkXmlType.LossZoneList }
     *     
     */
    public PSSNetworkXmlType.LossZoneList getLossZoneList() {
        return lossZoneList;
    }

    /**
     * Sets the value of the lossZoneList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PSSNetworkXmlType.LossZoneList }
     *     
     */
    public void setLossZoneList(PSSNetworkXmlType.LossZoneList value) {
        this.lossZoneList = value;
    }

    /**
     * Gets the value of the interchangeList property.
     * 
     * @return
     *     possible object is
     *     {@link PSSNetworkXmlType.InterchangeList }
     *     
     */
    public PSSNetworkXmlType.InterchangeList getInterchangeList() {
        return interchangeList;
    }

    /**
     * Sets the value of the interchangeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PSSNetworkXmlType.InterchangeList }
     *     
     */
    public void setInterchangeList(PSSNetworkXmlType.InterchangeList value) {
        this.interchangeList = value;
    }

    /**
     * Gets the value of the tieLineList property.
     * 
     * @return
     *     possible object is
     *     {@link PSSNetworkXmlType.TieLineList }
     *     
     */
    public PSSNetworkXmlType.TieLineList getTieLineList() {
        return tieLineList;
    }

    /**
     * Sets the value of the tieLineList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PSSNetworkXmlType.TieLineList }
     *     
     */
    public void setTieLineList(PSSNetworkXmlType.TieLineList value) {
        this.tieLineList = value;
    }

    /**
     * Gets the value of the xfrZTable property.
     * 
     * @return
     *     possible object is
     *     {@link XformerZTableXmlType }
     *     
     */
    public XformerZTableXmlType getXfrZTable() {
        return xfrZTable;
    }

    /**
     * Sets the value of the xfrZTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link XformerZTableXmlType }
     *     
     */
    public void setXfrZTable(XformerZTableXmlType value) {
        this.xfrZTable = value;
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
     *         &lt;element name="area" type="{http://www.ieee.org/odm/Schema}NetAreaXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "area"
    })
    public static class AreaList {

        protected List<NetAreaXmlType> area;

        /**
         * Gets the value of the area property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the area property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getArea().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NetAreaXmlType }
         * 
         * 
         */
        public List<NetAreaXmlType> getArea() {
            if (area == null) {
                area = new ArrayList<NetAreaXmlType>();
            }
            return this.area;
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
     *         &lt;element name="branch" type="{http://www.ieee.org/odm/Schema}BranchRecordXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "branch"
    })
    public static class BranchList {

        protected List<BranchRecordXmlType> branch;

        /**
         * Gets the value of the branch property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the branch property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBranch().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BranchRecordXmlType }
         * 
         * 
         */
        public List<BranchRecordXmlType> getBranch() {
            if (branch == null) {
                branch = new ArrayList<BranchRecordXmlType>();
            }
            return this.branch;
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
     *         &lt;element name="bus" type="{http://www.ieee.org/odm/Schema}BusRecordXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "bus"
    })
    public static class BusList {

        protected List<BusRecordXmlType> bus;

        /**
         * Gets the value of the bus property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bus property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBus().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusRecordXmlType }
         * 
         * 
         */
        public List<BusRecordXmlType> getBus() {
            if (bus == null) {
                bus = new ArrayList<BusRecordXmlType>();
            }
            return this.bus;
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
     *         &lt;element name="dcLint2T" type="{http://www.ieee.org/odm/Schema}DCLineData2TXmlType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="dcLintMT" type="{http://www.ieee.org/odm/Schema}DCLineDataMTXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "dcLint2T",
        "dcLintMT"
    })
    public static class DcLineList {

        protected List<DCLineData2TXmlType> dcLint2T;
        protected List<DCLineDataMTXmlType> dcLintMT;

        /**
         * Gets the value of the dcLint2T property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dcLint2T property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDcLint2T().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DCLineData2TXmlType }
         * 
         * 
         */
        public List<DCLineData2TXmlType> getDcLint2T() {
            if (dcLint2T == null) {
                dcLint2T = new ArrayList<DCLineData2TXmlType>();
            }
            return this.dcLint2T;
        }

        /**
         * Gets the value of the dcLintMT property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dcLintMT property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDcLintMT().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DCLineDataMTXmlType }
         * 
         * 
         */
        public List<DCLineDataMTXmlType> getDcLintMT() {
            if (dcLintMT == null) {
                dcLintMT = new ArrayList<DCLineDataMTXmlType>();
            }
            return this.dcLintMT;
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
     *         &lt;element name="interchange" type="{http://www.ieee.org/odm/Schema}InterchangeXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "interchange"
    })
    public static class InterchangeList {

        protected List<InterchangeXmlType> interchange;

        /**
         * Gets the value of the interchange property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the interchange property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInterchange().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InterchangeXmlType }
         * 
         * 
         */
        public List<InterchangeXmlType> getInterchange() {
            if (interchange == null) {
                interchange = new ArrayList<InterchangeXmlType>();
            }
            return this.interchange;
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
     *         &lt;element name="lossZone" type="{http://www.ieee.org/odm/Schema}NetZoneXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "lossZone"
    })
    public static class LossZoneList {

        protected List<NetZoneXmlType> lossZone;

        /**
         * Gets the value of the lossZone property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lossZone property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLossZone().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NetZoneXmlType }
         * 
         * 
         */
        public List<NetZoneXmlType> getLossZone() {
            if (lossZone == null) {
                lossZone = new ArrayList<NetZoneXmlType>();
            }
            return this.lossZone;
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
     *         &lt;element name="tieline" type="{http://www.ieee.org/odm/Schema}TielineXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "tieline"
    })
    public static class TieLineList {

        protected List<TielineXmlType> tieline;

        /**
         * Gets the value of the tieline property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tieline property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTieline().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TielineXmlType }
         * 
         * 
         */
        public List<TielineXmlType> getTieline() {
            if (tieline == null) {
                tieline = new ArrayList<TielineXmlType>();
            }
            return this.tieline;
        }

    }

}
