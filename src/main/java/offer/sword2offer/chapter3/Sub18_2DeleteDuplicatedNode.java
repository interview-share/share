package offer.sword2offer.chapter3;

import offer.common.ListNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/2 0:20
 * @description God Bless, No Bug!
 *
 * 删除有序链表中重复的节点
 * 题目描述
 *  在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *  例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。
 */
public class Sub18_2DeleteDuplicatedNode {

    public static void main(String[] args) {

    }

    /**
     * 递归删除
     * @param head
     * @return
     */
    public static ListNode delete(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        if (head.value == head.next.value){

            if (head.next.next==null){
                return null;
            }
            if (head.value == head.next.next.value){
                return delete(head.next);
            }
            return delete(head.next.next);
        }
        head.next = delete(head.next);
        return head;
    }
    public static ListNode delete2(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        // 因为头结点也可能重复,所以pre不能初始化为头结点
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            if (cur.next!=null && cur.next.value == cur.value){
                int value = cur.value;
                while (cur.next!=null && cur.value==value){
                    cur=cur.next;
                }
                // 第一次
                if (pre == null){
                    // 头结点重复,找到第一个不重复节点作为新的头结点
                    head = cur.next;
                }else {
                    pre.next = cur.next;
                }
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
