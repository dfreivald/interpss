//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.28 at 12:18:44 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for DynamicLoadEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DynamicLoadEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IEEEStaticLoad"/>
 *     &lt;enumeration value="InductionMotor"/>
 *     &lt;enumeration value="complexLoad"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum DynamicLoadEnumType {

    @XmlEnumValue("IEEEStaticLoad")
    IEEE_STATIC_LOAD("IEEEStaticLoad"),
    @XmlEnumValue("InductionMotor")
    INDUCTION_MOTOR("InductionMotor"),
    @XmlEnumValue("complexLoad")
    COMPLEX_LOAD("complexLoad");
    private final String value;

    DynamicLoadEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DynamicLoadEnumType fromValue(String v) {
        for (DynamicLoadEnumType c: DynamicLoadEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
