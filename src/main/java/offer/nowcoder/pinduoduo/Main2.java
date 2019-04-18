package offer.nowcoder.pinduoduo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author LRK
 * @project_name Offer
 * @package_name nowcoder.pinduoduo
 * @date 2019/4/3 19:51
 * @description God Bless, No Bug!
 */

public class Main2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNextInt()) {
            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = in.nextInt();
            }
            // A 的位数
            int cntA = in.nextInt();
            // B 的位数
            int cntB = in.nextInt();
            // 求 A*B 的最小值
            int sub = Math.abs(cntA-cntB);
            StringBuilder strA = new StringBuilder();
            StringBuilder strB = new StringBuilder();
            Queue<Integer> queue = new LinkedList<>();
            // 入队
            if (nums[0]>Math.min(cntA,cntB)){
                System.out.println(0);
                continue;
            }
            for (int i = 0; i < 10; i++) {

                while (nums[i]>0){
                    queue.offer(i);
                    nums[i]--;
                }
            }
            /*for (int i = 0; i < sub; i++) {
                if (strA.length()>0 && nums[0]>0){
                    strA.append(0);
                    nums[0]--;
                }
                strA.append(queue.poll());
            }*/
            while (!queue.isEmpty() && strA.length()<Math.min(cntA,cntB)){
                    strA.append(queue.poll());
            }
            while (!queue.isEmpty()){
                strB.append(queue.poll());
            }
            System.out.println(Integer.valueOf(strA.toString())*Integer.valueOf(strB.toString()));
        }
    }
}
