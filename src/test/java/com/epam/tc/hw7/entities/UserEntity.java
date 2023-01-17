package com.epam.tc.hw7.entities;

import com.epam.tc.hw7.PropertiesExtractor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {

    public static final UserEntity ROMAN_IOVLEV = new UserEntity(
            PropertiesExtractor.getUsername(),
            PropertiesExtractor.getPassword(),
            PropertiesExtractor.getCorrectUsername());

    private String userName;
    private String password;
    private String correctFullUserName;

    public UserEntity(String userName, String password, String correctFullUserName) {
        this.userName = userName;
        this.password = password;
        this.correctFullUserName = correctFullUserName;
    }

    /*public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCorrectFullUserName() {
        return correctFullUserName;
    }*/

}
