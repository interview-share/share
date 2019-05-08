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
public class Question2_copy3 {

    static int cnt = 0;
    public static void main(String[] args) {

        List<List<Integer>> out = new ArrayList<>();
        List<Integer> e = Arrays.asList(1, 2, 3);
        out.add(e);
        System.out.println(out.contains(Arrays.asList(1,2,3)));
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                res.append('*');
            }
            insert(res,0,k);
        }
    }

    private static void insert(StringBuilder res, int begin, int k) {
        if (k==0){
            cnt++;
            return;
        }
        for (int i = 0; i < k; i++) {
            res.insert(begin,'|');
            insert(res,begin+2,k-1);
        }
    }

}