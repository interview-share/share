package offer.common;

/**
 * @author LRK
 * @project_name Offer
 * @package_name common
 * @date 2019/1/30 19:36
 * @description God Bless, No Bug!
 *  二叉树
 */
public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode parent;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
    public BinaryTreeNode(int value){
        this.value = value;
    }
    public BinaryTreeNode(){}
}
