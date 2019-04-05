package algorithm.dp;

/**
 * @author LRK
 * @date 2019/4/4 17:51
 * project_name LeetCode
 * package_name algorithm.dp
 * description:
 * God Bless, No Bug!
 *
 * 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。
 * 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 *
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 *
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 */
public class _08LongestIncreasingPath {
    int[][] visited;
    int rows,cols;
    public static void main(String[] args) {

        int[][] matrix = {
                {3,4,5 },
                {3,2,6},
                {2,2,1}};
        _08LongestIncreasingPath test = new _08LongestIncreasingPath();
        System.out.println(test.longestIncreasingPath(matrix));
    }

    /**
     * dfs + dp 遍历搜索的时候 visited[][] 保存当前节点开头的最长递增子序列长度
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {

        rows = matrix.length;
        if (rows==0) {
            return 0;
        }
        cols = matrix[0].length;
        visited = new int[rows][cols];

        int res = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j]!=0){
                    continue;
                }
                res = Math.max(res,dfs(matrix,i,j,Integer.MIN_VALUE));
            }
        }
        return res;

    }

    /**
     * dfs 的时候保存中间值
     * @param matrix
     * @param i
     * @param j
     * @param oldVal
     * @return
     */
    private int dfs(int[][] matrix, int i, int j, int oldVal) {
        if (i<0 || i>=rows || j<0 || j>=cols || matrix[i][j]<=oldVal) {
            return 0;
        }
        if (visited[i][j]==0){
            int curVal = matrix[i][j];
            int down = dfs(matrix,i+1,j,curVal);
            int up = dfs(matrix,i-1,j,curVal);
            int right = dfs(matrix,i,j+1,curVal);
            int left = dfs(matrix,i,j-1,curVal);
            visited[i][j] = 1 + Math.max(Math.max(up,down),Math.max(left,right));
        }
        return visited[i][j];
    }
}
