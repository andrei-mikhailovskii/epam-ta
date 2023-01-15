package com.epam.tc.hw7.tests;

import com.epam.tc.hw7.JdiSite;
import com.epam.tc.hw7.TestSetup;
import com.epam.tc.hw7.entities.User;
import org.testng.annotations.Test;

public class JdiTest extends TestSetup {

    @Test
    public void metalColorsFormTest() {

        JdiSite.homePage.open();
        JdiSite.login(User.ROMAN_IOVLEV);
        JdiSite.homePage.checkLogin();
        JdiSite.metalColorsPage.open();
        JdiSite.metalColorsPage.fillForm();
        /*metalColorsPage.fillForm();
        metalColorsPage.checkFormFill();
        metalColorsPage.clickSubmit();
        metalColorsPage.checkResultSection();*/
    }

}
