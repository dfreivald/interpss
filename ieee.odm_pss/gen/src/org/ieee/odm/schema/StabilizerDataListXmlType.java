//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.19 at 07:37:24 AM GMT-08:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StabilizerDataListXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StabilizerDataListXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stabilizer" type="{http://www.ieee.org/odm/Schema}StabilizerXmlType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StabilizerDataListXmlType", propOrder = {
    "stabilizer"
})
public class StabilizerDataListXmlType {

    @XmlElement(required = true)
    protected List<StabilizerXmlType> stabilizer;

    /**
     * Gets the value of the stabilizer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stabilizer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStabilizer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StabilizerXmlType }
     * 
     * 
     */
    public List<StabilizerXmlType> getStabilizer() {
        if (stabilizer == null) {
            stabilizer = new ArrayList<StabilizerXmlType>();
        }
        return this.stabilizer;
    }

}
