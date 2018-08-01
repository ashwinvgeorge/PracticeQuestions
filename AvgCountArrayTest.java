package com.avgeorge.test;

import com.avgeorge.questions.AvgCountArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AvgCountArrayTest {

    private AvgCountArray avgCountArray;
    private int[] inputArray;
    private int number;
    private int[] expectedArray;

    public AvgCountArrayTest(int[] inputArray, int number, int[] expectedArray) {
        this.inputArray = inputArray;
        this.number = number;
        this.expectedArray = expectedArray;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
                {new int[]{2,4,8,6,2}, 2, new int[]{2,0,0,1,2}},
                {new int[]{9,5,2,4,0,3}, 3, new int[]{0,1,1,1,0,1}}
        });
    }

    @Before
    public void setUp() throws Exception {
        avgCountArray = new AvgCountArray();
    }

    @Test
    public void calcAvgCountPerIndex() {
        assertThat(avgCountArray.calcAvgCountPerIndex(inputArray, number), is(expectedArray));
    }
}