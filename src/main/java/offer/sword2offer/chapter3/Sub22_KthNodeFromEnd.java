package offer.sword2offer.chapter3;

import common.ListNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/2 21:42
 * @description God Bless, No Bug!
 *
 *  求链表中倒数第 k 个节点
 *      双指针,先走 k 步
 */
public class Sub22_KthNodeFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = FindKthToTail(head,3);
    }

    public static ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || k<=0){
            return null;
        }
        ListNode preNode=head,nextNode = head;
        for (int i = 0; i < k-1; i++) {
            if (preNode.next!=null){
                preNode = preNode.next;
            }
            else {
                return null;
            }
        }
        while (preNode.next!=null){
            preNode = preNode.next;
            nextNode = nextNode.next;
        }
        return nextNode;
    }

}
