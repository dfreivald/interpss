//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.21 at 05:27:34 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for StabilizerEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StabilizerEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IEEE1981Type"/>
 *     &lt;enumeration value="IEEE1982Type2A"/>
 *     &lt;enumeration value="IEE2ST"/>
 *     &lt;enumeration value="IEEEDualInput"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum StabilizerEnumType {

    @XmlEnumValue("IEEE1981Type")
    IEEE_1981_TYPE("IEEE1981Type"),
    @XmlEnumValue("IEEE1982Type2A")
    IEEE_1982_TYPE_2_A("IEEE1982Type2A"),
    @XmlEnumValue("IEE2ST")
    IEE_2_ST("IEE2ST"),
    @XmlEnumValue("IEEEDualInput")
    IEEE_DUAL_INPUT("IEEEDualInput");
    private final String value;

    StabilizerEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StabilizerEnumType fromValue(String v) {
        for (StabilizerEnumType c: StabilizerEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
