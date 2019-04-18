package offer.sword2offer.chapter4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter4
 * @date 2019/2/5 20:16
 * @description God Bless, No Bug!
 *  字符串的排列组合,递归的运用
 */
public class Sub38_StringPermutation {
    public static void main(String[] args) {
        System.out.println("123的排列: "+ permutation("123"));
        System.out.println("abc的组合:");
        combination("abc");
    }

    /**
     * 求字符串的排列
     * @param str
     * @return
     */
    public static ArrayList<String> permutation(String str) {

        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() <= 0) {
            return list;
        }

        char[] chars = str.toCharArray();
        permutation(chars, 0, list);
//        Collections.sort(list);
        return list;
    }

    private static void permutation(char[] chars, int begin, ArrayList<String> list) {

        if (begin == chars.length - 1) {
            // 得到一个排列
            list.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = begin; i < chars.length; i++) {

            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                // 固定index字符
                swap(chars, i, begin);
                // 递归固定剩余字符
                permutation(chars, begin + 1, list);
                // 恢复原数组
                swap(chars, i, begin);
            }
        }
    }

    /**
     * 求字符串的组合
     * @param str
     * @return
     */
    public static void combination(String str){
        if (str==null || str.length()==0) {
            return;
        }

        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 1; i <= chars.length; i++) {

            combination(chars,0,i,builder);
        }
    }

    /**
     * 从start下标开始找出m个数字组合
     * @param chars
     * @param start
     * @param m
     * @param builder
     */
    private static void combination(char[] chars, int start, int m, StringBuilder builder) {

        // 从剩余的字符串中选出0个,表示已经选出m个,递归结束
        if (m==0){
            System.out.println(builder.toString());
            return;
        }
        if (start == chars.length){
            return;
        }
        // 组合中包含chars[start]
        builder.append(chars[start]);
        combination(chars,start+1,m-1,builder);
        // 组合中不包含chars[start]
        builder.deleteCharAt(builder.length()-1);
        combination(chars,start+1,m,builder);
    }

    private static void swap(char[] chars, int i, int j) {
        Character temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
