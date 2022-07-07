package com.sud.lld.cache;

import com.sud.lld.cache.eviction.CacheEvictionPolicy;

import java.util.Random;

public class CacheMain {

    public static void main(String[] args) throws InterruptedException {
        LRUCache<Integer, Integer> integerLRUCache = new LRUCache<>(20, CacheEvictionPolicy.MRU);
        Random keyRandom = new Random();
        Random valueRandom = new Random();
        int i = 1;
        while (i != 10) {
            integerLRUCache.put(i, i);
            i++;
        }
        integerLRUCache.get(6);
        integerLRUCache.get(9);
        integerLRUCache.get(4);
        integerLRUCache.get(7);
        i = 11;
        while (i != 25) {
            integerLRUCache.put(i, i);
            i++;
            Thread.sleep(2000);
        }
    }
}
