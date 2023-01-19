package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalColorEntity;
import com.epam.tc.hw7.forms.enums.MetalColorElementsEnum;
import com.epam.tc.hw7.forms.enums.MetalColorVegetablesEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetalColorsForm extends Form<MetalColorEntity> {

    private String selectedVegetablesByDefault = "Vegetables";

    @FindBy(name = "custom_radio_odd")
    private RadioButtons radioButtonsOddNumbers;

    @FindBy(name = "custom_radio_even")
    private RadioButtons radioButtonsEvenNumbers;

    @FindBy(css = "#elements-checklist input")
    private Checklist elements;

    @JDropdown(root = ".colors", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown colorsDropdown;

    @JDropdown(root = ".metals", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown metalsDropdown;

    @FindBy(id = "salad-dropdown")
    private Button vegetablesDropdownButton;

    @FindBy(css = ".salad .dropdown-menu input")
    private Checklist vegetablesDropdownChecklist;

    @FindBy(id = "submit-button")
    private Button submitButton;

    @FindBy(xpath = "//*[contains(text(), 'Water')]/../input")
    private Checkbox waterCheckbox;

    @FindBy(xpath = "//*[contains(text(), 'Earth')]/../input")
    private Checkbox earthCheckbox;

    @FindBy(xpath = "//*[contains(text(), 'Wind')]/../input")
    private Checkbox windCheckbox;

    @FindBy(xpath = "//*[contains(text(), 'Fire')]/../input")
    private Checkbox fireCheckbox;

    @FindBy(xpath = "//*[contains(text(), 'Cucumber')]/../input")
    private Checkbox cucumberCheckbox;

    @FindBy(xpath = "//*[contains(text(), 'Tomato')]/../input")
    private Checkbox tomatoCheckbox;

    @FindBy(xpath = "//*[contains(text(), 'Vegetables')]/../input")
    private Checkbox vegetablesCheckbox;

    @FindBy(xpath = "//*[contains(text(), 'Onion')]/../input")
    private Checkbox onionCheckbox;

    @Override
    public void fill(MetalColorEntity metalColorEntity) {
        radioButtonsOddNumbers.select(metalColorEntity.getSummary().get(0));

        radioButtonsEvenNumbers.select(metalColorEntity.getSummary().get(1));

        for (String element : metalColorEntity.getElements()) {

            if (element.equals(MetalColorElementsEnum.WATER.getElementName())) {
                waterCheckbox.click();
            } else if (element.equals(MetalColorElementsEnum.EARTH.getElementName())) {
                earthCheckbox.click();
            } else if (element.equals(MetalColorElementsEnum.WIND.getElementName())) {
                windCheckbox.click();
            } else if (element.equals(MetalColorElementsEnum.FIRE.getElementName())) {
                fireCheckbox.click();
            }
        }

        colorsDropdown.expand();
        colorsDropdown.select(metalColorEntity.getColor());

        metalsDropdown.expand();
        metalsDropdown.select(metalColorEntity.getMetals());

        vegetablesDropdownButton.click();
        vegetablesDropdownChecklist.select(selectedVegetablesByDefault);

        for (String element : metalColorEntity.getVegetables()) {
            if (element.equals(MetalColorVegetablesEnum.CUCUMBER.getVegetableName())) {
                cucumberCheckbox.click();
            } else if (element.equals(MetalColorVegetablesEnum.TOMATO.getVegetableName())) {
                tomatoCheckbox.click();
            } else if (element.equals(MetalColorVegetablesEnum.VEGETABLES.getVegetableName())) {
                vegetablesCheckbox.click();
            } else if (element.equals(MetalColorVegetablesEnum.ONION.getVegetableName())) {
                onionCheckbox.click();
            }
        }
    }

}
