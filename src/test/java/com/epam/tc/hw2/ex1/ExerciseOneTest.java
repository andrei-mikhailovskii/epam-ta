package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.AbstractChromeTest;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExerciseOneTest extends AbstractChromeTest {

    @Test
    public void exerciseOne() {

        SoftAssertions softly = new SoftAssertions();

        //Assert Browser title
        softly.assertThat(driver.getTitle()).as("Invalid Browser title").isEqualTo("Home Page");

        //Perform login, Assert Username is loggined
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.uui-profile-menu"))).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> searchResultsUserNameElement = driver.findElements(By.id("user-name"));

        softly.assertThat(searchResultsUserNameElement.size() > 0).as("Login failed").isTrue();
        softly.assertThat(driver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");

        //Assert that there are 4 items on the header section are displayed and they have proper texts

        List<WebElement> searchResultsHeaderElement = driver.findElements(By.cssSelector("ul.m-l8>li"));
        softly.assertThat(searchResultsHeaderElement.size() == 4);

        softly.assertThat(driver.findElement(By.linkText("HOME")).isDisplayed());
        softly.assertThat(driver.findElement(By.linkText("CONTACT FORM")).isDisplayed());
        softly.assertThat(driver.findElement(By.linkText("SERVICE")).isDisplayed());
        softly.assertThat(driver.findElement(By.linkText("METALS & COLORS")).isDisplayed());


        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> searchResultsBenefitIcons = driver.findElements(By.className("benefit-icon"));
        softly.assertThat(searchResultsBenefitIcons.size() == 4)
                .as("Images quantity inconsistency").isTrue();

        softly.assertThat(driver.findElement(By.className("icon-practise")).isDisplayed());
        softly.assertThat(driver.findElement(By.className("icon-custom")).isDisplayed());
        softly.assertThat(driver.findElement(By.className("icon-multi")).isDisplayed());
        softly.assertThat(driver.findElement(By.className("icon-base")).isDisplayed());

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> searchResultsBenefitText = driver.findElements(By.className("benefit-txt"));
        softly.assertThat(searchResultsBenefitText.size() == 4).as("Texts quantity inconsistency");

        int correctTexts = 0;

        for (WebElement textElement : searchResultsBenefitText) {
            String text = textElement.getText();

            if (text.equals("To include good practices\nand ideas from successful\nEPAM project")
                || text.equals("To be flexible and\ncustomizable")
                || text.equals("To be multiplatform")
                || text.equals("Already have good base\n(about 20 internal and\nsome external projects),"
                    + "\nwish to get more…")) {
                correctTexts++;
            }

        }
        softly.assertThat(correctTexts == 4).as("Some of texts is incorrect").isTrue();

        //Assert that there is the iframe with “Frame Button” exist
        List<WebElement> searchResultsIFrame = driver.findElements(By.id("frame"));

        int buttonCount = 0;

        for (WebElement e : searchResultsIFrame) {
            driver.switchTo().frame("frame");

            if ((driver.findElements(By.id("frame-button")).size() > 0)) {
                buttonCount++;
            }

            driver.switchTo().defaultContent();
        }

        softly.assertThat(buttonCount > 0).as("No iframes with button 'Frame Button'").isTrue();


        //Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");

        softly.assertThat(driver.findElement(By.id("frame-button")));

        //Switch to original window back
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> searchResultsLeftSection = driver.findElements(By.cssSelector(".sidebar-menu>li"));
        softly.assertThat(searchResultsLeftSection.size() == 5)
                .as("There are not 5 elements in the Left Side section").isTrue();

        int numberOfCorrectTitles = 0;
        for (WebElement element : searchResultsLeftSection) {

            String title = element.getText();

            if (title.equals("Home")
                    || title.equals("Contact form")
                    || title.equals("Service")
                    || title.equals("Metals & Colors")
                    || title.equals("Elements packs")) {
                numberOfCorrectTitles++;
            }

        }

        softly.assertThat(numberOfCorrectTitles == 5)
                .as("Some of the Left Section items has improper text");

        softly.assertAll();

    }

}
