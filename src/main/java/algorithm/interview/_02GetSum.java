package algorithm.interview;

/**
 * @author LRK
 * @date 2019/4/5 13:11
 * project_name LeetCode
 * package_name algorithm.interview
 * description:
 * God Bless, No Bug!
 *
 * 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 *   示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class _02GetSum {

    public int getSum(int a, int b) {
        int sum = 0;
        // a&b为进位 a^b为不带进位加法器结果
        sum = a ^ b;
        int carry = (a & b) << 1;
        if (carry == 0) {
            return sum;
        }
        else {
            return getSum(sum, carry);
        }
    }
}
