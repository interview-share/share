package algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name string
 * @date 2019/3/8 23:42
 * @description God Bless, No Bug!
 *
 * 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * 提示:
 *
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。
 * 什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？
 * 如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 */
public class _06FindWords {
    public static void main(String[] args) {

        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        System.out.println(new _06FindWords().findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>(); // 结果集
        _05Trie2 trie = new _05Trie2(); // 前缀树
        for (String word : words) {
            trie.insert(word);
        }
        StringBuilder line = new StringBuilder(); // 当前路径
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                helper(board, rows, cols,i,j,trie,words,line,list,visited);
            }
        }
        return list;
    }

    private void helper(char[][] board, int rows, int cols, int curRow, int curCol,
                        _05Trie2 trie, String[] words, StringBuilder line, List<String> list, boolean[][] visited) {
        // 找到匹配的单词
        if (trie.search(line.toString()) && !list.contains(line.toString())){
            list.add(new String(line));
        }

        if ( curRow>=0 && curRow<rows && curCol>=0 && curCol<cols && !visited[curRow][curCol]){ // 没有出界
            char cur = board[curRow][curCol];

            line.append(cur); // 添加当前节点
            visited[curRow][curCol] =true;
            if (trie.startsWith(line.toString())){ // 判断是否有以当前line为前缀的单词,如果有,继续判断四周节点
                helper(board, rows, cols, curRow+1, curCol, trie, words, line, list, visited);
                helper(board, rows, cols, curRow-1, curCol, trie, words, line, list, visited);
                helper(board, rows, cols, curRow, curCol+1, trie, words, line, list, visited);
                helper(board, rows, cols, curRow, curCol-1, trie, words, line, list, visited);
            }
            // 回溯
            line.deleteCharAt(line.length()-1);
            visited[curRow][curCol] = false;
        }
    }
}
