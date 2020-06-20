package offer.nowcoder;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNext()) {
            String pattern = in.next();
            String str = in.next();
            System.out.println(match(str,pattern));
        }
    }

    private static boolean match(String str, String pattern) {
        if (str==null || pattern == null){
            return false;
        }
        return matchCore(str.toCharArray(),0,str.length(),pattern.toCharArray(),0,pattern.length());
    }

    /**
     * * 判断模式中第二个字符是否是 *：
     *      *
     *      *  若是，看模式串第一个字符与字符串第一个字符是否匹配：( 不匹配(i,j+2)/匹配一次(i+1,j+2)/匹配多次(i+1,j))
     *      *      若不匹配，在模式串上向右移动两个字符j+2，相当于 a* 被忽略
     *      *      若匹配，字符串后移i+1。此时模式串可以移动两个字符j+2(只匹配一次)，也可以不移动j(匹配多次)。
     *      *  若不是，看当前字符与模式串的当前字符是否匹配，即 str[i] == pattern[j] || pattern[j] == '.'：
     *      *      若匹配，则字符串与模式串都向右移动一位，i+1，j+1。
     *      *      若不匹配，返回 fasle。
     * @param str 字符串
     * @param i 字符串探针
     * @param lenStr str字符串长度
     * @param pattern 模式串
     * @param j 模式串探针
     * @param lenPtn 模式串长度
     * @return 是否匹配成功
     */
    private static boolean matchCore(char[] str, int i, int lenStr, char[] pattern, int j, int lenPtn) {

        if (i==lenStr && j==lenPtn){
            return true;
        }
        // 模式串结束但字符串还没结束--不匹配
        if (i!=lenStr && j==lenPtn){
            return false;
        }

        if (str[i]==pattern[j] || pattern[j]=='?'){
            return matchCore(str,i+1,lenStr,pattern,j+1,lenPtn);
        }else if (pattern[j]=='*'){
            return matchCore(str,new String(str).indexOf(pattern[j+1],i),lenStr,pattern,j+1,lenPtn);
        }
        return false;
    }

}
