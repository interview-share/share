package offer.leetcode.chapter1;

/**
 * @author LRK
 * @project_name Offer
 * @package_name leetcode.chapter1
 * @date 2019/2/16 22:17
 * @description God Bless, No Bug!
 */
public class Sub01_SingleNumber {
    public static void main(String[] args) {
        int[] data = {1,1,2,2,3,3,4,4,5};
        Sub01_SingleNumber test = new Sub01_SingleNumber();
        System.out.println(test.singleNumber(data));
    }

    public int singleNumber(int[] A) {

        if (A==null || A.length==0) return 0;
        int result=0;
        for (int num : A) {
            result ^= num;
        }
         return result;
    }
}
