package offer.sword2offer.chapter2;


import offer.common.BinaryTreeNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/31 0:06
 * @description God Bless, No Bug!
 *
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Sub08_NextNodeInBinaryTree {
    public static void main(String[] args) {

        BinaryTreeNode node = new BinaryTreeNode();
        BinaryTreeNode next = nextNodeInBinaryTree(node);
    }

    /**
     * 解法
     * 对于结点 pNode：
     *
     *  如果它有右子树，则右子树的最左结点就是它的下一个结点；
     *  如果它没有右子树，判断它与父结点 pNode.next 的位置情况：
     *      如果它是父结点的左孩子，那么父结点 pNode.next 就是它的下一个结点；
     *      如果它是父结点的右孩子，一直向上寻找，直到找到某个结点，它是它父结点的左孩子，那么该父结点就是 pNode 的下一个结点。
     *
     * @param pNode
     * @return
     */
    private static BinaryTreeNode nextNodeInBinaryTree(BinaryTreeNode pNode) {
        if(pNode == null){
            return pNode;
        }
        if(pNode.right != null){
            BinaryTreeNode temp = pNode.right;
            while(temp.left != null){
                temp = temp.left;
            }
            return temp;
        }
        if(pNode.parent != null && pNode == pNode.parent.left){
            return pNode.parent;
        }
        while(pNode.parent != null){
            if(pNode == pNode.parent.left){
                return pNode.parent;
            }
            pNode = pNode.parent;
        }
        return null;
    }
}
