package algorithm.linkedlist;

import common.ListNode;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name linkedlist
 * @date 2019/3/12 23:34
 * @description God Bless, No Bug!
 *
 * 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class _06IsPalindrome {

    ListNode tmp;

    /**
     * 利用递归比较首尾,成员变量tmp从头结点开始
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        tmp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head==null) return true;
        boolean flag = check(head.next)&&(tmp.val==head.val);
        tmp = tmp.next;
        return flag;
    }
    /**
     * 找到中点,将后半段链表反转,之后比较两链表即可
     */
    public boolean isPalindrome2(ListNode head) {

        ListNode slow=head,fast=head;
        while (fast!=null &&fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = reverseList(slow);
        ListNode pre = head;
        while (pre!=null && tail!=null){
            if (pre.val!=tail.val){
                return false;
            }
            pre = pre.next;
            tail = tail.next;
        }
        return true;
    }
    private ListNode reverseList(ListNode head) {

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
