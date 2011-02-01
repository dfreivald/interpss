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
 * <p>Java class for DStabLoadChangeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DStabLoadChangeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LowFrequency"/>
 *     &lt;enumeration value="LowVoltage"/>
 *     &lt;enumeration value="FixedTime"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum DStabLoadChangeEnumType {

    @XmlEnumValue("LowFrequency")
    LOW_FREQUENCY("LowFrequency"),
    @XmlEnumValue("LowVoltage")
    LOW_VOLTAGE("LowVoltage"),
    @XmlEnumValue("FixedTime")
    FIXED_TIME("FixedTime");
    private final String value;

    DStabLoadChangeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DStabLoadChangeEnumType fromValue(String v) {
        for (DStabLoadChangeEnumType c: DStabLoadChangeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
