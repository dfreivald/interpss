//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.21 at 05:19:28 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for LoadCharacteristicLocationEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LoadCharacteristicLocationEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="atBus"/>
 *     &lt;enumeration value="atOwner"/>
 *     &lt;enumeration value="atZone"/>
 *     &lt;enumeration value="atArea"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum LoadCharacteristicLocationEnumType {

    @XmlEnumValue("atBus")
    AT_BUS("atBus"),
    @XmlEnumValue("atOwner")
    AT_OWNER("atOwner"),
    @XmlEnumValue("atZone")
    AT_ZONE("atZone"),
    @XmlEnumValue("atArea")
    AT_AREA("atArea"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    LoadCharacteristicLocationEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoadCharacteristicLocationEnumType fromValue(String v) {
        for (LoadCharacteristicLocationEnumType c: LoadCharacteristicLocationEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
