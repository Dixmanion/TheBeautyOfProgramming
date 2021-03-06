package nju.edu.cn.leetcode;

import java.util.Map;
import java.util.HashMap;
public class LRUCache {
    
    Map<Integer, Integer> entries;
    Node head = null;
    Node tail = null;
    int MAX_CAPACITY;
    int length = 0;
    
    public LRUCache(int capacity) {
        MAX_CAPACITY = capacity;
        entries = new HashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if (entries.containsKey(key)){
            return entries.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (!entries.containsKey(key)) {
            
            Node nodeToSet = new Node(key);
            insertNode(nodeToSet);
            entries.put(key, value);
            
            if (length >= MAX_CAPACITY) {
                int lastKey = tail.key;
                //System.out.println("lastkey " + lastKey);
                entries.remove(lastKey);
                System.out.println(entries);
                deleteNode();
            } else {
                length++;
            }
            
        } else {
            entries.put(key, value);
        }
    }
    
    //插入放在第一个
    private void insertNode(Node node) {
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }
    
    //删除最后一个
    private void deleteNode() {
        //链表node个数为0
        if (head == null || tail == null) return;
        //链表node个数为1
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        //链表node个数2个及以上
        Node beforeTail = head;
        while(beforeTail.next != tail) {
            beforeTail = beforeTail.next;
        }
        beforeTail.next = null;
        tail = beforeTail;
    }
    
    public class Node {
    int key;
    Node next;
    
    public Node(int key){
        this.key = key;
        next = null;
    }
}
    
    public static void main(String[] args) {
    	LRUCache lruCache = new LRUCache(2);
    	lruCache.set(2, 1);
    	lruCache.set(1, 1);
    	System.out.println(lruCache.get(2));
    	lruCache.set(4, 1);
    	System.out.println(lruCache.get(1));
    	System.out.println(lruCache.get(2));
	}
}

