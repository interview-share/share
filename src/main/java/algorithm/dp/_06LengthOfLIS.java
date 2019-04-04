package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.dp
 * @date 2019/4/3 21:50
 * @description God Bless, No Bug!
 *
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class _06LengthOfLIS {

    public static void main(String[] args) {
        System.out.println(new _06LengthOfLIS().lengthOfLIS2(new int[]{3,5,6,2,5,4,19,5,6,7,12}));
    }

    public int lengthOfLIS2(int[] nums) {

        int n = nums.length;
        if (n<1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>(n);
        list.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i]<=list.get(0)){
                list.set(0,nums[i]);
                continue;
            }
            if (nums[i]>list.get(list.size()-1)){
                    list.add(nums[i]);
                continue;
            }
            int left = 0,right = list.size()-1;
            while (left<=right){
                int mid = (left+right)>>1;
                if (nums[i]==list.get(mid)){
                    left = mid;
                    break;
                }
                if (nums[i]<list.get(mid)){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
            if (left==list.size()){
                list.add(nums[i]);
            }else {
                list.set(left,nums[i]);
            }
        }

        return list.size();
    }
    public int lengthOfLIS(int[] nums) {

        // dp[i] ==> 表示以nums[i]结尾的最长上升子序列
        int n = nums.length;
        if (n<1){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int allMax = 1;
        for (int i = 1; i < n; i++) {

            int max = 0;
            for (int j = 0; j < i; j++) {

                if (nums[i]> nums[j] && dp[j]>max){
                    max = dp[j];
                }
            }
            dp[i] = max+1;
            if (dp[i]>allMax){
                allMax = dp[i];
            }
        }
        return allMax;
    }
}
