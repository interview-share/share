package tencent.array;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @date 2019/4/13 11:02
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 *   示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class _10SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        List<Integer> res = new ArrayList<>();
        if (rows<1){
            return res;
        }
        int cols = matrix[0].length;
        int beginX = 0,beginY=0,endX=rows-1,endY=cols-1;
        while (beginX<=endX && beginY<=endY){

            printMatrix(matrix,beginX++,endX--,beginY++,endY--,res);
        }
        return res;
    }

    private void printMatrix(int[][] matrix, int beginX, int endX, int beginY, int endY, List<Integer> res) {

        // 只有一行
        if (beginX == endX){
            while (beginY<=endY){
                res.add(matrix[beginX][beginY++]);
            }
        }
        // 只有一列
        else if (beginY==endY){
            while (beginX<=endX){
                res.add(matrix[beginX++][beginY]);
            }
        }
        // 多行多列
        else {
            int curX = beginX;
            int curY = beginY;

            // 从左到右
            while (curY<endY){
                res.add(matrix[curX][curY++]);
            }
            // 从上到下
            while (curX<endX){
                res.add(matrix[curX++][curY]);
            }
            // 从右到左
            while (curY>beginY){
                res.add(matrix[curX][curY--]);
            }
            // 从下到上
            while (curX>beginX){
                res.add(matrix[curX--][curY]);
            }
        }
    }
}
