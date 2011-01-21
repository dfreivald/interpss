//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.21 at 12:23:41 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XformerZTableXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XformerZTableXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="XformerZTableItem" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="lookup" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="turnRatioShiftAngle" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="scaleFactor" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "XformerZTableXmlType", propOrder = {
    "xformerZTableItem"
})
public class XformerZTableXmlType {

    @XmlElement(name = "XformerZTableItem")
    protected List<XformerZTableXmlType.XformerZTableItem> xformerZTableItem;

    /**
     * Gets the value of the xformerZTableItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xformerZTableItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXformerZTableItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XformerZTableXmlType.XformerZTableItem }
     * 
     * 
     */
    public List<XformerZTableXmlType.XformerZTableItem> getXformerZTableItem() {
        if (xformerZTableItem == null) {
            xformerZTableItem = new ArrayList<XformerZTableXmlType.XformerZTableItem>();
        }
        return this.xformerZTableItem;
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
     *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="lookup" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="turnRatioShiftAngle" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *                   &lt;element name="scaleFactor" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    @XmlType(name = "", propOrder = {
        "number",
        "lookup"
    })
    public static class XformerZTableItem {

        protected int number;
        protected List<XformerZTableXmlType.XformerZTableItem.Lookup> lookup;

        /**
         * Gets the value of the number property.
         * 
         */
        public int getNumber() {
            return number;
        }

        /**
         * Sets the value of the number property.
         * 
         */
        public void setNumber(int value) {
            this.number = value;
        }

        /**
         * Gets the value of the lookup property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lookup property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLookup().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XformerZTableXmlType.XformerZTableItem.Lookup }
         * 
         * 
         */
        public List<XformerZTableXmlType.XformerZTableItem.Lookup> getLookup() {
            if (lookup == null) {
                lookup = new ArrayList<XformerZTableXmlType.XformerZTableItem.Lookup>();
            }
            return this.lookup;
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
         *         &lt;element name="turnRatioShiftAngle" type="{http://www.w3.org/2001/XMLSchema}double"/>
         *         &lt;element name="scaleFactor" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
            "turnRatioShiftAngle",
            "scaleFactor"
        })
        public static class Lookup {

            protected double turnRatioShiftAngle;
            protected double scaleFactor;

            /**
             * Gets the value of the turnRatioShiftAngle property.
             * 
             */
            public double getTurnRatioShiftAngle() {
                return turnRatioShiftAngle;
            }

            /**
             * Sets the value of the turnRatioShiftAngle property.
             * 
             */
            public void setTurnRatioShiftAngle(double value) {
                this.turnRatioShiftAngle = value;
            }

            /**
             * Gets the value of the scaleFactor property.
             * 
             */
            public double getScaleFactor() {
                return scaleFactor;
            }

            /**
             * Sets the value of the scaleFactor property.
             * 
             */
            public void setScaleFactor(double value) {
                this.scaleFactor = value;
            }

        }

    }

}
