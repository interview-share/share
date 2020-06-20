package codingguide.dp;

/**
 * @author LRK
 * @date 2019/5/16 22:18
 * @project LeetCode
 * @description: God Bless, No Bug!
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class Q7IntegerBreak {

    /**
     * 思路:
     *  n>5时,拆尽可能多的3:
     *  最后可能剩下:
     *      4: 2*2
     *      2: 2
     * @param n
     * @return
     */
    public int integerBreak(int n) {

        int res = 1;
        if (n<5){
            return n;
        }

        while (n>0){
            if (n==2){
                return res*2;
            }
            if (n==4){
                return res*4;
            }
            res *=3;
            n -=3;
        }
        return res;
    }

    public int integerBreak2(int n) {

        int[] dp = new int[n+1];
        dp[1]=1;
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 1; j--) {

                dp[i] = Math.max(dp[i],dp[j]*dp[i-j]);
                dp[i] = Math.max(dp[i],j*(i-j));
            }
        }
        return dp[n];
    }
}
