package stack_and_queue;

import java.util.*;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name stack_and_queue
 * @date 2019/3/10 17:44
 * @description God Bless, No Bug!
 *
 * 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class _05TopKFrequent {
    public static void main(String[] args) {

        System.out.println(new _05TopKFrequent().topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }

    /**
     * 使用map保存出现次数,然后利用堆
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        // 小根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparing(map::get));
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxHeap.size()<k){
                maxHeap.offer(entry.getKey());
            }else {
                if (entry.getValue()>map.get(maxHeap.peek())){
                    maxHeap.poll();
                    maxHeap.offer(entry.getKey());
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty()){
            res.add(maxHeap.poll());
        }
        return res;
    }
}
