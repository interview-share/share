package offer.nowcoder.pinduoduo;

/**
 * @author LRK
 * @project_name Offer
 * @package_name nowcoder.pinduoduo
 * @date 2019/4/3 19:32
 * @description God Bless, No Bug!
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            int[] sum = new int[n>>1];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            for (int i = 0; i < (n >>1); i++) {
                sum[i] = nums[i]+nums[n-1-i];
            }
            Arrays.sort(sum);

            System.out.println(sum[sum.length-1]-sum[0]);
        }
    }
}

