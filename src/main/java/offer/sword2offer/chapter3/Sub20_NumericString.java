package offer.sword2offer.chapter3;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/2 15:50
 * @description God Bless, No Bug!
 *
 * 表示数值的字符串
 * 题目描述
 *  请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *      例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *      但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 解法
 *  解法一
 *      利用正则表达式匹配即可。
 *      new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
 *
 *  解法二【剑指offer解法】
 *      表示数值的字符串遵循模式A[.[B]][e|EC]或者.B[e|EC]，其中A为数值的整数部分，
 *      B紧跟小数点为数值的小数部分，C紧跟着e或者E为数值的指数部分。
 *      上述A和C都有可能以 + 或者 - 开头的09的数位串，B也是09的数位串，但前面不能有正负号。
 */
public class Sub20_NumericString {

    public static void main(String[] args) {
        boolean flag = isNumber2("6.5e2".toCharArray());
        System.out.println(flag);
    }

    private static int index = 0;
    private static boolean isNumber2(char[] str) {
        if (str==null || str.length==0){
            return false;
        }
        // 判断是否存在整数
        boolean flag = scanInteger(str);

        // 小数部分
        if (index<str.length && str[index]=='.'){
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        if (index<str.length && (str[index]=='e' || str[index]=='E')){
            index++;
            flag = scanInteger(str) && flag;
        }
        return flag && index == str.length;
    }

    private static boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index<str.length && str[index]>='0' && str[index]<='9'){
            index++;
        }
        return index>start;
    }

    private static boolean scanInteger(char[] str) {
        while (index<str.length && (str[index]=='+' || str[index]=='-')){
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private static boolean isNumber(char[] str) {

        return str!=null && str.length!=0
                &&new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

}
