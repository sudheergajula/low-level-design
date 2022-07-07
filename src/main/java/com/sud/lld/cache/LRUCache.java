package com.sud.lld.cache;

import cache.eviction.*;
import com.sud.lld.cache.eviction.*;
import com.tgt.dp.behavioural.cache.eviction.*;
import com.tgt.lld.cache.eviction.*;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<Key, Value> implements Cache<Key, Value> {

    private final CacheHolder<Key> doublyLinkedList;
    private final Map<Key, Value> keyValueMap;
    private static final int MAX_SIZE = 100;
    private final int size;

    public LRUCache(int size, CacheEvictionPolicy evictionPolicy) {
        this.doublyLinkedList = getEvictionPolicy(evictionPolicy);
        this.keyValueMap = new HashMap<Key, Value>();
        this.size = Math.min(size, MAX_SIZE);
    }

    private CacheHolder<Key> getEvictionPolicy(CacheEvictionPolicy evictionPolicy) {
        CacheHolder<Key> holder;
        switch (evictionPolicy) {
            case LRU:
                holder = new LRUCacheHolder<>();
                break;
            case MRU:
                holder = new MRUCacheHolder<>();
                break;
            case FIFO:
                holder = new FIFOCacheHolder<>();
                break;
            case LIFO:
                holder = new LIFOCacheHolder<>();
                break;
            default:
                holder = new LRUCacheHolder<>();
                break;
        }
        return holder;
    }

    @Override
    public void put(Key key, Value value) {
        if (isCacheFull()) {
            Key evictedKey = doublyLinkedList.delete();
            keyValueMap.remove(key);
            System.out.printf("Evicting key from cache %s", evictedKey);
            System.out.println();
        }
        doublyLinkedList.add(key);
        keyValueMap.put(key, value);
        doublyLinkedList.print();

    }

    @Override
    public Value get(Key key) {
        if (containsKey(key)) {
            doublyLinkedList.update(key);
            doublyLinkedList.print();
            return keyValueMap.get(key);
        }
        throw new RuntimeException(String.format("Key %s not found", key));
    }

    @Override
    public boolean isCacheFull() {
        return keyValueMap.size() >= size;
    }

    @Override
    public boolean containsKey(Key key) {
        return keyValueMap.containsKey(key);
    }
}
