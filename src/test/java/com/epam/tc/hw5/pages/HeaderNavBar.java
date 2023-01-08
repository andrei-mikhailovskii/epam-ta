package com.epam.tc.hw5.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(css = "ul.m-l8>li>ul.dropdown-menu>li")
    private List<WebElement> serviceDropdownElements;

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

    public void openPageFromDropdown(String dropdownElement) {
        for (WebElement opt : serviceDropdownElements) {
            if (opt.getText().equals(dropdownElement.toUpperCase())) {
                opt.click();
                break;
            }
        }
    }

}
