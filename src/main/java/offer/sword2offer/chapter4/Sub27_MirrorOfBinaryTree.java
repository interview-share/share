package offer.sword2offer.chapter4;

import common.TreeNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/3 13:12
 * @description God Bless, No Bug!
 *
 * 二叉树的镜像
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 源二叉树
 *      	8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *
 * 镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 *   递归
 */
public class Sub27_MirrorOfBinaryTree {

    public void mirror(TreeNode root) {

        if (root==null) {
            return;
        }
        if (root.left==null && root.right==null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left!=null){
            mirror(root.left);
        }
        if (root.right!=null){
            mirror(root.right);
        }
    }
}
