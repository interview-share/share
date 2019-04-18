package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 0:09
 * @description God Bless, No Bug!
 */
public class Sub44_DigitsInSequence {
    public static void main(String[] args) {
        Sub44_DigitsInSequence test = new Sub44_DigitsInSequence();
        System.out.println(test.digitAtIndex(1001));
    }

    public int digitAtIndex(int n){

        if (n<0) return -1;
        int i = 1; // 位数
        while (n>0){
            int count = getCount(i);
            if (n<count*i){
                break;
            }
            n -= count*i;
            ++i;
        }
        // 在 i 位数中的第 n 个
        int add = n/i;
        int result = n%i;
        return getDigit(i,add,result);
    }

    /**
     * 获取 i 位数的第 add 个数字的第 result 位 如: 3位数的第270个数字的第1位
     * @param i 位数
     * @param add 第几个i位数
     * @param result 数字的第 result 位(从0开始)
     * @return
     */
    private int getDigit(int i, int add, int result) {
        int number = (int) (Math.pow(10,i-1)+add);
        char c = (String.valueOf(number)).charAt(result);
        return c-'0';
    }

    /**
     * i 位数总共有多少个
     * @param i
     * @return
     */
    private int getCount(int i) {
        if (i==1){
            return 10;
        }
        return (int) (9*Math.pow(10,i-1));
    }
}
