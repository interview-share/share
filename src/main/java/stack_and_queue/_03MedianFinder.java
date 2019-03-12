package stack_and_queue;

import java.util.PriorityQueue;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name stack_and_queue
 * @date 2019/3/10 13:48
 * @description God Bless, No Bug!
 */
public class _03MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int size;

    /** initialize your data structure here. */
    public _03MedianFinder() {
        size = 0;
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((x,y) ->y-x);
    }

    public void addNum(int num) {

        if (minHeap.size()<++size/2){ // 最小堆中元素不满一半

            if (num>=maxHeap.peek()){
                minHeap.offer(num);
            }else {
                minHeap.add(maxHeap.poll());
                maxHeap.offer(num);
            }

        }else {
            if (maxHeap.isEmpty() || num<=minHeap.peek()){
                maxHeap.offer(num);
            }else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }

        }
    }

    public double findMedian() {

        if (maxHeap.isEmpty() && minHeap.isEmpty()){
            throw new IllegalArgumentException("No data");
        }
        if (maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        return (minHeap.peek()+maxHeap.peek())/2.0;
    }
}
