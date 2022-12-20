package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.AbstractChromeTest;
import com.epam.tc.hw3.page.IndexPage;
import com.epam.tc.hw3.page.IndexPageBenefitsSection;
import com.epam.tc.hw3.page.IndexPageIFrame;
import com.epam.tc.hw3.page.IndexPageNavBar;
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
    public void checkTitle() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.verifyTitle(driver, correctPageTitle);
    }

    //Perform login, Assert Username is loggined
    @Test
    public void loginCheck() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.loginUser(driver, userName, userPassword)
                .searchForUserNameElement()
                .verifyLogin(correctUserName);
    }

    //Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test
    public void navBarCheck() {
        IndexPageNavBar indexPageNavBar = new IndexPageNavBar(driver);
        indexPageNavBar.verifyNavBarContent();

    }

    //Assert that there are 4 images on the Index Page and they are displayed
    @Test
    public void imagesCheck() {
        IndexPageBenefitsSection indexPageBenefitsSection = new IndexPageBenefitsSection(driver);
        indexPageBenefitsSection
                .searchForImagesQuantity()
                .verifyImagesDisplayed();
    }

    //Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test
    public void textCheck() {
        IndexPageBenefitsSection indexPageBenefitsSection = new IndexPageBenefitsSection(driver);
        indexPageBenefitsSection
                .searchForTextQuantity()
                .verifyText();

    }

    //Assert that there is the iframe with “Frame Button” exist
    @Test
    public void iframeExists() {

        IndexPageIFrame indexPageIFrame = new IndexPageIFrame();
        indexPageIFrame.iFramePresense();

    }






   /*
    //Assert that there is the iframe with “Frame Button” exist
    @Test
    public void iframeExists() {

        List<WebElement> searchResults = driver.findElements(By.id("frame"));

        int buttonCount = 0;

        for (WebElement e : searchResults) {
            driver.switchTo().frame("frame");

            if ((driver.findElements(By.id("frame-button")).size() > 0)) {
                buttonCount++;
            }

            driver.switchTo().defaultContent();
        }

        assertThat(buttonCount > 0).as("No iframes with button 'Frame Button'").isTrue();

    }

    //Switch to the iframe and check that there is “Frame Button” in the iframe
    @Test
    public void iframeButton() {

        driver.switchTo().frame("frame");

        assertThat(driver.findElement(By.id("frame-button")));

        //Switch to original window back
        driver.switchTo().defaultContent();

    }

    //Assert that there are 5 items in the Left Section are displayed, and they have proper text
    @Test
    public void leftSection() {

        SoftAssertions softly = new SoftAssertions();
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".sidebar-menu>li"));
        softly.assertThat(searchResults.size() == 5).as("There are not 5 elements in the Left Side section").isTrue();

        softly.assertThat(driver.findElement(By.cssSelector("ul.sidebar-menu.left > li[index='1']"))
                .getText()).isEqualTo("Home");
        softly.assertThat(driver.findElement(By.cssSelector("ul.sidebar-menu.left > li[index='2']"))
                .getText()).isEqualTo("Contact form");
        softly.assertThat(driver.findElement(By.cssSelector("ul.sidebar-menu.left > li[index='3']"))
                .getText()).isEqualTo("Service");
        softly.assertThat(driver.findElement(By.cssSelector("ul.sidebar-menu.left > li[index='4']"))
                .getText()).isEqualTo("Metals & Colors");
        softly.assertThat(driver.findElement(By.cssSelector("ul.sidebar-menu.left > li[index='5']"))
                .getText()).isEqualTo("Elements packs");
        softly.assertAll();

    }*/

}