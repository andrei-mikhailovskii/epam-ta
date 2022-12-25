package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.AbstractChromeTest;
import com.epam.tc.hw4.PropertiesExtractor;
import com.epam.tc.hw4.page.DifferentElementsPage;
import com.epam.tc.hw4.page.DifferentElementsPageMainContainer;
import com.epam.tc.hw4.page.IndexPage;
import com.epam.tc.hw4.page.RightSideBar;
import io.qameta.allure.Description;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends AbstractChromeTest {

    private String correctPageTitle = "Home Page";
    private String checkboxWater = "Water";
    private String checkboxWind = "Wind";
    private String radioMetal = "Selen";

    @Test
    @Description("Checks browser title, login, elements on Different Elements page including log elements")
    public void exerciseTwo() {

        SoftAssertions softly = new SoftAssertions();

        //Assert Browser title
        IndexPage indexPage = new IndexPage(driver);
        softly.assertThat(driver.getTitle()).as("Invalid Browser title").isEqualTo(correctPageTitle);

        //Perform login, Assert Username is loggined
        indexPage.loginUser(driver, PropertiesExtractor.getUsername(), PropertiesExtractor.getPassword());
        softly.assertThat(indexPage.searchNotLoggedInUserNames() == 0).as("Login failed").isTrue();
        softly.assertThat(indexPage.loginName()).isEqualTo(PropertiesExtractor.getCorrectUsername());

        //Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.openDifferentElementsPage(driver);

        //select Water and Wind checkboxes
        //select Selen radio button
        //select Yellow color in dropdown
        DifferentElementsPageMainContainer diffElemPageMainContainer = new DifferentElementsPageMainContainer(driver);
        diffElemPageMainContainer.selectCheckboxes()
                .selectRadiobuttons()
                .selectColor();

        //check that each element has an individual log
        RightSideBar rightSideBar = new RightSideBar(driver);
        softly.assertThat(rightSideBar.logCount(driver) == 4).as("Lack of log entries").isTrue();

        //check that log values correspond the values of checkboxes, radio button, dropdown
        softly.assertThat(rightSideBar.checkboxMatchStatus(checkboxWater))
                .as("Log value for Water checkbox does not match it's value").isTrue();
        softly.assertThat(rightSideBar.checkboxMatchStatus(checkboxWind))
                .as("Log value for Wind checkbox does not match it's value").isTrue();
        softly.assertThat(rightSideBar.radioMatchStatus(radioMetal))
                .as("Log value for Metal radio does not match it's value").isTrue();
        softly.assertThat(rightSideBar.colorMatchStatus())
                .as("Log value for Selen radio des not match it's value").isTrue();

        softly.assertAll();

    }

}
