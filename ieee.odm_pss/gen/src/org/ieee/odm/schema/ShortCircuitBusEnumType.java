//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.21 at 03:20:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for ShortCircuitBusEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ShortCircuitBusEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Contributing"/>
 *     &lt;enumeration value="Non-contributing"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ShortCircuitBusEnumType {

    @XmlEnumValue("Contributing")
    CONTRIBUTING("Contributing"),
    @XmlEnumValue("Non-contributing")
    NON_CONTRIBUTING("Non-contributing");
    private final String value;

    ShortCircuitBusEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ShortCircuitBusEnumType fromValue(String v) {
        for (ShortCircuitBusEnumType c: ShortCircuitBusEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
