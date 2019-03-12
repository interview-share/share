package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name solution
 * @date 2019/3/4 23:02
 * @description God Bless, No Bug!
 */
public class _04FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(new _04FindMedianSortedArrays().findMedian(
                new int[]{}, new int[]{5, 7}
        ));
    }

    public double findMedian(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums.add(nums1[i++]);
            } else {
                nums.add(nums2[j++]);
            }
        }
        if (i == nums1.length) {
            while (j < nums2.length)
                nums.add(nums2[j++]);
        } else if (j == nums2.length) {
            while (i < nums1.length)
                nums.add(nums1[i++]);
        }
        if (nums.size() % 2 == 1)
            return nums.get(nums.size() / 2);
        else {
            return (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) / 2.0;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length,
                left = (m + n + 1) / 2, right = (m + n + 2) / 2;

        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;

    }

    /**
     * 递归 每次从两个数组的前面删除一部分确定比中位数小的数
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @param k
     * @return
     */
    private double findKth(int[] nums1, int i, int[] nums2, int j, int k) {

        if (i >= nums1.length) return nums2[j + k - 1]; // 其中一个数组为空
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) { // 递归结束条件
            return Math.min(nums1[i], nums2[j]);
        }

        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {

            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
