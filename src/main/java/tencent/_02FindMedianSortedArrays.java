package tencent;

import java.util.Map;

/**
 * @author LRK
 * @date 2019/4/12 15:24
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 *   请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class _02FindMedianSortedArrays {
    /**
     *
     * 如果某个有序数组长度是奇数，那么其中位数就是最中间那个，如果是偶数，那么就是最中间两个数字的平均值。
     * 这里对于两个有序数组也是一样的，假设两个有序数组的长度分别为m和n，由于两个数组长度之和 m+n 的奇偶不确定，
     * 因此需要分情况来讨论，对于奇数的情况，直接找到最中间的数即可，偶数的话需要求最中间两个数的平均值。
     * 为了简化代码，不分情况讨论，我们使用一个小trick，我们分别找第 (m+n+1)/2 个，和 (m+n+2)/2 个，然后求其平均值即可，
     * 这对奇偶数均适用。加入 m+n 为奇数的话，那么其实 (m+n+1)/2 和 (m+n+2)/2 的值相等，相当于两个相同的数字相加再除以2，还是其本身。
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length,m = nums2.length;
        // 第 k 个(从1开始计数)
        int left = (n+m+1)>>1, right = (n+m+2)>>1;

        return (findKthNum(nums1,0,nums2,0,left)+findKthNum(nums1,0,nums2,0,right))/2.0;
    }

    private double findKthNum(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // 只剩一个数组的情况,直接返回另一个数组的第 k 个数
        if (start1>=nums1.length){
            return nums2[start2+k-1];
        }
        if (start2>=nums2.length){
            return nums1[start1+k-1];
        }
        // 终止条件
        if (k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        // 一般情况,即两个数组剩余数字均大于 k/2
        int halfK1 = (start1+k/2-1)<nums1.length?nums1[start1+k/2-1]:Integer.MAX_VALUE;
        int halfK2 = (start2+k/2-1)<nums2.length?nums2[start2+k/2-1]:Integer.MAX_VALUE;
        if (halfK1<halfK2){
            return findKthNum(nums1,start1+k/2,nums2,start2,k-k/2);
        }else {
            return findKthNum(nums1,start1,nums2,start2+k/2,k-k/2);
        }
    }

}
