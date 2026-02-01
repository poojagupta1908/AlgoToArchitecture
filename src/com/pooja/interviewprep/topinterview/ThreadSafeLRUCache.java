package com.pooja.interviewprep.topinterview;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

//Synchronized LinkedHashMap
//“Iteration still needs external synchronization.”
//synchronized (cache) {
//    for (Map.Entry<K,V> e : cache.entrySet()) {
//        System.out.println(e);
//    }
//}
/*✅ Pros
✔ Simple
✔ Correct LRU behavior
✔ Perfect for interviews
❌ Cons
❌ Coarse-grained locking
❌ Lower concurrency*/
public class ThreadSafeLRUCache<K, V> {

    private final int capacity;
    private final Map<K, V> cache;

    public ThreadSafeLRUCache(int capacity) {
        this.capacity = capacity;

        this.cache = Collections.synchronizedMap(
                new LinkedHashMap<K, V>(capacity, 0.75f, true) {
                    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                        return size() > ThreadSafeLRUCache.this.capacity;
                    }
                }
        );
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

}
/*
⭐⭐ Approach 2 (PRODUCTION-GRADE)
ConcurrentHashMap + Doubly Linked List
👉 Used in real cache libraries (Caffeine, Guava)
________________________________________
Core Idea
•	ConcurrentHashMap → fast key lookup
•	Doubly Linked List → LRU ordering
•	ReentrantLock → protects list operations
________________________________________
🔑 Key Code (Interview-Level)
class LRUCache<K, V> {

    private final int capacity;
    private final ConcurrentHashMap<K, Node<K, V>> map;
    private final ReentrantLock lock = new ReentrantLock();

    private Node<K, V> head, tail;

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>();
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;

        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        lock.lock();
        try {
            if (map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                Node<K, V> node = new Node<>();
                node.key = key;
                node.value = value;

                map.put(key, node);
                addToHead(node);

                if (map.size() > capacity) {
                    Node<K, V> lru = removeTail();
                    map.remove(lru.key);
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
*/