package stack_and_queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name stack_and_queue
 * @date 2019/3/9 22:40
 * @description God Bless, No Bug!
 *
 * 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class _02FindKthLargest {

    public static void main(String[] args) {
        _02FindKthLargest test = new _02FindKthLargest();
        System.out.println(test.findKthLargest3(new int[]{1, 2, 3, 4, 5, 6}, 2));
        int [] heap = new int[]{1,2,3,4,5,6,7};
        test.buildHeap(heap,heap.length-1);
        System.out.println(Arrays.toString(heap));
    }

    /**
     * 快排思想
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        int start = 0;
        int end = nums.length-1;
        int index = partition(nums,start,end);
        while (k-1!=index){
            if (k-1<index){
                end = index-1;
            }else {
                start = index+1;
            }
            index = partition(nums,start,end);
        }
        return nums[k-1];
    }

    /**
     * 左大右小
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] nums, int low, int high) {
//        if (low == high) return low;
        int index =  low + (int)(Math.random()*(high-low+1));
        swap(nums,low,index);
        int base = nums[low];
        int i = low;
        int j = high;

        while (i<j){
            while (i<j && nums[j]<=base){
                --j;
            }
            while (i<j && nums[i]>=base){
                ++i;
            }
            if (i<j){
                swap(nums,i,j);
            }
        }
        swap(nums,low,j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 大根堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            if (maxHeap.size()<k){
                maxHeap.offer(nums[i]);
            }else {
                if (maxHeap.peek() < nums[i]){
                    maxHeap.poll();
                    maxHeap.offer(nums[i]);
                }
            }
        }
        return maxHeap.poll();
    }
    public int findKthLargest3(int[] nums, int k) {

        int len = nums.length;
        for (int i = 0; i < k; i++) {

            buildHeap(nums,len-1-i);
            swap(nums,0,len-i-1);
        }
        return nums[len-k];
    }

    /**
     * 构建大根堆
     * @param nums
     * @param end
     */
    private void buildHeap(int[] nums,int end){

        // 从最后一个节点的父节点开始
        for(int i = (end-1)/2;i>=0;i--){

            // 当前节点
            int cur = i;
            while (cur*2+1<=end){ // 当前节点有子节点

                int biggerChild = cur*2+1;
                // 判断是否有右子节点
                if (biggerChild<end){ // 有右子节点,并找出较大子节点index
                    biggerChild = nums[biggerChild]>nums[biggerChild+1]?biggerChild:biggerChild+1;
                }
                // 如果父节点比较大子节点小,则与较大子节点交换
                if (nums[cur]<nums[biggerChild]){
                    swap(nums,cur,biggerChild);
                    cur = biggerChild;
                }else {
                    break;
                }
            }
        }
    }
}
