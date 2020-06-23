package offer.sword2offer.chapter5;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 16:56
 * @description God Bless, No Bug!
 *
 * 最长不含重复字符的子字符串
 * 题目描述
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 假设字符串中只包含从 a 到 z的字符。
 *
 * 解法
 * 动态规划。
 *
 * res[i] 表示以 s[i] 字符结尾的最长不重复字符串的长度。判断 s[i]：
 *
 * 若 s[i] 在前面没出现过，那么 res[i] = res[i - 1] + 1；
 * 若 s[i] 在前面有出现过，判断它上一次出现的位置 index 到 i 的距离 d 与 res[i - 1] 的大小关系：
 *      若 d <= res[i - 1]，说明它被包含在 res[i - 1] 构成的子串中，那么 res[i] = d；
 *      若 d > res[i - 1]，说明它在 res[i - 1] 构成的子串的左侧，那么 res[i] = res[i - 1] + 1。
 * 需要用一个数组 t 记录一下当前出现的字符在哪个位置。
 *
 */
public class Sub48_LongestSubStringWithoutDuplication {
    public static void main(String[] args) {

        Sub48_LongestSubStringWithoutDuplication test = new Sub48_LongestSubStringWithoutDuplication();
        System.out.println(test.getLongestCount("arabcacfr"));
    }

    public int getLongestCount(String str){

        if (str==null || str.length()==0) {
            return 0;
        }
        // 记录上一次出现的字符位置
        int[] index = new int[26];
        Arrays.fill(index, -1);
        char[] chars = str.toCharArray();
        // result[i] 表示 以第i个字符结尾 的最长不重复子字符串长度
        int[] result = new int[chars.length];
        result[0] = 1;
        index[chars[0]-'a'] = 0;
        int max = result[0];
        for (int i = 1; i < chars.length; i++) {
            // 表示之前没出现过
            if (index[chars[i]-'a']==-1){
                result[i] = result[i-1]+1;
            }else { // 之前出现过
                // 与前一个相同字符的距离
                int dis = i - index[chars[i]-'a'];
                // 距离小于result[i-1],说明前一个相同字符位于前一个最大不相同字符之间:如 abcb
                if (dis<=result[i-1]){
                    result[i] = dis;
                }else {
                    result[i] = result[i-1]+1;
                }
            }
            index[chars[i]-'a'] = i; // 记录字符出现的下标
            max = Math.max(max,result[i]);
        }
        return max;
    }
}
