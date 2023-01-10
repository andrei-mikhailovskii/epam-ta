package com.epam.tc.hw6.page;

import com.epam.tc.hw6.WebDriverWaitClass;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {

    private String differentElementsMenuItem = "DIFFERENT ELEMENTS";
    private String pageTitle = "Different Elements";

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

    public void openDifferentElementsPage(WebDriver driver) {

        serviceDropDown.click();

        for (WebElement opt : serviceDropdownElements) {
            if (opt.getText().equals(differentElementsMenuItem)) {
                opt.click();
                break;
            }
        }

        WebDriverWaitClass.titleIs(driver, pageTitle);

    }

}
