package offer.sword2offer.chapter4;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/3 15:02
 * @description God Bless, No Bug!
 *
 * 包含min函数的栈
 * 题目描述
 *  定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O(1)）。
 *
 * 解法
 * 定义两个stack。
 *
 * 压栈时，先将元素node压入stack1。然后判断stack2的情况：
 *
 * stack2栈为空或者栈顶元素大于node，则将node压入stack2中。
 * stack2栈不为空且栈顶元素小于node，则重复压入栈顶元素。
 * 获取最小元素时，从stack2中获取栈顶元素即可。
 */
public class Sub30_MinInStack {
    public static void main(String[] args) {

        System.out.println(new Stack<Integer>().pop());
        /*Integer a = 127,b=127;
        Integer c = 128,d=128;
        System.out.println(a==b); // true
        System.out.println(c==d); // false*/
    }

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        // min栈为空或有新的最小值
        if (min.empty() || node<=min.peek() ){
            min.push(node);
        }else {
            min.push(min.peek());
        }
    }

    public Integer pop() {
        if (!stack.empty()){
            // 包装类型的比较尽量使用equals,虽然Integer会缓存[-128,127]
            min.pop();
            return stack.pop();
        }
        throw new EmptyStackException();
    }

    public int top() {
        if (!stack.empty()){

           return min.peek();
        }
        throw new EmptyStackException();
    }

    public int min() {
        if (!min.empty()){

            return min.peek();
        }
        throw new EmptyStackException();
    }

}
