package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/9 16:21
 * @description God Bless, No Bug!
 */
public class Sub53_1NUmberOfK {

    public static void main(String[] args) {
        Sub53_1NUmberOfK test = new Sub53_1NUmberOfK();
        int[] data = {1,3,3,3,3,4,5};
        System.out.println(test.GetNumberOfK(data, 2));
    }

    public int GetNumberOfK(int [] array , int k) {

        int count = 0;
        if (array==null || array.length==0) return 0;
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

        if (start>end) return -1;
        int mid = (start+end)/2;
        if (array[mid]==k){

            if ((mid>0 && array[mid-1]!=k) || mid==0){ // mid就是第一个k
                return mid;
            }else {
                end = mid-1;
            }
        }else if (array[mid]>k){ // 在前半段继续找
            end = mid-1;
        }else { // 在后半段继续找
            start = mid+1;
        }
        return getFirstK(array,k,start,end);
    }

    private int getLastK(int[] array, int k, int start, int end) {
        if (start>end) return -1;
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
