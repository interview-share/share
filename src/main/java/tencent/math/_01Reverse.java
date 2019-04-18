package tencent.math;

/**
 * @author LRK
 * @date 2019/4/13 13:35
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class _01Reverse {

    /**
     * 转换抛出异常则返回0
     * @param x
     * @return
     */
    public int reverse(int x) {
        int neg = 1;
        if (x<0){
            neg=-1;
        }
        String val = String.valueOf(x);
        StringBuilder builder = new StringBuilder(neg==1?val:val.substring(1));
        StringBuilder reverse = builder.reverse();
        try {

            return neg*Integer.valueOf(reverse.toString());
        }catch (Exception e){
            return 0;
        }
    }

    /**
     * 讨论溢出
     * @param x
     * @return
     */
    public int reverse2(int x){
        int rev = 0;
        while (x!=0){
            int mod = x%10;
            x /= 10;
            if (rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10 && mod>7)){
                return 0;
            }
            if (rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10 && mod<-8 )){
                return 0;
            }
            rev = rev*10+mod;
        }
        return rev;
    }
}
