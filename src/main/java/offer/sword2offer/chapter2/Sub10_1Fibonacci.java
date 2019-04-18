package offer.sword2offer.chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/31 15:52
 * @description God Bless, No Bug!
 *
 *  斐波那契数列
 */
public class Sub10_1Fibonacci {

    public static void main(String[] args) {
        Integer value = getFibonacci(6);
        System.out.println(value);
    }

    private static Integer getFibonacci(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Invalid Input!");
        }
        if (n < 2) {
            return n;
        }
        int pre = 0;
        int last = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = pre + last;
            pre = last;
            last = result;
        }

        return result;
    }

}
