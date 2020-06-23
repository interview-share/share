package offer.sword2offer.chapter5;

import common.ListNode;

import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/9 0:20
 * @description God Bless, No Bug!
 *
 * 两个链表的第一个公共结点
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 样例
 *
 * 给出两个链表如下所示：
 * A：        a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * 输出第一个公共节点c1
 * 解法
 * 先遍历两链表，求出两链表的长度，再求长度差 |n1 - n2|。
 *
 * 较长的链表先走 |n1 - n2| 步，之后两链表再同时走，首次相遇时的节点即为两链表的第一个公共节点。
 *
 */
public class Sub52_TheFirstSameNodeInList {
    public static void main(String[] args) {
        ListNode node1,node2,node3,node4,node5,node6,node7;
        node1 = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(3);
        node4 = new ListNode(4);
        node5 = new ListNode(5);
        node6 = new ListNode(6);
        node7 = new ListNode(7);

        node1.next=node2;
        node2.next=node3;
        node3.next=node6;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        Sub52_TheFirstSameNodeInList test = new Sub52_TheFirstSameNodeInList();
        System.out.println(test.FindFirstCommonNode2(node1, node4));

    }

    /**
     * 先统计两个链表长度差d,长链表先走d步,两链表第一个相同节点即为所求
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null) {
            return null;
        }
        int count1 = 0,count2=0;
        ListNode node1=pHead1,node2=pHead2;
        while (node1!=null){
            ++count1;
            node1 = node1.next;
        }
        while (node2!=null){
            ++count2;
            node2 = node2.next;
        }
        int dis =0;
        if (count1>count2){
            dis = count1-count2;
            return getFirstSameNode(pHead1,pHead2,dis);
        }else {
            dis = count2-count1;
            return getFirstSameNode(pHead2,pHead1,dis);
        }
    }

    private ListNode getFirstSameNode(ListNode pHead1, ListNode pHead2, int dis) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (dis>0){
            node1 = node1.next;
        }
        while (node1!=node2 && node1!=null&&node2!=null){
            node1 = node1.next;
            node2 = node2.next;
        }
        return (node1 == null || node2 == null) ? null : node1;
    }

    /**
     * 利用栈存储两个链表,反向比较
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null) {
            return null;
        }

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode node = pHead1;
        while (node!=null){
            stack1.push(node);
            node = node.next;
        }
        node = pHead2;
        while (node!=null){
            stack2.push(node);
            node = node.next;
        }
        ListNode pop1 = stack1.pop();
        ListNode pop2 = stack2.pop();
        ListNode result = pop1==pop2?pop1:null;
        while (!stack1.empty() &&!stack2.empty()){
            pop1 = stack1.pop();
            pop2 = stack2.pop();
            if(pop1 == pop2) {
                result = pop1;
            }
            if( stack1.empty() ||stack2.empty()) {
                break;
            }
        }
        return result;
    }
}
