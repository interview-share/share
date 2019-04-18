package offer.common;

/**
 * @author LRK
 * @project_name Offer
 * @package_name common
 * @date 2019/2/1 21:39
 * @description God Bless, No Bug!
 */
public class BigNumUtil {
    public static void main(String[] args) {

        System.out.println(sub("999", "999"));
    }

    public static String add(String a, String b) {

        // 反转方便对齐
        StringBuilder numA = new StringBuilder(a).reverse();
        StringBuilder numB = new StringBuilder(b).reverse();

        // 较长
        int len = 0;
        // 补0对齐
        if (numA.length() < numB.length()) {
            len = align(numB, numA);
        } else {
            len = align(numA, numB);
        }
        // 进位
        int high = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {

            int num = numA.charAt(i) - '0' + numB.charAt(i) - '0' + high;
            if (num > 9) {
                high = 1;
                num -= 10;
            } else {
                high = 0;
            }
            result.append(num);
        }
        if (high == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    /**
     * 补0对齐
     * @param numA
     * @param numB
     * @return
     */
    private static int align(StringBuilder numA, StringBuilder numB) {
        int len;
        len = numA.length();
        int count = numA.length() - numB.length();
        for (int i = 0; i < count; i++) {
            numB.append('0');
        }
        return len;
    }

    /**
     * 多个大数相加
     * @param params
     * @return
     */
    public static String add(String... params) {
        int maxLen = 0;
        //获取最大长度
        for (String s : params) {
            if (s.length() > maxLen) {
                maxLen = s.length();
            }
        }
        StringBuilder result = new StringBuilder();
        //进位 数
        int high = 0;
        //将每个待加参数每一位相加 进位
        for (int i = 0; i < maxLen; i++) {
            int charInt = 0;
            for (String s : params) {
                //高位不够用0代替
                charInt += s.length() - 1 < i ? 0 : Integer.parseInt(s.charAt(s.length() - 1 - i) + "");
            }
            charInt += high;
            //进位
            high = charInt / 10;
            //当前位的值 为charInt 余数
            int remainder = charInt % 10;
            result.append(remainder);
        }
        //最后一次进位,需要反向
        if (high > 0) {
            result.append(new StringBuilder(high + "").reverse());
        }
        //反转 输出结果
        return result.reverse().toString();
    }

    /**
     * 大数减法: a-b a,b均为正数
     *
     * @param a
     * @param b
     * @return
     */
    public static String sub(String a, String b) {

        // 翻转
        StringBuilder numA = new StringBuilder(a).reverse();
        StringBuilder numB = new StringBuilder(b).reverse();

        boolean isPositive = true;
        int lenA = numA.length();
        int lenB = numB.length();
        int maxLen = lenA;
        // 判断结果正负
        if (lenA < lenB) {
            maxLen = lenB;
            isPositive = false;
        } else if (lenA == lenB) {

            for (int i = 0; i < lenA; i++) {
                if (a.charAt(i) < b.charAt(i)) {
                    isPositive = false;
                    break;
                }
            }
        }
        int[] result = new int[maxLen];
        for (int i = 0; i < maxLen; i++) {
            int intA = i < lenA ? (numA.charAt(i) - '0') : 0;
            int intB = i < lenB ? (numB.charAt(i) - '0') : 0;
            if (isPositive) {
                result[i] = intA - intB;
            } else {
                result[i] = intB - intA;
            }
        }
        // 处理借位
        for (int i = 0; i < maxLen; i++) {
            // 负数表示需要借位
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }
        StringBuilder resStr = new StringBuilder();
        if (!isPositive) {
            resStr.append('-');
        }
        // 判断是否有前置0
        boolean flag = true;
        for (int i = maxLen - 1; i >= 0; i--) {
            if (flag && result[i] == 0 ) {
                continue;
            } else {
                flag = false;
            }
            resStr.append(result[i]);
        }
        if ("".equals(resStr.toString())) {
            resStr.append('0');
        }
        return resStr.toString();

    }
}
