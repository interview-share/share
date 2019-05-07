package algorithm.graph;

import java.util.*;

/**
 * @author LRK
 * @date 2019/4/4 20:32
 * @project_name LeetCode
 * @package_name algorithm.graph
 * @description:
 * God Bless, No Bug!
 *
 *  单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 *   每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class _01LadderLength {

    public static void main(String[] args) {

        System.out.println(new _01LadderLength().ladderLength(
                "hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    /**
     * 带行号层序遍历的思想:
     *  beginWord先入队列,将beginWord 能一次转换到的 未标记过的 word 加入队列
     *      (防止重复访问,mark[]数组用于标识访问过的word)
     *  当endWord入队时,当前层数即为需要转换的最少次数
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)){
            return 0;
        }
        int cnt=0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean[] mark = new boolean[wordList.size()+1];
        int layer = 1;
        while (!queue.isEmpty()){
            layer++;
            int size = queue.size();
            while (size-->0){
                String cur = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (mark[i]){continue;}
                    String dic = wordList.get(i);
                    if (canTransfer(dic,cur)){
                        if (dic.equals(endWord)){
                            return layer;
                        }
                        queue.offer(dic);
                        mark[i] = true;
                    }
                }
            }
        }

        return cnt;
    }


    /**
     * 判断两个单词是否能一次转换
     * @param begin
     * @param end
     * @return
     */
    private boolean canTransfer(String begin,String end){
        int n = begin.length();
        if (n!=end.length()){
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (begin.charAt(i)!=end.charAt(i)){
                cnt++;
                if (cnt>1){
                    return false;
                }
            }
        }
        return cnt==1;
    }
}
