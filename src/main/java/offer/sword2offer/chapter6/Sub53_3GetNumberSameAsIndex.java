package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/9 17:22
 * @description God Bless, No Bug!
 * 题目描述
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 *
 * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 *
 * 例如，在数组 [-3, -1, 1, 3, 5] 中，数字 3 和它的下标相等。
 *
 * 样例
 *
 * 输入：[-3, -1, 1, 3, 5]
 *
 * 输出：3
 * 注意:如果不存在，则返回 -1。
 *
 * 解法
 * 二分法查找。
 *
 * 当前元素等于对应的下标，直接返回该下标；
 * 当前元素大于该下标，在左边查找；
 * 当前元素小于该下标，在右边查找。
 *
 */
public class Sub53_3GetNumberSameAsIndex {

    public static void main(String[] args) {
        Sub53_3GetNumberSameAsIndex test = new Sub53_3GetNumberSameAsIndex();
        int[] data = {-3,-1,1,2,4};
        System.out.println(test.getSameNumber(data));
    }

    private int getSameNumber(int[] data) {

        if (data==null || data.length==0) {
            return -1;
        }
        int start = 0,end = data.length-1;

        while (start <= end){
            int mid = (start+end)>>1;
            if (data[mid]==mid){
                return data[mid];
            // 在前半段继续查找
            }else if (data[mid]>mid){
                end = mid-1;
            }else { // 在后半段继续查找
                start = mid+1;
            }
        }
        return -1;
    }


}
