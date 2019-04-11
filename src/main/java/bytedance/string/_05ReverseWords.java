package bytedance.string;

/**
 * @author LRK
 * @date 2019/4/6 14:30
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class _05ReverseWords {

    public static void main(String[] args) {

        System.out.println("a b c  d e".split(" +").length);
    }
    public String reverseWords(String s) {

        String[] split = s.split(" +");
        int n = split.length;
        for (int i = 0; i < (n>>1); i++) {
            String tmp = split[i];
            split[i] = split[n-1-i];
            split[n-1-i] = tmp;
        }
        return String.join(" ",split).trim();
    }
}
