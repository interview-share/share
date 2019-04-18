package offer.sword2offer.chapter4;

import common.TreeNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/5 19:40
 * @description God Bless, No Bug!
 */
public class Sub37_SerializeBinaryTree {

    public String Serialize(TreeNode root) {

        StringBuilder result = new StringBuilder();
        if (root == null) return result.toString();
        serializeHelper(root, result);
        result.deleteCharAt(result.lastIndexOf(","));
        return result.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder result) {

        if (root == null) {
            result.append("#");
            result.append(",");
            return;
        }
        result.append(root.val);
        result.append(",");
        serializeHelper(root.left, result);
        serializeHelper(root.right, result);
    }

    private int index = -1;

    public TreeNode Deserialize(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] treeNodeStr = str.split(",");
        return deserializeHelper(treeNodeStr);
    }

    private TreeNode deserializeHelper(String[] treeNodeStr) {

        index++;
        TreeNode node = null;
        if (index < treeNodeStr.length && !"#".equals(treeNodeStr[index])) {

            node = new TreeNode(Integer.valueOf(treeNodeStr[index]));
            node.left = deserializeHelper(treeNodeStr);
            node.right = deserializeHelper(treeNodeStr);
        }
        return node;
    }
}
