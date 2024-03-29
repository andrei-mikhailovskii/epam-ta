package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.entities.UserEntity;

public class LoginForm extends Form<UserEntity> {

    @FindBy(id = "name")
    private TextField userName;

    @FindBy(id = "password")
    private TextField password;

    @FindBy(id = "login-button")
    private Button loginButton;

}
