package offer.algorithm;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name offer.algorithm
 * @date 2019/4/24 10:12
 * @description God Bless, No Bug!
 */
public class _05RBTreeInsert {


    public void constructRBTree(int[] nums){

        for (int num : nums) {
        }
    }


}

/**
 * 红黑树
 */
class RBTree<T extends Comparable<T>>{

    public RBTNode<T> root;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    class RBTNode<T extends Comparable<T>> {
        public T key;
        public boolean color;
        public RBTNode<T> parent;
        public RBTNode<T> left;
        public RBTNode<T> right;

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    public void insert(T key){
        // 构造黑节点并插入
        RBTNode<T> node = new RBTNode<>(key,BLACK,null,null,null);
        insert(node);
    }

    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> par = null;
        RBTNode<T> cur = this.root;

        // 1. 将红黑树当做一棵二叉查找树,将节点添加到二叉查找树中
        while (cur!=null){
            par = cur;
            cmp = node.key.compareTo(cur.key);
            if (cmp<0){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        // 父节点赋值
        node.parent = par;
        if (par!=null){
            // node作为新节点插入左或右
            cmp = node.key.compareTo(par.key);
            if (cmp<0){
                par.left = node;
            }else {
                par.right = node;
            }

        }else {
            // 红黑树为空,插入根节点
            this.root = node;
        }

        // 2. 设置节点的颜色为红色
        node.color = RED;

        // 3. 修正为一颗二叉查找树
        insertFixUp(node);

    }

    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent,grandParent;

        // 若父节点存在,且父节点的颜色是红色(父节点为黑色不违反红黑树特性,直接跳过)
        while ((parent = parentOf(node))!=null && isRed(parent)){
            grandParent = parentOf(parent);

            // 父节点是红色
            // 若父节点是祖父节点的左孩子
            if (parent == grandParent.left){

                RBTNode<T> uncle = grandParent.right;

                // case1: 叔叔节点是红色
                // 此时将父节点和叔叔节点涂黑,祖父涂红,祖父作为新加节点继续调整
                if (uncle!=null && isRed(uncle)){

                    setBlack(uncle);
                    setBlack(parent);
                    setRed(grandParent);
                    node = grandParent;
                    continue;
                }

                // case2: 叔叔是黑色,父亲为红色,且当前节点是右孩子,
                // 则左旋parent,再右旋grandParent
                if (parent.right == node){
                    leftRotate(parent);
                    RBTNode<T> tmp = parent;
                    parent = node;
                    node = tmp;

                }
                // case3: 叔叔是黑色,父亲为红色,且当前节点是左孩子
                // 则将父亲涂黑,祖父涂红,右旋祖父节点
                setBlack(parent);
                setRed(grandParent);
                rightRotate(grandParent);



            }else {
                // 父节点是祖父节点的右孩子
                RBTNode<T> uncle = grandParent.left;
                // case1: 叔叔节点是红色
                setBlack(uncle);
                setBlack(parent);
                setRed(grandParent);
                node = grandParent;
                continue;
                // case2: 叔叔是黑色,且当前节点是左孩子

                // case3: 叔叔是黑色,且当前节点是右孩子

            }
        }

        setBlack(this.root);
    }

    private void rightRotate(RBTNode<T> node) {

    }

    private void leftRotate(RBTNode<T> node) {

        // 旋转节点
        RBTNode<T> right = node.right;
        // 旋转节点的右节点
        node.right = right.left;

        if (right.left!=null){
            // 若右节点的左节点不为空,则接到node的右节点上
            right.left.parent = node;
        }
        // node的父亲设为right的父亲
        right.parent = node.parent;

        if (node.parent==null) {
            // 若node的父亲为空,即node为根节点,则将right设为根节点
            this.root = right;
        }else {
            if (node.parent.left == node){
                //node是其父亲的左孩子,则将right设为node的父节点的左孩子
                node.parent.left = right;
            }else {
                node.parent.right = right;
            }
        }
        right.left = node;
        node.parent = right;

    }

    private void setRed(RBTNode<T> node) {
        node.color = RED;
    }

    private void setBlack(RBTNode<T> root) {
        root.color = BLACK;
    }

    private boolean isRed(RBTNode<T> node) {
        return node.color==RED;
    }

    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node!=null?node.parent:null;
    }
}
