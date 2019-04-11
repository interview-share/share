package linkedlist;

import common.ListNode;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name linkedlist
 * @date 2019/4/10 21:12
 * @description God Bless, No Bug!
 *
 * 92. 反转链表 II
 *
 * 题目描述
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class _02ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        for (int i = 0; i < m - 1; ++i) pre = pre.next;
        ListNode cur = pre.next;
        for (int i = m; i < n; ++i) {
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = pre.next;
            pre.next = t;
        }
        return dummy.next;

    }
}
