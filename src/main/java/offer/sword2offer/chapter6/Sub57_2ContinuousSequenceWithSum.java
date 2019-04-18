package offer.sword2offer.chapter6;

import java.util.ArrayList;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/9 20:11
 * @description God Bless, No Bug!
 */
public class Sub57_2ContinuousSequenceWithSum {
    public static void main(String[] args) {
        Sub57_2ContinuousSequenceWithSum test = new Sub57_2ContinuousSequenceWithSum();
        System.out.println(test.FindContinuousSequence(105));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum<1) return result;

        int small = 1,big = 2;
        int seqSum = small+big;
        while (small<big&&big<=(sum/2+1)){

            while (seqSum<sum){
                ++big;
                seqSum += big;
            }
            while (seqSum>sum){
                seqSum -=small;
                ++small;
            }
            if (seqSum == sum){
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    temp.add(i);
                }
                result.add(temp);
                ++big;
                seqSum+=big;
            }
        }
        return result;
    }
}
