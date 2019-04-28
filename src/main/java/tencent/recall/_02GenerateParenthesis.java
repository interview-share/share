package tencent.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name tencent.recall
 * @date 2019/4/28 21:08
 * @description God Bless, No Bug!
 *
 * 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class _02GenerateParenthesis {
    public static void main(String[] args) {

        System.out.println(new _02GenerateParenthesis().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        String line = new String();
        helper(n,n,line,res);
        return res;
    }

    private void helper(int left, int right, String line, List<String> res) {

        if (left<0 || right<0 || left>right){
            return;
        }
        if (left==0 && right==0){
            res.add(new String(line));
            return;
        }

        // 添加 '('或')' 继续递归
        helper(left-1,right,line +'(',res);
        helper(left,right-1,line+')',res);

    }
}
