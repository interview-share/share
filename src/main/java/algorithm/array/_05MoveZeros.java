package algorithm.array;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name array
 * @date 2019/3/9 16:17
 * @description God Bless, No Bug!
 *
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class _05MoveZeros {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i]!=0 && cnt>0){
                nums[i-cnt] = nums[i];
            }else if (nums[i]==0){
                ++cnt;
            }
        }
        for (int i = 0; i < cnt; i++) {
            nums[len-i] = 0;
        }
    }
}
