package tencent.array;

/**
 * @author LRK
 * @date 2019/4/12 20:49
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class _09ReverseWords {

    public String reverseWords(String s) {
        if (s.isEmpty()){
            return s;
        }
        String[] split = s.split(" +");
        for (int i = 0; i < split.length; i++) {
            split[i] = reverse(split[i].toCharArray());
        }
        return String.join(" ",split);
    }
    private String reverse(char[] chars){
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char tmp = chars[i];
            chars[i]= chars[n-1-i];
            chars[n-1-i] = tmp;
        }
        return new String(chars);
    }
}
