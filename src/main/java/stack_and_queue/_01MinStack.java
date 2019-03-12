package stack_and_queue;

import java.util.Stack;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name stack_and_queue
 * @date 2019/3/9 22:00
 * @description God Bless, No Bug!
 */
public class _01MinStack {


    class MinStack{

        Stack<Integer> stack;
        Stack<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {

            if (stack.empty() || x<min.peek()){
                min.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            if (!stack.empty()){
                int tmp = stack.pop();
                if (tmp == min.peek()){
                    min.pop();
                }
                stack.pop();
            }
        }

        public int top() {

            return stack.peek();
        }

        public int getMin() {

            return min.peek();
        }
    }
}
