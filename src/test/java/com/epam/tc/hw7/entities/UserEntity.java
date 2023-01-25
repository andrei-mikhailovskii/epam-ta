package com.epam.tc.hw7.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {

    private final String userName;
    private final String password;
    private final String correctFullUserName;

    public UserEntity(String userName, String password, String correctFullUserName) {
        this.userName = userName;
        this.password = password;
        this.correctFullUserName = correctFullUserName;
    }

}
