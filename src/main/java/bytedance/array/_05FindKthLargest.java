package bytedance.array;

/**
 * @author LRK
 * @date 2019/4/8 20:42
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 * <p>
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class _05FindKthLargest {

    public static void main(String[] args) {

        System.out.println(new _05FindKthLargest().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }

    /**
     * 快排思路,每次确定一个数在最终序列的位置,如果正好等于 k 返回结果;
     *  否则继续partition
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        int n = nums.length;
        if (n == 0 || n < k) {
            return 0;
        }
        return partition(nums, 0, n - 1, k-1);
    }

    private int partition(int[] nums, int begin, int end, int k) {

        if (begin > end) {
            return -1;
        }
        int base = nums[begin];
        int left = begin, right = end;

        while (left < right) {

            while (nums[right] <= base && left < right) {
                right--;
            }
            while (nums[left] >= base && left < right) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, left, begin);
        if (left == k) {
            return nums[k];
        }
        if (left<k){
            return partition(nums,left+1,end,k);
        }else {
            return partition(nums,begin,left-1,k);
        }
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
