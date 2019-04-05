package algorithm.math_bit;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LRK
 * @date 2019/4/5 16:53
 * project_name LeetCode
 * package_name algorithm.math_bit
 * description:
 * God Bless, No Bug!
 *
 * 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 *   如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 *
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 *
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 */
public class _03FractionToDecimal {

    public static void main(String[] args) {

        System.out.println(new _03FractionToDecimal().fractionToDecimal(-2147483648,-1));

    }
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator==0){
            return null;
        }
        int s1 = numerator>=0?1:-1;
        int s2 = denominator>=0?1:-1;
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        long out = num/den;
        long rem = num%den;

        Map<Long,Integer> map =new HashMap<>();
        StringBuilder res = new StringBuilder(String.valueOf(out));
        if (s1*s2 == -1 && (out>0 || rem>0)) {
            res.insert(0,"-");
        }
        if (rem==0){
            return res.toString();
        }
        res.append(".");
        int pos = res.length();
        while (rem!=0){

            if (map.containsKey(rem)){
                res.insert(map.get(rem),"(");
                res.append(")");
                break;
            }
            res.append(Math.abs((rem*10)/den));
            map.put(rem,pos++);
            rem = (rem*10)%den;
        }
        return res.toString();
    }
}
