package com.epam.tc.hw7.entities;

import com.epam.tc.hw7.PropertiesExtractor;

public class User {

    public static final User ROMAN_IOVLEV = new User(
            PropertiesExtractor.getUsername(),
            PropertiesExtractor.getPassword(),
            PropertiesExtractor.getCorrectUsername());

    public String userName;
    public String password;
    public String correctFullUserName;

    public User(String userName, String password, String correctFullUserName) {
        this.userName = userName;
        this.password = password;
        this.correctFullUserName = correctFullUserName;
    }

}
