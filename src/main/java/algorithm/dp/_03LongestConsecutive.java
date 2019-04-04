package algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.dp
 * @date 2019/3/29 1:55
 * @description God Bless, No Bug!
 *
 * 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class _03LongestConsecutive {

    /**
     * 使用hashMap保存
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;

            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);

            int sum = left + right + 1;
            map.put(num, sum);
            max = Math.max(max,sum);
            map.put(num-left,sum);
            map.put(num+right,sum);
        }
        return max;
    }
}
