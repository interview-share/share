package algorithm.tree;

import common.TreeNode;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.tree
 * @date 2019/3/13 19:51
 * @description God Bless, No Bug!
 */
public class _02LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 递归
         */
        if (root==null) return root;
        if (root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left!=null && right!=null){
            return root;
        }else if (left!=null){
            return left;
        }else if (right!=null){
            return right;
        }
        return null;
    }
}
