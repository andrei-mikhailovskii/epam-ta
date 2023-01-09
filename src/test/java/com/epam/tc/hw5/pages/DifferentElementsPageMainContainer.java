package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.enums.Checkbox;
import com.epam.tc.hw5.pages.enums.ColorDropdown;
import com.epam.tc.hw5.pages.enums.RadioButton;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPageMainContainer {

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
        checkboxes.stream().map(n -> {
            if (n.getText().equals(Checkbox.WATER.getCheckboxName())
                    || n.getText().equals(Checkbox.WIND.getCheckboxName())) {
                n.click();
            }
                return this;
            }
        ).collect(Collectors.toList());
        return this;
    }

    public DifferentElementsPageMainContainer selectRadiobuttons() {
        for (WebElement opt : radio) {
            if (opt.getText().equals(RadioButton.SELEN.getRadioName())) {
                opt.click();
            }
        }
        return this;
    }

    public DifferentElementsPageMainContainer selectColor() {
        Select color = new Select(colorDropdown);
        color.selectByVisibleText(ColorDropdown.YELLOW.getColorName());
        return this;
    }

}
