package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    private static Object NumberFormatException;

    @DataProvider(name = "sum")
    public static Object[][] sumCorrectData() {
        return new Object[][] {
                {1.0, 0.0, 1.0},
                {-1.0, 0.0, -1.0},
                {0.0, 0.0, 0.0},
                {0.00001, 0.0, 0.00001},
                {-1.0, -1.0, -2.0},
                {1.0, -1.0, 0.0},
                {1.0, -1.001, -0.001},
                {Double.MAX_VALUE, -1.0, (Double.MAX_VALUE - 1.0)},
                {Double.MIN_VALUE, 0.1, (Double.MIN_VALUE + 0.1)},
                {-0.0, 0.0, 0.0}
        };
    }

    @DataProvider(name = "sub")
    public static Object[][] subCorrectData() {
        return new Object[][] {
                {1.0, 0.0, 1.0},
                {0.0, 0.0, 0.0},
                {0.00001, 0.0, 0.00001},
                {-1.0, -1.0, 0.0},
                {1.0, 0.1, 0.9}
        };
    }

    @DataProvider(name = "mult")
    public static Object [][] multCorrectData() {
        return new Object[][] {
                {1.0, 1.0, 1.0},
                {1.0, 0.0, 0.0},
                {-1.0, 0.0, 0.0},
                {-10.0, -10.0, 100.0},
                {0.1, 9, 0.9},
                {-1000.0, 0.1, -100.0}
        };
    }

    @DataProvider(name = "div")
    public static Object [][] divCorrectData() {
        return new Object[][] {
                {-9223372036854775808.0, 1L, -9223372036854775808.0},
                {9223372036854775807.0, -1, -9223372036854775807.0},
                {0.0, 1.0, 0.0},
                {-10.0, 10.0, -1.0},
                {-0.9, -0.25, 3.6}
        };
    }

    @DataProvider(name = "divByZero")
    public static Object[][] divByZero() {
        return new Object[][] {
                {1.0, 0.0}
        };
    }

    @DataProvider(name = "cos")
    public static Object[][] cosCorrectData() {
        return  new Object[][] {
                {0.0, Math.cos(0.0)},
                {1.0, Math.cos(1.0)},
                {-1.0, Math.cos(-1.0)}
        };
    }

}
