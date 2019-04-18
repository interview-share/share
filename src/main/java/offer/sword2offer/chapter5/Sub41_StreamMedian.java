package offer.sword2offer.chapter5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/6 20:56
 * @description God Bless, No Bug!
 */
public class Sub41_StreamMedian {
    public static void main(String[] args) {
        Sub41_StreamMedian test = new Sub41_StreamMedian();
        test.Insert(1);
        test.Insert(2);
        System.out.println(test.GetMedian());
    }

    // 大根堆
    private PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
    // 小根堆
    private PriorityQueue<Integer> min = new PriorityQueue<>();

    /**
     * 确保大小根堆数目相差不超过1
     * @param num
     */
    public void Insert(Integer num) {

        if (max.isEmpty() || num < max.peek()) { // num比大根堆最大值小,插入到前面的大根堆
            max.offer(num);
            if (max.size() - min.size() > 1) {
                min.offer(max.poll());
            }
        } else {
            min.offer(num);
            if (min.size() - max.size() > 1) {
                max.offer(min.poll());
            }
        }
    }

    public Double GetMedian() {
        int sizeMax = max.size();
        int sizeMin = min.size();

        if (sizeMax > sizeMin) { // 大根堆size较大
            return (double)max.peek();
        }
        if (sizeMin > sizeMax) { // 小根堆size较大
            return (double)(min.peek());
        }
        return ((max.peek() + min.peek()) / 2.0);
    }
}
