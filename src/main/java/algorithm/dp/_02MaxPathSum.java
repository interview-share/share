package algorithm.dp;

import common.TreeNode;
import common.TreeUtil;

import java.util.Stack;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.dp
 * @date 2019/3/29 0:19
 * @description God Bless, No Bug!
 *
 * 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */
public class _02MaxPathSum {

    public static void main(String[] args) {

        int[] pre = {1,2,4,-5,3,6,7};
        int[] in = {4,2,-5,1,6,3,7};
        TreeNode root = TreeUtil.constructBinaryTree(pre, in);
        int max = new _02MaxPathSum().maxPathSum(root);
        System.out.println(max);

    }

    int ret = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {

        findMax(root);
        return ret;
    }

    /**
     * 单边路径的最大值
     * @param root
     * @return
     */
    private int findMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0,findMax(root.left));
        int right = Math.max(0,findMax(root.right));
        ret = Math.max(ret,left+right+root.val);
        return Math.max(left,right)+root.val;
    }

    /**
     * 构造一棵同样形状的树,节点的值表示==> 以该节点为根的最大路径和
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {

        transfer2Max(root);

        int max = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null || !stack.empty()){

            while (node!=null){
                max = Math.max(max,getMax(node));
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()){
                node = stack.pop().right;
            }
        }
        return max;
    }

    private int getMax(TreeNode root) {
        if (root==null) return 0;

        if (root.left!=null && root.right!=null){ // 左右均不为空
            if (Math.min(root.left.val,root.right.val)<=0){
                return root.val;
            }
            return root.val+Math.min(root.left.val,root.right.val);
        }
        return root.val;
    }

    /**
     * 每个节点的值是以单边路径的最大值
     * @param root
     * @return
     */
    private int transfer2Max(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null && root.right==null) return root.val;

        if (root.left==null){ // 仅右不空
            int right = transfer2Max(root.right);
            root.val = root.right.val>0?root.val+ right :root.val;
            return root.val;
        }
        if (root.right==null){ // 仅左不空
            int left = transfer2Max(root.left);
            root.val = left>0?root.val+left:root.val;
            return root.val;
        }
        // 左右均不为空
        int left = transfer2Max(root.left);
        int right = transfer2Max(root.right);
        if (left<=0 && right<=0){
            return root.val;
        }
        root.val = root.val+ Math.max(left, right);
        return root.val;
    }
}
