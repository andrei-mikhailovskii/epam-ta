package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class CosTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviderTest.class, dataProvider = "cos")
    public void cosTest(double a, double result) {

        double act = calculator.cos(a);

        assertThat(act).as("Cosine is wrong").isEqualTo(result);
    }

}
