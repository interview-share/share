package offer.sword2offer.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/8 21:24
 * @description God Bless, No Bug!
 *
 * 第一个只出现一次的字符
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * 解法1
 * 使用HashMap来统计字符出现的次数，因为字符的多少是固定的（大小写字母一共52个），
 * 所以可以认为使用HashMap的空间复杂度为O(1)。该解法时间复杂度为O(n)。
 *
 */
public class Sub50_FirstNotRepeatingChar {
    public static void main(String[] args) {
        Sub50_FirstNotRepeatingChar test = new Sub50_FirstNotRepeatingChar();
        System.out.println(test.FirstNotRepeatingChar("abcedsafjkshkjd"));
    }

    public int FirstNotRepeatingChar(String str) {

        if (str==null || str.length()==0) {
            return -1;
        }
        char[] chars = str.toCharArray();

        Map<Character,Integer> charMap = new HashMap<>();
        for (char c : chars) {

            if (!charMap.containsKey(c)){
                charMap.put(c,1);
            }else {
                charMap.put(c,charMap.get(c)+1);
            }
        }
        for (int i = 0; i < chars.length; i++) {

            if (charMap.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }
    private StringBuilder builder = new StringBuilder();
    Map<Character,Integer> charMap = new HashMap<>();
    public void Insert(char ch)
    {
        builder.append(ch);
        charMap.put(ch,charMap.getOrDefault(ch,0)+1);
    }
    // 字符流中第一个不重复的字符
    // 题目描述
    //  请实现一个函数用来找出字符流中第一个只出现一次的字符。
    //  例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
    //  当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。如果当前字符流没有存在出现一次的字符，返回#字符。
    public char FirstAppearingOnce()
    {
        for (int i = 0; i < builder.length(); i++) {
            if (charMap.get(builder.charAt(i))==1){
                return builder.charAt(i);
            }
        }
        return '#';
    }
}
