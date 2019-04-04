package test;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name test
 * @date 2019/3/13 23:55
 * @description God Bless, No Bug!
 * <p>
 * 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class GetSum {

    public static void main(String[] args) {
        System.out.println(new GetSum().getSum(2, 3));
    }

    public int getSum(int a, int b) {
        int sum = 0;
        // a&b为进位 a^b为不带进位加法器结果
        sum = a ^ b;
        int carry = (a & b) << 1;
        if (carry == 0) return sum;
        else {
            return getSum(sum, carry);
        }
    }
}
