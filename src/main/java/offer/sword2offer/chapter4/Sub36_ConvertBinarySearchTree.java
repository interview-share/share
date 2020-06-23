package offer.sword2offer.chapter4;

import common.TreeNode;

import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/5 18:11
 * @description God Bless, No Bug!
 *
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 解法
 * 由于是二叉搜索树，因此中序遍历的结果就是排序的。
 *
 * 中序遍历利用栈来实现。遍历时，前一个结点的 right 指向后一个结点，后一个结点的 left 指向前一个结点。
 */
public class Sub36_ConvertBinarySearchTree {

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }
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
