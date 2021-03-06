package algorithm.array;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name array
 * @date 2019/3/9 20:55
 * @description God Bless, No Bug!
 *
 *  搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class _09SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int rows = matrix.length; // 总行数
        int cols = matrix[0].length; // 总列数

        int curRow = 0; // 检查点行索引
        int curCol = cols-1; // 检查点列索引

        while(curCol>=0 && curRow<rows){
            if(matrix[curRow][curCol] == target){
                return true;
            }
            if(matrix[curRow][curCol]>target){
                --curCol;
            }else{
                ++curRow;
            }
        }
        return false;

    }
}
