package com.epam.tc.hw7.forms.enums;

import lombok.Getter;

@Getter
public enum MetalColorElementsEnum {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String elementName;

    MetalColorElementsEnum(String elementName) {
        this.elementName = elementName;
    }

}
