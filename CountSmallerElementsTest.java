package com.avgeorge.questions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountSmallerElementsTest {

    private CountSmallerElements countSmallerElements;
    private int[] inputArray;
    private int number;
    private int expectedCount;

    public CountSmallerElementsTest(int[] inputArray, int number, int expectedCount) {
        this.inputArray = inputArray;
        this.number = number;
        this.expectedCount = expectedCount;
    }

    @Before
    public void setUp() throws Exception {
        countSmallerElements = new CountSmallerElements();
    }

    @Parameterized.Parameters
    public static Collection paramSet() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,2,3,4,5,6}, 3, 3},
                {new int[]{1,3,4,5,7,8}, 7, 5},
                {new int[]{1,4,7,8,9,10}, 15, 6}
        });
    }



    @Test
    public void numOfSmallerElements() {
        assertThat(countSmallerElements.numOfSmallerElements(inputArray, number), is(expectedCount));
    }
}