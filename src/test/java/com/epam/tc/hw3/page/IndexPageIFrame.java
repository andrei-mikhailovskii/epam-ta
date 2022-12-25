package com.epam.tc.hw3.page;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPageIFrame {

    private String iframeId = "frame";

    @FindBy(id = "frame")
    private List<WebElement> listOfIFrames;

    @FindBy(id = "frame-button")
    private List<WebElement> listOfFrameButtons;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public IndexPageIFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void switchToIframe(WebDriver driver) {
        driver.switchTo().frame(iframeId);

    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public int iframeWithButtonCount(WebDriver driver) {

        int buttonCount = 0;

        for (WebElement e : listOfIFrames) {
            switchToIframe(driver);

            if (listOfFrameButtons.size() > 0) {
                buttonCount++;
            }

            switchToDefaultContent(driver);
        }

        return buttonCount;

    }

}
