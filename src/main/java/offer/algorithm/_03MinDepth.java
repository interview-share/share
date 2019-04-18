package offer.algorithm;

import common.TreeNode;
import offer.common.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LRK
 * @project_name Offer
 * @package_name algorithm
 * @date 2019/4/10 19:17
 * @description God Bless, No Bug!
 *
 *
111. 二叉树的最小深度
题目描述
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

      3
     / \
    9  20
      /  \
     15   7
返回它的最小深度  2.
 */
public class _03MinDepth {

    public static void main(String[] args) {

        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode root = BinaryTreeUtil.constructBinaryTree(pre, in);
        _03MinDepth test = new _03MinDepth();
        int res = test.minDepth(root);
    }

    /**
     * DFS
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        int dfsMinDepth = getDFSMinDepth(root);
        System.out.println("DFS最小深度: " +dfsMinDepth);
        int bfsMinDepth = getBFSMinDepth(root);
        System.out.println("BFS最小深度: " + bfsMinDepth);
        return dfsMinDepth;
    }

    /**
     * BFS  (层序遍历),利用队列实现
     * @param root
     * @return
     */
    private int getBFSMinDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cnt = 0;
        while (!queue.isEmpty()){
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                assert tmp != null;
                if ( tmp.left==null && tmp.right==null){
                    return cnt;
                }
                if (tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if (tmp.right!=null){
                    queue.offer(tmp.right);
                }
            }
        }
        return cnt;
    }

    /**
     * DFS 深度优先遍历,利用递归
     * @param root
     * @return
     */
    private int getDFSMinDepth(TreeNode root) {
        if (root == null){
            return Integer.MAX_VALUE;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        int left = getDFSMinDepth(root.left);
        int right = getDFSMinDepth(root.right);

        return Math.min(left,right)+1;
    }
}
