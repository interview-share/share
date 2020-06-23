package offer.sword2offer.chapter5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/6 20:56
 * @description God Bless, No Bug!
 *
 * 数据流中的中位数
 * 题目描述
 * 如何得到一个数据流中的中位数？
 *  如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *  如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *  我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 解法
 * 利用大根堆存放较小的一半元素，小根堆存放较大的一半元素。维持大小堆的元素个数差不超过 1。
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
     * 大根堆存放较小的一半元素，小根堆存放较大的一半元素。
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
        return ((max.peek().intValue() + min.peek().intValue()) / 2.0);
    }
}
