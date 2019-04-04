package algorithm.sort;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.sort
 * @date 2019/3/28 20:38
 * @description God Bless, No Bug!
 *
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class _04FindDuplicate {
    // 重复数字的题目,考虑利用==>位运算
    /**
     * 若只重复出现一次,则可用 所有数之和 - 1~n的和
     * 若可以改变原数组,则原地标记法 nums[i] < 0? return i : nums[i] = - nums[i]
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {

        /**
         * 快慢指针转化为求环的起点
         * 因为快指针每次走2，慢指针每次走1，快指针走的距离是慢指针的两倍。
         * 而快指针又比慢指针多走了一圈。所以
         *  head到环的起点+环的起点到他们相遇的点的距离
         *      与
         *  环一圈的距离
         *  相等。
         *  现在重新开始，head运行到环起点 和 相遇点到环起点 的距离也是相等的，
         *  相当于他们同时减掉了 环的起点到他们相遇的点的距离。
         */
        int slow=0,fast=0,t=0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (fast == slow) break;
        }
        while (true){
            slow = nums[slow];
            t = nums[t];
            if (t==slow) break;
        }
       return slow;
    }
    /**
     * 这道题还有一种位操作Bit Manipulation的解法，也十分的巧妙。
     * 思路是遍历每一位，然后对于32位中的每一个位bit，我们都遍历一遍从0到n-1，
     * 我们将0到n-1中的每一个数都跟bit相‘与’，若大于0，则计数器cnt1自增1。
     * 同时0到n-1也可以当作nums数组的下标，从而让nums数组中的每个数字也跟bit相‘与’，
     * 若大于0，则计数器cnt2自增1。最后比较若cnt2大于cnt1，则将bit加入结果res中。
     * 这是为啥呢，因为对于每一位，0到n-1中所有数字中该位上的1的个数应该是固定的，
     * 如果nums数组中所有数字中该位上1的个数多了，说明重复数字在该位上一定是1，
     * 这样我们把重复数字的所有为1的为都累加起来，就可以还原出了这个重复数字
     */
    public int findDuplicate2(int[] nums) {
        int res=0,len = nums.length;

        for (int i = 0; i < 32; i++) {
            int bit = (1 << i);
            int cnt1_N=0,cntNums=0;
            for (int j = 0; j < len; j++) {
                if ((j&bit) > 0) cnt1_N++;
                if ((nums[j]&bit) >0) cntNums++;
            }
            if (cntNums>cnt1_N) res += bit;
        }
        return res;
    }
}
