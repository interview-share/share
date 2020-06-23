package offer.sword2offer.chapter4;

import common.TreeNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/5 19:40
 * @description God Bless, No Bug!
 *
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树。使用前序遍历实现，空节点使用字符# 表示。
 *
 * 比如有如下二叉树：
 *
 * 	    		1
 * 	    	2	 	3
 * 	    4	  #	 5		6
 *    #	  #	   #   #  #   #
 * 序列化的结果为 1,2,4,#,#,#,3,5,#,#,6,#,#
 *
 * 反序列化的结果为上述二叉树
 *
 * 解法
 * 使用前序遍历进行序列化和反序列化。对格式没有要求，只要序列化得到的结果，再反序列化后能与原树相同即可。
 */
public class Sub37_SerializeBinaryTree {

    public String Serialize(TreeNode root) {

        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        }
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
