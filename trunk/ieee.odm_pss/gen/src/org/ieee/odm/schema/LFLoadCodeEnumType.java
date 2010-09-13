//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.12 at 04:33:33 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for LFLoadCodeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LFLoadCodeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CONST_P"/>
 *     &lt;enumeration value="CONST_I"/>
 *     &lt;enumeration value="CONST_Z"/>
 *     &lt;enumeration value="FunctionLoad"/>
 *     &lt;enumeration value="NoneLoad"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum LFLoadCodeEnumType {

    CONST_P("CONST_P"),
    CONST_I("CONST_I"),
    CONST_Z("CONST_Z"),
    @XmlEnumValue("FunctionLoad")
    FUNCTION_LOAD("FunctionLoad"),
    @XmlEnumValue("NoneLoad")
    NONE_LOAD("NoneLoad");
    private final String value;

    LFLoadCodeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LFLoadCodeEnumType fromValue(String v) {
        for (LFLoadCodeEnumType c: LFLoadCodeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
