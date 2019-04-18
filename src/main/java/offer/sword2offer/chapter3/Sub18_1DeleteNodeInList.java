package offer.sword2offer.chapter3;


import offer.common.ListNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/1 23:43
 * @description God Bless, No Bug!
 *
 * 在O(1)时间内删除链表节点
 * 题目描述
 *  给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 时间内删除该节点。
 *
 * 解法
 *  判断要删除的节点是否是尾节点，若是，直接删除；若不是，把要删除节点的下一个节点赋给要删除的节点即可。
 *
 * 进行n次操作，平均时间复杂度为：( (n-1) * O(1) + O(n) ) / n = O(1)，所以符合题目上说的O(1)
 */
public class Sub18_1DeleteNodeInList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(5);
        deleteNode(head,node);
    }

    private static ListNode deleteNode(ListNode head, ListNode node) {
        if (head==null || node == null) {
            return head;
        }
        // 不是尾节点
        if (node.next!=null){
            // 赋值下一节点的值并删除下一节点
            node.value = node.next.value;
            node.next = node.next.next;
        }
        // 链表中只有一个节点
        else if (node == head){
            head = null;
        }else { // 删除尾节点
            /*ListNode dNode = head;
            while (dNode.next!=node){
                dNode=dNode.next;
            }
            dNode.next = null;*/

            node = null;
        }
        return head;
    }

}
