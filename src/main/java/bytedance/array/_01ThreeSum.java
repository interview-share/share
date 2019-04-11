package bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LRK
 * @date 2019/4/7 17:04
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class _01ThreeSum {

    public static void main(String[] args) {

        System.out.println(new _01ThreeSum().threeSum(new int[]{1,0,-1,0,0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n-3; i++) {

            helper(nums, i, 3, 0, 0, 0, tmp, res);
        }
        return res;
    }

    private void helper(int[] nums, int begin, int n, int cur, int curSum, int sum, List<Integer> tmp, List<List<Integer>> res) {
        if (n == cur) {
//            System.out.println(tmp);
            if (curSum == sum) {
                /*for (List<Integer> list : res) {
                    if (list.containsAll(tmp)) {
                        return;
                    }
                }*/
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        for (int i = begin; cur < n && i <= nums.length - n + cur; i++) {
            tmp.add(nums[i]);
            curSum += nums[i];
            helper(nums, i + 1, n, cur + 1, curSum, sum, tmp, res);
            curSum -= nums[i];
            tmp.remove(tmp.size() - 1);
        }
    }
}
