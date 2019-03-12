package dynamicprogramming;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name dynamicprogramming
 * @date 2019/3/10 23:47
 * @description God Bless, No Bug!
 *
 * 至少有K个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */
public class _01LongestSubstring {

    public static void main(String [] args) {

        System.out.println(new _01LongestSubstring().longestSubstring("aaabb", 2));
    }

    /**
     *  遍历字符串，对于每一个字符，都将其视为起点，然后遍历到末尾，增加哈希表中字母的出现次数，
     *  如果其小于k，我们将mask的对应位改为1，如果大于等于k，将mask对应位改为0。
     *  然后看mask是否为0，是的话就更新res结果，然后把当前满足要求的子字符串的起始位置j保存到max_idx中，
     *  等内层循环结束后，将外层循环变量i赋值为max_idx+1，继续循环直至结束
     */
    public int longestSubstring(String s, int k) {

        int n = s.length();
        int i=0;
        int max = 0;
        while (i+k<=n){
            int res[] = new int[26]; // 记录每个字符出现的次数
            int maxIndex = i; // 记录满足条件的子串末尾
            int mask = 0; // 标识是否满足每个字母都出现至少k次,某个字符要么不出现,要么出现了至少k次,mask才能为0,否则必不为0;

            for (int j = i; j < n; j++) {

                int tmp = s.charAt(j)-'a';
                res[tmp] += 1;
                if (res[tmp]<k){ // 少于k次置于1
                    mask |= (1<<tmp);
                }else { // 多于k次置于0
                    mask &= (~(1<<tmp));
                }
                if (mask == 0){
                    max = Math.max(max,j-i+1);
                    maxIndex = j;
                }
            }
            i = maxIndex+1;
        }
        return max;
    }
}
