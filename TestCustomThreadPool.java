package com.avgeorge.threadPool;

public class TestCustomThreadPool {
    public static void main(String[] args) {
        CustomThreadPool pool = new CustomThreadPool(4, 20);
        for(int i=0; i<30; i++) {
            pool.enqueue(new MyRunnable(i));
        }
        pool.startWorkers();

    }

    private static class MyRunnable implements Runnable {
        private int taskNumber;
        public MyRunnable(int i) {
            taskNumber = i;
        }

        @Override
        public void run() {
            System.out.println("Executing task " + taskNumber);
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Completed task " + taskNumber);
            }
        }
    }
}
