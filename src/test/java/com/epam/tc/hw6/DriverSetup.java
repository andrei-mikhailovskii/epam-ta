package com.epam.tc.hw6;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriverSetup {

    protected WebDriver driver;

    private static final String HOME_PAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    //Setup driver, Maximize window, Open test site by URL
    @BeforeClass(alwaysRun = true)
    @Parameters({"isLocal", "hubAddress", "browserName"})
    public void setup(@Optional("false") final boolean isLocal, final String hubAddress, final String browserName) {
        try {
            driver = DriverFabric.getWebdriver(isLocal, hubAddress, browserName);
            driver.manage().window().maximize();
            driver.get(HOME_PAGE_URL);
        } catch (MalformedURLException malformedUrlException) {
            System.out.println("A malformed URL has occurred: " + malformedUrlException);
        }

    }

    @BeforeMethod(alwaysRun = true)
    public void setContextAttribute(ITestContext context) {
        context.setAttribute("driver", driver);
    }

    //close browser
    @AfterClass
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }

    }

}
