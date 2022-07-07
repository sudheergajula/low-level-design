package com.sud.lld.cache.eviction;

public class FIFOCacheHolder<T> implements CacheHolder<T> {

    private Node<T> head;
    private Node tail;

    @Override
    public void add(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        if (head.next == null) {
            head.next = node;
            node.prev = head;
            tail = node;
            return;
        }
        head.prev = node;
        node.next = head;
        head = node;
    }

    @Override
    public T delete() {
        if (tail == null) {
            throw new RuntimeException("Empty list, cannot delete");
        }
        Node<T> toDelete = head;
        head = head.next;
        head.prev = null;
        return toDelete.data;
    }

    @Override
    public void update(T key) {
        //no-op
    }

    @Override
    public void print() {
        Node _temp = head;
        StringBuilder builder = new StringBuilder();
        while (_temp != null) {
            builder.append(_temp.data).append("=>");
            _temp = _temp.next;
        }
        System.out.println(builder);
    }


}
