package array;

import common.SortUtil;

import java.util.*;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name array
 * @date 2019/3/9 19:01
 * @description God Bless, No Bug!
 * <p>
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class _07Intersect {

    /**
     * 排序后遍历
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
//        Arrays.sort(nums1);
        quickSort(nums1, 0, len1 - 1);
        int len2 = nums2.length;
        quickSort(nums2, 0, len2 - 1);

        List<Integer> list = new ArrayList<>();

        for (int i = 0, j = 0; i < len1 && j < len2; ) {

            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                ++i;
                ++j;
            } else if (nums1[i] < nums2[j]) {
                ++i;
            } else {
                ++j;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 装入map统计
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < len1; i++) {
            int key = nums1[i];
            map.put(key,map.containsKey(key)?map.get(key)+1:1);
        }
        for (int i = 0; i < len2; i++) {
            int key = nums2[i];
            Integer value = map.get(key);
            if (map.containsKey(key) && value >0){
                res.add(key);
                map.put(key,value-1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void quickSort(int[] nums, int low, int high) {

        if (low > high) return;
        int start = low, end = high;
        int base = nums[low];

        while (start < end) {

            while (start < end && nums[end] > base) {
                end--;
            }
            while (start < end && nums[start] < base) {
                start++;
            }
            if (start < end) {
                SortUtil.swap(nums, start, end);
            }
        }
        SortUtil.swap(nums, low, start);
        quickSort(nums, low, start - 1);
        quickSort(nums, start + 1, high);
    }


}
