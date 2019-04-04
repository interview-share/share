package algorithm.stack_and_queue;

import java.util.Stack;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name stack_and_queue
 * @date 2019/3/10 23:31
 * @description God Bless, No Bug!
 *
 * 逆波兰表达式求值 后缀表达式
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 */
public class _09EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        int n = tokens.length;
        for (int i = 0; i < n; i++) {

            try {
                int num = Integer.parseInt(tokens[i]);
                nums.push(num);
            }catch (Exception e){ // 转换失败就是运算符
                int num2 = nums.pop();
                int num1 = nums.pop();
                switch (tokens[i]){
                    case "+":
                        nums.push(num1+num2);
                        break;
                    case "-":
                        nums.push(num1-num2);
                        break;
                    case "*":
                        nums.push(num1*num2);
                        break;
                    case "/":
                        nums.push(num1/num2);
                        break;
                }
            }
        }
        return nums.pop();
    }
}
