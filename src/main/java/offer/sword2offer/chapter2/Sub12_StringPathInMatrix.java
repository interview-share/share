package offer.sword2offer.chapter2;

import java.util.Scanner;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/31 23:49
 * @description God Bless, No Bug!
 *
 * 矩阵中的路径
 * 题目描述
 *  请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *      路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *      如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 *      例如 a b c e s f c s a d e e 这样的 3 X 4 矩阵中包含一条字符串"bcced"的路径，
 *      但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 解法
 * 回溯法。首先，任选一个格子作为路径起点。假设格子对应的字符为 ch，并且对应路径上的第 i 个字符。
 *  若相等，到相邻格子寻找路径上的第 i+1 个字符。重复这一过程。
 */
public class Sub12_StringPathInMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            char[] matrix = new char[n * m];
            for (int i = 0; i < n; i++) {
                char[] tmp = in.next().toCharArray();
                for (int j = 0; j < m; j++) {
                    matrix[i * m + j] = tmp[j];
                }
            }

            for (int i = 0; i < q; i++) {
                char[] target = in.next().toCharArray();
                boolean b = hasPath(matrix, n, m, target);
                if (b) {
                    System.out.println("Case " + i + ": Has");
                } else {
                    System.out.println("Case " + i + ": Not Has");
                }
            }

        }
    }
        /*char[] matrix = "abtgcfcsjdeh".toCharArray();
        char[] str = "bfce".toCharArray();
        boolean hasPath = hasPath(matrix,3,4,str);
        System.out.println(hasPath);*/

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] target)
    {
        if (matrix==null || rows<1||cols<1||target==null){
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        int pathLength = 0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){

                if (hasPathCore(matrix,rows,cols,target,i,j,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯法判断矩阵中是否包含某路径
     * @param matrix 矩阵
     * @param rows 行数
     * @param cols 列数
     * @param target 目标字符串
     * @param i 当前检查点行坐标
     * @param j 当前检查点列坐标
     * @param pathLength 已匹配的路径长度
     * @param visited 数组标识是否访问过
     * @return 是否包含匹配字符串的路径
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] target, int i, int j, int pathLength, boolean[] visited) {

        if (pathLength == target.length){
            return true;
        }
        int index = i*cols+j;
        boolean hasPath = false;
        if (i >= 0 && i < rows && j >= 0 && j < cols
                &&matrix[index]==target[pathLength]&& !visited[index]){
            pathLength++;
            visited[index]=true;
            // 递归判断是否满足条件
            hasPath = hasPathCore(matrix,rows,cols,target,i-1,j,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,target,i+1,j,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,target,i,j-1,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,target,i,j+1,pathLength,visited);
            // 若不满足条件则==>回溯
            if (!hasPath){
                --pathLength;
                visited[index] = false;
            }
        }
        return hasPath;
    }
}
