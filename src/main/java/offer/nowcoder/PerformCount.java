package offer.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LRK
 * @date 2019/5/3 18:20
 * @project LeetCode
 * @description: God Bless, No Bug!
 */
public class PerformCount {
    public static void  main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for(int i=0; i<n; i++){
            h[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] w = new int[n];
        for(int i=0; i<m; i++){
            w[i] = in.nextInt();
        }
        System.out.println(getCount(w,h));
    }

    private static int getCount(int[] w,int[] h){
        int n = h.length,m = w.length;
        if (n==0 || m==0){
            return 0;
        }
        Arrays.sort(w);
        Arrays.sort(h);
        int cnt = 0;

        for(int i=0; i<n; i++){// 每个孩子所需的巧克力
            for(int j=0; j<m; j++){ // 每块巧克力的重量
                if(w[j] >= h[i]){// 满足条件
                    cnt++;
                    w[j] = 0; // 消耗巧克力
                    break;
                }
            }
        }
        return cnt;
    }
}
