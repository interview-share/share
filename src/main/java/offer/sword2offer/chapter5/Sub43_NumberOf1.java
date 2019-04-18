package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/6 23:30
 * @description God Bless, No Bug!
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
            temp = (int) (n % Math.pow(10, i));
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
