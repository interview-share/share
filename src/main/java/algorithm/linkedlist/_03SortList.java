package algorithm.linkedlist;

import common.ListNode;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name bytedance.linkedlist
 * @date 2019/3/12 22:00
 * @description God Bless, No Bug!
 *
 * 排序链表
 * 在 O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class _03SortList {


    /**
     * 链表的归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head==null || head.next==null) {
            return head;
        }

        ListNode slow=head,fast=head,preEnd=head;
        while (fast!=null && fast.next!=null){
            preEnd = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preEnd.next = null;
        return merge(sortList(head),sortList(slow));
    }

    private ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (head1!=null && head2!=null){

            if (head1.val<head2.val){
                cur.next = head1;
                head1 = head1.next;
            }else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1!=null){
            cur.next = head1;
        }
        if (head2!=null){
            cur.next = head2;
        }
        return dummy.next;
    }
}
