package com.epam.tc.hw3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IndexPageIFrame {

    @FindBy(id = "frame")
    private List<WebElement> listOfIFrames;

    @FindBy(id = "frame-button")
    private List<WebElement> listOfFrameButtons;

    public IndexPageIFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void iFrameExists(WebDriver driver) {

        int buttonCount = 0;

        for (WebElement e : listOfIFrames) {
            driver.switchTo().frame("frame");

            if (listOfFrameButtons.size() > 0) {
                buttonCount++;
            }

            driver.switchTo().defaultContent();
        }

        assertThat(buttonCount > 0).as("No iframes with button 'Frame Button'").isTrue();

    }

}
