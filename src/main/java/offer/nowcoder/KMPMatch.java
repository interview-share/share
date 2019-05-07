package offer.nowcoder;

/**
 * @author LRK
 * @date 2019/5/7 23:39
 * @project LeetCode
 * @description: God Bless, No Bug!
 */
public class KMPMatch {

    public static void main(String[] args) {

        System.out.println(new KMPMatch().kmpSearch("BBC ABAB ABCDABCDABDE", "ABAB"));
    }

    public int kmpSearch(String str, String pattern) {

        // 双索引依次匹配,若当前字符匹配,双索引加1
        // 若当前字符不匹配,i不变,j=next[j]继续匹配
        // 直到匹配成功或者i已到达str末尾

        int i = 0, j = 0;
        int m = str.length(), n = pattern.length();

        int[] next = getNext(pattern.toCharArray());

        while (i < m && j < n) {

            if (j == -1 || str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == n) {
            return i - j;
        } else {
            return -1;
        }

    }

    private int[] getNext(char[] p) {

        int n = p.length;
        int[] next = new int[n];
        // 赋初值-1
        next[0] = -1;
        // next[j]的值,即不包含pattern[j]的前后缀匹配的长度
        int k = -1;
        // 递归求解next[j]
        int j = 0;

        while (j < n - 1) {
            if (k == -1 || p[j] == p[k]) {
                ++j;
                ++k;
//                next[j]=k;
                if (p[j] != p[k]) {

                    next[j] = k;
                } else {
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
