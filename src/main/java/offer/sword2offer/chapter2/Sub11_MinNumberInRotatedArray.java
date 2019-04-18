package offer.sword2offer.chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/31 22:53
 * @description God Bless, No Bug!
 *
 *  旋转数组的最小数字
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为 1。
 *
 * **NOTE：**给出的所有元素都大于 0，若数组大小为 0，请返回 0。
 *
 * 解法
 * 解法一
 * 直接遍历数组找最小值，时间复杂度 O(n)，不推荐。
 *
 * 解法二
 * 利用指针 p,q 指向数组的首尾，如果 array[p] < array[q]，说明数组是递增数组，直接返回 array[p]。否则进行如下讨论。
 *
 *  计算中间指针 mid：
 *
 *      如果此时 array[p], array[q], array[mid] 两两相等，此时无法采用二分方式，只能通过遍历区间 [p,q] 获取最小值；
 *      如果此时 p,q 相邻，说明此时 q 指向的元素是最小值，返回 array[q]；
 *      如果此时 array[mid] >= array[p]，说明 mid 位于左边的递增数组中，最小值在右边，
 *          因此，把 p 指向 mid，此时保持了 p 指向左边递增子数组；
 *      如果此时 array[mid] <= array[q]，说明 mid 位于右边的递增数组中，最小值在左边，
 *          因此，把 q 指向 mid，此时保持了 q 指向右边递增子数组。
 *     例: [3,4,5,1,2] 是 [1,2,3,4,5]的旋转数组
 *      最小值为1
 */
public class Sub11_MinNumberInRotatedArray {

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int result = getMinNumber(arr);
        System.out.println(result);
    }

    private static int getMinNumber(int[] array) {
        if (array==null || array.length<=0) {
            throw new IllegalArgumentException("Invalid Input!");
        }
        int left = 0;
        int right = array.length-1;
        int mid = left;
        while (array[left]>=array[right]){

            if (left+1==right){
                mid = right;
                break;
            }
            mid = (left+right)/2;

            // 三数相等只能全部遍历
            if (array[left]==array[mid] && array[mid]==array[right]){
                return minInRotatedArray(array,left,right);
            }

            if (array[mid]>array[left]){
                left = mid;
            }else if (array[mid]<array[right]){
                right = mid;
            }
        }
        return array[mid];
    }

    private static int minInRotatedArray(int[] array, int preIdx, int lastIdx) {

        int min = array[preIdx];
        for (int i=preIdx+1;i<=lastIdx;i++){
            if (array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
}
