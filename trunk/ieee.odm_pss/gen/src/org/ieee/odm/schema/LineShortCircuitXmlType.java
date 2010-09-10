//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.10 at 04:31:09 PM MST 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LineShortCircuitXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LineShortCircuitXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}LineBranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="z0" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="y0Shunt" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="y0ShuntFromSide" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="y0ShuntToSide" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="lineMutualZeroZ" type="{http://www.ieee.org/odm/Schema/2008}MutualZeroZXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineShortCircuitXmlType", propOrder = {
    "z0",
    "y0Shunt",
    "y0ShuntFromSide",
    "y0ShuntToSide",
    "lineMutualZeroZ"
})
@XmlSeeAlso({
    LineDStabXmlType.class
})
public class LineShortCircuitXmlType
    extends LineBranchXmlType
{

    protected ZXmlType z0;
    protected YXmlType y0Shunt;
    protected YXmlType y0ShuntFromSide;
    protected YXmlType y0ShuntToSide;
    protected List<MutualZeroZXmlType> lineMutualZeroZ;

    /**
     * Gets the value of the z0 property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ0() {
        return z0;
    }

    /**
     * Sets the value of the z0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ0(ZXmlType value) {
        this.z0 = value;
    }

    /**
     * Gets the value of the y0Shunt property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getY0Shunt() {
        return y0Shunt;
    }

    /**
     * Sets the value of the y0Shunt property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setY0Shunt(YXmlType value) {
        this.y0Shunt = value;
    }

    /**
     * Gets the value of the y0ShuntFromSide property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getY0ShuntFromSide() {
        return y0ShuntFromSide;
    }

    /**
     * Sets the value of the y0ShuntFromSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setY0ShuntFromSide(YXmlType value) {
        this.y0ShuntFromSide = value;
    }

    /**
     * Gets the value of the y0ShuntToSide property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getY0ShuntToSide() {
        return y0ShuntToSide;
    }

    /**
     * Sets the value of the y0ShuntToSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setY0ShuntToSide(YXmlType value) {
        this.y0ShuntToSide = value;
    }

    /**
     * Gets the value of the lineMutualZeroZ property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineMutualZeroZ property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineMutualZeroZ().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MutualZeroZXmlType }
     * 
     * 
     */
    public List<MutualZeroZXmlType> getLineMutualZeroZ() {
        if (lineMutualZeroZ == null) {
            lineMutualZeroZ = new ArrayList<MutualZeroZXmlType>();
        }
        return this.lineMutualZeroZ;
    }

}
