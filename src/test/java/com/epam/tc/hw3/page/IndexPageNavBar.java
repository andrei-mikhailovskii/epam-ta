package com.epam.tc.hw3.page;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class IndexPageNavBar {

    private static final int WAIT_TIMEOUT_SEC = 5;

    @FindBy(css = "ul.m-l8>li>a[href='index.html']")
    private WebElement homeTab;

    @FindBy(css = "ul.m-l8>li>a[href='contacts.html']")
    private WebElement contactFormTab;

    @FindBy(css = "ul.m-l8>li>a.dropdown-toggle")
    private WebElement serviceDropDown;

    @FindBy(css = "ul.m-l8>li>a[href='metals-colors.html']")
    private WebElement metalAndColorsTab;

    public IndexPageNavBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void verifyNavBarContent() {

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homeTab.isDisplayed());
        softly.assertThat(contactFormTab.isDisplayed());
        softly.assertThat(serviceDropDown.isDisplayed());
        softly.assertThat(metalAndColorsTab.isDisplayed());

        softly.assertThat(homeTab.getText()).isEqualTo("HOME");
        softly.assertThat(contactFormTab.getText()).isEqualTo("CONTACT FORM");
        softly.assertThat(serviceDropDown.getText()).isEqualTo("SERVICE");
        softly.assertThat(metalAndColorsTab.getText()).isEqualTo("METALS & COLORS");
        softly.assertAll();
    }

}
