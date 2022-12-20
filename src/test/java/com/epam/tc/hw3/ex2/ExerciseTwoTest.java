package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.AbstractChromeTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTwoTest extends AbstractChromeTest {

    @Test
    public void exerciseTwo() {
        SoftAssertions softly = new SoftAssertions();

        //Assert Browser title
        softly.assertThat(driver.getTitle()).as("Invalid Browser title").isEqualTo("Home Page");

        //Perform login, Assert Username is loggined
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.uui-profile-menu"))).click();
            driver.findElement(By.id("name")).sendKeys("Roman");
            driver.findElement(By.id("password")).sendKeys("Jdi1234");
            driver.findElement(By.id("login-button")).click();
        } catch (NoSuchElementException e) {
            System.err.println("No element: " + e);
        }
        softly.assertThat(driver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");

        //Open through the header menu Service -> Different Elements Page
        driver.findElement(By.linkText("SERVICE")).click();

        List<WebElement> options = driver.findElements(By.cssSelector("ul.m-l8>li>ul.dropdown-menu>li"));

        for (WebElement opt : options) {
            if (opt.getText().equals("DIFFERENT ELEMENTS")) {
                opt.click();
                break;
            }
        }

        //select Water and Wind checkboxes
        List<WebElement> checkboxes = new WebDriverWait(driver, 5)
            .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(".label-checkbox"))));
        for (WebElement opt : checkboxes) {
            if (opt.getText().equals("Water") | opt.getText().equals("Wind")) {
                opt.click();
            }
        }

        //select Selen radio button
        List<WebElement> radio = driver.findElements(By.cssSelector(".label-radio"));
        for (WebElement opt : radio) {
            if (opt.getText().equals("Selen")) {
                opt.click();
            }
        }

        //select Yellow color in dropdown
        Select color = new Select(driver.findElement(By.cssSelector("div.colors>.uui-form-element")));
        color.selectByVisibleText("Yellow");


        //turn boolean values of checkboxes into char sequences for further check in assertions
        CharSequence water = null;
        CharSequence wind = null;
        for (WebElement opt : checkboxes) {
            if (opt.getText().equals("Water")) {
                water = String.valueOf(opt.findElement(By.cssSelector("input")).isSelected());
            } else if (opt.getText().equals("Wind")) {
                wind = String.valueOf(opt.findElement(By.cssSelector("input")).isSelected());
            }
        }

        //turn boolean value of radio button into char sequence for further check in assertions
        CharSequence metal = null;
        for (WebElement opt : radio) {
            if (opt.findElement(By.cssSelector("input")).isSelected()) {
                metal = opt.getText();
            }
        }

        //turn color option into char sequence for further check in assertions
        WebElement o = color.getFirstSelectedOption();
        CharSequence colorOption = o.getText();

        //find log entries and turn them into list of strings for further checks in assertions
        List<WebElement> logs = driver.findElements(By.cssSelector(".panel-body-list.logs>li"));
        List<String> logList = new ArrayList();
        for (WebElement e : logs) {
            logList.add(String.valueOf(e.getText()));
        }

        //check that each element has an individual log
        //check that log values correspond the values of checkboxes, radio button, dropdown
        int individualLogs = 0;
        for (String s : logList) {
            if (s.contains("Water")) {
                individualLogs++;
                softly.assertThat(s.contains(water))
                        .as("Log value for Water checkbox des not match it's value").isTrue();
            } else if (s.contains("Wind")) {
                individualLogs++;
                softly.assertThat(s.contains(wind)).as("Log value for Wind checkbox des not match it's value").isTrue();
            } else if (s.contains("metal")) {
                individualLogs++;
                softly.assertThat(s.contains(metal)).as("Log value for Metal radio des not match it's value").isTrue();
            } else if (s.contains("Color")) {
                individualLogs++;
                softly.assertThat(s.contains(colorOption))
                        .as("Log value for Selen radio des not match it's value").isTrue();
            }
        }
        softly.assertThat(individualLogs == 4).as("Lack of log entries").isTrue();

        softly.assertAll();

    }

}
