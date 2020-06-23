package offer.sword2offer.chapter5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/6 19:24
 * @description God Bless, No Bug!
 *
 * 获取数组中最小的k个数
 * 题目描述
 * 输入 n 个整数，找出其中最小的 K 个数。例如输入 4,5,1,6,2,7,3,8 这 8 个数字，则最小的 4 个数字是 1,2,3,4。
 *
 * 解法
 * 解法一
 * 利用快排中的 partition 思想。
 *
 * 数组中有一个数字出现次数超过了数组长度的一半，那么排序后，数组中间的数字一定就是我们要找的数字。
 * 我们随机选一个数字，利用 partition() 函数，使得比选中数字小的数字都排在它左边，比选中数字大的数字都排在它的右边。
 *
 * 判断选中数字的下标 index：
 *
 * 如果 index = k-1，结束循环，返回前 k 个数。
 * 如果 index > k-1，那么接着在 index 的左边进行 partition。
 * 如果 index < k-1，则在 index 的右边继续进行 partition。
 * 注意，这种方法会修改输入的数组。时间复杂度为 O(n)。
 *
 * 解法二
 * 利用大根堆，存储最小的 k 个数，最后返回即可。
 *
 * 此方法时间复杂度为 O(nlogk)。虽然慢一点，但是它不会改变输入的数组，并且它适合海量数据的输入。
 *
 * 假设题目要求从海量的数据中找出最小的 k 个数，由于内存的大小是有限的，有可能不能把这些海量的数据一次性全部载入内存。
 * 这个时候，用这种方法是最合适的。就是说它适合 n 很大并且 k 较小的问题。
 */
public class Sub40_KLeastNumbers {

    public static void main(String[] args) {

        Sub40_KLeastNumbers test = new Sub40_KLeastNumbers();
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(test.GetLeastNumbers_Solution3(data, 4));
    }

    /**
     * 利用系统提供的
     * @param input
     * @param k
     * @return
     */
    private ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k > input.length || k <= 0 || input.length == 0) {
            return list;
        }

        // 创建容量为k的大根堆,默认是小根堆
        PriorityQueue<Integer> result = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int num : input) {

            if (result.size()<k){
                result.offer(num);
            }else {
                if (num < result.peek()){
                   result.poll();
                   result.offer(num);
                }
            }
        }
        list.addAll(result);
        return list;
    }

    /**
     * 自己写构建大根堆的方法
     * @param input
     * @param k
     * @return
     */
    private ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k > input.length || k <= 0 || input.length == 0) {
            return list;
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = input[i];
        }
        for (int j = k;j<input.length;j++){

            buildMaxHeap(result,k-1);
            if (input[j]< result[0]){ // 当前值比大根堆的最大值小,替换最大值
                result[0] = input[j];
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(result[i]);
        }
        return list;
    }

    /**
     * 构建大根堆
     * @param array
     */
    private void buildMaxHeap(int[] array,int lastIndex) {

        if (array == null || array.length == 0) {
            return;
        }

        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i; // k保存当前检查的节点
            while (k * 2 + 1 <= lastIndex) { // 有左子树
                int biggerChildIndex = 2 * i + 1;

                if (biggerChildIndex < lastIndex) { // 有右子树
                    if (array[biggerChildIndex + 1] > array[biggerChildIndex]) {
                        ++biggerChildIndex;
                    }
                }
                if (array[i] < array[biggerChildIndex]) {
                    swap(array, i, biggerChildIndex);
                    k = biggerChildIndex;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 利用快排的方法找到第k个数,前面的数均比k小
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k > input.length || k <= 0 || input.length == 0) {
            return list;
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {

            if (index < k - 1) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private int partition(int[] input, int start, int end) {

        if (start > end) return 0;
        int key = input[start];
        int i = start;
        int j = end;
        while (i < j) {

            while (i < j && input[j] >= key) {
                j--;
            }
            while (i < j && input[i] <= key) {
                i++;
            }
            swap(input, i, j);
        }
        swap(input, start, i);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
