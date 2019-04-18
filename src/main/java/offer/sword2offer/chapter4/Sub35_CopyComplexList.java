package offer.sword2offer.chapter4;

import offer.common.RandomListNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/5 16:18
 * @description God Bless, No Bug!
 */
public class Sub35_CopyComplexList {

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        RandomListNode four = new RandomListNode(4);
        RandomListNode five = new RandomListNode(5);
        head.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        head.random=three;
        head.random = three;
        two.random = four;
        three.random = five;
        RandomListNode clone = Clone(head);
        System.out.println(clone);

    }

    public static RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) return null;
        // 1 复制每个节点,连接到对应源节点的后面
        RandomListNode copy = pHead;
        while (copy!=null){
            RandomListNode temp = new RandomListNode(copy.label);
            temp.next = copy.next;
            copy.next = temp;
            copy = temp.next;
        }
        // 2 复制随机连接
        copy = pHead;
        while (copy!=null){
            RandomListNode next = copy.next;
            if (copy.random!=null){

                next.random = copy.random.next;
            }
            copy = next.next;
        }
        // 3 拆开链表
        /*RandomListNode newHead = pHead.next;
        RandomListNode pre=pHead,next = newHead;
        while (pre!=null){
            if(next.next!=null){
                pre.next = next.next;
                next.next = next.next.next;
            }else{
                pre.next = null;
            }
            pre = pre.next;
            next = next.next;
        }*/
        copy = pHead;
        RandomListNode cloneHead = pHead.next;
        while (copy.next != null) {
            RandomListNode clone = copy.next;
            copy.next = clone.next;
            copy = clone;
        }
        return cloneHead;
    }
}
