package com.epam.tc.hw3.page;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPageMainContainer {

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

    public IndexPageMainContainer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int searchForImagesQuantity() {
        return listOfImages.size();
    }

    public WebElement getIconPractise() {
        return iconPractise;
    }

    public WebElement getIconCustom() {
        return  iconCustom;
    }

    public WebElement getIconMulti() {
        return iconMulti;
    }

    public WebElement getIconBase() {
        return iconBase;
    }

    public int searchForTextQuantity() {
        return listOfTexts.size();
    }

    public WebElement getTextPractise() {
        return textPractise;
    }

    public WebElement getTextCustom() {
        return textCustom;
    }

    public WebElement getTextMulti() {
        return textMulti;
    }

    public WebElement getTextBase() {
        return textBase;
    }

}
