package bytedance.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @date 2019/4/6 15:16
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *      两个经验，
 *          一是只要遇到字符串的子序列或配准问题首先考虑动态规划DP，
 *          二是只要遇到需要求出所有可能情况首先考虑用递归。
 *
 *  复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 *  示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 */
public class _07RestoreIpAddresses {

    public static void main(String[] args) {

        System.out.println(new _07RestoreIpAddresses().restoreIpAddresses2("010010"));
    }

    /**
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses2(String s) {

        List<String> res = new ArrayList<>();
        helper(s,0,"",res);
        return res;

    }

    /**
     *
     * @param remain 剩余字符串
     * @param n 第 n 段ip
     * @param cur 当前已拼接子串
     * @param res   list结果
     */
    private void helper(String remain, int n, String cur, List<String> res) {
        // 返回条件
        if (n == 4){
            if (remain.isEmpty()){
                res.add(cur);
            }
            return;
        }
        // 每段ip可能有 1,2,3位数字
        for (int i = 1; i < 4; i++) {

            if (remain.length()<i){
                break;
            }
            int num = Integer.valueOf(remain.substring(0,i));
            if (num>255 || i!=String.valueOf(num).length()) {
                continue;
            }
            helper(remain.substring(i),n+1,cur+num+(n==3?"":"."),res);
        }
    }

    public List<String> restoreIpAddresses(String s) {

        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    for (int l = 1; l <= 3; l++) {

                        if ((i+j+k+l)==n ){

                            String ip = matchIp(s, i, j, k, l);
                            if (ip !=null){
                                res.add(ip);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private String matchIp(String s, int i, int j, int k, int l) {

        StringBuilder builder = new StringBuilder();
        if (matchNum(s,builder,0,i) && matchNum(s,builder,i,j) &&
                matchNum(s,builder,i+j,k)&& matchNum(s,builder,i+j+k,l)){
            return builder.substring(0,builder.length()-1);
        }
        return null;
    }
    private boolean matchNum(String s,StringBuilder builder, int begin, int len) {

        String sub = s.substring(begin, begin+len);
        if (sub.startsWith("0") && len>1){
            return false;
        }
        Integer num = Integer.valueOf(sub);
        builder.append(num).append(".");
        return num>=0 && num<=255;
    }
}
