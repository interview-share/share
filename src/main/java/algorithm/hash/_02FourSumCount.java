package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.hash
 * @date 2019/3/13 17:42
 * @description God Bless, No Bug!
 *
 * 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class _02FourSumCount {

    public static void main(String[] args) {

        System.out.println(new _02FourSumCount().fourSumCount(
                new int[]{1, 2},
                new int[]{-2,-1},
                new int[]{-1, 2},
                new int[]{0, 2}
        ));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        /*
         * 循环AB,看能组成哪些和,存入字典,再循环CD,看其负和是否在字典;
         */
        int lenA = A.length,lenB=B.length,lenC=C.length,lenD=D.length;
        Map<Integer,Integer> sum = new HashMap<>();
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                int s = A[i] + B[j];
                sum.put(s,sum.getOrDefault(s,0)+1);
            }
        }
        int cnt = 0;
        for (int i = 0; i < lenC; i++) {
            for (int j = 0; j < lenD; j++) {
                int s = C[i] + D[j];
                if (sum.containsKey(-s)){ // 四数之和为0
                    cnt +=sum.get(-s);
                }
            }
        }
        return cnt;
    }
}
