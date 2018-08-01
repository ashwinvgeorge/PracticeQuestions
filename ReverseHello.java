package com.avgeorge.questions;

import java.util.concurrent.atomic.AtomicInteger;

public class ReverseHello {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

}
class MyRunnable implements Runnable {
    static int count;

    MyRunnable() {
        count++;
    }
    @Override
    public void run() {
        while (count < 50) {
            Thread newThread = new Thread(new MyRunnable());
            newThread.start();
            try {
                newThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello from thread " + Thread.currentThread().getId());
        }
    }
}