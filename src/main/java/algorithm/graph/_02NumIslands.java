package algorithm.graph;

/**
 * @author LRK
 * @date 2019/4/4 21:35
 * project_name LeetCode
 * package_name algorithm.graph
 * description:
 * God Bless, No Bug!
 *
 * 岛屿的个数
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 *
 *   示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
public class _02NumIslands {

    /**
     * dfs  深度搜索找连通域
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        if(rows==0) {
            return 0;
        }
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j]== '1' && !visited[i][j]){

                    dfs(grid,i,j,visited);
                    res++;
                }
            }
        }
        return res;

    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {

        if (i<0 || i>=grid.length) {
            return;
        }
        if (j<0 || j>=grid[0].length){
            return;
        }
        if (grid[i][j]!='1' || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(grid,i+1,j,visited);
        dfs(grid,i-1,j,visited);
        dfs(grid,i,j+1,visited);
        dfs(grid,i,j-1,visited);
    }
}
