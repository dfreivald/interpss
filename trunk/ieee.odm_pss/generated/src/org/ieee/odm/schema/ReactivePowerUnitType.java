//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.02 at 07:10:53 AM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for ReactivePowerUnitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReactivePowerUnitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PU"/>
 *     &lt;enumeration value="VAR"/>
 *     &lt;enumeration value="KVAR"/>
 *     &lt;enumeration value="MVAR"/>
 *     &lt;enumeration value="Ohm"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ReactivePowerUnitType {

    PU("PU"),
    VAR("VAR"),
    KVAR("KVAR"),
    MVAR("MVAR"),
    @XmlEnumValue("Ohm")
    OHM("Ohm");
    private final String value;

    ReactivePowerUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReactivePowerUnitType fromValue(String v) {
        for (ReactivePowerUnitType c: ReactivePowerUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
