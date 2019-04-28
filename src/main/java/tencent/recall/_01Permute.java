package tencent.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name tencent.recall
 * @date 2019/4/28 20:54
 * @description God Bless, No Bug!
 *
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class _01Permute {

    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums,0,res);

        return res;
    }

    private void permuteHelper(int[] nums, int start, List<List<Integer>> res) {

        // 终止条件
        if (start == nums.length){
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        int n = nums.length;
        for (int i = start; i < n; i++) {
            // 交换
            swap(nums,start,i);
            permuteHelper(nums,start+1,res);
            swap(nums,start,i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
