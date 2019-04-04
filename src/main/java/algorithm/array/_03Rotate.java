package algorithm.array;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name array
 * @date 2019/3/9 14:03
 * @description God Bless, No Bug!
 *
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 */
public class _03Rotate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6,};
        new _03Rotate().rotate4(nums,2);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 每次移动一格
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        int len = nums.length;
        for (int i = 0; i < k; i++) {
            int tmp = nums[len-1];
            for (int j = len-2; j >= 0; j--) { // 后移
                nums[j+1] = nums[j];
            }
            nums[0]=tmp;
        }
    }

    /**
     * 计算移动后的index
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums,int k){

        int len = nums.length;
        k %= len;
        if(k%len==0) return;
        if ( len % k==0 || len%(len-k)==0){
            for (int i = 0; i <((k<=len-k)?k:len-k); i++) {
                exchange(nums,i,k);
            }
        }else{
            exchange(nums,0,k);
        }
    }
    private void exchange(int[] nums,int start,int k){
        int over = start;
        int len = nums.length;
        int curTmp = nums[start];
        int nextTmp;
        do {
            start = (start+k)%len;
            nextTmp = nums[start];
            nums[start] = curTmp;
            curTmp = nextTmp;

        }while (start!=over);
    }

    /**
     * 翻转3次, 前(len-k)个,后k个,整体翻转
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums,int k){

        int len = nums.length;
        k %= len;
        if (k==0) return;
        reverse(nums,0,len-k-1);
        reverse(nums,len-k,len-1);
        reverse(nums,0,len-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i<j){
           swap(nums,i++,j--);
        }
    }

    /**
     * 每次将最后面 k 个数字 与确最前面 k 个数字 交换
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0;
             start < nums.length && k != 0;
             n -= k, start += k, k %= n) {

            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
