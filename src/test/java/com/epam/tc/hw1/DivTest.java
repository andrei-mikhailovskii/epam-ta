package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.within;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class DivTest extends AbstractCalculatorTest {

    @Test(groups = {"groupDiv"}, dataProviderClass = DataProviderTest.class, dataProvider = "div")
    public void divTest(double a, double b, double result) {

        double act = calculator.div(a, b);

        assertThat(result).as("Division is incorrect").isEqualTo(result, within(0.0001));
    }

    @Test(groups = {"groupDiv"},
            dataProviderClass = DataProviderTest.class, dataProvider = "divByZero",
            expectedExceptions = ArithmeticException.class)
    public void exceptionDivTest(double a, double b) {

        double act = calculator.div(a, b);

    }

}
