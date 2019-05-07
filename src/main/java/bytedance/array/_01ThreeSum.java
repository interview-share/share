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
 * @description: God Bless, No Bug!
 * <p>
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class _01ThreeSum {

    public static void main(String[] args) {

        System.out.println(new _01ThreeSum().threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
    }


    /**
     * 排序之后固定一个数,使用两数之和的方法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        int len = nums.length;
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;                             //简化，如果>0则说明该三数之和不可能为0
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;            //去重
            }
            int target = 0 - nums[i];
            //此处必须对i后面的数字进行筛选，不能重复
            int l = i + 1;
            int r = len - 1;
            while (l < r) {

                List<Integer> list = new ArrayList<>();
                if (nums[l] + nums[r] == target) {
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (r > l && nums[l + 1] == nums[l]) {
                        l++;          //这个地方改成l-1只会出现一个结果了
                    }
                    while (r > l && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {

            helper(nums, i, 3, 0, 0, 0, tmp, res);
        }
        return res;
    }

    private void helper(int[] nums, int begin, int n, int cur,
                        int curSum, int sum, List<Integer> tmp, List<List<Integer>> res) {
        if (n == cur) {
            //System.out.println(tmp);
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
