package offer.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name offer.algorithm
 * @date 2019/4/24 10:12
 * @description God Bless, No Bug!
 */
public class _05RBTreeInsert {

    public static void main(String[] args) {

        int[] nums = new int[]{41, 38, 31, 12, 19, 8};
        RBTree<Integer> rbTree = new RBTree<>();
        for (int num : nums) {
            rbTree.insert(num);
        }
        rbTree.print();
    }
}

/**
 * 红黑树
 */
class RBTree<T extends Comparable<T>> {

    public RBTNode<T> root;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    class RBTNode<T extends Comparable<T>> {
        public T key;
        boolean color;
        RBTNode<T> parent;
        RBTNode<T> left;
        RBTNode<T> right;

        public RBTNode() {
        }

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 构造红黑树节点,调用insert(RBTNode node)
     *
     * @param key
     */
    public void insert(T key) {
        // 构造黑节点并插入
        RBTNode<T> node = new RBTNode<>(key, BLACK, null, null, null);
        insert(node);
    }

    /**
     * 向红黑树种插入新节点
     * 插入新节点三步:
     *    1. 将红黑树当做一棵二叉查找树,将节点添加到二叉查找树中
     *    2. 设置节点的颜色为红色
     *    3. 修正为一颗二叉查找树
     * @param node
     */
    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> par = null;
        RBTNode<T> cur = this.root;

        // 1. 将红黑树当做一棵二叉查找树,将节点添加到二叉查找树中
        while (cur != null) {
            par = cur;
            cmp = node.key.compareTo(cur.key);
            if (cmp < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        // 父节点赋值
        node.parent = par;
        // 红黑树不为空
        if (par != null) {
            // node作为新节点插入左或右
            cmp = node.key.compareTo(par.key);
            if (cmp < 0) {
                par.left = node;
            } else {
                par.right = node;
            }

        } else {
            // 红黑树为空,插入根节点
            this.root = node;
        }

        // 2. 设置节点的颜色为红色
        node.color = RED;

        // 3. 修正为一颗二叉查找树
        insertFixUp(node);

    }

    /**
     * 添加新节点后调整结构使得结构满足红黑树性质
     *    1.如果是第一次插入，由于原树为空，所以只会违反红-黑树的规则2，所以只要把根节点涂黑即可；
     *    2.如果插入节点的父节点是黑色的，那不会违背红-黑树的规则，什么也不需要做；
     *    3.但是遇到如下三种情况，我们就要开始变色和旋转了：
     *      ①、插入节点的父节点和其叔叔节点（祖父节点的另一个子节点）均为红色。
     *          将当前节点 cur 的父节点 parent 和叔叔节点 uncle 涂黑，
     *          将祖父节点 grandParent 涂红,
     *          再将当前节点指向其祖父节点，再次从新的当前节点开始算法
     *      ②、插入节点的父节点是红色的，叔叔节点是黑色的，且插入节点是其父节点的右子节点。
     *      ③、插入节点的父节点是红色的，叔叔节点是黑色的，且插入节点是其父节点的左子节点。
     *          父亲是左孩子:
     *              cur 是右孩子: leftRotate(parent)-->rightRotate(grandParent)
     *              cur 是左孩子: rightRotate(grandParent)
     *          父亲是右孩子:
     *              cur 是左孩子: rightRotate(parent)-->leftRotate(grandParent)
     *              cur 是右孩子: leftRotate(grandParent)
     *
     * @param cur
     */
    private void insertFixUp(RBTNode<T> cur) {
        RBTNode<T> parent, grandParent;

        // 若父节点不存在直接跳过;
        // 若父节点存在,且父节点的颜色是红色(父节点为黑色不违反红黑树特性,直接跳过)
        while ((parent = parentOf(cur)) != null && isRed(parent)) {
            // grandParent肯定不为null,若为null,则parent为根节点,而根节点肯定为黑
            grandParent = parentOf(parent);

            // 父节点是红色
            // 若父节点是祖父节点的左孩子
            if (parent == grandParent.left) {

                RBTNode<T> uncle = grandParent.right;

                // case1: 叔叔节点是红色
                // 此时将父节点和叔叔节点涂黑,祖父涂红,祖父作为新加节点继续调整
                if (uncle != null && isRed(uncle)) {

                    setBlack(uncle);
                    setBlack(parent);
                    setRed(grandParent);
                    cur = grandParent;
                    continue;
                }
                // 父亲始终为红色,叔叔为黑色时,根据当前节点是左孩子还是右孩子分两种情况,即 case2 和 case3
                // case2: 当前节点是右孩子,(父亲始终为红色,叔叔为黑色时)
                // 则 左旋parent 转化为 case3,再右旋grandParent
                if (parent.right == cur) {
                    leftRotate(parent);
                    // 交换 parent 和 cur
                    RBTNode<T> tmp = parent;
                    parent = cur;
                    cur = tmp;

                }
                // case3: 当前节点是左孩子,(父亲始终为红色,叔叔为黑色时)
                // 则将父亲涂黑,祖父涂红,右旋祖父节点
                setBlack(parent);
                setRed(grandParent);
                rightRotate(grandParent);

            } else {
                // 父节点是祖父节点的右孩子
                RBTNode<T> uncle = grandParent.left;
                // case1: 叔叔节点是红色
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(grandParent);
                    cur = grandParent;
                    continue;
                }
                // case2: 叔叔是黑色,且当前节点是左孩子
                if (cur == parent.left) {
                    // 右旋parent
                    rightRotate(parent);
                    // 交换 cur 和 parent
                    RBTNode<T> tmp = parent;
                    parent = cur;
                    cur = tmp;
                }
                // case3: 叔叔是黑色,且当前节点是右孩子
                // 父亲涂黑,祖父涂红,左旋grandParent
                setBlack(parent);
                setRed(grandParent);
                leftRotate(grandParent);
            }
        }
        setBlack(this.root);
    }

    /**
     * 右旋示意图：对节点y进行右旋
     *        p                    p
     *       /②                   /
     *       y                    x
     *     /③ \                 / \
     *    x    ry   ----->      lx  y
     *   / \①                     / \
     *  lx  rx                   rx ry
     * <p>
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     *
     * @param y
     */
    private void rightRotate(RBTNode<T> y) {

        RBTNode<T> x = y.left;
        // 1 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        // 2 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
        x.parent = y.parent;
        if (y.parent == null) {
            this.root = x;
        } else {
            // y是p的左孩子
            if (y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }
        // 3 将x的右子节点设为y，将y的父节点设为x
        x.right = y;
        y.parent = x;
    }

    /**
     * 左旋示意图(对节点x进行左旋)：
     *        px                             px
     *       / ②                            /
     *      x                               y
     *    /   \ ③       --(左旋)-.         / \
     *   lx    y                          x  ry
     *       /① \                       /  \
     *      ly   ry                     lx  ly

     * 左旋做了三件事：
     *   1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     *       x.right = y.left; (notnull)y.left.parent = x;
     *   2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     *       y.parent = x.parent;
     *       if(x.parent==null){
     *           this.root = right;
     *       }else{
     *           x.parent.left(right) = y;
     *       }
     *   3. 将y的左子节点设为x，将x的父节点设为y
     *      y.left = x;
     *      x.parent = y;
     *
     * @param x
     */
    private void leftRotate(RBTNode<T> x) {

        // 旋转节点
        RBTNode<T> y = x.right;
        // ly 设置为 x 的右孩子
        x.right = y.left;

        if (y.left != null) {
            // 若右节点的左节点不为空,则接到 x 的右节点上
            y.left.parent = x;
        }
        // x 的父亲设为 y 的父亲
        y.parent = x.parent;

        if (x.parent == null) {
            // 若 x 的父亲为空,即 x 为根节点,则将 y 设为根节点
            this.root = y;
        } else {
            if (x.parent.left == x) {
                // x 是其父亲的左孩子,则将right设为node的父节点的左孩子
                x.parent.left = y;
            } else {
                // 如果 x是它父节点的右孩子，则将y设为“x的父节点的右孩子”
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent = y;
    }

    private void setRed(RBTNode<T> node) {
        if (node != null) {
            node.color = RED;
        }
    }

    private void setBlack(RBTNode<T> node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    private boolean isRed(RBTNode<T> node) {
        return node.color == RED;
    }

    private boolean isBlack(RBTNode<T> node) {
        return !isRed(node);
    }

    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node != null ? node.parent : null;
    }

    private int getTreeDepth(RBTNode<T> root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    /**
     * 将红黑树写入到数组中
     */
    private void writeArray(RBTNode<T> currNode, int rowIndex, int columnIndex, String[][] res,int[][] colors, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) {
            return;
        }
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.key);
        colors[rowIndex][columnIndex] = currNode.color?1:2;

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) {
            return;
        }
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res,colors, treeDepth);
        }
        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res,colors, treeDepth);
        }
    }
    /**
     * 层序遍历输出红黑树
     */
    public void levelPrint() {
        Queue<RBTNode<T>> queue = new LinkedList<>();
        ArrayList<RBTNode<T>> list = new ArrayList<>();
        if (root == null) {
            System.out.println("Empty Tree!");
            return;
        }
        RBTNode<T> curLast = root, nextLast = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            RBTNode<T> temp = queue.poll();
            list.add(temp);
            if (isRed(temp)){
                System.out.print("\033[31;4m" + temp.key + "("+(temp.color?"B":"R")+") " + "\033[0m");
            }else {
                System.out.print(temp.key + "("+(temp.color?"B":"R")+") ");
            }
            if (temp.left != null) {
                nextLast = temp.left;
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                nextLast = temp.right;
                queue.offer(temp.right);
            }
            // 表明已到达当前行末尾
            if (temp == curLast) {
                curLast = nextLast;
                System.out.println();
            }
        }
    }

    public void print() {
        if (root == null) {
            System.out.println("EMPTY!");
        }
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        int[][] colors = new int[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res,colors,treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        int j=0;
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (colors[j][i]==1){
                    sb.append("B");
                }else if (colors[j][i]==2){
                    sb.append("R");
                }
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            j++;
            System.out.println(sb.toString());
        }
    }
}
