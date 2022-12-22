package com.epam.tc.hw3.page;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu {
    @FindBy(xpath = "//nav[@role='navigation']//ul//li")
    private List<WebElement> navigationHeader;

    public void clickHeaderMenuItem(final String menuItem) {
        for (WebElement menuHeaderItem : navigationHeader) {
            if (menuItem.equals(menuHeaderItem.getText())) {
                menuHeaderItem.click();
                break;
            }
        }
    }
}
