package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/9 16:21
 * @description God Bless, No Bug!
 *
 * 数字在排序数组中出现的次数
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 *
 * 例如输入排序数组 [1, 2, 3, 3, 3, 3, 4, 5] 和数字 3，由于 3 在这个数组中出现了 4 次，因此输出 4。
 *
 * 样例
 *
 * 输入：[1, 2, 3, 3, 3, 3, 4, 5] ,  3
 *
 * 输出：4
 * 解法
 * 找出第一个 k 和最后一个 k 出现的位置。
 *
 * 找第一个 k 时，利用二分法，
 *      如果 nums[m] == k，判断它的前一个位置是不是也是 k，如果不是，说明这是第一个 k，直接返回。
 *      如果是，那么递归在左边查找第一个 k。
 *
 * 找最后一个 k 也同理。
 *
 */
public class Sub53_1NumberOfK {

    public static void main(String[] args) {
        Sub53_1NumberOfK test = new Sub53_1NumberOfK();
        int[] data = {1,3,3,3,3,4,5};
        System.out.println(test.GetNumberOfK(data, 2));
    }

    public int GetNumberOfK(int [] array , int k) {

        int count = 0;
        if (array==null || array.length==0) {
            return 0;
        }
        int first = getFirstK(array,k,0,array.length-1);
        int last = getLastK(array,k,0,array.length-1);
        if (first>-1&& last>-1){

            return last-first+1;
        }
        return count;
    }

    /**
     * 找出第一个k的下标
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int getFirstK(int[] array, int k, int start, int end) {

        if (start>end) {
            return -1;
        }
        int mid = (start+end)/2;
        if (array[mid]==k){

            // mid就是第一个k
            if ((mid>0 && array[mid-1]!=k) || mid==0){
                return mid;
            }else {
                end = mid-1;
            }
        // 在前半段继续找
        }else if (array[mid]>k){
            end = mid-1;
        }else { // 在后半段继续找
            start = mid+1;
        }
        return getFirstK(array,k,start,end);
    }

    private int getLastK(int[] array, int k, int start, int end) {
        if (start>end) {
            return -1;
        }
        int mid = (start+end)/2;
        if (array[mid]==k){
            if ((mid<array.length-1 && array[mid+1]!=k)||mid==array.length-1){ // mid就是最后一个k

                return mid;
            } else { // mid不是最后一个k,在后面继续寻找
                start = mid+1;
            }
        }else if (array[mid]>k){ //在前面继续找
            end = mid-1;
        }else { // 在后面继续找
            start = mid+1;
        }
        return getLastK(array,k,start,end);
    }
}
