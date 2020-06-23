package offer.sword2offer.chapter4;

import common.TreeNode;

import java.util.ArrayList;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/4 16:34
 * @description God Bless, No Bug!
 *
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Sub34_PathInTree {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        findPath(root,target, new ArrayList<>());
        return result;
    }

    private void findPath(TreeNode root, int target, ArrayList<Integer> list) {

        if (root==null) {
            return;
        }
        list.add(root.val);
        target -= root.val;

        if (target ==0 && root.left==null && root.right==null){

            result.add(new ArrayList<>(list));
        }else {
            findPath(root.left,target,list);
            findPath(root.right,target,list);
        }
        list.remove(list.size()-1);
    }
}
