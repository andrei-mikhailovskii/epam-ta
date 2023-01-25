package com.epam.tc.hw7;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.pages.HomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSetup {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
        JdiSite.homePage.open();
        JdiSite.homePage.login(HomePage.ROMAN_IOVLEV);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

}
