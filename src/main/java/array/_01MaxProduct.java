package array;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name array
 * @date 2019/3/9 12:48
 * @description God Bless, No Bug!
 *
 *  乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class _01MaxProduct {
    public static void main(String[] args) {
        System.out.println(new _01MaxProduct().maxProduct(new int[]{-4,-3,-2}));
    }
    public int maxProduct(int[] nums) {

        int len = nums.length;
        if(len==1) return nums[0];
        int max = nums[0];
        int min = nums[0];
        int cur[] = new int[len]; // res[i] 表示以res[i]结尾的最大连续乘积值
        cur[0] = nums[0];
        int res = cur[0];
        for (int i = 1; i < len; i++) {
            int tmpMax = max;
            int tmpMin = min;
            cur[i] = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            max = Math.max(nums[i],Math.max(tmpMax*nums[i],tmpMin*nums[i]));
            min = Math.min(nums[i],Math.min(tmpMax*nums[i],tmpMin*nums[i]));
            if (cur[i]>res){
                res = cur[i];
            }
        }
        return res;
    }

    public int maxProduct2(int[] nums){
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ int tmp = imax; imax = imin; imin = tmp;} //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
