package offer.sword2offer.chapter3;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/1 19:56
 * @description God Bless, No Bug!
 *
 *  打印从 1 到最大的 n 位数
 * 题目描述
 *  输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 *
 * 解法
 *  此题需要注意 n 位数构成的数字可能超出最大的 int 或者 long long 能表示的范围。因此，采用字符数组来存储数字。
 *
 * 关键是：
 *
 *  对字符数组表示的数进行递增操作
 *  输出数字（0开头的需要把0去除）
 */
public class Sub17_Print1ToMaxNDigits {
    public static void main(String[] args) {
        print1ToMax(3);
    }

    private static void print1ToMax2(int n) {
        char[] num = new char[n];
//        num[n]='\0';
        for (int i = 0; i < 10; i++) {
            num[i] = '0';
            doPrintRecursion(num,n,0);
        }
    }

    private static void doPrintRecursion(char[] num, int len, int index) {

        if (index == len-1){
            doPrint(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index+1] = (char) (i+'0');
            doPrintRecursion(num,len,index+1);
        }
    }

    private static void print1ToMax(int n) {

        char[] num = new char[n];
        for (int i = 0; i < n; i++) {
            num[i] = '0';
        }
        // 换行
        int back = 0;
        while (!increment(num)) {
            back++;
            if (back%10==0) {
                System.out.println();
            }
            doPrint(num);
        }
    }
    /**
     * 打印字符(去除前面的0)
     * @param num
     */
    private static void doPrint(char[] num) {

        int start = 0;
        while (num[start]=='0' && start<num.length ){
            start++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i < num.length; i++) {
            result.append(num[i]);
        }
        System.out.print(result.toString()+" ");
    }

    /**
     * num数字+1
     * @param num
     * @return flag: 是否溢出
     */
    private static boolean increment(char[] num) {

        boolean flag = false;
        int inc = 1;

        for (int i = num.length - 1; i >= 0; i--) {

            int res = num[i] - '0' + inc;
            if (res > 9) {
                if (i == 0) {
                    flag = true;
                    break;
                }
                num[i] = '0';
            } else {
                ++num[i];
                break;
            }
        }
        return flag;
    }
}
