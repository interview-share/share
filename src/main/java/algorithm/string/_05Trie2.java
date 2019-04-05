package algorithm.string;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name string
 * @date 2019/3/8 23:02
 * @description God Bless, No Bug!
 *
 * 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class _05Trie2 {

    TrieNode root;
    class TrieNode {
        TrieNode[] child;
        boolean hasWord;
        public TrieNode() {
            child = new TrieNode[26];
            hasWord = false;
        }

        void insert(String word, int index){

            if (index == word.length()){
                // 表明这个节点是某个单词的结尾
                this.hasWord = true;
                return;
            }
            int pos = word.charAt(index) - 'a';
            if (child[pos] == null){
                child[pos] = new TrieNode();
            }
            child[pos].insert(word,index+1);
        }

        TrieNode search(String word, int index){

            if (index == word.length()) {
                return this;
            }
            int pos = word.charAt(index)-'a';
            if (child[pos]!=null){
                return child[pos].search(word,index+1);
            }
            return null;
        }
    }
    public _05Trie2(){
        root = new TrieNode();
    }
    public void insert(String word) {
        root.insert(word,0);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode res = root.search(word, 0);
        return (res!=null && res.hasWord);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode res = root.search(prefix, 0);
        return res!=null;
    }
}
