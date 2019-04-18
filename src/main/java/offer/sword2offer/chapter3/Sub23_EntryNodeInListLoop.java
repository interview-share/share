package offer.sword2offer.chapter3;

import common.ListNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/2 22:08
 * @description God Bless, No Bug!
 *
 *  找出链表中环的入口
 */
public class Sub23_EntryNodeInListLoop {

    public static void main(String[] args) {

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        // 1 判断是否有环
        ListNode preNode = pHead, nextNode = pHead;
       /* while (preNode!=nextNode){
            if (preNode == null){
                return null;
            }
            nextNode = nextNode.next;
            preNode = preNode.next;
            if (preNode.next!=null){
                preNode = preNode.next;
            }else {
                return null;
            }
        }*/
        boolean flag = false;
        while (preNode != null && preNode.next != null) {
            nextNode = nextNode.next;
            preNode = preNode.next.next;
            if (preNode == nextNode) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return null;
        }
        int numberLoop = 1;
        // 2 找出环的长度len
        while (preNode.next != nextNode) {
            ++numberLoop;
            preNode = preNode.next;
        }
        preNode = pHead;
        nextNode = pHead;
        for (int i = 0; i < numberLoop; i++) {
            preNode = preNode.next;
        }
        while (preNode != nextNode) {
            preNode = preNode.next;
            nextNode = nextNode.next;
        }
        // 3 找出倒数第len个节点即为环的入口
        return nextNode;
    }
}
