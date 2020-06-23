package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/6 23:30
 * @description God Bless, No Bug!
 *
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 解法
 * 编程之美上给出的规律：
 *
 *  如果第i位（自右至左，从1开始标号）上的数字为0，则第i位可能出现1的次数由更高位决定（若没有高位，视高位为0），
 *      等于更高位数字X当前位数的权重10^(i-1)。
 *  如果第i位上的数字为1，则第i位上可能出现1的次数不仅受更高位影响，还受低位影响（若没有低位，视低位为0），
 *      等于更高位数字X当前位数的权重10^(i-1)+（低位数字+1）。
 *  如果第i位上的数字大于1，则第i位上可能出现1的次数仅由更高位决定（若没有高位，视高位为0），
 *      等于（更高位数字+1）X当前位数的权重10^(i-1)。
 *
 * 总结一下以上的算法，可以看到，当计算右数第 i 位包含的 X 的个数时：
 *
 * 取第 i 位左边（高位）的数字，乘以 10i−1，得到基础值 a。
 * 取第 i 位数字，计算修正值：
 *      如果大于 X，则结果为 a+10i−1。 aX
 *      如果小于 X，则结果为 a。
 *      如果等 X，则取第 i 位右边（低位）数字，设为 b，最后结果为 a+b+1。
 * 相应的代码非常简单，效率也非常高，时间复杂度只有 O(logn)。
 */
public class Sub43_NumberOf1 {
    public static void main(String[] args) {
        Sub43_NumberOf1 test = new Sub43_NumberOf1();
        System.out.println(test.NumberOf1Between1AndN_Solution(21345));
    }

    /**
     *  计算 1~n 的数字中出现 k 的次数 (0<= k < = 9)
     *  从右到左第 i 位(从1开始)的取值为0,1,其他时第 i 位可能出现1的次数:
     *      <1: 更高位数字 * 当前位数的权重10^(i-1)。
     *      =1:  更高位数字 * 当前位数的权重10^(i-1) + 低位+1。
     *      >1: (更高位数字 + 1)* 当前位数的权重10^(i-1)。
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {

        if (n < 1) {
            return 0;
        }
        int high, low, cur, temp, count, i = 1;
        high = n;
        count = 0;
        while (high != 0) { // 如 21 0 5
            high = (int) (n / Math.pow(10, i)); // 高位
            temp = (int) (n % Math.pow(10, i)); // 本位+低位
            cur = (int) (temp / Math.pow(10, i - 1));
            low = (int) (temp%Math.pow(10,i-1)); // 低位

            if (cur<1){
                count += high*Math.pow(10,i-1);
            }else if (cur==1){
                count += high*Math.pow(10,i-1)+low+1;
            }else { // cur>1
                count += (high+1)*Math.pow(10,i-1);
            }
            i++;
        }
        return count;
    }
}
