package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class MetalColorsForm {

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

    @JDropdown(root = "")
    private Dropdown vegetablesDropdown;

    @FindBy(id = "salad-dropdown")
    private Button vegetablesDropdownButton;

    @FindBy(css = ".salad .dropdown-menu")
    private Checklist vegetablesDropdownChecklist;

    @FindBy(id = "submit-button")
    private Button submitButton;

}
