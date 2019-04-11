package bytedance.dp;

import java.util.*;

/**
 * @author LRK
 * @date 2019/4/7 1:22
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 *   请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class _06MaxEnvelopes {

    public static void main(String[] args) {
        //[[46,89],[50,53],[52,68],[72,45],[77,81]]
        int[][] envelopes = {{46,89}, {50,53}, {52,68}, {72,45},{77,81}};
        System.out.println(new _06MaxEnvelopes().maxEnvelopes(envelopes));
        System.out.println(Arrays.deepToString(envelopes));

        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.computeIfAbsent(1,(set) -> new HashSet<>()).add(2);
    }
    public int maxEnvelopes(int[][] envelopes) {

        // 排序 + dp
        int n = envelopes.length;
        if (n<2) {
            return n;
        }
        Arrays.sort(envelopes,(p,q) -> p[0]==q[0]?p[1]-q[1]:p[0]-q[0]);
//        quickSort(envelopes,0,n-1);
        int max = 1;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int tmp = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    int cnt = dp[j]+1;
                    if (cnt>tmp){
                        tmp = cnt;
                    }
                }
            }
            dp[i] = tmp;
            if (tmp>max){
                max = tmp;
            }
        }
        return max;
    }

    private void quickSort(int[][] envelopes, int begin, int end) {
        if (begin>end){
            return;
        }
        int left = begin,right = end;
        int base = envelopes[begin][0];
        int high = envelopes[begin][1];
        while (left<right){

            while (left<right && envelopes[right][0]>=base){
                if (envelopes[right][0]==base && envelopes[right][1]<high){
                    break;
                }
                right--;
            }
            while (left<right && envelopes[left][0]<=base){
                if (envelopes[left][0]==base && envelopes[left][1]>high){
                    break;
                }
                left++;
            }
            if (left<right){
                swap(envelopes,left,right);
            }
        }
        swap(envelopes,begin,left);

        quickSort(envelopes,begin,left-1);
        quickSort(envelopes,left+1,end);
    }

    private void swap(int[][] envelopes, int i, int j) {

        int[] tmp = envelopes[i];
        envelopes[i] = envelopes[j];
        envelopes[j] = tmp;
    }
}
