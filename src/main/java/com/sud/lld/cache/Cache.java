package com.sud.lld.cache;

public interface Cache<Key, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    boolean isCacheFull();

    boolean containsKey(Key key);
}
