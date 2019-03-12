package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name solution
 * @date 2019/3/4 20:32
 * @description God Bless, No Bug!
 *
 * 1 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class _01TwoSum {

    /**
     * 暴力算法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res= new int[2];
        int len = nums.length;
        for(int i = 0;i<len-1;i++){

            for(int j = i+1;j<len;j++){
                if(nums[i]+nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 利用hashMap 空间换时间
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)){
                return new int[]{map.get(tmp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
