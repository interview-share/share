package common;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name common
 * @date 2019/3/13 19:16
 * @description God Bless, No Bug!
 */
public class TreeUtil {

    public static TreeNode constructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length!=in.length){
            return null;
        }
        int n = pre.length;
        return constructBinaryTreeCore(pre,0,n-1,in,0,n-1);

    }

    private static TreeNode constructBinaryTreeCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        TreeNode root = new TreeNode(pre[startPre]);
        // 判断是否结束,只有一个节点时结束
        if (startPre == endPre){
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
