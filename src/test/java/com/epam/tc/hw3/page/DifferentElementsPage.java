package com.epam.tc.hw3.page;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementsPage {

    private static final int WAIT_TIMEOUT_SEC = 5;

    @FindBy(css = "li.uui-profile-menu")
    private WebElement loginDropdown;

    @FindBy(id = "name")
    private WebElement searchInputName;

    @FindBy(id = "password")
    private WebElement searchInputPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "span[id='user-name'].hidden")
    private List<WebElement> loggedInUserNames;

    @FindBy(linkText = "SERVICE")
    private WebElement serviceDropDown;

    @FindBy(css = "ul.m-l8>li>ul.dropdown-menu>li")
    private List<WebElement> serviceDropdownElements;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public DifferentElementsPage openDifferentElementsPage(WebDriver driver, String userName, String userPassword) {

        if (loggedInUserNames.size() != 0) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SEC)
                    .until(ExpectedConditions.elementToBeClickable(loginDropdown))
                    .click();
            searchInputName.sendKeys(userName);
            searchInputPassword.sendKeys(userPassword);
            loginButton.click();
        }

        serviceDropDown.click();

        for (WebElement opt : serviceDropdownElements) {
            if (opt.getText().equals("DIFFERENT ELEMENTS")) {
                opt.click();
                break;
            }
        }

        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("Different Elements"));

        return new DifferentElementsPage(driver);
    }

}
