package offer.common;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name Offer
 * @package_name common
 * @date 2019/1/31 16:41
 * @description God Bless, No Bug!
 */
@SuppressWarnings("all")
public class SortUtil {

    public static void main(String[] args) {
        int[] datas = {5, 6, 2, 1, 3, 8, 9, 7, 4};
        bubbleSort(datas);
//        quickSort(datas,0,datas.length-1);
//        insertSort(datas);
//        shellSort(datas);
//        selectSort(datas);
//        heapSort(datas);
//        mergeSort(datas, 0, datas.length-1);
        System.out.println(Arrays.toString(datas));
    }

    /**
     * 冒泡排序: 每一趟找出未排序序列的最大的值放到未排序序列右边
     * 平均时间复杂度: O(n²)
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) { // 控制循环的次数
            for (int j = 0; j < len - 1 - i; j++) { // 每次循环比较的次数
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    /*temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;*/
                }
            }
        }
    }

    /**
     * 快速排序: 每一趟确定基准在最终序列的位置,即左小右大
     * 选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），
     * 比基准值大的都在右边（一般是无序的）。 一般选择序列的第一个元素。
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
        // 将基准值放到最终位置
        swap(arr, low, start);
        // 递归排序左右子序列
        quickSort(arr, low, end - 1);
        quickSort(arr, end + 1, high);
    }

    /**
     * 直接插入排序: 每一趟将待插入数字插入到有序序列中
     * 平均时间复杂度: O(n²)
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int len = arr.length;
        int temp;
        for (int i = 1; i < len; i++) {
            temp = arr[i]; // 待插入的数
            int j;
            for (j = i - 1; j >= 0; j--) {

                if (arr[j] > temp) { // 如果比temp大,则后移一位
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * 插入排序:
     * 希尔排序: 逐步缩小增量,基于插入排序
     * O（nlogn）～O（n2）
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int inc = arr.length / 2;
        while (inc >= 1) {
            for (int i = inc; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i - inc; j >= 0; j -= inc) {

                    if (arr[j] > temp) { // 插入排序
                        arr[j + inc] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + inc] = temp;
            }
            inc /= 2;
        }
    }

    /**
     * 简单选择排序
     * O（n^2）
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    /**
     * 堆排序
     *  初始构建堆时间复杂度是 O(n),取出最大值后重建堆的时间复杂度为O(logn)
     *  整个过程需要取n-1次堆顶并重建,所以总的时间复杂度为 O(nlogn)
     *  堆排序对原始记录的状态并不敏感,因此它无论是最好、最坏和平均时间复杂度均为O(nlogn)
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            buildMaxHeap(arr, len - 1 - i);
            swap(arr, 0, len - 1 - i);
        }
    }

    /**
     * 构建大根堆
     *  1 从最后一个节点的父节点k开始进行大根堆的构建
     *  2 保存较大子节点的索引biggerChildIndex
     *  3 比较父节点k和较大子节点的大小:
     *       1) 若子节点较大,则交换父子节点,并赋值 k=biggerChildIndex继续子节点的大根堆构建
     *       (因为交换之后可能破坏原本满足大根堆性质的子节点,使其不再满足大根堆)
     *       2) 若父节点较大则继续下次循环
     *
     * @param arr
     * @param lastIndex
     */
    private static void buildMaxHeap(int[] arr, int lastIndex) {

        // 从最后一个节点的父节点开始调整堆
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {

            int cur = i; // 正在判断的节点

            while (cur * 2 + 1 <= lastIndex) { // 如果当前k节点有子节点

                int biggerChildIndex = 2 * cur + 1; // 左节点索引
                if (biggerChildIndex < lastIndex) { // 右子节点存在
                    if (arr[biggerChildIndex] < arr[biggerChildIndex + 1]) {
                        biggerChildIndex++; // 记录较大子节点索引
                    }
                }
                if (arr[cur] < arr[biggerChildIndex]) { // 如果子节点较大
                    swap(arr, cur, biggerChildIndex);
                    cur = biggerChildIndex; // 交换节点位置之后可能破坏子树的大根堆形质,再次进行大根堆构建
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 归并排序,先分组,直到每组只有一个数字,可认为有序,之后合并各有序序列
     * 时间复杂度为O(nlogn)
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void mergeSort(int[] arr, int start, int end) {
        /*if (arr == null || arr.length <= 1) {
            return;
        }*/
        if (start < end) {// 每个分组的个数大于1个,则继续分组,直到每个组只有一个数字结束递归
            int middle = (start + end) >> 1;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }

    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[arr.length];
        int i = left;
        int j = middle + 1;
        int k = left;
        // 归并,[left,middle]和[middle+1,right]均已有序
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 复制回原数组
        for (int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
    }

    /**
     * 交换数组中两个数的位置
     *
     * @param numbers
     * @param a
     * @param b
     */
    public static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
