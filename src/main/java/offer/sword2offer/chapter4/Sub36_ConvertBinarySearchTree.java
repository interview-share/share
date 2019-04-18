package offer.sword2offer.chapter4;

import common.TreeNode;

import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/5 18:11
 * @description God Bless, No Bug!
 */
public class Sub36_ConvertBinarySearchTree {

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        TreeNode res = null;

        while (cur!=null || !stack.empty()){

            if (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if (pre == null){ //双向链表头结点
                    pre = cur;
                    res = pre;
                }else { // pre是前一节点,cur是当前节点
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
                cur = cur.right;
            }
        }
        return res;
    }
}
