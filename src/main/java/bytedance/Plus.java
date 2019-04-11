package bytedance;

import common.ListNode;

public class Plus {

    public static void main(String[] args) {

        ListNode a = new ListNode(5);
        a.next = new ListNode(8);
        ListNode b = new ListNode(9);
        b.next = new ListNode(4);
        ListNode node = new Plus().plusAB(a, b);

        while (node!=null){
            System.out.print(node.val);
            node = node.next;
        }
    }
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if (a == null && b == null){
            return null;
        }
        if (a==null){
            return b;
        }
        if (b==null){
            return a;
        }
        ListNode p = a;
        ListNode q = b;
        ListNode head = new ListNode((p.val+q.val)%10);
        ListNode cur = head;
        int high = (p.val+q.val)/10;
        p = p.next;
        q = q.next;
        while (p!=null && q!=null){
            int sum = p.val+q.val+high;
            high = sum/10;
            sum = sum%10;
            ListNode tmp = new ListNode(sum);
            cur.next = tmp;
            cur = tmp;
            p = p.next;
            q = q.next;
        }
        while (p!=null){
            ListNode tmp = new ListNode(p.val+high);
            high = 0;
            cur.next = tmp;
            cur = tmp;
            p = p.next;
        }
        while (q!=null){
            ListNode tmp = new ListNode(q.val+high);
            high = 0;
            cur.next = tmp;
            cur = tmp;
            q =q.next;
        }
        return head;
    }
}