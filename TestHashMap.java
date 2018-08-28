package com.avgeorge.collections;

import com.avgeorge.collections.hashmap.MyHashMap;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        testMyHashMap();
    }

    @SuppressWarnings("unchecked")
    private static void testMyHashMap() {
        MyHashMap map = new MyHashMap(4);
        map.put("Ashwin", 31);
        map.put("Nayana", 29);
        map.put("Asha", 36);
        map.put("Reju", 37);
        map.put("Neiv", 3);
        map.put("Anita", 61);
        map.put("Vinoo", 63);
        map.put("Jeanie", 6);

        map.display();

        System.out.println("\n");
        map.remove("Ashwin");
        System.out.println("\n");

        map.display();

        System.out.println("\n");

        System.out.println("Asha's value in map : " + map.get("Asha"));

        System.out.println("Ashwin's value in map : " + map.get("Ashwin"));
    }
}
