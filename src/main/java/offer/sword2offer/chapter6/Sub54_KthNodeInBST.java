package offer.sword2offer.chapter6;

import common.TreeNode;

import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/9 17:31
 * @description God Bless, No Bug!
 */
public class Sub54_KthNodeInBST {
    public static void main(String[] args) {
        Sub54_KthNodeInBST test = new Sub54_KthNodeInBST();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        System.out.println(test.KthNode(node2, 2).val);

    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        TreeNode result = null;
        if (pRoot == null || k<0) return result;
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        TreeNode cur = pRoot;
        while (cur!=null || !stack.empty()){

            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.empty()){
                TreeNode temp = stack.pop();
                if (++index == k){
                    result = temp;
                    break;
                }
                cur = temp.right;
            }
        }
        return result;
    }
}
