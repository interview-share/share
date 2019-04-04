package algorithm.stack_and_queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name stack_and_queue
 * @date 2019/3/10 20:57
 * @description God Bless, No Bug!
 * 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 注意：
 *
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 */
public class _06MaxSlidingWindow {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new _06MaxSlidingWindow().maxSlidingWindow(
                new int[]{7,2,4}, 2
        )));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length-k+1;
        int[] res = new int[n];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[i]>=nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        res[0] = nums[deque.getFirst()];
        for (int i = 1;i<n;i++){

            if (deque.getFirst()<i){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i+k-1]>=nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i+k-1);
            res[i] = nums[deque.getFirst()];
        }
//        res[n-1] = nums[i+k-1];
        return res;
    }
}
