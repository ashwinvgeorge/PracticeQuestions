package com.avgeorge.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private WorkerThread[] workerThreads;
    private BlockingQueue<Runnable> taskQueue;

    public CustomThreadPool(int nThreads, int nTasks) {
        workerThreads = new WorkerThread[nThreads];
        taskQueue = new LinkedBlockingQueue<>(nTasks);
    }

    public void startWorkers() {
        for(int i=0; i<workerThreads.length; i++) {
            workerThreads[i] = new WorkerThread();
            workerThreads[i].start();
        }
    }

    public void enqueue(Runnable r) {
        taskQueue.offer(r);
    }

    class WorkerThread extends Thread{
        @Override
        public void run() {
            Runnable r;
            while(!taskQueue.isEmpty()) {
                try {
                    r = taskQueue.take();
                    r.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

