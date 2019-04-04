package algorithm.tree;

import common.TreeNode;
import common.TreeUtil;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.tree
 * @date 2019/3/13 19:03
 * @description God Bless, No Bug!
 *
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class _01kthSmallest {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinaryTree(new int[]{1,2,4,5,3,6,7},new int[]{4,2,5,1,6,3,7});
        System.out.println(new _01kthSmallest().kthSmallest(root, 3));
    }

    public int kthSmallest(TreeNode root, int k) {

        TreeNode node = root.left;
        if (getSize(node)!=k-1){
            int size = getSize(node);
            if (size>k-1){
                return kthSmallest(root.left,k);
            }else {
                return kthSmallest(root.right,k-size-1);
            }
        }else {
            return root.val;
        }
    }

    private int getSize(TreeNode root) {

        if (root == null) return 0;

        return getSize(root.left)+getSize(root.right)+1;
    }
}
