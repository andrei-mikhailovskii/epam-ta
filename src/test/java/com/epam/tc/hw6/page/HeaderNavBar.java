package com.epam.tc.hw6.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderNavBar {

    @FindBy(css = "ul.m-l8>li")
    private List<WebElement> listOfHeaderElements;

    @FindBy(linkText = "HOME")
    private WebElement homeTab;

    @FindBy(linkText = "CONTACT FORM")
    private WebElement contactFormTab;

    @FindBy(linkText = "SERVICE")
    private WebElement serviceDropDown;

    @FindBy(linkText = "METALS & COLORS")
    private WebElement metalAndColorsTab;

    public int listOfHeaderElementsQuantity() {
        return listOfHeaderElements.size();
    }

    public WebElement getHomeTab() {
        return homeTab;
    }

    public WebElement getContactFormTab() {
        return contactFormTab;
    }

    public WebElement getServiceDropDown() {
        return serviceDropDown;
    }

    public WebElement getMetalAndColorsTab() {
        return metalAndColorsTab;
    }

}
