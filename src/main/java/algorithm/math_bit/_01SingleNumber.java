package algorithm.math_bit;

/**
 * @author LRK
 * @date 2019/4/5 14:13
 * project_name LeetCode
 * package_name algorithm.math_bit
 * description:
 * God Bless, No Bug!
 *
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 *说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class _01SingleNumber {

    /**
     * n^n = 0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
