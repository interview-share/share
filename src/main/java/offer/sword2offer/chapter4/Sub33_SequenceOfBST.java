package offer.sword2offer.chapter4;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/4 15:52
 * @description God Bless, No Bug!
 *
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 解法
 * 序列的最后一个元素是二叉搜索树的根节点。
 *
 * 在序列中从左到右找到根节点的左子树(比根节点小)、右子树(比根节点大)。
 *
 *
 * 如果右子树中出现比根节点小的元素，那么为 false。
 * 否则递归左右子树。
 */
public class Sub33_SequenceOfBST {
    public boolean VerifySequenceOfBST(int [] sequence) {

        if (sequence==null || sequence.length<=0) {
            return false;
        }
        return VerifySequenceOfBST(sequence,0,sequence.length-1);
    }

    public boolean VerifySequenceOfBST(int [] sequence,int start,int end) {
        if (start>=end) {
            return true;
        }
        int root = sequence[end];
        int len = end - start+1;
        int i = start;
        for (; i <= end ; i++) {
            if (sequence[i]>root){
                break;
            }
        }
        int j=i;
        for (; j < len-1; j++) {
            if (sequence[j]<root){
                return false;
            }
        }
        return VerifySequenceOfBST(sequence,start,i-1)&&VerifySequenceOfBST(sequence,i,end-1);
    }
}
