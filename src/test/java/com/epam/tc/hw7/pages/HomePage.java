package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.PropertiesExtractor;
import com.epam.tc.hw7.entities.UserEntity;
import com.epam.tc.hw7.forms.LoginForm;

public class HomePage extends WebPage {

    public static final UserEntity ROMAN_IOVLEV = new UserEntity(
            PropertiesExtractor.getUsername(),
            PropertiesExtractor.getPassword(),
            PropertiesExtractor.getCorrectUsername());

    private LoginForm loginForm;

    @FindBy(id = "user-icon")
    private Icon userIcon;

    @FindBy(id = "user-name")
    private Label loggedInUserName;

    public void login(UserEntity userEntity) {
        userIcon.click();
        loginForm.login(userEntity);
    }

    public void checkLogin() {
        loggedInUserName.is().text(ROMAN_IOVLEV.getCorrectFullUserName());
    }

}
