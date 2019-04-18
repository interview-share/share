package offer.nowcoder.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LRK
 * @project_name Offer
 * @package_name nowcoder.bytedance
 * @date 2019/3/29 13:41
 * @description God Bless, No Bug!
 *
 * [编程题] 手串
 * 时间限制：1秒
 *
 * 空间限制：65536K
 *
 * 作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。
 * 为了使手串的色彩看起来不那么单调，金主要求，
 * 手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。
 * 手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。
 * 请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜色在任意连续m个串珠中出现了至少两次。
 *
 *
 * 输入描述:
 * 第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50)
 * 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。
 * 接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)
 *
 * 输出描述:
 * 一个非负整数，表示该手链上有多少种颜色不符需求。
 *
 * 输入例子1:
 * 5 2 3
 * 3 1 2 3
 * 0
 * 2 2 3
 * 1 2
 * 1 3
 *
 * 输出例子1:
 * 2
 *
 * 例子说明1:
 * 第一种颜色出现在第1颗串珠，与规则无冲突。
 * 第二种颜色分别出现在第 1，3，4颗串珠，第3颗与第4颗串珠相邻，所以不合要求。
 * 第三种颜色分别出现在第1，3，5颗串珠，第5颗串珠的下一个是第1颗，所以不合要求。
 * 总计有2种颜色的分布是有问题的。
 * 这里第2颗串珠是透明的。
 */
public class _02HandString {

    static class Node{
        public int count;
        public List<Integer> colors;
        public Node next;

        public Node(int count,List<Integer> colors){
            this.count = count;
            this.colors = colors;
        }
    }

    /**
     * 使用链表保存每颗珠子的颜色,遍历所有珠子看是否有非法颜色
     *
     * 另一种思路: 求每种颜色出现的手串序号,可用链表保存,如果相邻序号小于m,则该种颜色分布有问题
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,m,c;
        n = in.nextInt();
        m = in.nextInt();
        c = in.nextInt();
        Node head=null,pre = null;
        for (int i = 0; i < n; i++) {
            int count = in.nextInt();
            List<Integer> colors = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                colors.add(in.nextInt());
            }
            Node node = new Node(count,colors);
            if (i==0){
                head = node;
                pre = head;
                continue;
            }
            pre.next = node;
            pre = pre.next;
        }
        pre.next = head;

        Node cur = head;
        List<Integer> dupColor = new ArrayList<>();
        do {
            List<Integer> intersect = new ArrayList<>();
            Node tmp = cur;
            for (int i = 0; i < m; i++,tmp=tmp.next) {
                for (Integer color : tmp.colors) {
                    if (intersect.contains(color)){
                        if (!dupColor.contains(color)){
                            dupColor.add(color);
                        }
                    }else {
                        intersect.add(color);
                    }

                }
            }
            cur = cur.next;
        }while (cur!=head);
        System.out.println(dupColor.size());
    }
}
