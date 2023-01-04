package com.epam.tc.hw4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesExtractor {

    public static Properties getProperties() {

        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {

            Properties properties = new Properties();
            properties.load(input);
            return properties;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getUsername() {
        String userName = getProperties().getProperty("userName");
        return userName;
    }

    public static String getPassword() {
        String userPassword = getProperties().getProperty("password");
        return userPassword;
    }

    public static String getCorrectUsername() {
        String correctUsername = getProperties().getProperty("correctUsername");
        return correctUsername;
    }

}
