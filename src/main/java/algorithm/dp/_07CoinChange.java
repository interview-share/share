package algorithm.dp;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.dp
 * @date 2019/4/3 23:39
 * @description God Bless, No Bug!
 * <p>
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class _07CoinChange {

    public static void main(String[] args) {

        System.out.println(new _07CoinChange().coinChange(new int[]{1,2},2));
    }
    int cnt = Integer.MAX_VALUE;

    /**
     * failed
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {

        Arrays.sort(coins);
        if (amount==0) {
            return 0;
        }
        coinHelper(coins,amount);
        return cnt;

    }
    int tmp = 0;
    private boolean coinHelper(int[] coins, int amount) {

        if (amount == 0){
            if (tmp <cnt){
                cnt = tmp;
            }
            return true;
        }else if (amount<0){
            tmp = 0;
            return false;
        }
        int n = coins.length;
        for (int i = n-1; i >= 0; i--) {
            while (amount>coins[i]){
                amount -= coins[i];
                if (coinHelper(coins,amount)){
                    tmp++;
                    return true;
                }else {
                    amount +=coins[i];
                    continue;
                }
            }
        }
        return false;
    }

    public int coinChange(int[] coins, int amount) {

        if (coins.length == 0) {
            return -1;
        }
        //这个判断纯属应付测试用例
        if (amount == 0) {
            return 0;
        }
        //dp[i]表示硬币能组成的和为i的最小个数；
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for(int coin:coins) {
                if (i-coin>=0) {
                    dp[i] = Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
