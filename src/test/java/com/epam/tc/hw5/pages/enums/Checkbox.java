package com.epam.tc.hw5.pages.enums;

public enum Checkbox {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String checkboxName;

    Checkbox(String checkboxName) {
        this.checkboxName = checkboxName;
    }

    public String getCheckboxName() {
        return checkboxName;
    }

}
