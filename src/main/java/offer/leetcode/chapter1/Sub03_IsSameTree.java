package offer.leetcode.chapter1;

import common.TreeNode;
import offer.common.BinaryTreeUtil;

/**
 * @author LRK
 * @project_name Offer
 * @package_name leetcode.chapter1
 * @date 2019/2/16 22:37
 * @description God Bless, No Bug!
 */
public class Sub03_IsSameTree {
    public static void main(String[] args) {
        Sub03_IsSameTree test = new Sub03_IsSameTree();
        TreeNode root1 = BinaryTreeUtil.constructBinaryTree(new int[]{1,3,2},new int[]{3,1,2});
        TreeNode root2 = BinaryTreeUtil.constructBinaryTree(new int[]{1,2,3},new int[]{2,1,3});
        System.out.println(test.isSameTree(root1,root2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q==null) return true;
        if (p==null || q==null) return false;
        if (p.val == q.val) return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        return false;
    }
}
