package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.DriverSetup;
import com.epam.tc.hw5.pages.IndexPage;
import com.epam.tc.hw5.pages.RightSideBar;
import com.epam.tc.hw5.pages.UserTablePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExerciseThreeStep extends DriverSetup {

    IndexPage indexPage = new IndexPage(driver);
    UserTablePage userTablePage = new UserTablePage(driver);
    RightSideBar rightSideBar = new RightSideBar(driver);

    @When("I click on {string} button in Header")
    public void clickButtonInHeader(String buttonName) {
        indexPage.getHeaderNavBar().getServiceDropDown().click();
    }

    @When("I click on {string} button in Service dropdown")
    public void clickButtonInServiceDropdown(String element) {
        indexPage.getHeaderNavBar().openPageFromDropdown(element);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkUserTypeDropdownsQuantity(int correctQuantity) {
        assertThat(userTablePage.getUserTypeDropdownsQuantity())
                .as("User Type Dropdowns Quantity mismatch").isEqualTo(correctQuantity);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkUsernamesQuantity(int correctQuantity) {
        assertThat(userTablePage.getUsernamesQuantity())
                .as("Usernames Quantity mismatch").isEqualTo(correctQuantity);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkDescriptionTextsQuantity(int correctQuantity) {
        assertThat(userTablePage.getDescriptionsUnderImagesQuantity())
                .as("Description Texts Under Images Quantity mismatch").isEqualTo(correctQuantity);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkCheckboxesQuantity(int correctQuantity) {
        assertThat(userTablePage.getCheckboxesQuantity())
                .as("Checkboxes Quantity mismatch").isEqualTo(correctQuantity);
    }

    @Then("User table should contain following values:")
    public void checkUserTableValues(DataTable dataTable) {
        //check Number
        List<String> userNumbersList = userTablePage.getUserNumbers();
        List<List<String>> dataLs = dataTable.asLists(String.class);
        int indexNumber = 0;
        for (int i = 1; i < dataLs.size(); i++) {
            List<String> list = dataLs.get(i);
            assertThat(list.get(0)).as("Invalid user number").isEqualTo(userNumbersList.get(indexNumber));
            indexNumber++;
        }

        //check User
        List<String> usernamesList = userTablePage.getUserNames();
        int indexUsername = 0;
        for (int i = 1; i < dataLs.size(); i++) {
            List<String> list = dataLs.get(i);
            assertThat(list.get(1)).as("Invalid username").isEqualTo(usernamesList.get(indexUsername));
            indexUsername++;
        }

        //check Description
        List<String> descriptionList = userTablePage.getDescriptions();
        int indexDescription = 0;
        for (int i = 1; i < dataLs.size(); i++) {
            List<String> list = dataLs.get(i);
            assertThat(list.get(2)).as("Invalid description")
                    .isEqualTo(descriptionList.get(indexDescription));
            indexDescription++;
        }

    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkDropdownValues(List<String> expectedValues) {
        assertThat(userTablePage.getDropdownOptions())
                .extracting(WebElement::getText)
                .as("Invalid dropdown options for user Roman")
                .containsAll(expectedValues);
    }

    @When("I select vip checkbox for {string}")
    public void selectVipCheckbox(String user) {
        for (String checkboxId : userTablePage.getCheckboxIdList()) {
            if (user.toLowerCase().contains(checkboxId)) {
                String cssSelector = "#" + checkboxId;
                WebElement checkbox = driver.findElement(By.cssSelector(cssSelector));
                checkbox.click();
                break;
            }
        }

    }

    @Then("{int} log row has {string} text in log section")
    public void checkLogForCheckbox(int logRowQuantity, String logText) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(rightSideBar.getLogList().size())
                .as("Invalid log rows number").isEqualTo(logRowQuantity);
        int matchValues = 0;
        for (String logTextValue : rightSideBar.getLogTexts()) {
            if (logTextValue.contains(logText)) {
                matchValues++;
            }
        }
        softly.assertThat(matchValues).as("Wrong text in log section").isEqualTo(logRowQuantity);
        softly.assertAll();
    }
}
