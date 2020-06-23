package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 15:29
 * @description God Bless, No Bug!
 *
 * 把数字翻译成字符串
 * 题目描述
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 *
 * 0 翻译成 ”a”，1 翻译成 ”b”，……，11 翻译成 ”l”，……，25 翻译成 ”z”。
 *
 * 一个数字可能有多个翻译。例如 12258 有 5 种不同的翻译，它们分别是 ”bccfi”、”bwfi”、”bczi”、”mcfi”和”mzi”。
 *
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 *
 * 解法
 * 先写入递推式，res 表示共有多少种翻译方法。看最后一个字符，判断它与前一个字符能否构成有效翻译，计算 res[i]：
 *
 * 能，那么 res[i] = res[i - 1] + res[i - 2]；
 * 不能，那么 res[i] = res[i - 1]。
 *
 */
public class Sub46_TranslateNumberToString {

    public static void main(String[] args) {
        Sub46_TranslateNumberToString test = new Sub46_TranslateNumberToString();
        System.out.println(test.getTranslateCount("12258"));
    }

    public int getTranslateCount(String str){

        if (str==null || str.length()<1){
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] result = new int[len];
        result[0]=1;
        result[1]=isCombination(chars[0],chars[1])?2:1;

        for (int i = 2; i < len; i++) {
            if (isCombination(chars[i-1],chars[i])){

                result[i]= result[i-1]+result[i-2];
            }else {
                result[i]= result[i-1];
            }
        }
        return result[len-1];
    }

    private boolean isCombination(char i, char j) {
        int num = (i-'0')*10+(j-'0');
        return num>=10 && num<=25;
    }
}
