package bytedance.array;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author LRK
 * @date 2019/4/7 23:28
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 *   ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class _03Search {

    public static void main(String[] args) {
        System.out.println(new _03Search().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        // 中点一分为二之后,至少有一半是递增的,另一半可能递增,也可能仍是螺旋数组

        if (nums[mid] < nums[high]) {
            // 后半部分递增,并且要找的值在后半段递增部分
            if (nums[mid] < target && target <= nums[high]) {
                return search(nums, mid + 1, high, target);
            } else {
                return search(nums, low, mid - 1, target);
            }
        } else {
            // 前半部分递增,并且要找的值在前半段递增部分
            if (nums[low] <= target && target < nums[mid]) {
                return search(nums, low, mid - 1, target);
            } else {
                return search(nums, mid + 1, high, target);
            }
        }
    }
}
