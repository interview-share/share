package codingguide.dp;

/**
 * @author LRK
 * @date 2019/5/15 17:31
 * @project LeetCode
 * @description: God Bless, No Bug!
 * <p>
 * 62. 不同路径
 * 题目描述
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */

public class Q5UniquePathWithObstacles {
    public int uniquePaths(int[][] obstacleGrid) {

        // dp[i][j]---表示从{0,0}到{i,j}有多少条不同的路径
        // dp[0][1...n]=1;
        // dp[1...m][0]=1;
        // dp[i][j] = dp[i-1][j]+dp[i][j-1];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0]==1){
                dp[i][0] = 0;
            }else {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1; i < n; i++) {

            if (obstacleGrid[0][i]==1){
                dp[0][i]=0;
            }else {
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }

            }
        }
        return dp[m-1][n-1];
    }
}
