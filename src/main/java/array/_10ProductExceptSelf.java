package array;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name array
 * @date 2019/3/9 20:57
 * @description God Bless, No Bug!
 *
 * 除自身以外数组的乘积
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class _10ProductExceptSelf {
    public static void main(String[] args) {
        int[] result = new _10ProductExceptSelf().productExceptSelf2(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result));
    }

    /**
     * 用两个数组保存从左到右和从右到左的乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        left[0] = nums[0];
        right[0] = nums[len-1];
        for (int i = 1; i < len; i++) {
            left[i] = left[i-1]* nums[i];
            right[i] =right[i-1]* nums[len-1-i];
        }

        res[0] = right[len-2];
        res[len-1] = left[len-2];
        for (int i = 1; i < len-1; i++) {

            res[i] = left[i-1]*right[len-i-2];
        }
        return res;
    }

    /**
     * 用结果数组保存从右到左的乘积,原数组保存从左到右的乘积
     * 除了结果数组便可不使用多余数组,空间复杂福为O(1)
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {

        int len = nums.length;
        int[] res = Arrays.copyOf(nums,len);

        res[len-1] = nums[len-1];
        for (int i = 1; i < len; i++) {

            nums[i] = nums[i-1]*nums[i];
            res[len-1-i] = res[len-1-i]*res[len-i];
        }

        res[0] = res[1];
        for (int i = 1; i < len-1; i++) {
            res[i] = nums[i-1]*res[i+1];
        }
        res[len-1] = nums[len-2];
        return res;
    }
}
