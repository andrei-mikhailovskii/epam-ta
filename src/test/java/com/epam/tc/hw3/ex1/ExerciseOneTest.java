package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.AbstractChromeTest;
import com.epam.tc.hw3.page.*;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExerciseOneTest extends AbstractChromeTest {

    private String correctPageTitle = "Home Page";
    private String userName = "Roman";
    private String userPassword = "Jdi1234";
    private String correctUserName = "ROMAN IOVLEV";

    //Assert Browser title
    @Test
    public void exerciseOne() {

        //Assert Browser title
        //Perform login, Assert Username is loggined
        IndexPage indexPage = new IndexPage(driver);
        indexPage.verifyTitle(driver, correctPageTitle)
                .loginUser(driver, userName, userPassword)
                .searchForUserNameElement()
                .verifyLogin(correctUserName);

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        IndexPageNavBar indexPageNavBar = new IndexPageNavBar(driver);
        indexPageNavBar.verifyNavBarContent();

        //Assert that there are 4 images on the Index Page and they are displayed
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        IndexPageBenefitsSection indexPageBenefitsSection = new IndexPageBenefitsSection(driver);
        indexPageBenefitsSection
                .searchForImagesQuantity()
                .verifyImagesDisplayed()
                .searchForTextQuantity()
                .verifyText();

        //Assert that there is the iframe with “Frame Button” exist
        //Switch to the iframe and check that there is “Frame Button” in the iframe
        IndexPageIFrame indexPageIFrame = new IndexPageIFrame(driver);
        indexPageIFrame.iFrameExists(driver);

        //Assert that there are 5 items in the Left Section are displayed, and they have proper text
        IndexPageLeftSection indexPageLeftSection = new IndexPageLeftSection(driver);
        indexPageLeftSection.leftSectionElementsCheck();

    }

}
