package offer.sword2offer.chapter3;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/1 19:11
 * @description God Bless, No Bug!
 *
 * 数值的整数次方
 * 题目描述
 *  给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。求 base的 exponent 次方。
 *
 * 解法
 * 注意判断指数是否小于 0。另外 0 的 0 次方没有意义，也需要考虑一下，看具体题目要求。
 */
public class Sub16_Power {

    public static void main(String[] args) {
        double result = getPower(5.0, 4);
        System.out.println(result);
    }

    private static double getPower(double base, int exponent) {

        if (String.valueOf(base).equals(String.valueOf(0.0))) {
            return 0;
        }
        int n = Math.abs(exponent);
        double result = getAbsPower(base, n);

        return exponent<0?1.0/result:result;
    }

    private static double getAbsPower(double base, int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        double result = getAbsPower(base, n >> 1);
        result *= result;
        if ((n & 1) == 1) {
            result = result * base;
        }
        return result;
    }
}
