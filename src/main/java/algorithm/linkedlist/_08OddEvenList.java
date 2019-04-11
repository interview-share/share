package algorithm.linkedlist;

import common.ListNode;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name bytedance.linkedlist
 * @date 2019/3/13 0:21
 * @description God Bless, No Bug!
 *
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class _08OddEvenList {

    /**
     * 依次将每个节点的next指向next.next,最后将偶数节点链接到奇数链后面
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {

        if (head==null || head.next==null) return head;
        ListNode oddTail = head;
        ListNode tail = null;
        ListNode evenHead = head.next;
        int cnt = 1;
        while (oddTail.next!=null){
            ListNode next = oddTail.next;

            if (next.next==null && (cnt&1)==1){
                tail = oddTail;
            }
            oddTail.next = next.next;
            cnt++;
            oddTail = next;
        }
        if (tail!=null){
            oddTail = tail;
        }
        oddTail.next=evenHead;
        return head;
    }

    public ListNode oddEvenList2(ListNode head){
        if(head == null){
            return null;
        }
        //odd用来串奇数索引链表，even用来串偶数索引链表
        //需要注意的是，因为最后是奇数的尾巴连偶数的头，所以需要保存一下偶数的头部位置
        ListNode odd = head, even = head.next;
        ListNode evenHead = even;
        //画图很容易理解下面循环的过程
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        //奇数链表的尾巴串上偶数链表的头
        odd.next = evenHead;
        return head;
    }
}
