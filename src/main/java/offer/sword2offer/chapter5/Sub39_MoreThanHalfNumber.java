package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/6 17:17
 * @description God Bless, No Bug!
 */
public class Sub39_MoreThanHalfNumber {
    public static void main(String[] args) {

        Sub39_MoreThanHalfNumber test = new Sub39_MoreThanHalfNumber();
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(test.MoreThanHalfNum_Solution2(arr));
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array == null || array.length==0) return 0;

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

        if (array == null || array.length==0) return 0;

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

        if (start>end) return 0;
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
