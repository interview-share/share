package offer.sword2offer.chapter2;

import static common.SortUtil.swap;

/**
 * @author LRK
 *
 * 找出数组中重复的数字(可以修改原数组)
 * 题目描述
 *  在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 *  数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 *  请找出数组中任意一个重复的数字。
 *  例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字 2 或者 3。
 *
 * 解法一
 *  排序后，顺序扫描，判断是否有重复，时间复杂度为 O(n²)。
 *
 * 解法二
 *  利用哈希表，遍历数组，如果哈希表中没有该元素，则存入哈希表中，否则返回重复的元素。时间复杂度为 O(n)，空间复杂度为 O(n)。
 *
 * 解法三
 *  长度为 n，元素的数值范围也为 n，如果没有重复元素，那么数组每个下标对应的值与下标相等。
 *  该解法的思想就是:   将数字 i 放到 数组索引为 i 的位置
 * 从头到尾遍历数组，当扫描到下标 i 的数字 nums[i]：
 *
 *  如果等于 i，继续向下扫描；
 *  如果不等于 i，拿它与第 nums[i] 个数进行比较，
 *      如果相等，说明有重复值，返回 nums[i]。
 *      如果不相等，就把第 i 个数 和第 nums[i] 个数交换。重复这个比较交换的过程。
 * 此算法时间复杂度为 O(n)，因为每个元素最多只要两次交换，就能确定位置。空间复杂度为 O(1)。
 */
public class Sub03_Duplication {

    public static void main(String[] args) {

        int[] datas = {2, 3, 5, 4, 3, 2, 6, 7};
        int duplicate = getDuplication2(datas);
        System.out.println("hhhhhhh");
        System.out.println("重复数字:" + duplicate);

    }

    private static int getDuplication2(int[] data) {

        int n = data.length;
        for (int i = 0; i < n; i++) {
            while (i!=data[i]){

                if (data[i] == data[data[i]]){
                    return data[i];
                }else {
                    swap(data,i,data[i]);
                }
            }
        }
        return -1;
    }



}
