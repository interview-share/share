package offer.sword2offer.chapter3;

import java.util.Arrays;

import static common.SortUtil.swap;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/2 16:45
 * @description God Bless, No Bug!
 *
 * 调整数组顺序使奇数位于偶数前面
 *  题目描述
 *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *      使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 *      并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 解法
 *  解法一
 *      计算出奇数的个数，就很容易写出来了。
 */
public class Sub21_ReorderArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        reorderArray4(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reorderArray2(int[] array) {

        int numOfOdd = 0; // 奇数的个数
        for (int num : array) {
            if ((num & 1) == 1) {
                numOfOdd++;
            }
        }
        int[] bak = Arrays.copyOf(array, array.length);
        int index = 0;
        for (int num : bak) {
            if ((num & 1) == 1) {
                array[index++] = num;
            }else {
                array[numOfOdd++] = num;
            }
        }
    }

    public void reOrderArray3(int [] array) {
        if (array == null || array.length < 2) {
            return;
        }
        Integer[] bak = new Integer[array.length];
        Arrays.setAll(bak, i -> array[i]);
        Arrays.sort(bak, (x, y) -> (y & 1) - (x & 1));
        Arrays.setAll(array, i -> bak[i]);
    }

    /**
     * 无法保证相对顺序不变
     * @param array
     */
    private static void reorderArray(int[] array) {

        int len = array.length;
        int pre = 0;
        int last = len - 1;
        while (pre < last) {

            while (pre < last && isOdd(array[pre])) {
                pre++;
            }
            while (pre < last && !isOdd(array[last])) {
                last--;
            }
            if (pre < last) {
                int temp = array[pre];
                array[pre] = array[last];
                array[last] = temp;
            }
        }
    }

    private static boolean isOdd(int num) {

        return (num & 1) == 1;
    }

    /**
     * 错误记录
     * @param array
     */
    public static void reorderArray4(int [] array) {
        if(array == null || array.length <2){
            return;
        }
        int i = 0;
        int j = 0;
        int n = array.length;
        while(j<n){
            if((array[i] & 1) == 1){
                // 奇数 i++;j++
                i++;
                j++;
            }else{
                while(j<n){
                    if((array[j] & 1) == 0){
                        // j 是偶数
                        j++;
                    }else{
                        break;
                    }
                }
                if(j<n){
                    swap(array,i,j);
                    i++;
                }
            }

        }
    }
}
