package com.pooja.interviewprep.topinterview;

import java.util.HashMap;
import java.util.Map;

//HashMap → O(1) access to cache entries
//Doubly Linked List → maintain usage order
//Head = Most Recently Used (MRU)
//Tail = Least Recently Used (LRU)
//get() → move node to head
//put() → add to head, remove tail if capacity exceeded
//LRU = HashMap + Doubly Linked List


/*
🧠 The 4-Block Memory Template
Block 1: Node (always same)
Memorize once. This never changes.
class Node {
    int key, value;
    Node prev, next;
}
👉 If you forget this, LRU is impossible.
👉 If you remember this, you’re 40% done.
________________________________________
Block 2: Core variables (3 lines only)
Say this in your head:
capacity + map + head/tail
int capacity;
Map<Integer, Node> map;
Node head, tail;
Dummy head & tail = no null checks
(this is an interview gold point ✨)
________________________________________
Block 3: Only TWO list operations
You do not need to remember everything.
Only these two helpers:
Remove a node
remove(node):
    node.prev.next = node.next
    node.next.prev = node.prev
Add to head
addToHead(node):
    node.next = head.next
    node.prev = head
    head.next.prev = node
    head.next = node
📌 These 6 lines are the heart of LRU
Repeat them 2–3 times — they’ll stick.
________________________________________
Block 4: get() and put() logic (in words)
👉 Don’t memorize code — memorize behavior
get(key)
if not in map → return -1
remove node
add node to head
return value
put(key, value)
if key exists:
    update value
    move to head
else:
    if cache full:
        remove tail.prev (LRU)
    create new node
    add to head
    put in map
That’s it. No more.

“I’ll write the Node class first, then the two list operations, then get and put.”
LRU = HashMap + DLL
Head = MRU, Tail = LRU
get → move node to head
put → add to head
if full → remove tail.prev
2 helpers → remove(), addToHead()
 */
public class ManualLRUCache {

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public ManualLRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head & tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        // Move accessed node to head (MRU)
        remove(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            // Update value and move to head
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            if (map.size() == capacity) {
                // Remove LRU node
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            addToHead(newNode);
            map.put(key, newNode);
        }
    }

    // Remove node from doubly linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node right after head
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Doubly Linked List Node
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Demo
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1)); // 10

        cache.put(3, 30); // evicts key 2
        System.out.println(cache.get(2)); // -1
    }
}