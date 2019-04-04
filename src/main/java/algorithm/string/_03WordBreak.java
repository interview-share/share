package algorithm.string;

import java.util.ArrayList;
import java.util.List;

class _03WordBreak {
    public static void main(String[] args) {
        String s = "aaaaaaa";
//        String s = "leetcode";
        List<String> wordList = new ArrayList<>();
//        wordList.add("leet");
//        wordList.add("code");
//        wordList.add("a");
//        wordList.add("aa");
        wordList.add("aaa");
        wordList.add("aaaa");
        System.out.println(new _03WordBreak().wordBreak(s, wordList));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        //res[i]表示前i个字符能不能被dict完美划分
        boolean[] res = new boolean[len+1];
        res[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j =0; j < i;j++){
                if (res[j] && wordDict.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }

}