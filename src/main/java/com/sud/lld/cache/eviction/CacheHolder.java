package com.sud.lld.cache.eviction;

public interface CacheHolder<T> {
    void add(T item);

    T delete();

    void update(T item);

    void print();

}
