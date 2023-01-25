package com.epam.tc.hw5.pages.enums;

public enum RadioButton {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String radioName;

    RadioButton(String radioName) {
        this.radioName = radioName;
    }

    public String getRadioName() {
        return radioName;
    }

}
