package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/6 17:17
 * @description God Bless, No Bug!
 *
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为 9 的数组 {1,2,3,2,2,2,5,4,2}。
 * 由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。如果不存在则输出 0。
 *
 * 解法
 * 解法一
 * 利用快排中的 partition 思想。
 *
 * 数组中有一个数字出现次数超过了数组长度的一半，那么排序后，数组中间的数字一定就是我们要找的数字。
 * 我们随机选一个数字，利用 partition() 函数，使得比选中数字小的数字都排在它左边，比选中数字大的数字都排在它的右边。
 *
 * 判断选中数字的下标 index：
 *
 * 如果 index = n/2，那么这个数字就是中位数。
 * 如果 index > n/2，那么接着在 index 的左边进行 partition。
 * 如果 index < n/2，则在 index 的右边继续进行 partition。
 * **注意：**这种方法会修改输入的数组。时间复杂度为 O(n)。
 *
 * 解法二
 * 利用多数投票算法，从头到尾遍历数组，遇到两个不一样的数就把这两个数同时除去。
 * 除去的两个数可能都不是 majority，也可能一个是 majority 另一个不是，
 * 但是因为 majority 总数大于一半，所以这么删完最后剩下的肯定是 majority。
 *
 * 此方法时间复杂度为 O(n)，且不会改变数组。
 */
public class Sub39_MoreThanHalfNumber {
    public static void main(String[] args) {

        Sub39_MoreThanHalfNumber test = new Sub39_MoreThanHalfNumber();
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(test.MoreThanHalfNum_Solution2(arr));
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array == null || array.length==0) {
            return 0;
        }

        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {

            if (times==0){
                result = array[i];
                ++times;
            }else if (result == array[i]){
                ++times;
            }else {
                --times;
            }
        }
        return isMoreThanHalf(array,result)?result:0;
    }


    public int MoreThanHalfNum_Solution(int [] array) {

        if (array == null || array.length==0) {
            return 0;
        }

        // 1 快排找出中位数
        int len = array.length;
        int start = 0,end=len-1;
        int mid = len>>1;
        int index = partition(array,start,end);
        while (index!=mid){
            if (index<mid){
                index = partition(array,index+1,end);
            }else {
                index = partition(array,start,index-1);
            }
        }
        // 2 判断该中位数是否超过一半
        return isMoreThanHalf(array,array[index])?array[index]:0;
    }

    private int partition(int[] array, int start, int end) {

        if (start>end){
            return 0;
        }
        int key = array[start];
        int i=start;
        int j = end;
        while (i<j){
            while (i<j && array[j]>=key){
                j--;
            }
            while (i<j && array[i]<=key){
                i++;
            }
            swap(array,i,j);
        }
        swap(array,start,i);
        return i;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean isMoreThanHalf(int[] array, int number) {
        int count =0;
        for (int num : array) {
            if (num == number){
                ++count;
            }
        }
        return count>(array.length>>1);
    }
}
