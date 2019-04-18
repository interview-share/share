package offer.sword2offer.chapter2;

import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/30 18:16
 * @description God Bless, No Bug!
 *
 * 逆序输出带头结点的链表
 */
public class Sub06_PrintListInReversedOrder {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node.next = node2;
        node2.next =node3;
        node3.next = node4;

//        test(node);
        test2(node);
    }

    /**
     * 利用递归实现逆序输出带头结点的单向链表
     * 不推荐,容易栈溢出
     * @param node
     */
    private static void test2(ListNode node) {
        if (node!=null ){
            if (node.next!=null){
                test2(node.next);
            }
            System.out.println(node.value);
        }
    }

    /**
     * 利用栈逆序输出带头结点的单向链表,
     * @param node
     */
    private static void test(ListNode node) {
        if (node ==null){
            return;
        }
        Stack<ListNode> stack = new Stack<>();
//        Queue<Integer> queue = new LinkedList<>();
        while (node!=null){
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().value);
        }
    }
}

class ListNode{
    int value;
    ListNode next=null;
    ListNode(int value){
        this.value = value;
    }
}
