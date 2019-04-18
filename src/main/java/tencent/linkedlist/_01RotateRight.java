package tencent.linkedlist;

import common.ListNode;

/**
 * @author LRK
 * @date 2019/4/13 12:50
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 *   示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class _01RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;

        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        k = (k >= count) ? k % count : k;

        for (int i = 0; i < k; i++) {
            q = q.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = dummyHead.next;
        dummyHead.next = p.next;
        p.next = null;

        return dummyHead.next;
    }
}
