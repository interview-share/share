package offer.sword2offer.chapter2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/31 15:07
 * @description God Bless, No Bug!
 *
 *  用两个队列实现栈
 */
public class Sub09_2StackWithTwoQueues {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }
}

class MyStack{

    /**
     * 从 Queue1 入队
     * 出队时,利用Queue2暂存Queue1的值
     * 将Queue1的最后一个值返回
     * 交换两个队列
     */
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    void push(Integer value){
        queue1.offer(value);
    }
    Integer pop(){
        if (queue1.isEmpty()){
           throw new RuntimeException("Empty Stack!");
        }
        while (queue1.size()>1){
            queue2.offer(queue1.poll());
        }
        Integer val = queue1.poll();

        // 交换两个队列
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return val;
    }




    public void push2(Integer value){
        if (!queue2.isEmpty()){
            queue2.offer(value);
        }else {
            queue1.offer(value);
        }
    }
    public Integer pop2(){
        if (!queue1.isEmpty() && queue2.isEmpty()){
            while (queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else if (queue1.isEmpty() && !queue2.isEmpty()){
            while (queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else {
            throw new RuntimeException("栈为空或内部错误!");
        }
    }
}
