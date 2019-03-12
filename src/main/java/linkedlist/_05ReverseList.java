package linkedlist;

import common.ListNode;
import common.SortUtil;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name linkedlist
 * @date 2019/3/12 23:01
 * @description God Bless, No Bug!
 *
 * 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class _05ReverseList {

    public static void main(String[] args) {
        ListNode head = SortUtil.getLinkedList(1, 2, 3, 4, 5);
        ListNode result = new _05ReverseList().reverseList(head);
        System.out.println(result);
    }

    /**
     * 1 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next==null) return head;

        ListNode next = head.next;
        ListNode node = reverseList(head.next);
        next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 2 迭代
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next==null) return head;
        ListNode p = head,q=head.next;
        p.next = null;
        while (q!=null){
            ListNode tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        return p;
    }
}
