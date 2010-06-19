//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.19 at 07:37:24 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusDynDataListXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusDynDataListXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="generatorDataList" type="{http://www.ieee.org/odm/Schema}GeneratorDataListXmlType" minOccurs="0"/>
 *         &lt;element name="exciterDataList" type="{http://www.ieee.org/odm/Schema}ExciterDataListXmlType" minOccurs="0"/>
 *         &lt;element name="turbineGovernorDataList" type="{http://www.ieee.org/odm/Schema}TurbineGovernorDataListXmlType" minOccurs="0"/>
 *         &lt;element name="stabilizerDataList" type="{http://www.ieee.org/odm/Schema}StabilizerDataListXmlType" minOccurs="0"/>
 *         &lt;element name="LoadCharacteristicDataList" type="{http://www.ieee.org/odm/Schema}LoadCharacteristicDataListXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusDynDataListXmlType", propOrder = {
    "generatorDataList",
    "exciterDataList",
    "turbineGovernorDataList",
    "stabilizerDataList",
    "loadCharacteristicDataList"
})
public class BusDynDataListXmlType {

    protected GeneratorDataListXmlType generatorDataList;
    protected ExciterDataListXmlType exciterDataList;
    protected TurbineGovernorDataListXmlType turbineGovernorDataList;
    protected StabilizerDataListXmlType stabilizerDataList;
    @XmlElement(name = "LoadCharacteristicDataList")
    protected LoadCharacteristicDataListXmlType loadCharacteristicDataList;

    /**
     * Gets the value of the generatorDataList property.
     * 
     * @return
     *     possible object is
     *     {@link GeneratorDataListXmlType }
     *     
     */
    public GeneratorDataListXmlType getGeneratorDataList() {
        return generatorDataList;
    }

    /**
     * Sets the value of the generatorDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneratorDataListXmlType }
     *     
     */
    public void setGeneratorDataList(GeneratorDataListXmlType value) {
        this.generatorDataList = value;
    }

    /**
     * Gets the value of the exciterDataList property.
     * 
     * @return
     *     possible object is
     *     {@link ExciterDataListXmlType }
     *     
     */
    public ExciterDataListXmlType getExciterDataList() {
        return exciterDataList;
    }

    /**
     * Sets the value of the exciterDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExciterDataListXmlType }
     *     
     */
    public void setExciterDataList(ExciterDataListXmlType value) {
        this.exciterDataList = value;
    }

    /**
     * Gets the value of the turbineGovernorDataList property.
     * 
     * @return
     *     possible object is
     *     {@link TurbineGovernorDataListXmlType }
     *     
     */
    public TurbineGovernorDataListXmlType getTurbineGovernorDataList() {
        return turbineGovernorDataList;
    }

    /**
     * Sets the value of the turbineGovernorDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurbineGovernorDataListXmlType }
     *     
     */
    public void setTurbineGovernorDataList(TurbineGovernorDataListXmlType value) {
        this.turbineGovernorDataList = value;
    }

    /**
     * Gets the value of the stabilizerDataList property.
     * 
     * @return
     *     possible object is
     *     {@link StabilizerDataListXmlType }
     *     
     */
    public StabilizerDataListXmlType getStabilizerDataList() {
        return stabilizerDataList;
    }

    /**
     * Sets the value of the stabilizerDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link StabilizerDataListXmlType }
     *     
     */
    public void setStabilizerDataList(StabilizerDataListXmlType value) {
        this.stabilizerDataList = value;
    }

    /**
     * Gets the value of the loadCharacteristicDataList property.
     * 
     * @return
     *     possible object is
     *     {@link LoadCharacteristicDataListXmlType }
     *     
     */
    public LoadCharacteristicDataListXmlType getLoadCharacteristicDataList() {
        return loadCharacteristicDataList;
    }

    /**
     * Sets the value of the loadCharacteristicDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadCharacteristicDataListXmlType }
     *     
     */
    public void setLoadCharacteristicDataList(LoadCharacteristicDataListXmlType value) {
        this.loadCharacteristicDataList = value;
    }

}
