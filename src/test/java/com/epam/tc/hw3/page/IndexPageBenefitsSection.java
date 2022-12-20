package com.epam.tc.hw3.page;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IndexPageBenefitsSection {

    @FindBy(className = "benefit-icon")
    private List<WebElement> listOfImages;

    @FindBy(className = "icon-practise")
    private WebElement iconPractise;

    @FindBy(className = "icon-custom")
    private WebElement iconCustom;

    @FindBy(className = "icon-multi")
    private WebElement iconMulti;

    @FindBy(className = "icon-base")
    private WebElement iconBase;

    @FindBy(className = "benefit-txt")
    private List<WebElement> listOfTexts;

    @FindBy(xpath = "//div[normalize-space(span) = 'To include good practicesand ideas from successfulEPAM project']")
    private WebElement textPractise;

    @FindBy(xpath = "//div[normalize-space(span) = 'To be flexible andcustomizable']")
    private WebElement textCustom;

    @FindBy(xpath = "//span[(text()='To be multiplatform ')]")
    private WebElement textMulti;

    @FindBy(xpath = "//div[normalize-space(span) = 'Already "
            + "have good base(about 20 internal andsome external projects),wish to get more…']")
    private WebElement textBase;

    public IndexPageBenefitsSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public IndexPageBenefitsSection searchForImagesQuantity() {
        assertThat(listOfImages.size() == 4).as("Images quantity inconsistency").isTrue();
        return this;
    }

    public IndexPageBenefitsSection verifyImagesDisplayed() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(iconPractise.isDisplayed());
        softly.assertThat(iconCustom.isDisplayed());
        softly.assertThat(iconMulti.isDisplayed());
        softly.assertThat(iconBase.isDisplayed());

        softly.assertAll();

        return this;
    }

    public IndexPageBenefitsSection searchForTextQuantity() {
        assertThat(listOfTexts.size() == 4).as("Texts quantity inconsistency").isTrue();
        return this;
    }

    public void verifyText() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(textPractise.isDisplayed());
        softly.assertThat(textCustom.isDisplayed());
        softly.assertThat(textMulti.isDisplayed());
        softly.assertThat(textBase.isDisplayed());

        softly.assertAll();
    }

}
