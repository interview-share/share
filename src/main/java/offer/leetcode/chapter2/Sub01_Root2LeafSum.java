package offer.leetcode.chapter2;

import common.TreeNode;
import offer.common.BinaryTreeUtil;

import java.util.ArrayList;

/**
 * @author LRK
 * @project_name Offer
 * @package_name leetcode.chapter2
 * @date 2019/2/16 22:55
 * @description God Bless, No Bug!
 *
 *  打印二叉树的所有路径
 */
public class Sub01_Root2LeafSum {
    public static void main(String[] args) {
        Sub01_Root2LeafSum test = new Sub01_Root2LeafSum();
        TreeNode root = BinaryTreeUtil.constructBinaryTree(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 2, 5, 1, 6, 3, 7});
        System.out.println(test.pathSum(root));

        ArrayList<ArrayList<TreeNode>> paths = test.getPaths(root);
        for (ArrayList<TreeNode> path : paths) {
            for (TreeNode node : path) {
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }

    /**
     * 打印二叉树的所有路径
     * @param root 根节点
     * @return 路径集
     */
    public ArrayList<ArrayList<TreeNode>> getPaths(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();
        if (root == null) return result;
        ArrayList<TreeNode> temp = new ArrayList<>();
        if (root.left == null && root.right == null) {
            temp.add(root);
            result.add(temp);
            return result;
        }
        preOrderTreePath(root, result, temp);
        return result;
    }

    private void preOrderTreePath(TreeNode root, ArrayList<ArrayList<TreeNode>> result, ArrayList<TreeNode> temp) {
        temp.add(root);
        if (root.left == null && root.right == null) { // 找到一条路径,添加到结果集
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        } else if (root.left == null) { // 只有右子树
            preOrderTreePath(root.right, result, temp);
            temp.remove(temp.size() - 1);
        } else if (root.right == null) { // 只有左子树
            preOrderTreePath(root.left, result, temp);
            temp.remove(temp.size() - 1);
        } else { // 左右子树均有
            preOrderTreePath(root.left, result, temp);
            preOrderTreePath(root.right, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 求路径和
     * @param root
     * @return
     */
    public int pathSum(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return preOrderTreeSum(root, sum);
    }
    private int preOrderTreeSum(TreeNode root, int sum) {

        if (root == null) return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return preOrderTreeSum(root.left, sum) + preOrderTreeSum(root.right, sum);
    }
}
