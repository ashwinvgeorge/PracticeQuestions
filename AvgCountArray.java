package com.avgeorge.questions;

public class AvgCountArray {

    public int[] calcAvgCountPerIndex(int[] inputArray, int number) {
        int[] avgCountsPerIndex = new int[inputArray.length];
        for (int i=0; i<inputArray.length; i++) {
            int avg = (inputArray[i] + number)/2;
            int count = 0;

            for(int check : inputArray) {
                if (check == avg)
                    count++;
            }
            avgCountsPerIndex[i] = count;
        }
        return avgCountsPerIndex;
    }
}
