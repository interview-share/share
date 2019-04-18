package offer.algorithm;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name Offer
 * @package_name algorithm
 * @date 2019/4/17 13:10
 * @description God Bless, No Bug!
 */
public class _04MaxCommonSubArray {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new _04MaxCommonSubArray().findLength(
                new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7})));
    }
    public int[] findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n+1][m+1];
        int len = 0,end=-1;
        dp[0][0]=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (A[i-1]==B[j-1])?dp[i-1][j-1]+1:0;
                if (dp[i][j]>len){
                    len = dp[i][j];
                    end = i;
                }
            }
        }
        return Arrays.copyOfRange(A,end-len,end);
    }
}
