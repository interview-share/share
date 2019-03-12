package solution;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name solution
 * @date 2019/3/5 13:52
 * @description God Bless, No Bug!
 */
public class _05LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new _05LongestPalindrome().Manacher("bananas"));
    }

    /**
     * p[i] = mx > i ? min(p[2 * id - i], mx - i) : 1;
     * @param s
     * @return
     */
    public String Manacher(String s) {

        StringBuilder builder = new StringBuilder("$#");
        int len = s.length();
        for (int i = 0; i < len; i++) {
            builder.append(s.charAt(i));
            builder.append('#');
        }
        builder.append('@');
        int pLen = builder.length();
        System.out.println(pLen);
        int[] p = new int[pLen];

        int mx=0,id=0,resLen=0,resCenter=0;
        for (int i = 1; i < pLen-1; i++) {

            p[i] = mx>i?Math.min(p[2*id-i],mx-i):1;
            while (builder.charAt(i+p[i])==builder.charAt(i-p[i])){
                p[i]+=1;
            }
            if (mx<i+p[i]){
                mx = i+p[i];
                id = i;
            }
            if (resLen <p[i]){
                resLen = p[i];
                resCenter =i;
            }
        }
        return s.substring((resCenter-resLen)/2,(resCenter-resLen)/2+resLen-1);
    }


    public String longestPalindrome(String s) {
        if (s==null || s.length()<1) return "";

        int len = s.length();
        int start =0,end=0;

        for (int i = 0; i < len; i++) {

            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int max = Math.max(len1, len2);
            if (max >end-start){
                start = i-(max-1)/2;
                end = i+max/2;
            }
        }
        return s.substring(start,end+1);
    }

    /**
     * 获取最长回文字符串的长度 中心扩展
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        int L = left,R = right;
        while (L>=0 && R<s.length()&& s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }

    public String longestPalindrome2(String s) {
        if (s==null) return s;

        int len = s.length();
        int[] palindrome = new int[len];

        // 初始化
        palindrome[0] = 1;
        int max = palindrome[0];
        String res = s.substring(0,1);
        for (int i = 1; i < len; i++) {

            palindrome[i] = 1;
            // 查看当前字符是否与 以前一个字符结尾 的回文字符串 的前一个是否相等
            char cur = s.charAt(i);
            if ( palindrome[i-1] <i && cur == s.charAt(i-1-palindrome[i-1])){
                palindrome[i] = palindrome[i-1]+2;
                if (palindrome[i] > max){ // 更新最长回文结果
                    max = palindrome[i];
                    res = s.substring(i-max+1,i+1);
                }
            }else {
                int j = i;
                while (j>0){
                    if (cur != s.charAt(--j)){
                        break;
                    }
                    palindrome[i] += 1;
                }
                if (palindrome[i] > max){ // 更新最长回文结果
                    max = palindrome[i];
                    res = s.substring(i-max+1,i+1);
                }
            }

        }
        return res;
    }
}
