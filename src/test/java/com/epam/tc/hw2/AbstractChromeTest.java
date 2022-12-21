package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractChromeTest {

    protected WebDriver driver;

    //Setup driver for Chrome, Open test site by URL, Maximize window
    @BeforeClass(alwaysRun = true)
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }

}
