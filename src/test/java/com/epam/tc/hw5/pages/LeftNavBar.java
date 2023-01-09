package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.enums.LeftMenuButton;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftNavBar {

    @FindBy(css = ".sidebar-menu>li")
    private List<WebElement> leftSectionElements;

    public int leftSectionElementsCount() {
        return leftSectionElements.size();
    }

    public int leftSectionCorrectTitlesCount() {
        int numberOfCorrectTitles = 0;
        for (WebElement element : leftSectionElements) {

            String title = element.getText();

            if (title.equals(LeftMenuButton.HOME.getButtonName())
                    || title.equals(LeftMenuButton.CONTACT_FORM.getButtonName())
                    || title.equals(LeftMenuButton.SERVICE.getButtonName())
                    || title.equals(LeftMenuButton.METALS_AND_COLORS.getButtonName())
                    || title.equals(LeftMenuButton.ELEMENTS_PACKS.getButtonName())) {
                numberOfCorrectTitles++;
            }

        }
        return numberOfCorrectTitles;
    }

}
