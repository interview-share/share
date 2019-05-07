package bytedance.other;

import java.util.*;

/**
 * @author LRK
 * @date 2019/4/11 19:28
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 *  全 O(1) 的数据结构
 * 实现一个数据结构支持以下操作：
 *
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 */
public class AllOne {
    Map<String,Node> valMap;
    Node oneNode;
    Node head;
    Node tail;
    public AllOne() {
        valMap = new HashMap<>();
        oneNode = new Node(1);
        head = oneNode;
        tail = oneNode;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!valMap.containsKey(key)) {
            valMap.put(key, oneNode);
            oneNode.keySet.add(key);
        } else {
            Node older = valMap.get(key);
            int val = older.val;
            val += 1;
            Node pre = older.pre;
            if (pre == null) {
                head = new Node(val);
                head.next = older;
                head.keySet.add(key);
                older.pre = head;
                valMap.put(key, head);
            } else {
                if (pre.val == val) {
                    pre.keySet.add(key);
                    valMap.put(key, pre);
                } else if (pre.val > val) {
                    Node newNode = new Node(val);
                    insertNode(pre, newNode, older);
                    newNode.keySet.add(key);
                    valMap.put(key, newNode);
                }
            }
            older.keySet.remove(key);
            if (older.keySet.isEmpty() && older.val != 1) {
                deleteNode(older);
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data
     * structure.
     */
    public void dec(String key) {
        if (!valMap.containsKey(key)) {
            return;
        }
        Node oldNode = valMap.get(key);
        if (oldNode.val == 1) {
            oldNode.keySet.remove(key);
            valMap.remove(key);
            return;
        }
        int val = oldNode.val;
        val -= 1;
        if (oldNode.next.val == val) {
            oldNode.next.keySet.add(key);
            valMap.put(key, oldNode.next);
        } else if (oldNode.next.val < val) {
            Node newNode = new Node(val);
            newNode.keySet.add(key);
            insertNode(oldNode, newNode, oldNode.next);
            valMap.put(key, newNode);
        }
        oldNode.keySet.remove(key);
        if (oldNode.keySet.isEmpty()) {
            deleteNode(oldNode);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        System.out.println(head.keySet);
        for (String key : head.keySet) {
            return key;
        }
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        Node node = tail;
        if (tail.keySet.isEmpty()) {
            node = tail.pre;
        }
        if (node != null) {
            for (String key : node.keySet) {
                return key;
            }
        }
        return "";
    }

    void deleteNode(Node node) {
        if (node.val == 1) {
            return;
        }
        if (node == head) {
            head = node.next;
            node.next = null;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    void insertNode(Node pre, Node node, Node next) {
        pre.next = node;
        node.pre = pre;
        next.pre = node;
        node.next = next;
    }

    class Node {
        final int val;
        final Set<String> keySet = new HashSet<>();
        Node next;
        Node pre;

        public Node(int val) {
            this.val = val;
        }

    }
}