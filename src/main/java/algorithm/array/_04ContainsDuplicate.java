package algorithm.array;

import java.util.*;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name array
 * @date 2019/3/9 16:12
 * @description God Bless, No Bug!
 *
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class _04ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        /*int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (list.contains(nums[i])){
                return true;
            }
            list.add(nums[i]);
        }
        return false;*/
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (!set.add(nums[i]))
                return false;
        }
        return true;
    }
}
