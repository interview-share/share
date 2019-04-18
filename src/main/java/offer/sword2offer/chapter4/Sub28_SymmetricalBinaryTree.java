package offer.sword2offer.chapter4;

import common.TreeNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/3 13:34
 * @description God Bless, No Bug!
 *
 * 对称的二叉树
 * 题目描述
 *  请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 解法
 *  递归
 *  比较二叉树的前序遍历序列和对称前序遍历序列是否一样，若是，说明是对称的。
 */
public class Sub28_SymmetricalBinaryTree {

    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot,pRoot);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {

        if (root1==null && root2==null) {
            return true;
        }
        if (root1==null || root2==null) {
            return false;
        }
        if (root1.val!=root2.val){
            return false;
        }
        return isSymmetrical(root1.left,root2.right)&&isSymmetrical(root2.left,root1.right);
    }
}