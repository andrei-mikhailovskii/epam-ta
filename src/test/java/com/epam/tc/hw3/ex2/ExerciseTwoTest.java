package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.AbstractChromeTest;
import com.epam.tc.hw3.page.DifferentElementsPage;
import com.epam.tc.hw3.page.DifferentElementsPageMainContainer;
import com.epam.tc.hw3.page.IndexPage;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends AbstractChromeTest {

    private String pageTitleIndexPage = "Home Page";
    private String userName = "Roman";
    private String userPassword = "Jdi1234";
    private String correctUserName = "ROMAN IOVLEV";

    @Test
    public void exerciseTwo() {

        //Assert Browser title
        //Perform login, Assert Username is loggined
        IndexPage indexPage = new IndexPage(driver);
        indexPage.verifyTitle(driver, pageTitleIndexPage)
                .loginUser(driver, userName, userPassword)
                .searchForUserNameElement()
                .verifyLogin(correctUserName);

        //Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.openDifferentElementsPage(driver, userName, userPassword);

        //select Water and Wind checkboxes
        //select Selen radio button
        //check that each element has an individual log
        //check that log values correspond the values of checkboxes, radio button, dropdown
        DifferentElementsPageMainContainer diffElemPageMainContainer = new DifferentElementsPageMainContainer(driver);
        diffElemPageMainContainer.selectCheckboxes()
                .selectRadiobuttons()
                .selectColor()
                .verifyLogs(driver);

    }

}
