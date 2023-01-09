package com.epam.tc.hw5.pages.enums;

public enum LeftMenuButton {

    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors"),
    ELEMENTS_PACKS("Elements packs");

    private String buttonName;

    LeftMenuButton(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }

}
