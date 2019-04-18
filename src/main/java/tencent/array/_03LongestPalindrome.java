package tencent.array;

/**
 * @author LRK
 * @date 2019/4/12 16:22
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class _03LongestPalindrome {


    public String longestPalindrome(String s) {

        if (s==null || s.length()<1){
            return s;
        }
        int n = s.length();
        int start=0,end=0;
        int max = 0;
        for (int i = 0; i < n; i++) {

            int len1 = expandAround(s,i,i);
            int len2 = expandAround(s,i,i+1);
            max = Math.max(len1,len2);
            if (max >end-start){
                start = i-(max-1)/2;
                end = i+max/2;
            }
        }
        return s.substring(start,end+1);
    }

    private int expandAround(String s, int left, int right) {

        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
