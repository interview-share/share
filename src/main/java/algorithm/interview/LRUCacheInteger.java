package algorithm.interview;

import java.util.HashMap;

/**
 * @author LRInteger
 * @date 2019/4/5 13:58
 * project_name LeetCode
 * package_name algorithm.interview
 * description:
 * God Bless, No Bug!
 */
public class LRUCacheInteger {


    private final int MAX_CACHE_SIZE;
    private Entry first;
    private Entry last;

    private HashMap<Integer,Entry> hashMap;

    public LRUCacheInteger(int capacity) {
        MAX_CACHE_SIZE = capacity;
        hashMap = new HashMap<>();
    }

    public Integer get(Integer key) {

        Entry entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        moveToFirst(entry);
        return entry.value;

    }

    public void put(Integer key, Integer value) {

       Entry entry = getEntry(key);
        if (entry == null) {
            if (hashMap.size() >= MAX_CACHE_SIZE) {
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key, entry);
    }

    private void moveToFirst(Entry entry) {
        // 如果当前元素已经是第一个
        if (first == entry) {
            return;
        }
        // 如果当前元素不是第一个,前后断链
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        // 如果当前元素是最后一个
        if (entry == last) {
            last = last.pre;
        }
        // 当前仅有一个元素
        if (first == null || last == null) {
            first = last = entry;
            return;
        }
        // 将元素插入到链表头
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {

        if (last != null) {
            last = last.pre;
            // 如果只有一个元素
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }

    private Entry getEntry(Integer key) {

        return hashMap.get(key);
    }


    class Entry {
        public Integer key;
        public Integer value;
        public Entry pre;
        public Entry next;
    }
}

