package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/9 19:39
 * @description God Bless, No Bug!
 */
public class Sub56_2NumberAppearOnce {
    public static void main(String[] args) {
        Sub56_2NumberAppearOnce test = new Sub56_2NumberAppearOnce();
        System.out.println(test.FindNumberAppearingOnce(new int[]{1, 1, 1, 5, 5, 5, 4}));
    }

    public int FindNumberAppearingOnce(int[] array){

        if (array == null || array.length<1) return -1;
        int[] bitSum = new int[32];
        for (int num : array) {
            int bitMask = 1;
            for (int i = 31; i >= 0; i--) {
                int bit = num&bitMask;
                if (bit!=0){
                    bitSum[i] += 1;
                }
                bitMask = bitMask<<1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result<<1;
            result += bitSum[i]%3;
        }
        return result;
    }
}
