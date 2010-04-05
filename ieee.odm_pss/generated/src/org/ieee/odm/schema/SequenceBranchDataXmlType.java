//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.04 at 05:26:16 PM PDT 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SequenceBranchDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SequenceBranchDataXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lineZeroSeq" type="{http://www.ieee.org/odm/Schema}LineZeroSeqXmlType" minOccurs="0"/>
 *         &lt;element name="xfrZeroSeq" type="{http://www.ieee.org/odm/Schema}TransformerZeroSeqXmlType" minOccurs="0"/>
 *         &lt;element name="linemutualZeroZ" type="{http://www.ieee.org/odm/Schema}MutualZeroZXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequenceBranchDataXmlType", propOrder = {
    "lineZeroSeq",
    "xfrZeroSeq",
    "linemutualZeroZ"
})
public class SequenceBranchDataXmlType {

    protected LineZeroSeqXmlType lineZeroSeq;
    protected TransformerZeroSeqXmlType xfrZeroSeq;
    protected List<MutualZeroZXmlType> linemutualZeroZ;

    /**
     * Gets the value of the lineZeroSeq property.
     * 
     * @return
     *     possible object is
     *     {@link LineZeroSeqXmlType }
     *     
     */
    public LineZeroSeqXmlType getLineZeroSeq() {
        return lineZeroSeq;
    }

    /**
     * Sets the value of the lineZeroSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineZeroSeqXmlType }
     *     
     */
    public void setLineZeroSeq(LineZeroSeqXmlType value) {
        this.lineZeroSeq = value;
    }

    /**
     * Gets the value of the xfrZeroSeq property.
     * 
     * @return
     *     possible object is
     *     {@link TransformerZeroSeqXmlType }
     *     
     */
    public TransformerZeroSeqXmlType getXfrZeroSeq() {
        return xfrZeroSeq;
    }

    /**
     * Sets the value of the xfrZeroSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransformerZeroSeqXmlType }
     *     
     */
    public void setXfrZeroSeq(TransformerZeroSeqXmlType value) {
        this.xfrZeroSeq = value;
    }

    /**
     * Gets the value of the linemutualZeroZ property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linemutualZeroZ property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinemutualZeroZ().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MutualZeroZXmlType }
     * 
     * 
     */
    public List<MutualZeroZXmlType> getLinemutualZeroZ() {
        if (linemutualZeroZ == null) {
            linemutualZeroZ = new ArrayList<MutualZeroZXmlType>();
        }
        return this.linemutualZeroZ;
    }

}
