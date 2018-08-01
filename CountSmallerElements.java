package com.avgeorge.questions;

public class CountSmallerElements {

    public int numOfSmallerElements(int[] sortedArray, int number) {
        int lastIndexOfNumber = -1;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] > number) {
                lastIndexOfNumber = i;
                break;
            }
        }

        /*if(lastIndexOfNumber != -1) {
            return lastIndexOfNumber;
        } else {
            return sortedArray.length;
        }*/
        return (lastIndexOfNumber != -1)? lastIndexOfNumber : sortedArray.length;
    }
}
