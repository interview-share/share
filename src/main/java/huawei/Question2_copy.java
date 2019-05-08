package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author LRK
 * @date 2019/5/8 19:20
 * @project LeetCode
 * @description: God Bless, No Bug!
 */
public class Question2_copy {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            solution(n, k);
        }
    }
    /**
     * n 件礼物分给 k 个小朋友
     *
     * @param n
     * @param k
     * @return
     */
    public static void solution(int n, int k) {

        int[] gift = new int[k];
        helper(1, k, n, gift);
    }

    /**
     * 将remGift个礼物分给 k 个小朋友
     *
     * @param i
     * @param k
     * @param remGift
     * @param gift
     */
    private static void helper(int i, int k, int remGift, int[] gift) {

        if (i == k || remGift == 0) {
            gift[k - 1] = remGift;
            for (int j = 0; j < k; j++) {
                int cnt = gift[j];
                while (cnt>0){
                    System.out.print("*");
                    cnt--;
                }
                if (j != k-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            return;
        }

        for (int j = remGift; j >= 0; j--) {
            gift[i - 1] = j;
            helper(i + 1, k, remGift - j, gift);
        }
    }
}
