package bytedance.linkedlist;

import common.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LRK
 * @date 2019/4/11 18:46
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *   例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class _06ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int level = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            level++;
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                // 奇数行,从左到右打印,从头部取,尾部插,先左后右
                if ((level & 1)==1) {

                    TreeNode node = deque.removeFirst();
                    list.add(node.val);
                    if (node.left!=null){
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                }
                // 偶数行从右到左打印,从尾部取,头部插,先右后左
                else {
                    TreeNode node = deque.removeLast();
                    list.add(node.val);
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left!=null){
                        deque.addFirst(node.left);
                    }

                }
            }
            res.add(list);
        }
        return res;
    }
}
