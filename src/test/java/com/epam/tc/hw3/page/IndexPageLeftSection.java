package com.epam.tc.hw3.page;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IndexPageLeftSection {

    private String leftMenuHomeName = "Home";
    private String leftMenuContactName = "Contact form";
    private String leftMenuServiceName = "Service";
    private String leftMenuMetalsName = "Metals & Colors";
    private String leftMenuElementPacksName = "Elements packs";

    @FindBy(css = ".sidebar-menu>li")
    private List<WebElement> leftSectionElements;

    public IndexPageLeftSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void leftSectionElementsCheck() {

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(leftSectionElements.size() == 5)
                .as("There are not 5 elements in the Left Side section");

        int numberOfCorrectTitles = 0;
        for (WebElement element : leftSectionElements) {

            String title = element.getText();

            if (title.equals(leftMenuHomeName)
                    || title.equals(leftMenuContactName)
                    || title.equals(leftMenuServiceName)
                    || title.equals(leftMenuMetalsName)
                    || title.equals(leftMenuElementPacksName)) {
                numberOfCorrectTitles++;
            }

        }

        softly.assertThat(numberOfCorrectTitles == 5)
                .as("Some of the Left Section items has improper text");

        softly.assertAll();

    }

}
