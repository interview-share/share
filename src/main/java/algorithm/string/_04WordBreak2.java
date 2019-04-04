package algorithm.string;

import java.util.*;

/**
 * @author LRK
 * @project_name LeeCode
 * @package_name string
 * @date 2019/3/4 0:50
 * @description God Bless, No Bug!
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */
public class _04WordBreak2 {

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        ArrayList<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaa";
//        ArrayList<String> wordDict = new ArrayList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa"));

        System.out.println(new _04WordBreak2().wordBreak(s, wordDict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        helper(s, wordDict, builder, res);
        return res;
    }

    private void helper(String s, List<String> wordDict, StringBuilder builder, List<String> m) {
//        boolean flag = true;
        if (s.length() == 0) { // 已全部扫描完
            String line = builder.substring(0, builder.length() - 1);
            m.add(line);
            return;
        }
        // ** 先判断是否能完全拆分
        if (!new _03WordBreak().wordBreak(s,wordDict)) return;
        for (String word : wordDict) {
            if ( word.length()<=s.length() && word.equals(s.substring(0, word.length()))) {

                builder.append(word).append(" ");
                helper(s.substring(word.length()), wordDict, builder, m);
                builder.delete(builder.length() - word.length() - 1, builder.length());
            }
        }
    }

}
