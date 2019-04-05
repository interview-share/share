package algorithm.math_bit;

/**
 * @author LRK
 * @date 2019/4/5 20:47
 * project_name LeetCode
 * package_name algorithm.math_bit
 * description:
 * God Bless, No Bug!
 *
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 *   示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class _09IsPowerOfThree {

    public static void main(String[] args) {

        System.out.println(Integer.toString(27,3));
    }
    public boolean isPowerOfThree(int n) {

        return Integer.toString(n,3).matches("10*");
    }
}
