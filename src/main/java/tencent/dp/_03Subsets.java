package tencent.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name tencent.dp
 * @date 2019/4/22 16:25
 * @description God Bless, No Bug!
 */
public class _03Subsets {

    public static void main(String[] args) {

        System.out.println(new _03Subsets().subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            List<Integer> line = new ArrayList<>(i);
            combination(nums,0,i,line,res);
        }
        return res;
    }

    private void combination(int[] nums, int start, int k, List<Integer> line, List<List<Integer>> res) {

        // 终止条件
        if (k==0){
            res.add(new ArrayList<>(line));
            return;
        }
        if (start==nums.length){
            return;
        }
        // 包含当前数字
        line.add(nums[start]);
        combination(nums,start+1,k-1,line, res);
        // 不包含当前数字
        line.remove(line.size()-1);
        combination(nums,start+1,k,line, res);
    }

}
