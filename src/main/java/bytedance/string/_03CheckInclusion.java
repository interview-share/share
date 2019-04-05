package bytedance.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LRK
 * @date 2019/4/5 22:34
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 *  换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class _03CheckInclusion {

    public static void main(String[] args) {
        System.out.println(new _03CheckInclusion().checkInclusion2("ab", "eidboaooa"));

    }
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        int[] check1 = new int[26];
        int[] check2 = new int[26];
        for (int i = 0; i < n1; i++) {
            check1[s1.charAt(i)-'a']++;
            check2[s2.charAt(i)-'a']++;
        }
        if (Arrays.equals(check1,check2)){
            return true;
        }
        for (int i = 0; i < n2-n1; i++) {
            check2[s2.charAt(i)-'a']--;
            check2[s2.charAt(i+n1)-'a']++;
            if (Arrays.equals(check1,check2)){
                return true;
            }

        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length()>s2.length()){
            return false;
        }
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (char c : s1.toCharArray()) {
            list1.add(c);
        }
        for (char c : s2.toCharArray()) {
            list2.add(c);
        }
        int len1 = s1.length();
        int tail = s2.length() - s1.length();
        for (int i = 0; i <= tail; i++) {
            if (list1.containsAll(list2.subList(i,i+len1))){
                return true;
            }
        }
        return false;

    }
}
