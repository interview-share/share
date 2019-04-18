package offer.sword2offer.chapter2;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/30 15:35
 * @description God Bless, No Bug!
 * <p>
 * 思路扩展： 在合并两个数组（包括字符串）时，如果从前往后复制每个数字（或字符）需要重复移动数字（或字符）多次，
 * 那么我们可以考虑从后往前复制，这样就能减少移动的次数，从而提高效率。
 */
public class Sub05_ReplaceBlank {
    public static void main(String[] args) {
        test();

        StringBuffer source = new StringBuffer("We are happy");
        test1(source);
        test2(source);
        test3();

    }


    private static void test() {
        String source = "We are happy";
        String target = source.replace(" ", "%20");
        System.out.println("target: " + target);
    }

    /**
     * 创建 StringBuilder，遍历原字符串，遇到非空格，直接 append 到 StringBuilder 中，
     * 遇到空格则将 %20 append 到 StringBuilder 中。
     *
     * @param source
     */
    private static void test1(StringBuffer source) {

        if (source == null || source.length() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (' ' == c) {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        System.out.println("target1: " + sb.toString());

    }

    /**
     * 先遍历原字符串，遇到空格，则在原字符串末尾 append 任意两个字符，如两个空格。
     * 用指针 p 指向原字符串末尾，q 指向现字符串末尾，p, q 从后往前遍历，
     * 当 p 遇到空格，q 位置依次要 append '02%'，
     * 若不是空格，直接 append p 指向的字符。
     *
     * @param source
     * @return
     */
    private static void test2(StringBuffer source) {
        if (source == null || source.length() == 0) {
            return;
        }
        int len = source.length();
        for (int i = 0; i < len; i++) {
            if (source.charAt(i) == ' ') {
                source.append("  ");
            }
        }
        int p = len - 1; // 指向原字符串末尾
        int q = source.length() - 1; // 指向新字符串末尾
        while (p >= 0) {
            if (source.charAt(p) == ' ') {
                source.setCharAt(q--, '0');
                source.setCharAt(q--, '2');
                source.setCharAt(q--, '%');
            } else {
                source.setCharAt(q--, source.charAt(p));
            }
            p--;
        }
        System.out.println("target2: " + source.toString());
    }

    /**
     * 有两个有序数组A和B,将B插入到A中(A容量足够),使新数组仍有序
     */
    private static void test3() {
        int[] arrayA = new int[20]; // {1,3,5,7,9}
        for (int i = 0, j = 1; i < 5; i++, j = j + 2) {
            arrayA[i] = j;
        }
        int[] arrayB = {2, 4, 6, 8, 10};
        int p = 0; // A中最后一个非0数字的index 4
        for (int i = arrayA.length - 1; i > 0; i--) {
            if (arrayA[i] != 0) {
                p = i;
                break;
            }
        }
        int q = arrayB.length - 1; // B数组的末尾index 4

        int newLen = p + q + 1; // 新数组末尾index 9

        while ((q >= 0) && (p >= 0)) {
            if (arrayA[p] <= arrayB[q]) { // A < B
                arrayA[newLen--] = arrayB[q--];
            } else {
                arrayA[newLen--] = arrayA[p--];
            }
        }
        System.out.println(Arrays.toString(arrayA));


    }
}
