package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 0:09
 * @description God Bless, No Bug!
 *
 * 数字序列中某一位的数字
 * 题目描述
 * 数字以 0123456789101112131415… 的格式序列化到一个字符序列中。
 *
 * 在这个序列中，第 5 位（从 0 开始计数）是 5，第 13 位是 1，第 19 位是 4，等等。
 *
 * 请写一个函数求任意位对应的数字。
 *
 * 解法
 * 举个栗子，求序列第 1001 位。
 *
 * 序列的前 10 位是 0~9， 这 10 个只有一位的数字。显然第 1001 位在这 10 个数字之后，因此这 10 个数字可以直接跳过。
 * 再从后面序列中找第 991（991=1001-10） 位的数字。
 * 接下来有 90 个两位数，共 180 位，由于 991>180，所以继续跳过。从 881 找...最后可以找到对应的数字以及数字的某一位。
 *
 * /**
 */
public class Sub44_DigitsInSequence {
    public static void main(String[] args) {
        Sub44_DigitsInSequence test = new Sub44_DigitsInSequence();
        System.out.println(test.digitAtIndex(10));
    }

    public int digitAtIndex(int n){

        if (n<0) {
            return -1;
        }
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
