package com.epam.tc.hw3.page;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {

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
    private List<WebElement> notLoggedInUserNames;

    @FindBy(id = "user-name")
    private WebElement loggedInUserName;

    public IndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public IndexPage loginUser(WebDriver driver, String userName, String userPassword) {
        if (notLoggedInUserNames.size() != 0) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SEC)
                    .until(ExpectedConditions.elementToBeClickable(loginDropdown))
                            .click();
            searchInputName.sendKeys(userName);
            searchInputPassword.sendKeys(userPassword);
            loginButton.click();
        }
        return this;
    }

    public int searchNotLoggedInUserNames() {
        return notLoggedInUserNames.size();
    }

    public String loginName() {
        return loggedInUserName.getText();
    }

}
