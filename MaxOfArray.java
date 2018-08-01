package com.avgeorge.questions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxOfArray {

    public static void main(String[] args) {
        int[] array = {1,47,89,87,74,72,86,98,25,26,12,95,65,64,69,71,73,42,45,48,41,52};
        AtomicInteger max = new AtomicInteger(0);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        class MyRunnable implements Runnable {

            private int number;

            MyRunnable(int number) {
                this.number = number;
            }

            @Override
            public void run() {
                if (number > max.get()) {
                    max.set(number);
                }
            }
        }

        for (int i=0; i<array.length; i++) {
            executorService.submit(new MyRunnable(array[i]));
        }

        executorService.shutdown();

        try {
            if(executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                System.out.println("Completed and the Max value is " + max);
            }
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }


    }
}
