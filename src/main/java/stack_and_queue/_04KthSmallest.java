package stack_and_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name stack_and_queue
 * @date 2019/3/10 16:08
 * @description God Bless, No Bug!
 *
 * 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 */
public class _04KthSmallest {
    public static void main(String[] args) {
        int[][] matrix = {{1,  5,  9},{10, 11, 13},{12, 13, 15}};
        System.out.println(new _04KthSmallest().kthSmallest(matrix, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        PriorityQueue<Integer> max = new PriorityQueue<>((x,y) ->y-x); // 大根堆;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (max.size()<k){
                    max.offer(matrix[i][j]);
                }else {
                    if (matrix[i][j]<max.peek()){
                        max.offer(matrix[i][j]);
                        max.poll();
                    }
                }
            }
        }
        return max.poll();
    }

    public int kthSmallest2(int[][] matrix, int k) {

        // 找到
        int n = matrix.length;
        int level = 1;
        while (k>(level*level)){
            level++;
        }
        int count = (level-1)*(level-1); // 1,4,9...
        int i = 0,j=0;

        while (count<k){

            if (matrix[level-1][i]<=matrix[j][level-1]){
                ++count;
                if (count==k) return matrix[level-1][i];
                ++i;
            }else {
                ++count;
                if (count==k) return matrix[j][level-1];
                ++j;
            }
        }
        return 0;
//        return k;
    }
}
