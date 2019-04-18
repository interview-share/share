package offer.sword2offer.chapter7;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter7
 * @date 2019/2/10 19:31
 * @description God Bless, No Bug!
 *  找出两个节点的最近公共父节点
 */
public class Sub68_CommonParent {
    public static void main(String[] args) {
        Sub68_CommonParent test = new Sub68_CommonParent();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(System.getProperty("java.version"));
        System.out.println(test.getCommonParent(node1, node4, node6).val);
    }

    public TreeNode getCommonParent(TreeNode root, TreeNode node1, TreeNode node2){

        if (root==null||node1==null|| node2==null) return null;
        Deque<TreeNode> path1 = new LinkedList<>();
        Deque<TreeNode> path2 = new LinkedList<>();
        getPath(root,node1,path1);
        getPath(root,node2,path2);
        return commonParent(path1,path2);
    }

    private boolean getPath(TreeNode root, TreeNode node, Deque<TreeNode> path) {

        if (root == node) return true;
        path.addLast(root);
        boolean found = false;
        if (root.left!=null){
            found = getPath(root.left,node,path);
        }
        if (found) return found;
        if (root.right!=null){
            found = getPath(root.right,node,path);
        }
        if (!found){
            path.removeLast();
        }
        return found;
    }

    private TreeNode commonParent(Deque<TreeNode> path1, Deque<TreeNode> path2) {
        if (path1==null || path2==null) return null;
        TreeNode node1 = path1.getFirst();
        TreeNode node2 = path2.getFirst();
        TreeNode result = node1==node2?node1:null;
        while (node1==node2){
            result = path1.removeFirst();
            path2.removeFirst();
            if (path1.isEmpty()|| path2.isEmpty()){
                break;
            }
            node1 = path1.getFirst();
            node2 = path2.getFirst();
        }
        return result;
    }
}
