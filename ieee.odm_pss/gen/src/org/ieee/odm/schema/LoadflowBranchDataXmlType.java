//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.21 at 05:19:28 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoadflowBranchDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoadflowBranchDataXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema}BaseBranchDataXmlType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="lineInfo" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="length" type="{http://www.ieee.org/odm/Schema}LengthXmlType" minOccurs="0"/>
 *                     &lt;element name="lossFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="xfrInfo" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="tapAdjustment" type="{http://www.ieee.org/odm/Schema}TapAdjustmentXmlType" minOccurs="0"/>
 *                     &lt;element name="angleAdjustment" type="{http://www.ieee.org/odm/Schema}AngleAdjustmentXmlType" minOccurs="0"/>
 *                     &lt;element name="zTableNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                     &lt;element name="dataOnSystemBase" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                     &lt;element name="z23" type="{http://www.ieee.org/odm/Schema}ZXmlType" minOccurs="0"/>
 *                     &lt;element name="z31" type="{http://www.ieee.org/odm/Schema}ZXmlType" minOccurs="0"/>
 *                     &lt;element name="turnRatio3" type="{http://www.ieee.org/odm/Schema}TapXmlType" minOccurs="0"/>
 *                     &lt;element name="shiftAngle3" type="{http://www.ieee.org/odm/Schema}AngleXmlType" minOccurs="0"/>
 *                     &lt;element name="starVMag" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
 *                     &lt;element name="starVAng" type="{http://www.ieee.org/odm/Schema}AngleXmlType" minOccurs="0"/>
 *                     &lt;element name="ratedVoltage1" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
 *                     &lt;element name="ratedVoltage2" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
 *                     &lt;element name="ratedVoltage3" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
 *                     &lt;element name="ratedPower12" type="{http://www.ieee.org/odm/Schema}ApparentPowerXmlType" minOccurs="0"/>
 *                     &lt;element name="ratedPower23" type="{http://www.ieee.org/odm/Schema}ApparentPowerXmlType" minOccurs="0"/>
 *                     &lt;element name="ratedPower31" type="{http://www.ieee.org/odm/Schema}ApparentPowerXmlType" minOccurs="0"/>
 *                     &lt;element name="branchRatingLimit23" type="{http://www.ieee.org/odm/Schema}BranchRatingLimitXmlType" minOccurs="0"/>
 *                     &lt;element name="branchRatingLimit13" type="{http://www.ieee.org/odm/Schema}BranchRatingLimitXmlType" minOccurs="0"/>
 *                     &lt;element name="lossFactor1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                     &lt;element name="lossFactor2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                     &lt;element name="lossFactor3" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element name="branchRatingLimit" type="{http://www.ieee.org/odm/Schema}BranchRatingLimitXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="code" use="required" type="{http://www.ieee.org/odm/Schema}LFBranchCodeEnumType" />
 *       &lt;attribute name="sec" type="{http://www.w3.org/2001/XMLSchema}int" default="1" />
 *       &lt;attribute name="xfr3W" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadflowBranchDataXmlType", propOrder = {
    "lineInfo",
    "xfrInfo",
    "branchRatingLimit"
})
public class LoadflowBranchDataXmlType
    extends BaseBranchDataXmlType
{

    protected LoadflowBranchDataXmlType.LineInfo lineInfo;
    protected LoadflowBranchDataXmlType.XfrInfo xfrInfo;
    protected BranchRatingLimitXmlType branchRatingLimit;
    @XmlAttribute(required = true)
    protected LFBranchCodeEnumType code;
    @XmlAttribute
    protected Integer sec;
    @XmlAttribute
    protected Boolean xfr3W;

    /**
     * Gets the value of the lineInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LoadflowBranchDataXmlType.LineInfo }
     *     
     */
    public LoadflowBranchDataXmlType.LineInfo getLineInfo() {
        return lineInfo;
    }

    /**
     * Sets the value of the lineInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadflowBranchDataXmlType.LineInfo }
     *     
     */
    public void setLineInfo(LoadflowBranchDataXmlType.LineInfo value) {
        this.lineInfo = value;
    }

    /**
     * Gets the value of the xfrInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LoadflowBranchDataXmlType.XfrInfo }
     *     
     */
    public LoadflowBranchDataXmlType.XfrInfo getXfrInfo() {
        return xfrInfo;
    }

    /**
     * Sets the value of the xfrInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadflowBranchDataXmlType.XfrInfo }
     *     
     */
    public void setXfrInfo(LoadflowBranchDataXmlType.XfrInfo value) {
        this.xfrInfo = value;
    }

    /**
     * Gets the value of the branchRatingLimit property.
     * 
     * @return
     *     possible object is
     *     {@link BranchRatingLimitXmlType }
     *     
     */
    public BranchRatingLimitXmlType getBranchRatingLimit() {
        return branchRatingLimit;
    }

    /**
     * Sets the value of the branchRatingLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchRatingLimitXmlType }
     *     
     */
    public void setBranchRatingLimit(BranchRatingLimitXmlType value) {
        this.branchRatingLimit = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link LFBranchCodeEnumType }
     *     
     */
    public LFBranchCodeEnumType getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link LFBranchCodeEnumType }
     *     
     */
    public void setCode(LFBranchCodeEnumType value) {
        this.code = value;
    }

    /**
     * Gets the value of the sec property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getSec() {
        if (sec == null) {
            return  1;
        } else {
            return sec;
        }
    }

    /**
     * Sets the value of the sec property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSec(Integer value) {
        this.sec = value;
    }

    /**
     * Gets the value of the xfr3W property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isXfr3W() {
        return xfr3W;
    }

    /**
     * Sets the value of the xfr3W property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setXfr3W(Boolean value) {
        this.xfr3W = value;
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
     *         &lt;element name="length" type="{http://www.ieee.org/odm/Schema}LengthXmlType" minOccurs="0"/>
     *         &lt;element name="lossFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        "length",
        "lossFactor"
    })
    public static class LineInfo {

        protected LengthXmlType length;
        protected Double lossFactor;

        /**
         * Gets the value of the length property.
         * 
         * @return
         *     possible object is
         *     {@link LengthXmlType }
         *     
         */
        public LengthXmlType getLength() {
            return length;
        }

        /**
         * Sets the value of the length property.
         * 
         * @param value
         *     allowed object is
         *     {@link LengthXmlType }
         *     
         */
        public void setLength(LengthXmlType value) {
            this.length = value;
        }

        /**
         * Gets the value of the lossFactor property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getLossFactor() {
            return lossFactor;
        }

        /**
         * Sets the value of the lossFactor property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setLossFactor(Double value) {
            this.lossFactor = value;
        }

    }


    /**
     * from : 1, to:2 and tert :3
     * 
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="tapAdjustment" type="{http://www.ieee.org/odm/Schema}TapAdjustmentXmlType" minOccurs="0"/>
     *         &lt;element name="angleAdjustment" type="{http://www.ieee.org/odm/Schema}AngleAdjustmentXmlType" minOccurs="0"/>
     *         &lt;element name="zTableNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="dataOnSystemBase" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="z23" type="{http://www.ieee.org/odm/Schema}ZXmlType" minOccurs="0"/>
     *         &lt;element name="z31" type="{http://www.ieee.org/odm/Schema}ZXmlType" minOccurs="0"/>
     *         &lt;element name="turnRatio3" type="{http://www.ieee.org/odm/Schema}TapXmlType" minOccurs="0"/>
     *         &lt;element name="shiftAngle3" type="{http://www.ieee.org/odm/Schema}AngleXmlType" minOccurs="0"/>
     *         &lt;element name="starVMag" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
     *         &lt;element name="starVAng" type="{http://www.ieee.org/odm/Schema}AngleXmlType" minOccurs="0"/>
     *         &lt;element name="ratedVoltage1" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
     *         &lt;element name="ratedVoltage2" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
     *         &lt;element name="ratedVoltage3" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
     *         &lt;element name="ratedPower12" type="{http://www.ieee.org/odm/Schema}ApparentPowerXmlType" minOccurs="0"/>
     *         &lt;element name="ratedPower23" type="{http://www.ieee.org/odm/Schema}ApparentPowerXmlType" minOccurs="0"/>
     *         &lt;element name="ratedPower31" type="{http://www.ieee.org/odm/Schema}ApparentPowerXmlType" minOccurs="0"/>
     *         &lt;element name="branchRatingLimit23" type="{http://www.ieee.org/odm/Schema}BranchRatingLimitXmlType" minOccurs="0"/>
     *         &lt;element name="branchRatingLimit13" type="{http://www.ieee.org/odm/Schema}BranchRatingLimitXmlType" minOccurs="0"/>
     *         &lt;element name="lossFactor1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="lossFactor2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="lossFactor3" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        "tapAdjustment",
        "angleAdjustment",
        "zTableNumber",
        "dataOnSystemBase",
        "z23",
        "z31",
        "turnRatio3",
        "shiftAngle3",
        "starVMag",
        "starVAng",
        "ratedVoltage1",
        "ratedVoltage2",
        "ratedVoltage3",
        "ratedPower12",
        "ratedPower23",
        "ratedPower31",
        "branchRatingLimit23",
        "branchRatingLimit13",
        "lossFactor1",
        "lossFactor2",
        "lossFactor3"
    })
    public static class XfrInfo {

        protected TapAdjustmentXmlType tapAdjustment;
        protected AngleAdjustmentXmlType angleAdjustment;
        protected Integer zTableNumber;
        protected Boolean dataOnSystemBase;
        protected ZXmlType z23;
        protected ZXmlType z31;
        protected TapXmlType turnRatio3;
        protected AngleXmlType shiftAngle3;
        protected VoltageXmlType starVMag;
        protected AngleXmlType starVAng;
        protected VoltageXmlType ratedVoltage1;
        protected VoltageXmlType ratedVoltage2;
        protected VoltageXmlType ratedVoltage3;
        protected ApparentPowerXmlType ratedPower12;
        protected ApparentPowerXmlType ratedPower23;
        protected ApparentPowerXmlType ratedPower31;
        protected BranchRatingLimitXmlType branchRatingLimit23;
        protected BranchRatingLimitXmlType branchRatingLimit13;
        protected Double lossFactor1;
        protected Double lossFactor2;
        protected Double lossFactor3;

        /**
         * Gets the value of the tapAdjustment property.
         * 
         * @return
         *     possible object is
         *     {@link TapAdjustmentXmlType }
         *     
         */
        public TapAdjustmentXmlType getTapAdjustment() {
            return tapAdjustment;
        }

        /**
         * Sets the value of the tapAdjustment property.
         * 
         * @param value
         *     allowed object is
         *     {@link TapAdjustmentXmlType }
         *     
         */
        public void setTapAdjustment(TapAdjustmentXmlType value) {
            this.tapAdjustment = value;
        }

        /**
         * Gets the value of the angleAdjustment property.
         * 
         * @return
         *     possible object is
         *     {@link AngleAdjustmentXmlType }
         *     
         */
        public AngleAdjustmentXmlType getAngleAdjustment() {
            return angleAdjustment;
        }

        /**
         * Sets the value of the angleAdjustment property.
         * 
         * @param value
         *     allowed object is
         *     {@link AngleAdjustmentXmlType }
         *     
         */
        public void setAngleAdjustment(AngleAdjustmentXmlType value) {
            this.angleAdjustment = value;
        }

        /**
         * Gets the value of the zTableNumber property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getZTableNumber() {
            return zTableNumber;
        }

        /**
         * Sets the value of the zTableNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setZTableNumber(Integer value) {
            this.zTableNumber = value;
        }

        /**
         * Gets the value of the dataOnSystemBase property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDataOnSystemBase() {
            return dataOnSystemBase;
        }

        /**
         * Sets the value of the dataOnSystemBase property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDataOnSystemBase(Boolean value) {
            this.dataOnSystemBase = value;
        }

        /**
         * Gets the value of the z23 property.
         * 
         * @return
         *     possible object is
         *     {@link ZXmlType }
         *     
         */
        public ZXmlType getZ23() {
            return z23;
        }

        /**
         * Sets the value of the z23 property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZXmlType }
         *     
         */
        public void setZ23(ZXmlType value) {
            this.z23 = value;
        }

        /**
         * Gets the value of the z31 property.
         * 
         * @return
         *     possible object is
         *     {@link ZXmlType }
         *     
         */
        public ZXmlType getZ31() {
            return z31;
        }

        /**
         * Sets the value of the z31 property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZXmlType }
         *     
         */
        public void setZ31(ZXmlType value) {
            this.z31 = value;
        }

        /**
         * Gets the value of the turnRatio3 property.
         * 
         * @return
         *     possible object is
         *     {@link TapXmlType }
         *     
         */
        public TapXmlType getTurnRatio3() {
            return turnRatio3;
        }

        /**
         * Sets the value of the turnRatio3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link TapXmlType }
         *     
         */
        public void setTurnRatio3(TapXmlType value) {
            this.turnRatio3 = value;
        }

        /**
         * Gets the value of the shiftAngle3 property.
         * 
         * @return
         *     possible object is
         *     {@link AngleXmlType }
         *     
         */
        public AngleXmlType getShiftAngle3() {
            return shiftAngle3;
        }

        /**
         * Sets the value of the shiftAngle3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link AngleXmlType }
         *     
         */
        public void setShiftAngle3(AngleXmlType value) {
            this.shiftAngle3 = value;
        }

        /**
         * Gets the value of the starVMag property.
         * 
         * @return
         *     possible object is
         *     {@link VoltageXmlType }
         *     
         */
        public VoltageXmlType getStarVMag() {
            return starVMag;
        }

        /**
         * Sets the value of the starVMag property.
         * 
         * @param value
         *     allowed object is
         *     {@link VoltageXmlType }
         *     
         */
        public void setStarVMag(VoltageXmlType value) {
            this.starVMag = value;
        }

        /**
         * Gets the value of the starVAng property.
         * 
         * @return
         *     possible object is
         *     {@link AngleXmlType }
         *     
         */
        public AngleXmlType getStarVAng() {
            return starVAng;
        }

        /**
         * Sets the value of the starVAng property.
         * 
         * @param value
         *     allowed object is
         *     {@link AngleXmlType }
         *     
         */
        public void setStarVAng(AngleXmlType value) {
            this.starVAng = value;
        }

        /**
         * Gets the value of the ratedVoltage1 property.
         * 
         * @return
         *     possible object is
         *     {@link VoltageXmlType }
         *     
         */
        public VoltageXmlType getRatedVoltage1() {
            return ratedVoltage1;
        }

        /**
         * Sets the value of the ratedVoltage1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link VoltageXmlType }
         *     
         */
        public void setRatedVoltage1(VoltageXmlType value) {
            this.ratedVoltage1 = value;
        }

        /**
         * Gets the value of the ratedVoltage2 property.
         * 
         * @return
         *     possible object is
         *     {@link VoltageXmlType }
         *     
         */
        public VoltageXmlType getRatedVoltage2() {
            return ratedVoltage2;
        }

        /**
         * Sets the value of the ratedVoltage2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link VoltageXmlType }
         *     
         */
        public void setRatedVoltage2(VoltageXmlType value) {
            this.ratedVoltage2 = value;
        }

        /**
         * Gets the value of the ratedVoltage3 property.
         * 
         * @return
         *     possible object is
         *     {@link VoltageXmlType }
         *     
         */
        public VoltageXmlType getRatedVoltage3() {
            return ratedVoltage3;
        }

        /**
         * Sets the value of the ratedVoltage3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link VoltageXmlType }
         *     
         */
        public void setRatedVoltage3(VoltageXmlType value) {
            this.ratedVoltage3 = value;
        }

        /**
         * Gets the value of the ratedPower12 property.
         * 
         * @return
         *     possible object is
         *     {@link ApparentPowerXmlType }
         *     
         */
        public ApparentPowerXmlType getRatedPower12() {
            return ratedPower12;
        }

        /**
         * Sets the value of the ratedPower12 property.
         * 
         * @param value
         *     allowed object is
         *     {@link ApparentPowerXmlType }
         *     
         */
        public void setRatedPower12(ApparentPowerXmlType value) {
            this.ratedPower12 = value;
        }

        /**
         * Gets the value of the ratedPower23 property.
         * 
         * @return
         *     possible object is
         *     {@link ApparentPowerXmlType }
         *     
         */
        public ApparentPowerXmlType getRatedPower23() {
            return ratedPower23;
        }

        /**
         * Sets the value of the ratedPower23 property.
         * 
         * @param value
         *     allowed object is
         *     {@link ApparentPowerXmlType }
         *     
         */
        public void setRatedPower23(ApparentPowerXmlType value) {
            this.ratedPower23 = value;
        }

        /**
         * Gets the value of the ratedPower31 property.
         * 
         * @return
         *     possible object is
         *     {@link ApparentPowerXmlType }
         *     
         */
        public ApparentPowerXmlType getRatedPower31() {
            return ratedPower31;
        }

        /**
         * Sets the value of the ratedPower31 property.
         * 
         * @param value
         *     allowed object is
         *     {@link ApparentPowerXmlType }
         *     
         */
        public void setRatedPower31(ApparentPowerXmlType value) {
            this.ratedPower31 = value;
        }

        /**
         * Gets the value of the branchRatingLimit23 property.
         * 
         * @return
         *     possible object is
         *     {@link BranchRatingLimitXmlType }
         *     
         */
        public BranchRatingLimitXmlType getBranchRatingLimit23() {
            return branchRatingLimit23;
        }

        /**
         * Sets the value of the branchRatingLimit23 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BranchRatingLimitXmlType }
         *     
         */
        public void setBranchRatingLimit23(BranchRatingLimitXmlType value) {
            this.branchRatingLimit23 = value;
        }

        /**
         * Gets the value of the branchRatingLimit13 property.
         * 
         * @return
         *     possible object is
         *     {@link BranchRatingLimitXmlType }
         *     
         */
        public BranchRatingLimitXmlType getBranchRatingLimit13() {
            return branchRatingLimit13;
        }

        /**
         * Sets the value of the branchRatingLimit13 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BranchRatingLimitXmlType }
         *     
         */
        public void setBranchRatingLimit13(BranchRatingLimitXmlType value) {
            this.branchRatingLimit13 = value;
        }

        /**
         * Gets the value of the lossFactor1 property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getLossFactor1() {
            return lossFactor1;
        }

        /**
         * Sets the value of the lossFactor1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setLossFactor1(Double value) {
            this.lossFactor1 = value;
        }

        /**
         * Gets the value of the lossFactor2 property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getLossFactor2() {
            return lossFactor2;
        }

        /**
         * Sets the value of the lossFactor2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setLossFactor2(Double value) {
            this.lossFactor2 = value;
        }

        /**
         * Gets the value of the lossFactor3 property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getLossFactor3() {
            return lossFactor3;
        }

        /**
         * Sets the value of the lossFactor3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setLossFactor3(Double value) {
            this.lossFactor3 = value;
        }

    }

}
