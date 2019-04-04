package algorithm.tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.tree
 * @date 2019/3/13 21:14
 * @description God Bless, No Bug!
 *
 * 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class _03Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root==null){
            return "null";
        }else {
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode cur = queue.poll();
                if (cur.val==-1){
                    builder.append("null,");
                }else {
                    builder.append(cur.val+",");
                }
                if (cur.val!=-1){
                    if (cur.left!=null){
                        queue.offer(cur.left);
                    }else {
                        queue.offer(new TreeNode(-1));
                    }
                    if (cur.right!=null){
                        queue.offer(cur.right);
                    }else {
                        queue.offer(new TreeNode(-1));
                    }
                }
            }
        }
        return builder.substring(0,builder.length()-1);
    }


    public String serialize2(TreeNode root) {

        if (root == null){
            return "null,";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(root.val+",");
        builder.append(serialize2(root.left));
        builder.append(serialize2(root.right));
        return builder.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(split));

        return queue2Tree(queue);
    }

    private TreeNode queue2Tree(Queue<String> queue) {

        String str = queue.poll();
        if ("null".equals(str)){
            return null;
        }
        TreeNode newHead = new TreeNode(Integer.parseInt(str));
        newHead.left = queue2Tree(queue);
        newHead.right = queue2Tree(queue);
        return newHead;
    }
}
