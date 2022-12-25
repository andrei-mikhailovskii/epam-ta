package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.AbstractChromeTest;
import com.epam.tc.hw4.PropertiesExtractor;
import com.epam.tc.hw4.page.IndexPage;
import com.epam.tc.hw4.page.IndexPageIFrame;
import com.epam.tc.hw4.page.IndexPageMainContainer;
import io.qameta.allure.Description;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class ExerciseOneTest extends AbstractChromeTest {

    private String correctPageTitle = "Home Page";
    private String correctUserName = "ROMAN IOVLEV";

    //Assert Browser title
    @Test
    @Description("Checks browser title, login, header section, 4 images with texts, iframe with “Frame Button”")
    public void exerciseOne() {

        SoftAssertions softly = new SoftAssertions();

        //Assert Browser title
        IndexPage indexPage = new IndexPage(driver);
        softly.assertThat(driver.getTitle()).as("Invalid Browser title").isEqualTo(correctPageTitle);

        //Perform login, Assert Username is loggined
        indexPage.loginUser(driver, PropertiesExtractor.getUsername(), PropertiesExtractor.getPassword());
        softly.assertThat(indexPage.searchNotLoggedInUserNames() == 0).as("Login failed").isTrue();
        softly.assertThat(indexPage.loginName()).isEqualTo(correctUserName);

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        softly.assertThat(indexPage.getHeaderNavBar().listOfHeaderElementsQuantity() == 4).isTrue();

        softly.assertThat(indexPage.getHeaderNavBar().getHomeTab().isDisplayed());
        softly.assertThat(indexPage.getHeaderNavBar().getContactFormTab().isDisplayed());
        softly.assertThat(indexPage.getHeaderNavBar().getServiceDropDown().isDisplayed());
        softly.assertThat(indexPage.getHeaderNavBar().getMetalAndColorsTab().isDisplayed());

        //Assert that there are 4 images on the Index Page and they are displayed
        IndexPageMainContainer indexPageMainCont = new IndexPageMainContainer(driver);
        softly.assertThat(indexPageMainCont.searchForImagesQuantity() == 4).isTrue();

        softly.assertThat(indexPageMainCont.getIconPractise().isDisplayed());
        softly.assertThat(indexPageMainCont.getIconCustom().isDisplayed());
        softly.assertThat(indexPageMainCont.getIconMulti().isDisplayed());
        softly.assertThat(indexPageMainCont.getIconBase().isDisplayed());


        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        softly.assertThat(indexPageMainCont.searchForTextQuantity() == 4).isTrue();

        softly.assertThat(indexPageMainCont.numberOfCorrectTexts() == 4).isTrue();

        //Assert that there is the iframe with “Frame Button” exist
        //Switch to the iframe and check that there is “Frame Button” in the iframe
        IndexPageIFrame indexPageIFrame = new IndexPageIFrame(driver);
        softly.assertThat(indexPageIFrame.iframeWithButtonCount(driver) > 0)
                .as("No iframes with button 'Frame Button'").isTrue();

        //Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softly.assertThat(indexPage.getLeftNavBar().leftSectionElementsCount() == 5)
                .as("There are not 5 elements in the Left Side section").isTrue();

        softly.assertThat(indexPage.getLeftNavBar().leftSectionCorrectTitlesCount() == 5)
                .as("Some of the Left Section items has improper text").isTrue();

        softly.assertAll();

    }

}
