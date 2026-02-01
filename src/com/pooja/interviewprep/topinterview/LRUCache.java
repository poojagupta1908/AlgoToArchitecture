package com.pooja.interviewprep.topinterview;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    // helper method only for demo
    public void printCache() {
        System.out.println(cache);
    }

    public static void main(String[] args) {

        LRUCache lru = new LRUCache(2);

        lru.put(1, 10);
        lru.printCache();   // {1=10}

        lru.put(2, 20);
        lru.printCache();   // {1=10, 2=20}

        System.out.println(lru.get(1)); // 10
        lru.printCache();   // {2=20, 1=10}

        lru.put(3, 30);     // evicts key 2
        lru.printCache();   // {1=10, 3=30}

        System.out.println(lru.get(2)); // -1 (not found)
    }

}
