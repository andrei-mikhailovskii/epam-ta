package com.epam.tc.hw6.page.enums;

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
