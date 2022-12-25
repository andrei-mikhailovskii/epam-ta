package com.epam.tc.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractChromeTest {

    protected WebDriver driver;

    private static final String HOME_PAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    //Setup driver for Chrome, Open test site by URL, Maximize window
    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);
    }

    //close browser
    @AfterClass
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }

    }

}
