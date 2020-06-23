package offer.sword2offer.chapter3;


import offer.common.ListNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/2 23:19
 * @description God Bless, No Bug!
 *
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Sub25_MergeSortedLists {

    /**
     * 递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeRecursion(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }else if (list2 ==null){
            return list1;
        }
        if (list1.value<list2.value){
            list1.next = mergeRecursion(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeRecursion(list1,list2.next);
            return list2;
        }
    }

    /**
     * 归并
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }else if (list2 ==null){
            return list1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = cur;
        ListNode p1=list1,p2=list2;
        while (p1!=null && p2!=null){
            if (p1.value <p2.value){
                ListNode temp = p1.next;
                cur.next = p1;
                p1.next = null; // 断链
                p1 = temp;
            }else {
                ListNode temp = p2.next;
                cur.next = p2;
                p2.next = null; // 断链
                p2 = temp;
            }
            cur = cur.next;
        }
        cur.next = p1==null?p2:p1;
        return dummy.next;
    }
}
