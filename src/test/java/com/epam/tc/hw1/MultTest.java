package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.within;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class MultTest extends AbstractCalculatorTest {

    @Test(groups = {"groupMult"}, dataProviderClass = DataProviderTest.class, dataProvider = "mult")
        public void multTest(double a, double b, double result) {

        double act = calculator.mult(a, b);

        assertThat(act).as("Multiplication is incorrect").isCloseTo(result, within(0.0001));
    }

}
