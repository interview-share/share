package linkedlist;

import common.ListNode;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name linkedlist
 * @date 2019/3/12 22:46
 * @description God Bless, No Bug!
 *
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class _04GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA==null || headB==null) return null;
        // 先统计每条链表长度并比较末尾节点是否相同(即是否相交)
        int lenA=0,lenB=0;
        ListNode p=headA,q=headB,tailA=null,tailB=null;

        while (p!=null){
            ++lenA;
            if (p.next==null){
                tailA = p;
                break;
            }
            p = p.next;
        }
        while (q!=null){
            ++lenB;
            if (q.next==null){
                tailB = q;
                break;
            }
            q = q.next;
        }
        if (tailA!=tailB) return null;

        // 算出长度差k,长链表先走k步,之后两链表同时后移,第一个相同的节点即为相交起点
        int k = Math.abs(lenA-lenB);
        p = headA;
        q = headB;
        if (lenA>lenB){
            for (int i = 0; i < k; i++) {
                p = p.next;
            }
        }else {
            for (int i = 0; i < k; i++) {
                q = q.next;
            }
        }

        while (p!=q){
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
