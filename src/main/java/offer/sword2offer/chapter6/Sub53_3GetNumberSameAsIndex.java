package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/9 17:22
 * @description God Bless, No Bug!
 */
public class Sub53_3GetNumberSameAsIndex {

    public static void main(String[] args) {
        Sub53_3GetNumberSameAsIndex test = new Sub53_3GetNumberSameAsIndex();
        int[] data = {-3,-1,1,2,4};
        System.out.println(test.getSameNumber(data));
    }

    private int getSameNumber(int[] data) {

        if (data==null || data.length==0) return -1;
        int start = 0,end = data.length-1;

        while (start <= end){
            int mid = (start+end)>>1;
            if (data[mid]==mid){
                return data[mid];
            }else if (data[mid]>mid){ // 在前半段继续查找
                end = mid-1;
            }else { // 在后半段继续查找
                start = mid+1;
            }
        }
        return -1;
    }


}
