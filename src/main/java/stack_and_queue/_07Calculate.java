package stack_and_queue;

import java.util.Stack;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name stack_and_queue
 * @date 2019/3/10 21:55
 * @description God Bless, No Bug!
 *
 * 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class _07Calculate {

    public static void main(String[] args) {
        System.out.println(new _07Calculate().calculate("3+15/2*2"));
    }

    /**
     * 利用中缀表达式转后缀表达式: 栈顶的优先级高则弹出
     * 如果遇到运算符+、-、*、/：
     *
     * 先判断栈是否为空。
     *  若是，则直接将此运算符压入栈。
     *  若不是，则查看当前栈顶元素。
     *      若栈顶元素优先级大于或等于此操作符级别，则弹出栈顶元素，将栈顶元素添加到后缀表达式中，并继续进行上述判断。
     *      如果不满足上述判断或者栈为空，将这个运算符入栈。要注意的是，经过上述步骤，这个运算符最终一定会入栈。
     * @param s
     * @return
     */
    public int calculate(String s) {
        s = s.replace(" ","");
        Stack<Integer> nums = new Stack<>();
        Stack<Character> cal = new Stack<>();
        int index = 0,len = s.length();
        while (index<=len-1){
            char symbol = s.charAt(index);
            if (symbol>='0' && symbol<='9'){ // 操作数直接圧栈
                int calNum = symbol -'0';
                while (index+1<len &&s.charAt(index+1)>='0'&&s.charAt(index+1)<='9'){
                    calNum = calNum*10+(s.charAt(++index)-'0');
                }
                nums.push(calNum);
            }
            if (symbol=='+' || symbol=='-'){ // 如果栈顶也是'+'或'-',先取出栈顶数据计算,将结果圧栈再继续判断栈顶

                while (!cal.empty() && (cal.peek()=='+'||cal.peek()=='-')){
                    switch (cal.pop()){
                        case '+':
                            nums.push(nums.pop()+nums.pop());
                            break;
                        case '-':
                            int num1 = nums.pop();
                            int num2 = nums.pop();
                            nums.push(num2-num1);
                            break;

                    }
                }
                cal.push(symbol);
            }
            if (symbol=='*' || symbol=='/'){ // 取出数据计算结果再圧栈

                int num1 = nums.pop();
                int num2 = s.charAt(++index) -'0';
                while (index+1<len &&s.charAt(index+1)>='0'&&s.charAt(index+1)<='9'){
                    num2 = num2*10+(s.charAt(++index)-'0');
                }
                switch (symbol){
                    case '*':
                        nums.push(num1*num2);
                        break;
                    case '/':
                        nums.push(num1/num2);
                        break;
                }
            }
            index++;
        }

        if (!cal.empty()){
            int num2 = nums.pop();
            int num1 = nums.pop();
            switch (cal.pop()){
                case '+':
                    return num1+num2;
                case '-':
                    return num1-num2;
            }
        }
        return nums.pop();
    }
}
