//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.10 at 04:31:09 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeneratorModelListXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneratorModelListXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="equivGenUnit" type="{http://www.ieee.org/odm/Schema/2008}EquiMachineXmlType" minOccurs="0"/>
 *         &lt;element name="classicalModel" type="{http://www.ieee.org/odm/Schema/2008}ClassicMachineXmlType" minOccurs="0"/>
 *         &lt;element name="transModel" type="{http://www.ieee.org/odm/Schema/2008}Eq1Ed1MachineXmlType" minOccurs="0"/>
 *         &lt;element name="subTransientModel" type="{http://www.ieee.org/odm/Schema/2008}Eq11Ed11MachineXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneratorModelListXmlType", propOrder = {
    "equivGenUnit",
    "classicalModel",
    "transModel",
    "subTransientModel"
})
public class GeneratorModelListXmlType {

    protected EquiMachineXmlType equivGenUnit;
    protected ClassicMachineXmlType classicalModel;
    protected Eq1Ed1MachineXmlType transModel;
    protected Eq11Ed11MachineXmlType subTransientModel;

    /**
     * Gets the value of the equivGenUnit property.
     * 
     * @return
     *     possible object is
     *     {@link EquiMachineXmlType }
     *     
     */
    public EquiMachineXmlType getEquivGenUnit() {
        return equivGenUnit;
    }

    /**
     * Sets the value of the equivGenUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquiMachineXmlType }
     *     
     */
    public void setEquivGenUnit(EquiMachineXmlType value) {
        this.equivGenUnit = value;
    }

    /**
     * Gets the value of the classicalModel property.
     * 
     * @return
     *     possible object is
     *     {@link ClassicMachineXmlType }
     *     
     */
    public ClassicMachineXmlType getClassicalModel() {
        return classicalModel;
    }

    /**
     * Sets the value of the classicalModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassicMachineXmlType }
     *     
     */
    public void setClassicalModel(ClassicMachineXmlType value) {
        this.classicalModel = value;
    }

    /**
     * Gets the value of the transModel property.
     * 
     * @return
     *     possible object is
     *     {@link Eq1Ed1MachineXmlType }
     *     
     */
    public Eq1Ed1MachineXmlType getTransModel() {
        return transModel;
    }

    /**
     * Sets the value of the transModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Eq1Ed1MachineXmlType }
     *     
     */
    public void setTransModel(Eq1Ed1MachineXmlType value) {
        this.transModel = value;
    }

    /**
     * Gets the value of the subTransientModel property.
     * 
     * @return
     *     possible object is
     *     {@link Eq11Ed11MachineXmlType }
     *     
     */
    public Eq11Ed11MachineXmlType getSubTransientModel() {
        return subTransientModel;
    }

    /**
     * Sets the value of the subTransientModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Eq11Ed11MachineXmlType }
     *     
     */
    public void setSubTransientModel(Eq11Ed11MachineXmlType value) {
        this.subTransientModel = value;
    }

}
