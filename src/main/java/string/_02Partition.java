package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @project_name LeeCode
 * @package_name string
 * @date 2019/3/3 22:42
 * @description God Bless, No Bug!
 *
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class _02Partition {

    public static void main(String[] args) {
        System.out.println("abc".substring(0,3));
        System.out.println(new _02Partition().partition("aab"));
    }
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> line = new ArrayList<>();

        helper(s,0,result,line);

        return result;

    }

    public void helper(String s,int start,List<List<String>> result,List<String> line){

        if(start == s.length()){
            result.add(new ArrayList<>(line));
            return;
        }
        for(int i = start; i<s.length();i++){

            if(!isPalindrome(s,start,i)) continue;

            line.add(s.substring(start,i+1));
            helper(s,i+1,result,line);
            line.remove(line.size()-1);
        }
    }

    public boolean isPalindrome(String s,int start,int end) {
        int i = start;
        int j = end;

        while(i<j){

            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
