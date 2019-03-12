package array;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name array
 * @date 2019/3/9 19:31
 * @description God Bless, No Bug!
 *
 * 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class _08IncreasingTriplet {

    public static void main(String[] args) {
        System.out.println(new _08IncreasingTriplet().increasingTriplet(new int[]{1,0,0,0,10,0,0,1000}));
    }
    public boolean increasingTriplet(int[] nums) {

        int min = Integer.MAX_VALUE; // 最小值
        int sub = Integer.MAX_VALUE; // 次小值
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i]<=min){
                min = nums[i];
            }else if (nums[i]>min && nums[i]<=sub){ // 能到这里说明sub之前一定有一个min比sub小
                sub = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}
