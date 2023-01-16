package com.epam.tc.hw5.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPageMainContainer {

    private String textPractise = "To include good practices\nand ideas from successful\nEPAM project";
    private String textCustom = "To be flexible and\ncustomizable";
    private String textMulti = "To be multiplatform";
    private String textBase = "Already have good base\n(about 20 internal and\nsome external projects),\n"
            + "wish to get more…";

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

    public int numberOfCorrectTexts() {
        int numberOfCorrectTexts = 0;
        for (WebElement element : listOfTexts) {
            if (element.getText().equals(textPractise)
                || element.getText().equals(textCustom)
                || element.getText().equals(textMulti)
                || element.getText().equals(textBase)) {
                numberOfCorrectTexts++;
            }
        }
        return numberOfCorrectTexts;
    }
}
