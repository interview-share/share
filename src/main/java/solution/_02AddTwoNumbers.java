package solution;

import common.ListNode;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name solution
 * @date 2019/3/4 20:57
 * @description God Bless, No Bug!
 */
public class _02AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1,p2 = l2;
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while(p1!=null && p2!=null){

            int x = p1==null?0:p1.val;
            int y = p2==null?0:p2.val;
            int sum = x+y;
            int carry = (sum)/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
        }

        return head.next;
    }
}
