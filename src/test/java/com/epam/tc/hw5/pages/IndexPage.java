package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.DriverSetup;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends DriverSetup {

    private WebDriver driver;
    private static final String HOME_PAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private HeaderNavBar headerNavBar;
    private LeftNavBar leftNavBar;

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
        this.driver = driver;
        PageFactory.initElements(driver, this);

        headerNavBar = new HeaderNavBar();
        PageFactory.initElements(driver, headerNavBar);

        leftNavBar = new LeftNavBar();
        PageFactory.initElements(driver, leftNavBar);
    }

    public void openIndexPage() {
        DriverSetup.setup().get(HOME_PAGE_URL);
    }

    public IndexPage loginUser(String userName, String userPassword) {
        if (notLoggedInUserNames.size() != 0) {
            loginDropdown.click();
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

    public HeaderNavBar getHeaderNavBar() {
        return headerNavBar;
    }

    public LeftNavBar getLeftNavBar() {
        return leftNavBar;
    }

}
