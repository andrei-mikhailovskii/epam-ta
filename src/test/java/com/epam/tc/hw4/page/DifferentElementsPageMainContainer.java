package com.epam.tc.hw4.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPageMainContainer {

    private String checkboxWater = "Water";
    private String checkboxWind = "Wind";
    private String radioSelen = "Selen";
    private String colorYellow = "Yellow";

    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(css = ".label-radio")
    private List<WebElement> radio;

    @FindBy(css = "div.colors>.uui-form-element")
    private WebElement colorDropdown;

    @FindBy(css = ".panel-body-list.logs>li")
    private List<WebElement> logEntries;

    public DifferentElementsPageMainContainer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public DifferentElementsPageMainContainer selectCheckboxes() {
        for (WebElement opt : checkboxes) {
            if (opt.getText().equals(checkboxWater) || opt.getText().equals(checkboxWind)) {
                opt.click();
            }
        }
        return this;
    }

    public DifferentElementsPageMainContainer selectRadiobuttons() {
        for (WebElement opt : radio) {
            if (opt.getText().equals(radioSelen)) {
                opt.click();
            }
        }
        return this;
    }

    public DifferentElementsPageMainContainer selectColor() {
        Select color = new Select(colorDropdown);
        color.selectByVisibleText(colorYellow);
        return this;
    }

}
