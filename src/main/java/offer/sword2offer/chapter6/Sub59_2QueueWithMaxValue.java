package offer.sword2offer.chapter6;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/9 22:17
 * @description God Bless, No Bug!
 *
 * 利用双向队列构造含最大值的队列
 */
public class Sub59_2QueueWithMaxValue {
    public static void main(String[] args) {
        QueueWithMaxValue queue = new QueueWithMaxValue();
        queue.push(2);
        System.out.println(queue.getMax());
        queue.push(1);
        queue.pop();
        System.out.println(queue.getMax());
        queue.push(3);
        queue.push(9);
        queue.push(2);
        queue.push(8);


    }

}

class QueueWithMaxValue{

    private Queue<Integer> queue = new LinkedList<>();
    private Deque<Integer> maxValue = new LinkedList<>();
    public void push(Integer num){
        while (!maxValue.isEmpty() && num>=maxValue.getLast()){
            maxValue.removeLast();
        }
        queue.offer(num);
        maxValue.addLast(num);
    }
    public Integer pop(){
        if (!queue.isEmpty()){
            if (queue.peek().equals(maxValue.getFirst())){
                maxValue.removeFirst();
            }
        }
        return queue.poll();
    }
    public Integer getMax(){

        return maxValue.getFirst();
    }
}
