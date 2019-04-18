package offer.sword2offer.chapter4;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/4 15:52
 * @description God Bless, No Bug!
 */
public class Sub33_SequenceOfBST {
    public boolean VerifySequenceOfBST(int [] sequence) {

        if (sequence==null || sequence.length<=0) return false;
        return VerifySequenceOfBST(sequence,0,sequence.length-1);
    }

    public boolean VerifySequenceOfBST(int [] sequence,int start,int end) {
        if (start>=end) return true;
        int root = sequence[end];
        int len = end - start+1;
        int i = start;
        for ( ;i < len-1; i++) {
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
