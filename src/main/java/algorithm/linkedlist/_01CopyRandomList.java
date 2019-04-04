package algorithm.linkedlist;


import common.Node;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name linkedlist
 * @date 2019/3/12 20:44
 * @description God Bless, No Bug!
 *
 * 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深拷贝。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 */
public class _01CopyRandomList {

    public static void main(String[] args) {

        Node node = new Node();
        node.val = 2;
        node.next = null;
        node.random = node;
        Node head = new Node(1,node,node);

        Node newHead = new _01CopyRandomList().copyRandomList(head);
        System.out.println(newHead);
    }
    public Node copyRandomList(Node head) {

        if (head==null) return null;
        Node newHead;
        Node p = head;
        while (p!=null){ // 在原链表上复制,复制节点插入原节点后面

            Node copy = new Node();
            copy.val = p.val;
            copy.next = p.next;
            p.next = copy;

            p = copy.next;
        }
        p = head;
        while (p!=null){
            if(p.random !=null)
                p.next.random = p.random.next;

            p = p.next.next;
        }

        newHead = head.next;
        p = head;

        while (p!=null){ // 新老链表断开
            Node next = p.next;
            if (next!=null){
                p.next = next.next;
            }
            p = next;
        }
        return newHead;

    }
}
