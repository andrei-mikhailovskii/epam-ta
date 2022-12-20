package com.epam.tc.hw2.ex1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw2.AbstractChromeTest;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExerciseOneTest extends AbstractChromeTest {

    //Assert Browser title
    @Test
    public void checkTitle() {

        assertThat(driver.getTitle()).as("Invalid Browser title").isEqualTo("Home Page");

    }

    //Perform login, Assert Username is loggined
    @Test
    public void login() {

        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.uui-profile-menu"))).click();
            driver.findElement(By.id("name")).sendKeys("Roman");
            driver.findElement(By.id("password")).sendKeys("Jdi1234");
            driver.findElement(By.id("login-button")).click();
        } catch (NoSuchElementException e) {
            System.err.println("No element: " + e);
        }

        List<WebElement> searchResults = driver.findElements(By.id("user-name"));

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(searchResults.size() > 0).as("Login failed").isTrue();
        softly.assertThat(driver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");
        softly.assertAll();

    }

    //Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test
    public void navBarCheck() {

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='index.html']")).isDisplayed());
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='contacts.html']")).isDisplayed());
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a.dropdown-toggle")).isDisplayed());
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='metals-colors.html']")).isDisplayed());

        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='index.html']")).getText()).isEqualTo("HOME");
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='contacts.html']")).getText()).isEqualTo("CONTACT FORM");
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a.dropdown-toggle"))
                .getText()).isEqualTo("SERVICE");
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='metals-colors.html']")).getText()).isEqualTo("METALS & COLORS");
        softly.assertAll();

    }

    //Assert that there are 4 images on the Index Page and they are displayed
    @Test
    public void imagesCheck() {

        SoftAssertions softly = new SoftAssertions();
        List<WebElement> searchResults = driver.findElements(By.className("benefit-icon"));
        softly.assertThat(searchResults.size() == 4).as("Images quantity inconsistency").isTrue();

        softly.assertThat(driver.findElement(By.className("icon-practise")).isDisplayed());
        softly.assertThat(driver.findElement(By.className("icon-custom")).isDisplayed());
        softly.assertThat(driver.findElement(By.className("icon-multi")).isDisplayed());
        softly.assertThat(driver.findElement(By.className("icon-base")).isDisplayed());

        softly.assertAll();

    }

    //Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test
    public void textCheck() {

        SoftAssertions softly = new SoftAssertions();
        List<WebElement> searchResults = driver.findElements(By.className("benefit-txt"));
        softly.assertThat(searchResults.size() == 4).as("Texts quantity inconsistency").isTrue();

        softly.assertThat(driver
                .findElement(By.xpath("//div[normalize-space(span) = "
                        + "'To include good practicesand ideas from successfulEPAM project']")).isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//div[normalize-space(span) = "
                + "'To be flexible andcustomizable']")).isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//span[(text()='To be multiplatform ')]")).isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//div[normalize-space(span) = 'Already "
                + "have good base(about 20 internal andsome external projects),wish to get more…']")).isDisplayed());
        softly.assertAll();

    }

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

    }

}
