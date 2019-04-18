package offer.algorithm;

import common.TreeNode;
import offer.common.BinaryTreeUtil;

import java.util.Stack;

/**
 * @author LRK
 * @date 2019/4/4 12:57
 * project_name Offer
 * package_name algorithm
 * description God Bless, No Bug!
 *
 * 1. 给定一个二叉搜索树的根结点 root, 返回
 * 树中任意两节点的差的最小值。
 * 示例：
 *  输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意， root 是树结点对象(TreeNode object)，而不是数组。
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *       4
 *      / \
 *      2 6
 *     / \
 *     1 3
 * 最小的差值是 1, 它是节点 1 和节点 2 的差值, 也是节点 3 和
 * 节点 2 的差值。
 */
public class _02MidTraverse {

    public static void main(String[] args) {
        // 生成二叉搜索树
        TreeNode root = BinaryTreeUtil.getBST(new int[]{1,4,5,7,9});
        System.out.println("节点之差的最小值: "+new _02MidTraverse().midTraverse(root));
    }

    /**
     * 中序遍历相邻节点之差的最小值
     * @param root
     * @return
     */
    public int midTraverse(TreeNode root) {
        if (root == null) {
            return -1;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        int pre = -1;
        int min = Integer.MAX_VALUE;
        while (current!=null || !stack.empty()){
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            if (!stack.empty()){
                TreeNode temp = stack.pop();
                if (pre !=-1){
                    int sub = temp.val - pre;
                    if (sub <min){
                        min = sub;
                    }
                    pre = temp.val;
                }else {
                    pre = temp.val;
                }
                current = temp.right;
            }
        }
        return min;
    }
}
