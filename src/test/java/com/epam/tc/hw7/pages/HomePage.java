package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.entities.User;

public class HomePage extends WebPage {

    public static void login(User romanIovlev) {
        romanIovlev = User.ROMAN_IOVLEV;
    }

    public static void checkLogin() {
    }

}
