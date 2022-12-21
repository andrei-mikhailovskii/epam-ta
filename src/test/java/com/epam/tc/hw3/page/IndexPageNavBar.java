package com.epam.tc.hw3.page;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPageNavBar {

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

    public IndexPageNavBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void verifyNavBarContent() {

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(listOfHeaderElements.size() == 4);

        softly.assertThat(homeTab.isDisplayed());
        softly.assertThat(contactFormTab.isDisplayed());
        softly.assertThat(serviceDropDown.isDisplayed());
        softly.assertThat(metalAndColorsTab.isDisplayed());

        softly.assertAll();
    }

}
