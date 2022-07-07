# Cache

## Cache should support eviction based on policy
* LRU - Evict least recently used element
* MRU - Evict most  recently used element
* FIFO - Evict element that was recently added
* LIFO - Evict element that is oldest.

### Define storage class supporting following operations
* put
* get
* containsKey
* remove
```
public interface Cache<Key, Value>{
    void put(Key key, Value value);
    
    Value get(Key key);
    
    boolean containsKey(Key key);
}
```

```
public class CacheImpl<Key, Value> implements Cache<Key, Value> {
    
    public CacheImpl(CacheEvictionPolicy policy, int size){
        this.size = size;
        this.cacheHolder = getCacheHolder(policy); 
    }
    
    void put(Key key, Value value);
    
    Value get(Key key);
    
    boolean containsKey(Key key);
}
```

### MRU Cache eviction

- Once element has been accessed update it to head of DLL
- Delete from head of the DLL

### LRU Cache eviction

- Once element has been accessed update it to head of DLL
- Delete from tail of the DLL

### FIFO and LIFO Cache eviction

- Do not update the list, just appened elments to list.
- Delete from head/tail based on policy of the DLL