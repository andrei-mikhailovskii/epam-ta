package com.epam.tc.hw6;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@UtilityClass
public class DriverFabric {

    public WebDriver getWebdriver(final boolean isLocal, final String hubAddress, @NonNull final String browserName)
            throws MalformedURLException {

        if(isLocal) {
            return WebDriverManager.getInstance(browserName).create();
        } else {
            Capabilities capabilities = null;
            if (browserName.toUpperCase(Locale.ROOT).equals("CHROME")) {
                capabilities = new ChromeOptions();
            } else if (browserName.toUpperCase(Locale.ROOT).equals("FIREFOX")) {
                capabilities = new FirefoxOptions();
            } else {

            }
            return new RemoteWebDriver(new URL(hubAddress), capabilities);
        }


    }

}
