package com.epam.tc.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitClass {

    private static final int WAIT_TIMEOUT_SEC = 5;

    public static void elementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SEC)
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public static void titleIs(WebDriver driver, String title) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SEC).until(ExpectedConditions.titleIs(title));
    }

}
