package offer.common;

import common.TreeNode;

import java.util.*;

/**
 * @author LRK
 * @project_name Offer
 * @package_name common
 * @date 2019/1/30 20:18
 * @description God Bless, No Bug!
 *
 *  二叉树: 前序遍历 中序遍历 后序遍历的非递归实现 层序遍历 构造二叉树 构造平衡二叉搜索树
 */
public class BinaryTreeUtil {
    /**
     * 前序遍历非递归实现一:
     *  1 输出当前节点p,将其入栈,再看p的左孩子是否为空:
     *  2 若左孩子不为空,则依次输出左子树并入栈,重复直到左孩子为空,
     *  3 左孩子为空,则弹出栈顶结点,并将弹出节点的右孩子作为当前节点判断是否为空
     *  4 若不为空,则循环至1
     *  5 若为空,则继续出栈,同时将出栈节点的右孩子作为当前节点判断是否为空,重复4,5
     *  6 直到当前节点为空并且栈空,遍历结束
     *
     * @param root
     * @return
     */
    public static ArrayList<BinaryTreeNode> preTraverse(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<BinaryTreeNode> list = new ArrayList<>();
        BinaryTreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // 当前节点为空表示所有节点都访问过了
            while (current != null) {
                list.add(current);
                stack.push(current);
                current = current.left;
            }
            // 栈为空表示所有入栈节点的右子树都访问过了
            if (!stack.isEmpty()) {
                BinaryTreeNode temp = stack.pop();
                current = temp.right;
            }
        }
        return list;
    }

    /**
     * 前序遍历非递归实现二:
     *  1 将根节点入栈
     *  2 当栈不为空时开始循环:
     *      1)弹出栈顶结点p,输出弹出的节点,打印节点;
     *      2)先将p.rightChild入栈;
     *      3)再将p.leftChild入栈;
     *
     * @param root
     * @return
     */
    public static ArrayList<BinaryTreeNode> preTraverse2(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<BinaryTreeNode> list = new ArrayList<>();
        stack.push(root);
        BinaryTreeNode node = null;
        while (!stack.empty()) {
            node = stack.pop();
            if (node != null) {
                list.add(node);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }

    /**
     * 中序遍历非递归实现: 和前序实现一类似,只是将打印操作放到出栈时执行
     *   实现思路:
     *      中序遍历是要先遍历左子树，然后根节点，最后遍历右子树。所以需要先把根节点入栈然后再一直把左子树入栈
     *      直到左子树为空，此时停止入栈。栈顶节点就是我们需要访问的节点，取栈顶节点p并访问。然后该节点可能有右子树，所以
     *      访问完节点p后还要判断p的右子树是否为空，如果为空则接下来要访问的节点在栈顶，所以将p赋值为null。如果不为空则
     *      将p赋值为其右子树的值。 循环结束的条件是p不为空或者栈不为空。
     * @param root
     * @return
     */
    public static ArrayList<BinaryTreeNode> midTraverse(BinaryTreeNode root) {

        if (root == null) {
            return null;
        }

        BinaryTreeNode current = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<BinaryTreeNode> list = new ArrayList<>();

        while (current!=null || !stack.empty()){
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            if (!stack.empty()){
                BinaryTreeNode temp = stack.pop();
                list.add(temp);
                current = temp.right;
            }
        }
        return list;
    }

    /**
     * 后序遍历非递归实现:
     *    要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。
     *         如果P不存在左孩子和右孩子，则可以直接访问它；
     *         或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
     *    若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，
     *    左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
     * @param root
     * @return
     */
    public static ArrayList<BinaryTreeNode> afterTraverse(BinaryTreeNode root){

        ArrayList<BinaryTreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current,previous = null;
        stack.push(root);
        while (!stack.empty()){
            current = stack.peek();
            if ((current.left ==null && current.right ==null)
                    || ( (previous == current.right) || (previous== current.left && current.right==null) )){
                // 后一条件也可以写为||(previous!=null &&(previous==current.left || previous == current.right))
                // 如果是叶子节点或者左右子节点均已访问过,则可以出栈并访问
                BinaryTreeNode temp = stack.pop();
                list.add(temp);
                previous = temp;
            }else {
                // 否则将current的右,左子树依次进栈
                if (current.right !=null){
                    stack.push(current.right);
                }
                if (current.left !=null){
                    stack.push(current.left);
                }
            }
        }
        return list;
    }

    /**
     * 层序遍历,借助队列实现
     * @param root
     * @return
     */
    public static ArrayList<BinaryTreeNode> levelTraverse(BinaryTreeNode root){

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        ArrayList<BinaryTreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTreeNode temp = queue.poll();
            list.add(temp);
            if (temp.left !=null){
                queue.offer(temp.left);
            }
            if (temp.right !=null){
                queue.offer(temp.right);
            }
        }
        return list;
    }

    /**
     * 带行号的层序遍历
     * @param root
     * @return
     */
    public static ArrayList<TreeNode> levelTraverseWithLevelNumber(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode curLast=root,nextLast=root;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp);
            System.out.print(temp.val+" ");
            if (temp.left!=null){
                nextLast = temp.left;
                queue.offer(temp.left);
            }
            if (temp.right!=null){
                nextLast = temp.right;
                queue.offer(temp.right);
            }
            // 表明已到达当前行末尾
            if (temp == curLast){
                curLast = nextLast;
                System.out.println();
            }
        }
        return list;
    }

    /**
     * 根据前序和中序序列构建二叉树
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode constructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length!=in.length){
            return null;
        }
        int n = pre.length;
        return constructBinaryTreeCore(pre,0,n-1,in,0,n-1);

    }

    /**
     * 递归构造根节点与左右子节点
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    private static TreeNode constructBinaryTreeCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        TreeNode root = new TreeNode(pre[startPre]);
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

    /**
     * 数组生成二叉搜索树
     * @param nums
     * @return
     */
    public static TreeNode getBST(int[] nums){

        Arrays.sort(nums);
        return getBSTHelper(nums,0,nums.length-1);
    }

    private static TreeNode getBSTHelper(int[] nums, int left, int right) {

        if (right<left){return null;}
        int mid = (left+right)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getBSTHelper(nums,left,mid-1);
        root.right = getBSTHelper(nums,mid+1,right);
        return root;
    }

}
