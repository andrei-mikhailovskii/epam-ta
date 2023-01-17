package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalColorEntity;

public class MetalColorsForm extends Form<MetalColorEntity> {

    @FindBy(name = "custom_radio_odd")
    private RadioButtons radioButtonsOddNumbers;

    @FindBy(name = "custom_radio_even")
    private RadioButtons radioButtonsEvenNumbers;

    @FindBy(id = "elements-checklist")
    private Checklist elements;

    @JDropdown(root = ".colors", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown colorsDropdown;

    @JDropdown(root = ".metals", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown metalsDropdown;

    @FindBy(id = "salad-dropdown")
    private Button vegetablesDropdownButton;

    @FindBy(css = ".salad .dropdown-menu")
    private Checklist vegetablesDropdownChecklist;

    @FindBy(id = "submit-button")
    private Button submitButton;

    @Override
    public void fill(MetalColorEntity metalColorEntity) {
        radioButtonsOddNumbers.select(metalColorEntity.getSummary().get(0));
        radioButtonsEvenNumbers.select(metalColorEntity.getSummary().get(1));
        metalColorEntity.getElements().forEach(elements -> click());
        colorsDropdown.expand();
        colorsDropdown.select(metalColorEntity.getColor());
        metalsDropdown.expand();
        metalsDropdown.select(metalColorEntity.getMetals());
        vegetablesDropdownButton.click();
        vegetablesDropdownChecklist.uncheckAll();
        metalColorEntity.getVegetables().forEach(vegetablesDropdownChecklist -> click());
        submitButton.click();
    }

}
