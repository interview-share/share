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
public class Question2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            List<List<Integer>> res = solution(n, k);
            print(res);
        }
    }

    private static void print(List<List<Integer>> res) {
        System.out.println(res.size());
        for (List<Integer> sol : res) {

            for (int i = 0; i < sol.size(); i++) {
                int m = sol.get(i);
                for (int j = 0; j < m; j++) {
                    System.out.print("*");
                }
                if (i != sol.size() - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }



    /**
     * n 件礼物分给 k 个小朋友
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> solution(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        int[] gift = new int[k];
        helper(1, k, n, gift, res);
        return res;
    }

    /**
     * 将remGift个礼物分给 k 个小朋友
     *
     * @param i
     * @param k
     * @param remGift
     * @param gift
     * @param res
     */
    private static void helper(int i, int k, int remGift, int[] gift, List<List<Integer>> res) {

        if (i == k || remGift == 0) {
            gift[k - 1] = remGift;
            List<Integer> line = Arrays.stream(gift).boxed().collect(Collectors.toList());
            res.add(line);
            return;
        }

        for (int j = remGift; j >= 0; j--) {
            gift[i - 1] = j;
            helper(i + 1, k, remGift - j, gift, res);
        }
    }
}
