package com.epam.tc.hw6.ex1;

import com.epam.tc.hw6.DriverSetup;
import com.epam.tc.hw6.PropertiesExtractor;
import com.epam.tc.hw6.page.IndexPage;
import com.epam.tc.hw6.page.IndexPageIFrame;
import com.epam.tc.hw6.page.IndexPageMainContainer;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class ExerciseOneTest extends DriverSetup {

    private String correctPageTitle = "Home Page";
    private String correctUserName = "ROMAN IOVLEV";

    SoftAssertions softly = new SoftAssertions();

    @Test
    @Feature("Feature One")
    @Story("Index Page")
    @Description("Checks browser title, login, header section, 4 images with texts, iframe with “Frame Button”")
    public void exerciseOne() {
        assertBrowserTitle();
        assertLogin();
        assertHeaderSection();
        assertImages();
        assertIconsTexts();
        assertIframe();

        softly.assertAll();
    }

    //Assert Browser title
    @Step
    public SoftAssertions assertBrowserTitle() {
        softly.assertThat(driver.getTitle()).as("Invalid Browser title").isEqualTo(correctPageTitle);
        return softly;
    }

    //Perform login, Assert Username is loggined
    @Step
    public SoftAssertions assertLogin() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.loginUser(driver, PropertiesExtractor.getUsername(), PropertiesExtractor.getPassword());
        softly.assertThat(indexPage.searchNotLoggedInUserNames() == 0).as("Login failed").isTrue();
        softly.assertThat(indexPage.loginName()).isEqualTo(PropertiesExtractor.getCorrectUsername());
        return softly;
    }

    //Assert that there are 4 items on the header section are displayed and they have proper texts
    @Step
    public SoftAssertions assertHeaderSection() {
        IndexPage indexPage = new IndexPage(driver);
        softly.assertThat(indexPage.getHeaderNavBar().listOfHeaderElementsQuantity() == 4).isTrue();

        softly.assertThat(indexPage.getHeaderNavBar().getHomeTab().isDisplayed());
        softly.assertThat(indexPage.getHeaderNavBar().getContactFormTab().isDisplayed());
        softly.assertThat(indexPage.getHeaderNavBar().getServiceDropDown().isDisplayed());
        softly.assertThat(indexPage.getHeaderNavBar().getMetalAndColorsTab().isDisplayed());
        return softly;
    }

    //Assert that there are 4 images on the Index Page and they are displayed
    @Step
    public SoftAssertions assertImages() {
        IndexPageMainContainer indexPageMainCont = new IndexPageMainContainer(driver);
        softly.assertThat(indexPageMainCont.searchForImagesQuantity() == 4).isTrue();

        softly.assertThat(indexPageMainCont.getIconPractise().isDisplayed());
        softly.assertThat(indexPageMainCont.getIconCustom().isDisplayed());
        softly.assertThat(indexPageMainCont.getIconMulti().isDisplayed());
        softly.assertThat(indexPageMainCont.getIconBase().isDisplayed());
        return softly;
    }

    //Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Step
    public SoftAssertions assertIconsTexts() {
        IndexPageMainContainer indexPageMainCont = new IndexPageMainContainer(driver);
        softly.assertThat(indexPageMainCont.searchForTextQuantity() == 4).isTrue();

        softly.assertThat(indexPageMainCont.numberOfCorrectTexts() == 4).isTrue();
        return softly;
    }

    //Assert that there is the iframe with “Frame Button” exist
    //Switch to the iframe and check that there is “Frame Button” in the iframe
    @Step
    public SoftAssertions assertIframe() {
        IndexPage indexPage = new IndexPage(driver);
        IndexPageIFrame indexPageIFrame = new IndexPageIFrame(driver);
        softly.assertThat(indexPageIFrame.iframeWithButtonCount(driver) > 0)
                .as("No iframes with button 'Frame Button'").isTrue();

        //Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softly.assertThat(indexPage.getLeftNavBar().leftSectionElementsCount() == 5)
                .as("There are not 5 elements in the Left Side section").isTrue();

        softly.assertThat(indexPage.getLeftNavBar().leftSectionCorrectTitlesCount() == 5)
                .as("Some of the Left Section items has improper text").isTrue();
        return softly;
    }

}
