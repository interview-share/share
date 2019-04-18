package offer.leetcode.chapter1;

import common.TreeNode;
import offer.common.BinaryTreeUtil;

/**
 * @author LRK
 * @project_name Offer
 * @package_name leetcode.chapter1
 * @date 2019/2/16 22:23
 * @description God Bless, No Bug!
 */
public class Sub02_MaxDepth {
    public static void main(String[] args) {

        int[] pre = {1,2,4,8,5,3,6,7};
        int[] in = {8,4,2,5,1,6,3,7};
        TreeNode root = BinaryTreeUtil.constructBinaryTree(pre, in);
        Sub02_MaxDepth test = new Sub02_MaxDepth();
        System.out.println(test.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left==null && root.right==null){
            return 1;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return left>right?left+1:right+1;
    }
}
