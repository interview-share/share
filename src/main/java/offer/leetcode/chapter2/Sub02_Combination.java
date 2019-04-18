package offer.leetcode.chapter2;

import java.util.ArrayList;

/**
 * @author LRK
 * @project_name Offer
 * @package_name leetcode.chapter2
 * @date 2019/2/16 23:07
 * @description God Bless, No Bug!
 */
public class Sub02_Combination {
    public static void main(String[] args) {

        Sub02_Combination test = new Sub02_Combination();
        System.out.println(test.getCombination(4, 2));
    }

    public ArrayList<ArrayList<Integer>> getCombination(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (n < 1 || k < 0 || n < k) return result;
        int[] seq = new int[n];
        for (int i = 0; i < seq.length; i++) {
            seq[i] = i + 1;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        combination(seq, 0, k, result, temp);
        return result;
    }

    private void combination(int[] seq, int start, int m, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {

        if (m == 0) { //
            //添加一个组合
            result.add(new ArrayList<>(temp));
            return;
        }
        if (start == seq.length) {
            return;
        }
        // 组合包含seq[start]
        temp.add(seq[start]);
        combination(seq, start + 1, m - 1, result, temp);
        // 组合不包含seq[start]
        temp.remove(temp.size() - 1);
        combination(seq, start + 1, m, result, temp);

    }
}
