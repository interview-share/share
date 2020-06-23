package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/9 16:50
 * @description God Bless, No Bug!
 * 题目描述
 * 一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围 0 到 n-1 之内。
 *
 * 在范围 0 到 n-1 的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 样例
 *
 * 输入：[0,1,2,4]
 *
 * 输出：3
 * 解法
 * 找出第一个与下标不对应的数字即可。
 *
 * 特殊情况：
 *
 * 下标都对应，那么应该返回 最后一个数+1；
 * 缺失的数字是第一个，那么返回 0。
 *
 *
 */
public class Sub53_2GetMissingNumber {
    public static void main(String[] args) {
        Sub53_2GetMissingNumber test = new Sub53_2GetMissingNumber();
        int[] data = {0,1,2,4,5,6};
        System.out.println(test.getMissingNumber(data));
    }

    /**
     * 长度为n-1 包含0~n-1的n-1个数字,有且仅有一个不在其中
     * @param array
     * @return
     */
    public int getMissingNumber(int[] array){

        if (array == null || array.length==0){
            return -1;
        }

        int start = 0,end = array.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if (array[mid]!=mid){
                // mid是第一个不等于下标的
                if ( mid == 0 || array[mid-1]==mid-1){
                    return mid;
                }else { // 继续往前查找
                    end = mid-1;
                }
            }else {
                start = mid+1;
            }
        }
        if (start == array.length-1) {
            return start;
        }
        return -1;
    }
    public int getMissingNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] != mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start == n ? n : -1;

    }



}
