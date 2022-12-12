package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.within;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class SubTest extends AbstractCalculatorTest {

    @Test(groups = {"groupSub"}, dataProviderClass = DataProviderTest.class, dataProvider = "sub")
    public void subTest(double a, double b, double result) {

        double act = calculator.sub(a, b);

        assertThat(act).as("Subtraction is incorrect").isCloseTo(result, within(0.0001));
    }

}
