package offer.sword2offer.chapter2;

import offer.common.BinaryTreeNode;
import offer.common.BinaryTreeUtil;

import java.util.ArrayList;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/30 19:35
 * @description God Bless, No Bug!
 *
 * 根据前序遍历和中序遍历序列重建二叉树
 */
public class Sub07_ReconstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        BinaryTreeNode root = constructBinaryTree(pre,in);
        ArrayList<BinaryTreeNode> list = BinaryTreeUtil.levelTraverse(root);
        for (BinaryTreeNode node : list) {
            System.out.print(node.val +" ");
        }
    }

    private static BinaryTreeNode constructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length!=in.length){
            return null;
        }
        int n = pre.length;
        return constructBinaryTreeCore(pre,0,n-1,in,0,n-1);

    }

    private static BinaryTreeNode constructBinaryTreeCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        BinaryTreeNode root = new BinaryTreeNode(pre[startPre]);
        if (startPre == endPre){ // 判断是否结束,只有一个节点时结束
            if (startIn == endIn){
                return root;
            }
            throw new IllegalArgumentException("Invalid Input!");
        }
        // 找到根节点在中序遍历中的位置
        int inOrder = startIn;
        while (in[inOrder]!= pre[startPre]){
            ++inOrder;
            if (inOrder > endIn){
                throw new IllegalArgumentException("Invalid Input!");
            }
        }
        int len = inOrder - startIn;
        if (len > 0){
            // 构建左子树
            root.left = constructBinaryTreeCore(pre,startPre+1,startPre+len,in,startIn,inOrder-1);
        }
        if (inOrder < endIn){
            // 构建右子树
            root.right = constructBinaryTreeCore(pre,startPre+len+1,endPre,in,inOrder+1,endIn);
        }
        return root;
    }

}
