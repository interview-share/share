package offer.sword2offer.chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/2/1 16:43
 * @description God Bless, No Bug!
 *
 * 二进制中 1 的个数
 * 题目描述
 *  输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Sub15_NumberOf1InBinary {
    public static void main(String[] args) {
        int result = getCount3(7);
        System.out.println(result);
        System.out.println(-3/2);
    }

    /**
     * 推荐:
     *   num & (num-1)---将最右边的1变为0
     *    (num-1)---将num的最右边的1变为0,若该1后面还有0,则将其后面所有的0变为1
     *    同理: (num+1)---将num最右边的0变成1,若该0后面还有1,则将其后面所有的1变成0
     * @param num
     * @return
     */
    private static int getCount3(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    /**
     * 原数据不动,用数字1逻辑左移与num进逻辑与运算,缺点是int类型有多少位就要循环多少次
     *
     * @param num
     * @return
     */
    private static int getCount2(int num) {
        int i = 1;
        int count = 0;
        int loop = 0;
        while (i != 0) {
            if ((num & i) != 0) {
                count++;
            }
            loop++;
            i = i << 1;
        }
        System.out.println("循环次数: " + loop);
        return count;
    }

    /**
     * num右移与'1'进行与运算,输入负数时会造成死循环,因为负数算术右移时是在左边补符号位'1'
     *
     * >>> 逻辑右移
     * >> 算术右移
     * << 左移
     * @param num
     * @return
     */
    private static int getCount(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 0b1) != 0) {
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }


}
