package com.epam.tc.hw6.page.enums;

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
