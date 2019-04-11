package bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LRK
 * @date 2019/4/8 21:23
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 *  按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class _07GetPermutation {

    public static void main(String[] args) {

        System.out.println(new _07GetPermutation().getPermutation2(3, 5));
    }


    public String getPermutation2(int n, int k) {

        // 阶乘数组
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i-1]*i;
        }
        /**
         * java.lang.UnsupportedOperationException是指请求的方法不被支持的异常。
         * 在从Arrays.asList()转化过来的List的不支持add()和remove()方法，
         * 这是由于从Arrays.asList()返回的是返回java.util.Arrays$ArrayList，
         * 而不是ArrayList。Arrays$ArrayList和ArrayList都是继承AbstractList，
         * add() 和remove()等方法在AbstractList中默认throw UnsupportedOperationException而不做任何操作。
         * ArrayList重写这些方法对List进行操作，
         * 而Arrays$ArrayList却没有重写add()和 remove()等方法，
         * 所以对从Arrays.asList()转化过来的List进行add()和remove()会出现UnsupportedOperationException异常。
         */
        List<Integer> nums = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        StringBuilder builder = new StringBuilder();
        --k;
        for (int i = n; i > 0; i--) {
            // 当前位的数字
            int j = k / f[i - 1];
            builder.append(nums.get(j));
            k %= f[i-1];
            nums.remove(j);
        }
        return builder.toString();
    }


    int cnt = 0;
    int over;
    public String getPermutation(int n, int k) {
        over = k;
        char[] nums = new char[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (char) ('1'+i);
        }
        return permutation(nums,0);
    }

    private String permutation(char[] nums, int begin) {
        String res = null;
        if (begin == nums.length-1){
            cnt++;
            if (over == cnt){
                return new String(nums);
            }else {
                return null;
            }
        }
        for (int i = begin; i < nums.length; i++) {
            swap(nums,begin,i);
            if ((res = permutation(nums,begin+1))!=null){
                   return res;
            }
            swap(nums,begin,i);
        }
        return res;
    }
    public void swap(char[] nums,int i,int j){
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
