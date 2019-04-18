package offer.algorithm;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LRK
 * @project_name Offer
 * @package_name algorithm
 * @date 2019/4/3 13:09
 * @description God Bless, No Bug!
 */
public class MinValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6= new TreeNode(6);
        TreeNode node1= new TreeNode(1);
        TreeNode node3= new TreeNode(3);
        root.left = node2;
        root.right = node6;
        node2.left = node1;
        node2.right = node3;
        System.out.println(new MinValue().getMinValue(root));
    }

    /**
     * 层序遍历,加入队列时判断差值,记录最小值
     * @param root
     * @return
     */
    public int getMinValue(TreeNode root){
        if (root == null) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            if (p.left!=null){
                queue.offer(p.left);
                int dif = p.val - p.left.val;
                if (dif < min){
                    min = dif;
                }
            }
            if(p.right!=null){
                queue.offer(p.right);
                int dif = p.right.val - p.val;
                if (dif < min){
                    min = dif;
                }
            }
        }
        return min;
    }
}
