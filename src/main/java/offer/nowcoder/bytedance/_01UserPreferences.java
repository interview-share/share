package offer.nowcoder.bytedance;

import java.util.*;

/**
 * @author LRK
 * @project_name Offer
 * @package_name nowcoder.bytedance
 * @date 2019/3/29 13:18
 * @description God Bless, No Bug!
 *
 * [编程题] 用户喜好
 * 时间限制：3秒
 *
 * 空间限制：262144K
 *
 * 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。
 * 假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，每个用户都有不同的喜好值，
 * 我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。
 * 因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。
 *
 * 输入描述:
 * 输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数  第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型
 *
 * 输出描述:
 * 输出：一共q行，每行一个整数代表喜好值为k的用户的个数
 *
 * 输入例子1:
 * 5
 * 1 2 3 3 5
 * 3
 * 1 2 1
 * 2 4 5
 * 3 5 3
 *
 * 输出例子1:
 * 1
 * 0
 * 2
 *
 * 例子说明1:
 * 样例解释:
 * 有5个用户，喜好值为分别为1、2、3、3、5，
 * 第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
 * 第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
 * 第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
 */
public class _01UserPreferences {
    public static Map<Integer,Node> map = new HashMap<>();
    static class Node{
        public int position;
        public Node next;
        public Node(int position){
            this.position = position;
        }
        public void insert(Node node){
            if(this.next==null){//不包含则直接插入
                this.next=node;
            }else{ //包含则递归调用
                this.next.insert(node);
            }
        }
    }
    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        list.retainAll(new ArrayList<>());
        Scanner in = new Scanner(System.in);
        int n,q,l,r,k;
        n = in.nextInt();
        // 读取数据存入map,数据值作为key,索引构造成Node插入链表
        for(int i=1;i<=n;i++){
            int num = in.nextInt();
            Node node = new Node(i);
            if(map.containsKey(num)){
                map.get(num).insert(node);
            }else{
                map.put(num,node);
            }
        }
        // 统计结果
        q = in.nextInt();
        for(int i=0; i<q; i++){
            l = in.nextInt();
            r = in.nextInt();
            k = in.nextInt();
            int cnt = 0;
            Node root = map.get(k);
            while(root!=null && root.position<=r){
                if(root.position >=l && root.position <= r){
                    cnt++;
                }
                root = root.next;
            }
            System.out.println(cnt);
        }
    }
}
