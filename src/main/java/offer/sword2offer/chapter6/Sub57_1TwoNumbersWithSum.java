package offer.sword2offer.chapter6;

import java.util.ArrayList;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/9 20:00
 * @description God Bless, No Bug!
 */
public class Sub57_1TwoNumbersWithSum {
    public static void main(String[] args) {
        Sub57_1TwoNumbersWithSum test = new Sub57_1TwoNumbersWithSum();
        System.out.println(test.FindNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15));
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> result = new ArrayList<>();
        if (array ==null || array.length==0) return result;

        int pre=0,behind=array.length-1;
        while (pre<behind){
            while (array[pre]+array[behind]>sum){
                --behind;
            }
            while (array[pre]+array[behind]<sum){
                ++pre;
            }
            if (array[pre]+array[behind]==sum){
                result.add(array[pre]);
                result.add(array[behind]);
                break;
            }
        }
        return result;
    }
}
