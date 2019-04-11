package bytedance.linkedlist;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LRK
 * @date 2019/4/11 18:10
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 *  示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class _05MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> min = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for (ListNode list : lists) {
            ListNode tmp = list;
            if (tmp!=null){
                min.offer(tmp);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre=dummy,tmp;
        while (min.size()>0){
            tmp = min.poll();
            pre.next = tmp;
            pre = tmp;
            if (tmp.next!=null){
                min.offer(tmp.next);
            }
        }
        return dummy.next;
    }
}
