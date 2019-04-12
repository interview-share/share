package tencent;

/**
 * @author LRK
 * @date 2019/4/12 20:49
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 */
public class _09ReverseWords {

    public String reverseWords(String s) {
        if (s.isEmpty()){
            return s;
        }
        String[] split = s.split(" +");
        for (int i = 0; i < split.length; i++) {
            split[i] = reverse(split[i].toCharArray());
        }
        return String.join(" ",split);
    }
    private String reverse(char[] chars){
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char tmp = chars[i];
            chars[i]= chars[n-1-i];
            chars[n-1-i] = tmp;
        }
        return new String(chars);
    }
}
