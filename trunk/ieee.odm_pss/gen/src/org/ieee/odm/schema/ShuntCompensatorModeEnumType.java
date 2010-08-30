//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.29 at 07:17:30 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for ShuntCompensatorModeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ShuntCompensatorModeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fixed"/>
 *     &lt;enumeration value="Discrete"/>
 *     &lt;enumeration value="Continuous"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ShuntCompensatorModeEnumType {

    @XmlEnumValue("Fixed")
    FIXED("Fixed"),
    @XmlEnumValue("Discrete")
    DISCRETE("Discrete"),
    @XmlEnumValue("Continuous")
    CONTINUOUS("Continuous");
    private final String value;

    ShuntCompensatorModeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ShuntCompensatorModeEnumType fromValue(String v) {
        for (ShuntCompensatorModeEnumType c: ShuntCompensatorModeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
