package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.DriverSetup;
import com.epam.tc.hw5.pages.IndexPage;
import com.epam.tc.hw5.pages.IndexPageIFrame;
import com.epam.tc.hw5.pages.IndexPageMainContainer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class ExerciseOneStep extends DriverSetup {

    IndexPage indexPage = new IndexPage(driver);
    IndexPageMainContainer indexPageMainCont = new IndexPageMainContainer(driver);
    IndexPageIFrame indexPageIFrame = new IndexPageIFrame(driver);

    @When("I open JDI GitHub site")
    public void openJdiGitHubSite() {
        indexPage.openIndexPage();
    }

    @Then("Browser title equals {string}")
    public void checkBrowserTitle(String correctPageTitle) {
        assertThat(driver.getTitle()).as("Invalid Browser title").isEqualTo(correctPageTitle);
    }

    @When("I login with username {string} and password {string}")
    public void loginUser(String username, String password) {
        indexPage.loginUser(username, password);
    }

    @Then("User is logged in as {string}")
    public void checkUserLogin(String correctUserName) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(indexPage.searchNotLoggedInUserNames() == 0).as("Login failed").isTrue();
        softly.assertThat(indexPage.loginName()).isEqualTo(correctUserName);
        softly.assertAll();
    }

    @Then("Header buttons are displayed and have proper texts")
    public void checkHeaderButtons() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(indexPage.getHeaderNavBar().listOfHeaderElementsQuantity() == 4).isTrue();
        softly.assertThat(indexPage.getHeaderNavBar().getHomeTab().isDisplayed());
        softly.assertThat(indexPage.getHeaderNavBar().getContactFormTab().isDisplayed());
        softly.assertThat(indexPage.getHeaderNavBar().getServiceDropDown().isDisplayed());
        softly.assertThat(indexPage.getHeaderNavBar().getMetalAndColorsTab().isDisplayed());
        softly.assertAll();
    }

    @Then("{int} images are displayed")
    public void checkImagesDisplayed(int imagesQuantity) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(indexPageMainCont.searchForImagesQuantity() == imagesQuantity).isTrue();
        softly.assertThat(indexPageMainCont.getIconPractise().isDisplayed());
        softly.assertThat(indexPageMainCont.getIconCustom().isDisplayed());
        softly.assertThat(indexPageMainCont.getIconMulti().isDisplayed());
        softly.assertThat(indexPageMainCont.getIconBase().isDisplayed());
        softly.assertAll();
    }

    @Then("Images texts are displayed and correct")
    public void checkImagesTexts() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(indexPageMainCont.searchForTextQuantity() == 4).isTrue();
        softly.assertThat(indexPageMainCont.numberOfCorrectTexts() == 4).isTrue();
        softly.assertAll();
    }

    @Then("Iframe with “Frame Button” exists")
    public void checkIframeWithFrameButton() {
        assertThat(indexPageIFrame.iframeWithButtonCount(driver) > 0)
                .as("No iframes with button 'Frame Button'").isTrue();
    }

    @Then("Left section menu items are displayed with proper texts")
    public void leftSectionMenuItemsAreDisplayedWithProperTexts() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(indexPage.getLeftNavBar().leftSectionElementsCount() == 5)
                .as("There are not 5 elements in the Left Side section").isTrue();
        softly.assertThat(indexPage.getLeftNavBar().leftSectionCorrectTitlesCount() == 5)
                .as("Some of the Left Section items has improper text").isTrue();
        softly.assertAll();
    }
}
