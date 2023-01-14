package com.epam.tc.hw7.tests;

import com.epam.tc.hw7.entities.User;
import org.testng.annotations.Test;

public class JdiTest {

    @Test
    public void metalColorsFormTest() {

        JdiSite.login(User.ROMAN_IOVLEV);

        homePage.open();
        homePage.login();
        homePage.checkLogin();
        metalColorsPage.open();
        metalColorsPage.fillForm();
        metalColorsPage.checkFormFill();
        metalColorsPage.clickSubmit();
        metalColorsPage.checkResultSection();
    }

}
