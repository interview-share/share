package algorithm.interview;

import java.util.HashMap;
/**
 * @author LRK
 * @date 2019/4/5 13:34
 * project_name LeetCode
 * package_name algorithm.interview
 * description:
 * God Bless, No Bug!
 */
public class LRUCache<K,V> {

    private final int MAX_CACHE_SIZE;
    /**
     *  维护带头尾节点的链表
     */
    private Entry first;
    private Entry last;

    private HashMap<K,Entry<K,V>> hashMap;

    public LRUCache(int capacity) {
        MAX_CACHE_SIZE = capacity;
        hashMap = new HashMap<>();
    }

    public V get(K key) {

        Entry<K, V> entry = getEntry(key);
        if (entry == null){
            return null;
        }
        moveToFirst(entry);
        return entry.value;

    }

    /**
     * 如果key存在,直接修改value并移动到头部
     * 如果key不存在,判断链表是否已满:
     *      如果链表已满,移除最后一个;
     *      如果链表未满,创建新节点插入头部
     * @param key
     * @param value
     */
    public void put(K key, V value) {

        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            if (hashMap.size()>=MAX_CACHE_SIZE) {
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry<>();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key,entry);
    }

    /**
     * 将当前节点移动到头部
     * @param entry
     */
    private void moveToFirst(Entry<K, V> entry) {
        // 如果当前元素已经是第一个
        if (entry == first){
            return;
        }
        // 如果当前元素不是第一个,前后断链
        if (entry.pre!=null){
            entry.pre.next = entry.next;
        }
        if(entry.next!=null){
            entry.next.pre = entry.pre;
        }
        // 如果当前元素是最后一个
        if (entry == last){
            last = last.pre;
        }
        // 当前仅有一个元素
        if (first==null || last==null){
            first = last = entry;
            return;
        }
        // 将元素插入到链表头
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    /**
     * 移除最后一个元素
     */
    private void removeLast(){

        if (last!=null){
            last = last.pre;
            // 如果只有一个元素
            if (last == null){
                first=null;
            }else {
                last.next=null;
            }
        }
    }

    private Entry<K,V> getEntry(K key){

        return hashMap.get(key);
    }


    class Entry<K,V>{
        public K key;
        public V value;
        public Entry pre;
        public Entry next;
    }
}
