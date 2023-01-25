package com.epam.tc.hw7.tests;

import com.epam.tc.hw7.DataProviderClass;
import com.epam.tc.hw7.JdiSite;
import com.epam.tc.hw7.TestSetup;
import com.epam.tc.hw7.entities.MetalColorEntity;
import org.testng.annotations.Test;

public class JdiTest extends TestSetup {

    @Test(dataProvider = "JsonData", dataProviderClass = DataProviderClass.class)
    public void metalColorsFormTest(MetalColorEntity metalColorEntity) {

        JdiSite.homePage.checkLogin();
        JdiSite.metalColorsPage.open();
        JdiSite.metalColorsPage.fillForm(metalColorEntity);
        JdiSite.metalColorsPage.clickSubmit();
        JdiSite.metalColorsPage.checkResultSection(metalColorEntity);

    }

}
