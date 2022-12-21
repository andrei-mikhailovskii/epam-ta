package com.epam.tc.hw3.page;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPageMainContainer {

    private String checkboxWater = "Water";
    private String checkboxWind = "Wind";
    private String radioSelen = "Selen";
    private String colorYellow = "Yellow";
    private String logMetalPart = "metal";
    private String logColorPart = "Color";
    private String inputElementTagName = "input";

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

    public void verifyLogs(WebDriver driver) {
        //turn boolean values of checkboxes into char sequences for further check in assertions
        CharSequence water = null;
        CharSequence wind = null;
        for (WebElement opt : checkboxes) {
            if (opt.getText().equals(checkboxWater)) {
                water = String.valueOf(opt.findElement(By.tagName(inputElementTagName)).isSelected());
            } else if (opt.getText().equals(checkboxWind)) {
                wind = String.valueOf(opt.findElement(By.tagName(inputElementTagName)).isSelected());
            }
        }

        //turn boolean value of radio button into char sequence for further check in assertions
        CharSequence metal = null;
        for (WebElement opt : radio) {
            if (opt.findElement(By.tagName(inputElementTagName)).isSelected()) {
                metal = opt.getText();
            }
        }

        //turn color option into char sequence for further check in assertions
        Select color = new Select(colorDropdown);
        WebElement o = color.getFirstSelectedOption();
        CharSequence colorOption = o.getText();

        //find log entries and turn them into list of strings for further checks in assertions
        List<String> logList = new ArrayList();
        for (WebElement e : logEntries) {
            logList.add(String.valueOf(e.getText()));
        }

        //check that each element has an individual log
        //check that log values correspond the values of checkboxes, radio button, dropdown
        SoftAssertions softly = new SoftAssertions();
        int individualLogs = 0;
        for (String s : logList) {
            if (s.contains(checkboxWater)) {
                individualLogs++;
                softly.assertThat(s.contains(water))
                        .as("Log value for Water checkbox does not match it's value");
            } else if (s.contains(checkboxWind)) {
                individualLogs++;
                softly.assertThat(s.contains(wind))
                        .as("Log value for Wind checkbox does not match it's value");
            } else if (s.contains(logMetalPart)) {
                individualLogs++;
                softly.assertThat(s.contains(metal))
                        .as("Log value for Metal radio does not match it's value");
            } else if (s.contains(logColorPart)) {
                individualLogs++;
                softly.assertThat(s.contains(colorOption))
                        .as("Log value for Selen radio does not match it's value");
            }
        }
        softly.assertThat(individualLogs == 4).as("Lack of log entries");

        softly.assertAll();
    }

}
