package tencent.dp;

import common.ACUtil;

/**
 * @author LRK
 * @date 2019/4/13 16:11
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class _02UniquePaths {
    public static void main(String[] args) {

        System.out.println(new _02UniquePaths().uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || j==0){
                    dp[i][j]=1;
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
//        return helper(1,1,m,n);
    }

    /**
     * C(m+n-2,n-1)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {

        return (int)ACUtil.C(m,n);
    }
    /**
     *  return helper(1,1,m,n)
     * @param x
     * @param y
     * @param m
     * @param n
     * @return
     */
    private int helper(int x, int y, int m, int n) {

        if (x>m || y>n){
            return 0;
        }
        // 左边
        boolean left = x == m && y == n - 1;
        boolean up = x == m - 1 && y == n;
        if (left || up){
            return 1;
        }else {
            return helper(x+1,y,m,n)+helper(x,y+1,m,n);
        }
    }
}
