package tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author LRK
 * @date 2019/4/12 19:25
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 *   有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class _06IsValid {
    public static void main(String[] args) {

        char[] chars = {'(',')','[',']','{','}'};
        for (char c : chars) {
            System.out.println(Integer.valueOf(c));
        }
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        int n = s.length();
        List<Character> left = Arrays.asList('[','{','(');
        for (int i = 0; i < n; i++) {

            if (stack.empty()|| left.contains(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                switch (s.charAt(i)){
                    case ']':
                        if (stack.peek().equals('[')){
                            stack.pop();
                        }else {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.peek().equals('{')){
                            stack.pop();
                        }else {
                            return false;
                        }
                        break;
                    case ')':
                        if (stack.peek().equals('(')){
                            stack.pop();
                        }else {
                            return false;
                        }
                        break;
                        default: return false;
                }
            }
        }
        return stack.size()==0;
    }
}
