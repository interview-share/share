package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/9 18:44
 * @description God Bless, No Bug!
 */
public class Sub56_1NumbersAppearOnce {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array == null || array.length < 2) return;

        int xorRes = 0;
        for (int num : array) {
            xorRes ^= num;
        }
        int index = indexOf1(xorRes);
        num1[0] = 0;
        num2[0] = 0;
        for (int num : array) {

            if (isBit1(num, index)) { // 如果是1
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    /**
     * 判断从右至左的第 index 位是否为1
     *
     * @param num
     * @param index
     * @return
     */
    private boolean isBit1(int num, int index) {
        for (int i = 0; i < index; i++) {
            num = num >> 1;
        }
        return (num & 1) == 1;
    }

    /**
     * 找到从右至左的第一个1的索引
     *
     * @param xorRes
     * @return
     */
    private int indexOf1(int xorRes) {

        int index = 0;
        while ((xorRes & 1) == 0) { // 最后一位是0
            ++index;
            xorRes = xorRes >> 1;
        }
        return index;
    }
}
