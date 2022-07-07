package com.sud.lld.cache.eviction;

public class Node<T> {
    T data;
    Node next;
    Node prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}


