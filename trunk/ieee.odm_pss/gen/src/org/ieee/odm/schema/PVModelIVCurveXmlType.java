//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.22 at 06:40:06 AM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for PVModelIVCurveXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PVModelIVCurveXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BasePVModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="ivPoint" type="{http://www.ieee.org/odm/Schema/2008}PVModelPointXmlType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PVModelIVCurveXmlType", propOrder = {
    "ivPoint"
})
public class PVModelIVCurveXmlType
    extends BasePVModelXmlType
{

    @XmlElement(required = true)
    protected List<PVModelPointXmlType> ivPoint;

    /**
     * Gets the value of the ivPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ivPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIvPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PVModelPointXmlType }
     * 
     * 
     */
    public List<PVModelPointXmlType> getIvPoint() {
        if (ivPoint == null) {
            ivPoint = new ArrayList<PVModelPointXmlType>();
        }
        return this.ivPoint;
    }

}
