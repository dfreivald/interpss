//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.31 at 09:52:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for AdjustmentModeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdjustmentModeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ValueAdjustment"/>
 *     &lt;enumeration value="RangeAdjustment"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum AdjustmentModeEnumType {

    @XmlEnumValue("ValueAdjustment")
    VALUE_ADJUSTMENT("ValueAdjustment"),
    @XmlEnumValue("RangeAdjustment")
    RANGE_ADJUSTMENT("RangeAdjustment");
    private final String value;

    AdjustmentModeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdjustmentModeEnumType fromValue(String v) {
        for (AdjustmentModeEnumType c: AdjustmentModeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
