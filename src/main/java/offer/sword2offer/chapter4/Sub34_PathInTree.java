package offer.sword2offer.chapter4;

import common.TreeNode;

import java.util.ArrayList;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/4 16:34
 * @description God Bless, No Bug!
 */
public class Sub34_PathInTree {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        findPath(root,target,new ArrayList<Integer>());
        return result;
    }

    private void findPath(TreeNode root, int target, ArrayList<Integer> list) {

        if (root==null) return;
        list.add(root.val);
        target -=root.val;

        if (target ==0 && root.left==null && root.right==null){

            result.add(new ArrayList<Integer>(list));
        }else {
            findPath(root.left,target,list);
            findPath(root.right,target,list);
        }
        list.remove(list.size()-1);
    }
}
