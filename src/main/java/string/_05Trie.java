package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name string
 * @date 2019/3/8 22:43
 * @description God Bless, No Bug!
 */
public class _05Trie {
    List<String> queue = new ArrayList<>();
    public _05Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        queue.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return queue.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        for (String s : queue) {
            if (s.startsWith(prefix))
                return true;
        }
        return false;
    }
}
