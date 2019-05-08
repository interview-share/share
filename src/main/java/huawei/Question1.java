package huawei;

import java.util.Scanner;

/**
 * @author LRK
 * @date 2019/5/8 19:00
 * @project LeetCode
 * @description: God Bless, No Bug!
 */
public class Question1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            int k = in.nextInt();
            rotateMatrix(matrix,k);
        }
    }

    /**
     * 输出 n 阶矩阵 matrix 顺时针旋转 k 次后的矩阵
     * @param matrix
     * @param k
     */
    public static void rotateMatrix(int[][] matrix,int k){

        int cnt = k%4;
        for (int i = 0; i < cnt; i++) {
            rotate(matrix);
        }
        print(matrix);
    }

    private static void print(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 顺时针旋转一次
     * @param matrix
     */
    private static void rotate(int[][] matrix) {

        int  n = matrix.length;

        for (int i = 0; i < n/2; i++) {

            for (int j = i; j < n-1-i; j++) {
                // 旋转
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}
