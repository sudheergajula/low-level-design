package com.sud.lld.cache.eviction;

public class LRUCacheHolder<T> implements CacheHolder<T> {

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
        Node<T> toDelete = tail;
        tail = tail.prev;
        tail.next = null;
        return toDelete.data;
    }

    @Override
    public void update(T key) {
        Node _temp = head;
        if (key == _temp.data) return;
        while (_temp.data != key && _temp.next != null) {
            _temp = _temp.next;
        }
        if (_temp.next == null) {
            _temp.prev.next = null;
            tail = _temp.prev;
        } else {
            _temp.prev.next = _temp.next;
            _temp.next.prev = _temp.prev;
        }

        head.prev = _temp;
        _temp.next = head;
        _temp.prev = null;
        head = _temp;
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
