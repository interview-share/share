package offer.sword2offer.chapter6;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/10 14:08
 * @description God Bless, No Bug!
 */
public class Sub61_ContinuousCards {
    public static void main(String[] args) {
        Sub61_ContinuousCards test = new Sub61_ContinuousCards();
        System.out.println(test.isContinuous(new int[]{3,0,5,2,1}));
    }

    public boolean isContinuous(int[] numbers) {

        if (numbers==null || numbers.length==0) return false;
        // 1 对数组排序
//        SortUtil.quickSort(numbers, 0, numbers.length - 1);
        Arrays.sort(numbers);
        // 2 统计0的个数
        int count = 0, index = 0;
        while (numbers[index++] == 0) {
            count++;
        }
        int lackCount = 0;
        // 3 统计相邻数据之间的空缺
        for (int i = count + 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) return false;
            if (numbers[i] - numbers[i - 1] > 1) {
                lackCount += numbers[i] - numbers[i - 1] - 1;
            }
        }
        if (count>=lackCount){
            return true;
        }
        return false;
    }
}
