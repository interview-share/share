package common;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name common
 * @date 2019/3/9 19:06
 * @description God Bless, No Bug!
 */
public class SortUtil {

    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 传入数组获取单向链表
     * @param values
     * @return
     */
    public static ListNode getLinkedList(int...values){
        ListNode head = new ListNode(values[0]);
        ListNode p = head;
        for (int i = 1; i < values.length; i++) {

            ListNode node = new ListNode(values[i]);
            p.next = node;
            p = p.next;
        }
        return head;
    }
}
