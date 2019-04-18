package offer.sword2offer.chapter4;

import java.util.ArrayList;


/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/3 14:03
 * @description God Bless, No Bug!
 *
 * 顺时针打印矩阵
 * 题目描述
 *  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下 4 X 4 矩阵：
 *
 * 1   2   3   4
 * 5   6   7   8
 * 9   10  11  12
 * 13  14  15  16
 * 则依次打印出数字：
 *
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 在矩阵中，使用左上角坐标(tR,tC)和右下角的坐标(dR,dC)就可以表示一个矩阵。
 * 比如题目中的矩阵，当(tR,tC) = (0,0)和(dR,dC) = (3,3)时，表示的子矩阵就是整个矩阵：
 *
 * 1	2	3	4
 * 5			8
 * 9			12
 * 13	14	15	16
 * 当外层循环遍历后，可以令tR和tC加1，dR和dC减1，执行内层循环。
 * 当左上角的坐标跑到右下角坐标的右方或者下方，则整个过程就终止。
 */
public class Sub29_PrintMatrix {
    public static void main(String[] args) {
        int[][]  matrix = new int[1][1];
        matrix[0][0] = 1;
        System.out.println(printMatrix(matrix));
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }
        // 左上和右下的坐标
        int startX = 0,startY = 0;
        int endX=matrix.length-1,endY = matrix[0].length-1;

        // 每次循环打印外圈
        while (startX<=endX && startY<=endY){

            printMatrixInCircle(matrix,startX++,startY++,endX--,endY--,result);
        }
        return result;

    }

    private static void printMatrixInCircle(int[][] matrix, int startX, int startY, int endX, int endY, ArrayList<Integer> result) {
        // 只有一行
        if (startX == endX){
            while (startY<=endY){
                result.add(matrix[startX][startY++]);
            }
        }
        // 只有一列
        else if (startY == endY){
            while (startX<=endX){
                result.add(matrix[startX++][startY]);
            }
        }else { // 多行多列
            int curX = startX;
            int curY = startY;

            // 从左到右
            while (curY!=endY){
                result.add(matrix[curX][curY++]);
            }
            // 从上到下
            while (curX!=endX){
                result.add(matrix[curX++][curY]);
            }
            // 从右到左
            while (curY!=startY){
                result.add(matrix[curX][curY--]);
            }
            // 从下到上
            while (curX!=startX){
                result.add(matrix[curX--][curY]);
            }
        }
    }


}
