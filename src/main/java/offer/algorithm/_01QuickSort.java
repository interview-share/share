package offer.algorithm;

import java.util.Arrays;
import java.util.Random;

import static common.SortUtil.swap;

/**
 * @author LRK
 * @project_name Offer
 * @package_name algorithm
 * @date 2019/3/27 22:26
 * @description God Bless, No Bug!
 *
 * 1.实现普通快排算法及其随机划分版本（见课
 * 程 PPT），实验比较两个算法的性能（随机生成
 * 10000-100000 个数字，对其进行排序，分别统
 * 计时间）
 */
@SuppressWarnings("all")
public class _01QuickSort {

    public static void main(String[] args) {

        Random random = new Random();
        int len = random.ints(10000,100001).findFirst().getAsInt();
        int[] arr = random.ints(Integer.MIN_VALUE,Integer.MAX_VALUE).limit(len).toArray();
        int[] copy = Arrays.copyOf(arr,len);
        int[] copy2 = Arrays.copyOf(arr,len);
        System.out.println("随机生成了 "+len+" 个整数");

        System.out.println("========随机顺序数组耗时测试==========");
        long begin = System.currentTimeMillis();
        quickSort(arr,0,len-1);
        long end = System.currentTimeMillis();
        System.out.println("普通快排耗时: "+ (end-begin) +"ms");

        begin = System.currentTimeMillis();
        quickSort2(copy,0,len-1);
        end = System.currentTimeMillis();
        System.out.println("随机快排耗时: "+ (end-begin) +"ms");

        begin = System.currentTimeMillis();
        quickSort3(copy2,0,len-1);
        end = System.currentTimeMillis();
        System.out.println("三数取中耗时: "+ (end-begin) +"ms");

        System.out.println("========初始有序数组耗时测试==========");

        begin = System.currentTimeMillis();
        quickSort(arr,0,len-1);
        end = System.currentTimeMillis();
        System.out.println("普通快排耗时: "+ (end-begin) +"ms");

        begin = System.currentTimeMillis();
        quickSort2(copy,0,len-1);
        end = System.currentTimeMillis();
        System.out.println("随机快排耗时: "+ (end-begin) +"ms");

        begin = System.currentTimeMillis();
        quickSort3(copy2,0,len-1);
        end = System.currentTimeMillis();
        System.out.println("三数取中耗时: "+ (end-begin) +"ms");
    }

    /**
     * 快速排序: 每一趟确定基准在最终序列的位置,即左小右大
     * 选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），
     * 比基准值大的都在右边（一般是无序的）。
     *
     * 平均时间复杂度: O(nlogn) 平均性能最优
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int start = low; // 左哨兵
        int end = high; // 右哨兵
        int base = arr[low]; // 基准

        while (start < end) { // 循环结束找到基准的最终位置
            // 先从右边往左探测,找到第一个小于base的index
            while (base <= arr[end] && start < end) {
                end--;
            }
            // 再从左边往右探测,找到第一个大于base的index
            while (base >= arr[start] && start < end) {
                start++;
            }
            if (start < end) {// 交换找到的两个要交换位置的数
                swap(arr, start, end);
            }
        }
        swap(arr, low, start);
        // 递归排序左右子序列
        quickSort(arr, low, end - 1);
        quickSort(arr, end + 1, high);
    }

    /**
     * 随机选择一个数作为基准
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort2(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int start = low; // 左哨兵
        int end = high; // 右哨兵
        int index = start + (int)(Math.random() * (end - start));
        int base = arr[index]; // 基准
        swap(arr,index,start);

        while (start < end) { // 循环结束找到基准的最终位置
            // 先从右边往左探测,找到第一个小于base的index
            while (base <= arr[end] && start < end) {
                end--;
            }
            // 再从左边往右探测,找到第一个大于base的index
            while (base >= arr[start] && start < end) {
                start++;
            }
            if (start < end) {// 交换找到的两个要交换位置的数
                swap(arr, start, end);
            }
        }
        swap(arr, low, start);
        // 递归排序左右子序列
        quickSort2(arr, low, end - 1);
        quickSort2(arr, end + 1, high);
    }

    /**
     * 三数取中
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort3(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int start = low; // 左哨兵
        int end = high; // 右哨兵

        // 找出left,right,mid中间值与left交换
        dealPivot(arr, start, end);
        int base = arr[start];

        while (start < end) { // 循环结束找到基准的最终位置
            // 先从右边往左探测,找到第一个小于base的index
            while (base <= arr[end] && start < end) {
                end--;
            }
            // 再从左边往右探测,找到第一个大于base的index
            while (base >= arr[start] && start < end) {
                start++;
            }
            if (start < end) {// 交换找到的两个要交换位置的数
                swap(arr, start, end);
            }
        }
        swap(arr, low, start);
        // 递归排序左右子序列
        quickSort3(arr, low, end - 1);
        quickSort3(arr, end + 1, high);
    }

    private static void dealPivot(int[] arr, int left, int right) {

        int mid = (left + right) >> 1;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[right] < arr[mid]) {
            swap(arr, right, mid);
        }
        swap(arr, left, mid);
    }
}
