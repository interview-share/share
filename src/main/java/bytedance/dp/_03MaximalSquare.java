package bytedance.dp;

import java.util.Map;

/**
 * @author LRK
 * @date 2019/4/6 23:17
 * @project LeetCode
 * @description:
 * God Bless, No Bug!
 *
 * 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class _03MaximalSquare {


    /**
     * dp[i][j] = 1+ Math.min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        if (rows < 1) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int max = 0;
        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1') {

                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
