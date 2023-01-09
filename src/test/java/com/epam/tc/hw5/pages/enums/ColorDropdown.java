package com.epam.tc.hw5.pages.enums;

public enum ColorDropdown {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String colorName;

    ColorDropdown(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

}
