package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.AbstractChromeTest;
import com.epam.tc.hw3.PropertiesExtractor;
import com.epam.tc.hw3.page.IndexPage;
import com.epam.tc.hw3.page.IndexPageBenefitsSection;
import com.epam.tc.hw3.page.IndexPageIFrame;
import com.epam.tc.hw3.page.IndexPageLeftSection;
import com.epam.tc.hw3.page.IndexPageNavBar;
import org.testng.annotations.Test;

public class ExerciseOneTest extends AbstractChromeTest {

    private String correctPageTitle = "Home Page";
    private String correctUserName = "ROMAN IOVLEV";

    //Assert Browser title
    @Test
    public void exerciseOne() {

        //Assert Browser title
        //Perform login, Assert Username is loggined
        IndexPage indexPage = new IndexPage(driver);
        indexPage.verifyTitle(driver, correctPageTitle)
                .loginUser(driver, PropertiesExtractor.getUsername(), PropertiesExtractor.getPassword())
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
        indexPageIFrame.iframeExists(driver);

        //Assert that there are 5 items in the Left Section are displayed, and they have proper text
        IndexPageLeftSection indexPageLeftSection = new IndexPageLeftSection(driver);
        indexPageLeftSection.leftSectionElementsCheck();

    }

}
