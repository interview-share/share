package algorithm.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LRK
 * @date 2019/4/5 13:16
 * project_name LeetCode
 * package_name algorithm.interview
 * description:
 * God Bless, No Bug!
 */
public class _05LRUCache {

    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    LinkedHashMap<Integer, Integer> map;

    public _05LRUCache(int capacity) {

        MAX_CACHE_SIZE = capacity;
        int size = (int) Math.ceil(capacity / DEFAULT_LOAD_FACTOR) + 1;
        map = new LinkedHashMap<Integer, Integer>(size, DEFAULT_LOAD_FACTOR, true) {
            /**
             * 是否移除最久未使用的元素
             * @param eldest
             * @return
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > MAX_CACHE_SIZE;
            }
        };
    }

    public int get(int key) {

        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
