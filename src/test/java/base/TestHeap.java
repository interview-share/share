package base;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name base
 * @date 2019/3/10 1:25
 * @description God Bless, No Bug!
 */
public class TestHeap {

    @Test
    public void test(){

        PriorityQueue<Integer> heap = new PriorityQueue<>((x,y) ->y-x); // 默认小根堆
        for (int i = 0; i < 5; i++) {
            heap.offer(i);
            System.out.println(heap.peek());
        }
    }
}
