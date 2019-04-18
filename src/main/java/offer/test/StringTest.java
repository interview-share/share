package offer.test;

import common.TreeNode;
import offer.common.BinaryTreeUtil;
import org.junit.jupiter.api.Test;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/30 15:25
 * @description God Bless, No Bug!
 */
public class StringTest {
    public static void main(String[] args) {
        String text = "hello";
        modifyString(text);
        System.out.println(text);
    }

    private static void modifyString(String text) {
        text = "world";
        System.out.println(text);
    }

    @Test
    public void test(){
        int a = 8;
        int b = 8;
        int c = (a+b)>>1;
        System.out.println(c);
    }
    @Test
    public void testLevelTraverse(){

        int[] pre = {1,2,4,5,3,6,7};
        int[] in =  {4,2,5,1,6,3,7};
        TreeNode root = BinaryTreeUtil.constructBinaryTree(pre, in);
        BinaryTreeUtil.levelTraverseWithLevelNumber(root);
    }
}
