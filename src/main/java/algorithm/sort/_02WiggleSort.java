package algorithm.sort;

import java.util.Arrays;
import static common.SortUtil.swap;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.sort
 * @date 2019/3/25 21:38
 * @description God Bless, No Bug!
 *
 * 摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1:
 *
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 *
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 *
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */
public class _02WiggleSort {

    public static void main(String[] args) {

        int[] nums = {1, 2,3,4,5,6};
        _02WiggleSort test = new _02WiggleSort();
        test.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {

        int len = nums.length;
        int[] tmp = Arrays.copyOf(nums, len);
        Arrays.sort(tmp);

        int k = len, j = (len +1) >> 1;
        for (int i = 0; i < len; i++) {
            nums[i] = ((i&1)==1)?tmp[--k]:tmp[--j];
        }
    }

    /**
     * 先快速排序，然后把最小的一半依次放在奇数位上，最大的一半依次放在偶数位上。
     * 算法复杂度是快速排序的复杂度O(NlogN)。仔细思考后发现快速排序不是必要的，只需要找到中位数即可。
     * 利用快速排序的思想找中位数的期望时间复杂度是O(N)。为了防止相等的数放在一起，需要注意放置的顺序。
     *   笔者采用的方法是依nums长度分两种情况：
     *      若长度为奇数，把比中位数小的依次放在0,2,4,...位置，比中位数大的依次放在length-2,length-4,...位置；
     *      若长度为偶数，把比中位数小的依次放在length-2,length-4,...位置，比中位数大的依次放在1,3,5,...位置。
     *      其余位置填充中位数。这样可以保证中位数一定与较小与较大的数相邻（题目保证一定有解）。
     * @param nums
     */
    public void wiggleSort2(int[] nums) {

        int len = nums.length;
        int mid = partition(nums,0, len-1,len/2);
        for (int num : nums) {

        }
    }

    /**
     * 快排思想找出第k小的数
     * @param nums
     * @param begin
     * @param end
     * @param k
     * @return
     */
    private int partition(int[] nums, int begin, int end, int k) {
        int left = begin;
        int right = end;
        int base = nums[left];

        while (left<right){

            while (left<right && nums[right]>=base){
                right--;
            }
            while (left<right && nums[left]<=base){
                left++;
            }
            if (left<right){
                swap(nums,left,right);
            }
        }
        swap(nums,begin,left);
        if (k==left){
            return nums[k];
        }else if (k<left){
            return partition(nums,begin,left-1,k);
        }else {
            return partition(nums,begin+1,end,k);
        }
    }
}
