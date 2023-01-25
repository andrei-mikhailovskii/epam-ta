package com.epam.tc.hw7.forms.enums;

import lombok.Getter;

@Getter
public enum MetalColorVegetablesEnum {

    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    private String vegetableName;

    MetalColorVegetablesEnum(String vegetableName) {
        this.vegetableName = vegetableName;
    }

}
