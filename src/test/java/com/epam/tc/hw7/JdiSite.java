package com.epam.tc.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.pages.HomePage;
import com.epam.tc.hw7.pages.MetalColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @Url("/index.html")
    public static HomePage homePage;

    @Url("/metals-colors.html")
    public static MetalColorsPage metalColorsPage;

}
