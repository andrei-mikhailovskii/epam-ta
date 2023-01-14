package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.JdiSite.homePage;

import com.epam.tc.hw7.JdiSite;
import org.testng.annotations.Test;

public class JdiTest {

    @Test
    public void metalColorsFormTest() {

        JdiSite.open();
        JdiSite.login();

        homePage.checkLogin();
//        metalColorsPage.open();
//        metalColorsPage.fillForm();
//        metalColorsPage.checkFormFill();
//        metalColorsPage.clickSubmit();
//        metalColorsPage.checkResultSection();
    }

}
