package com.epam.tc.hw5.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.epam.tc.hw5.cucumber.steps"},
        publish = true
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
