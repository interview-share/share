package offer.sword2offer.chapter6;

import common.TreeNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/9 18:04
 * @description God Bless, No Bug!
 */
public class Sub55_2BalanceBinaryTree {


    private boolean isBalanced;
    public boolean IsBalanced_Solution2(TreeNode root) {

        if (root==null) return true;
        isBalanced = true;
        getTreeDepth(root);
        return isBalanced;

    }

    private int getTreeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        if (Math.abs(left-right)>1){
            isBalanced = false;
        }
        return 1+Math.max(left,right);

    }


    public boolean IsBalanced_Solution(TreeNode root) {

        if (root == null) return true;

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left-right;
        if (diff>1||diff<-1){
            return false;
        }
        return IsBalanced_Solution(root.left)&& IsBalanced_Solution(root.right);
    }
    public int TreeDepth(TreeNode root) {

        if (root ==null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left>right?left+1:right+1;
    }
}
