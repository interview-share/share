package tencent.array;

/**
 * @author LRK
 * @date 2019/4/13 12:32
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 * 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 *   示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class _11GenerateMatrix {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int start=0,end = n-1;
        int cnt = 1;
        while (start<=end){
            int curX=start,curY=start;
            if (start==end){
                matrix[curX][curY] = cnt;
            }else {
                // 左到右
                while (curY<end){
                    matrix[curX][curY++] = cnt++;
                }
                // 上到下
                while (curX<end){
                    matrix[curX++][curY] = cnt++;
                }
                while (curY>start){
                    matrix[curX][curY--] = cnt++;
                }
                while (curX>start){
                    matrix[curX--][curY] = cnt++;
                }
            }
            start++;
            end--;
        }
        return matrix;
    }
}
