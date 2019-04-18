package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/6 21:19
 * @description God Bless, No Bug!
 */
public class Sub42_GreatestSumOfSubArray {

    public static void main(String[] args) {
        Sub42_GreatestSumOfSubArray test = new Sub42_GreatestSumOfSubArray();
        System.out.println(test.FindGreatestSumOfSubArray2(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }

    private int FindGreatestSumOfSubArray2(int[] array) {

        int[] result = new int[array.length];
        result[0] = array[0];
        int max = array[0];

        for (int i=1;i<array.length;i++){
            result[i] = result[i-1]<0?array[i]:result[i-1]+array[i];
            max = Math.max(max,result[i]);
        }
        return max;
    }

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array==null || array.length==0) return 0;
        int sum = 0;
        int max = 0x80000000;
        for (int i = 0; i < array.length; i++) {

           if (sum<0){
               sum = array[i];
           }else {
               sum += array[i];
           }
           if (sum>max) {
               max = sum;
           }
        }
        return max;
    }
}
