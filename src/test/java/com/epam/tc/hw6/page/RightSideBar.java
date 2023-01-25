package com.epam.tc.hw6.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RightSideBar {

    private String checkboxWater = "Water";
    private String checkboxWind = "Wind";
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

    public RightSideBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private List<String> getLogList() {
        List<String> logList = new ArrayList();
        for (WebElement e : logEntries) {
            logList.add(String.valueOf(e.getText()));
        }
        return logList;
    }

    public int logCount(WebDriver driver) {

        int individualLogs = 0;
        for (String s : getLogList()) {
            if (s.contains(checkboxWater)) {
                individualLogs++;
            } else if (s.contains(checkboxWind)) {
                individualLogs++;
            } else if (s.contains(logMetalPart)) {
                individualLogs++;
            } else if (s.contains(logColorPart)) {
                individualLogs++;
            }
        }
        return individualLogs;
    }

    public boolean checkboxMatchStatus(String checkboxName) {

        //turn boolean values of checkbox into char sequence for further check in assertions
        CharSequence checkboxStatus = null;
        for (WebElement opt : checkboxes) {
            if (opt.getText().equals(checkboxName)) {
                checkboxStatus = String.valueOf(opt.findElement(By.tagName(inputElementTagName)).isSelected());
            }
        }

        //find log entries and turn them into list of strings for further checks in assertions
        boolean isCheckboxMatchesLogValue = false;
        for (String s : getLogList()) {
            if (s.contains(checkboxName)) {
                isCheckboxMatchesLogValue = s.contains(checkboxStatus);
            }
        }
        return isCheckboxMatchesLogValue;
    }

    public boolean radioMatchStatus(String radioName) {

        //turn boolean value of radio button into char sequence for further check in assertions
        CharSequence metal = null;
        for (WebElement opt : radio) {
            if (opt.findElement(By.tagName(inputElementTagName)).isSelected()) {
                metal = opt.getText();
            }
        }

        boolean isRadioMatchesLogValue = false;
        for (String s : getLogList()) {
            if (s.contains(radioName)) {
                isRadioMatchesLogValue = s.contains(metal);
            }
        }
        return isRadioMatchesLogValue;

    }

    public boolean colorMatchStatus() {

        //turn color option into char sequence for further check in assertions
        Select color = new Select(colorDropdown);
        WebElement o = color.getFirstSelectedOption();
        CharSequence colorSelected = o.getText();

        boolean isColorMatchesLogValue = false;
        for (String s : getLogList()) {
            if (s.contains(colorSelected)) {
                isColorMatchesLogValue = true;
            }
        }
        return  isColorMatchesLogValue;
    }

}
