package com.epam.tc.hw4.page;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftNavBar {

    private String leftMenuHomeName = "Home";
    private String leftMenuContactName = "Contact form";
    private String leftMenuServiceName = "Service";
    private String leftMenuMetalsName = "Metals & Colors";
    private String leftMenuElementPacksName = "Elements packs";

    @FindBy(css = ".sidebar-menu>li")
    private List<WebElement> leftSectionElements;

    public int leftSectionElementsCount() {
        return leftSectionElements.size();
    }

    public int leftSectionCorrectTitlesCount() {
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
        return numberOfCorrectTitles;
    }

}
