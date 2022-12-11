package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.within;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class SumTest extends AbstractCalculatorTest {

    @Test(groups = {"groupSum"}, dataProviderClass = DataProviderTest.class, dataProvider = "sum")
    public void sumTest(double a, double b, double result) {

        double act = calculator.sum(a, b);

        assertThat(act).as("Sum is incorrect").isCloseTo(result, within(0.0001));
    }

}
