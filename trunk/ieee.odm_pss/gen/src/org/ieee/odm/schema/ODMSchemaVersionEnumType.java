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
 * <p>Java class for ODMSchemaVersionEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ODMSchemaVersionEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="V0.7"/>
 *     &lt;enumeration value="V0.6"/>
 *     &lt;enumeration value="V0.5"/>
 *     &lt;enumeration value="V0.4"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ODMSchemaVersionEnumType {

    @XmlEnumValue("V0.7")
    V_0_7("V0.7"),
    @XmlEnumValue("V0.6")
    V_0_6("V0.6"),
    @XmlEnumValue("V0.5")
    V_0_5("V0.5"),
    @XmlEnumValue("V0.4")
    V_0_4("V0.4");
    private final String value;

    ODMSchemaVersionEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ODMSchemaVersionEnumType fromValue(String v) {
        for (ODMSchemaVersionEnumType c: ODMSchemaVersionEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
