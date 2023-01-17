package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.entities.UserEntity;
import com.epam.tc.hw7.forms.LoginForm;

public class HomePage extends WebPage {

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
        loggedInUserName.is().text(UserEntity.ROMAN_IOVLEV.getCorrectFullUserName());
    }

}
