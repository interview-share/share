package offer.sword2offer.chapter5;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 14:02
 * @description God Bless, No Bug!
 */
public class Sub45_SortArrayForMinNumber {
    public static void main(String[] args) {

        Sub45_SortArrayForMinNumber test = new Sub45_SortArrayForMinNumber();
        int[] data = {3,32,321};
        System.out.println(test.PrintMinNumber(data));
    }

    public String PrintMinNumber(int [] numbers) {

        if (numbers==null || numbers.length==0) return null;

        String[] numStr = new String[numbers.length];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            numStr[i] = String.valueOf(numbers[i]);
        }
        // A.compareTo(B) A>B则返回正值,相等返回0,A<B返回负值
        Arrays.sort(numStr,((a,b)->(a+b).compareTo(b+a)));
        for (int i = 0; i < numStr.length; i++) {
            builder.append(numStr[i]);
        }
        return builder.toString();
    }
}
