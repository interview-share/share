package offer.sword2offer.chapter2;


import offer.common.BinaryTreeNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/31 0:06
 * @description God Bless, No Bug!
 *
 * 找出二叉树前序遍历中给定节点pNode的下一节点
 */
public class Sub08_NextNodeInBinaryTree {
    public static void main(String[] args) {

        BinaryTreeNode node = new BinaryTreeNode();
        BinaryTreeNode next = nextNodeInBinaryTree(node);
    }

    /**
     * 找出二叉树前序遍历中给定节点pNode的下一节点
     *    1 如果pNode有右子树,则右子树的最左节点就是下一节点
     *    2 如果pNode没有右子树
     *    则一直向上寻找父节点,直到找到满足条件的第一个父节点,该节点是其父节点的左孩子
     *    如果找到根节点还没找到满足条件的节点,则不存在下一节点
     *
     * @param node
     * @return
     */
    private static BinaryTreeNode nextNodeInBinaryTree(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.rightChild != null) {
            BinaryTreeNode temp = node.rightChild;
            while (temp.leftChild != null) {
                temp = temp.leftChild;
            }
            return temp;
        } else {
            while (node.parent != null) {
                if (node == node.parent.leftChild) {
                    return node.parent;
                }
                node = node.parent;
            }
        }
        return null;
    }
}
