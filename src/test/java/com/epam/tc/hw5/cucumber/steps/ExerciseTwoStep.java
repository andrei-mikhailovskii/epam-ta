package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.DriverSetup;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.DifferentElementsPageMainContainer;
import com.epam.tc.hw5.pages.RightSideBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExerciseTwoStep extends DriverSetup {

    DifferentElementsPage diffElementsPage = new DifferentElementsPage(driver);
    DifferentElementsPageMainContainer diffElemPageMainContainer = new DifferentElementsPageMainContainer(driver);
    RightSideBar rightSideBar = new RightSideBar(driver);

    @When("I open Different Elements page")
    public void clickDropdownInHeader() {
        diffElementsPage.openDifferentElementsPage(driver);
    }

    @When("I select two checkboxes")
    public void selectCheckboxes() {
        diffElemPageMainContainer.selectCheckboxes();
    }

    @When("I select radio button")
    public void selectRadioButton() {
        diffElemPageMainContainer.selectRadiobuttons();
    }

    @When("I select color dropdown")
    public void selectColorDropdown() {
        diffElemPageMainContainer.selectColor();
    }

    @Then("{string} page should be opened")
    public void checkBrowserTitle(String correctPageTitle) {
        assertThat(driver.getTitle()).as("Invalid Browser title").isEqualTo(correctPageTitle);
    }

    @And("{int} log rows are presented")
    public void checkLogRows(int logQuantity) {
        assertThat(rightSideBar.logCount(driver) == logQuantity).as("Lack of log entries").isTrue();
    }

    @Then("{string} checkbox log status is correct")
    public void checkCheckboxLogStatus(String checkboxName) {
        assertThat(rightSideBar.checkboxMatchStatus(checkboxName))
                .as("Log value for Water checkbox does not match it's value").isTrue();
    }

    @Then("{string} radio button log status is correct")
    public void ckechRadioLogStatus(String radioName) {
        assertThat(rightSideBar.radioMatchStatus(radioName))
                .as("Log value for Metal radio does not match it's value").isTrue();
    }

    @Then("Color dropdown log status is correct")
    public void checkColorLogStatus() {
        assertThat(rightSideBar.colorMatchStatus())
                .as("Log value for Selen radio des not match it's value").isTrue();
    }

}
