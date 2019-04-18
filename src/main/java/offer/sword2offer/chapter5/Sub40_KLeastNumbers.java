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
        if (input == null || k > input.length || k <= 0 || input.length == 0) return list;

        PriorityQueue<Integer> result = new PriorityQueue<>(k, Comparator.reverseOrder()); // 创建容量为k的大根堆,默认是小根堆

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
        if (input == null || k > input.length || k <= 0 || input.length == 0) return list;

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = input[i];
        }
        for (int j = k;j<input.length;j++){

            buildMaxHeap(result);
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
    private void buildMaxHeap(int[] array) {

        if (array == null || array.length == 0) return;
        int lastIndex = array.length - 1;

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
        if (input == null || k > input.length || k <= 0 || input.length == 0) return list;

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
