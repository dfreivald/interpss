//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.19 at 07:37:24 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for FaultTypeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FaultTypeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BusFault"/>
 *     &lt;enumeration value="BranchFault"/>
 *     &lt;enumeration value="BranchOutage"/>
 *     &lt;enumeration value="LoadChange"/>
 *     &lt;enumeration value="GenChange"/>
 *     &lt;enumeration value="DcLineFault"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum FaultTypeEnumType {

    @XmlEnumValue("BusFault")
    BUS_FAULT("BusFault"),
    @XmlEnumValue("BranchFault")
    BRANCH_FAULT("BranchFault"),
    @XmlEnumValue("BranchOutage")
    BRANCH_OUTAGE("BranchOutage"),
    @XmlEnumValue("LoadChange")
    LOAD_CHANGE("LoadChange"),
    @XmlEnumValue("GenChange")
    GEN_CHANGE("GenChange"),
    @XmlEnumValue("DcLineFault")
    DC_LINE_FAULT("DcLineFault");
    private final String value;

    FaultTypeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FaultTypeEnumType fromValue(String v) {
        for (FaultTypeEnumType c: FaultTypeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
