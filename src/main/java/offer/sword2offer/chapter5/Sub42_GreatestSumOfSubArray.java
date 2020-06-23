package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/6 21:19
 * @description God Bless, No Bug!
 *
 * 连续子数组的最大和
 * 题目描述
 * 输入一个非空整型数组，数组里的数可能为正，也可能为负。 数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 解法
 * 动态规划法。
 *
 * res[i] 表示以第 i 个数字结尾的子数组的最大和，那么求出 max(res[i]) 即可。
 *
 * res[i] = array[i], if res[i - 1] < 0
 * res[i] = res[i - 1] + array[i], if res[i - 1] >= 0
 *
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

        if (array==null || array.length==0) {
            return 0;
        }
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
