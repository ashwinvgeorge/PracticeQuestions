package com.avgeorge.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ObjectPool {
    private static AtomicLong id = new AtomicLong(1);
    private static List<Objects> objectPool = new ArrayList<>();

    public static Objects getObject() {
        if(objectPool.isEmpty()) {
            return new Objects(id.getAndIncrement(), "WHITE");
        } else {
            return objectPool.remove(objectPool.size()-1);
        }
    }

    public static void returnObject(Objects obj) {
        objectPool.add(obj);
    }

    public static int getObjectPoolSize() {
        return objectPool.size();
    }

    public static long getNumberOfObjectsCreated() {
        return id.get();
    }
}
