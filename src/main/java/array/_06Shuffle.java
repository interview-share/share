package array;

import java.util.*;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name array
 * @date 2019/3/9 16:42
 * @description God Bless, No Bug!
 *
 * 打乱数组
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class _06Shuffle {
    public static void main(String[] args) {
        _06Shuffle test = new _06Shuffle(new int[]{5, 4, 6, 3, 7, 8, 1, 2});

        Random random = new Random();
        System.out.println(random.nextInt(2));
    }

    int[] source; // 已排序数组
    Random random;

    public _06Shuffle(int[] nums) {
        source = Arrays.copyOf(nums,nums.length);
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return source;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * Knuth洗牌算法
     * 随机牌j选取的方法，在拿起第i张牌时，只从它前面的牌随机选出j，而不是从整副牌里面随机选取。
     */
    public int[] shuffle() {
        int len = source.length;
        int[] shuffle = Arrays.copyOf(source,len);

        for (int i = 0; i < len; i++) {

            int j = random.nextInt(i+1);
            swap(shuffle,i,j);
        }
        return shuffle;
    }
}
