package offer.sword2offer.chapter3;

import common.ListNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/2 22:54
 * @description God Bless, No Bug!
 *
 * 反转链表
 * 题目描述
 *  输入一个链表，反转链表后，输出新链表的表头。
 *
 * 解法
 *  解法一
 *      利用头插法解决。
 *  解法二：
 *      递归
 */
public class Sub24_ReverseList {
    public static void main(String[] args) {

        ListNode head = reverseList(new ListNode(1));
    }
    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next==null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null; // next用来保存下一个节点,防止断链
        ListNode newHead = null;
        while (cur!=null){
            next = cur.next;
            if (next == null){
                newHead = cur;
            }
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return newHead;
    }

}
