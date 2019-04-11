package bytedance.linkedlist;

import common.ListNode;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name bytedance.linkedlist
 * @date 2019/4/10 21:00
 * @description God Bless, No Bug!
 *
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class _01MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy,p = l1,q=l2;
        while (p!=null && q!=null){
            if (p.val<=q.val){
                pre.next = p;
                pre = pre.next;
                p = p.next;
            }else {
                pre.next = q;
                pre = pre.next;
                q = q.next;
            }
        }
        pre.next = p!=null?p:q;
        return dummy.next;
    }
}
