package com.epam.tc.hw3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    private List<WebElement> loggedInUserNames;

    @FindBy(id = "user-name")
    private WebElement loggedInUserName;

    public IndexPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public IndexPage verifyTitle(WebDriver driver, String correctPageTitle) {
        assertThat(driver.getTitle()).as("Invalid Browser title").isEqualTo(correctPageTitle);
        return this;
    }

    public IndexPage loginUser(WebDriver driver, String userName, String userPassword) {
        if (loggedInUserNames.size() == 0) {
            return this;
        } else {
            new WebDriverWait(driver, WAIT_TIMEOUT_SEC)
                    .until(ExpectedConditions.elementToBeClickable(loginDropdown))
                            .click();
            searchInputName.sendKeys(userName);
            searchInputPassword.sendKeys(userPassword);
            loginButton.click();
            return this;
        }
    }

    public IndexPage searchForUserNameElement() {
            assertThat(loggedInUserNames.size() == 0).as("Login failed").isTrue();
            return this;
    }

    public void verifyLogin(String correctUserName) {
        assertThat(loggedInUserName.getText()).isEqualTo(correctUserName);
    }

}
