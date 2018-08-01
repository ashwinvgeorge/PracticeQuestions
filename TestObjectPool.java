package com.avgeorge.test;

import com.avgeorge.pool.ObjectPool;
import com.avgeorge.pool.Objects;

import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestObjectPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for(int i=0; i<1000 ; i++) {
            executorService.submit(() -> {
               Objects obj = ObjectPool.getObject();
               try {
                   Thread.sleep(300);
               } catch (InterruptedException ex) {
                   ex.printStackTrace();
               } finally {
                   ObjectPool.returnObject(obj);
               }
                System.out.println(MessageFormat.format("Thread {0} execution complete, " +
                        "Active ObjectPool contains {1} objects, Number of objects created : {2}", Thread.currentThread().getId(),
                        ObjectPool.getObjectPoolSize(), ObjectPool.getNumberOfObjectsCreated()));
            });
        }

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(2, TimeUnit.MINUTES)) {
                System.out.println("All tasks completed");
            }
        }catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
