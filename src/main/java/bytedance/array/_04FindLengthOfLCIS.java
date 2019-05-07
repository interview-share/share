package bytedance.array;

/**
 * @author LRK
 * @date 2019/4/8 20:37
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 *  示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 */
public class _04FindLengthOfLCIS {

    /**
     * 典型动态规划,数组dp[i]记录以nums[i]结尾的递增序列长度
     * 数组也可用一个变量替换节省空间
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {

        int n = nums.length;
        if (n<2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {

            if (nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }else {
                dp[i] = 1;
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
