package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 18:43
 * @description God Bless, No Bug!
 *
 * 丑数
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 解法1
 * 由题目可以得知，丑数必定可以整除2、3或者5（除了丑数1之外），
 * 也就是说，如果一个数能够被2整除，就连续除以2；能够被3整除，就连续除以3；能够被5整除，就连续除以5；
 * 如果最后得到1，那么这个数便是丑数。因此我们可以使用暴力的方式遍历到第N个丑数。
 *
 * 该解法的time complexity为O(count)，比如第1500个丑数为859963392，那么就需要枚举1到859963392
 *
 *
 * 解法2
 * 把15以内的丑数列出来：1、2、3、4、5、6、8、9、10、12、15 ，你会发现新丑数必定是旧丑数乘以因子2、3或者5得来的。
 * 所以可以使用一个list来存储已经出现的丑数以此来计算出新的丑数，从而避免对非丑数的计算。
 *
 * 通过维护3个下标i2，i3，i5和它们对应的值m2，m3，m5，每次向list中添加的为m2，m3，m5中的最小值，以此来维护list的有序性。
 *
 * 该解法的time complexity为O(n)，space complexity为O(n)，属于典型的用空间换时间的解决方法。
 *
 */
public class Sub49_UglyNumber {
    public static void main(String[] args) {

        Sub49_UglyNumber test = new Sub49_UglyNumber();
        System.out.println(test.GetUglyNumber_Solution(7));
    }

    public int GetUglyNumber_Solution(int index) {

        if (index < 1) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }

        int[] result = new int[index];
        result[0] = 1;
        int T2 = 0, T3 = 0, T5 = 0;
        int M2, M3, M5;

        for (int i = 1; i < index; i++) {

            M2 = result[T2] * 2;
            M3 = result[T3] * 3;
            M5 = result[T5] * 5;
            result[i] = Math.min(Math.min(M2, M3), M5);
            if (result[i] == M2) {
                T2++;
            }
            if (result[i] == M3) {
                T3++;
            }
            if (result[i] == M5) {
                T5++;
            }
        }
        return result[index - 1];
    }
}
