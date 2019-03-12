package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name solution
 * @date 2019/3/4 22:13
 * @description God Bless, No Bug!
 */
public class _03LengthOfLongestSubstring {

    public static void main(String[] args) {
//        System.out.println(new _03LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));

        System.out.println("".equals("   ".trim()));
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null) return 0;
        int len = s.length();
        // max[i] 表示以第 i 个字符结尾的无重复最长子串的长度
        int max[] = new int[len];
        int res = 0;
        max[0] = 1;
        Map<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)){ // 之前并未出现过
                max[i] = max[i-1]+1;
            }else { // 之前出现过
                int last = map.get(c); // 前一个索引
                if( (i - last) > max[i-1]){ // 中间存在其他相同的字符
                    max[i] = max[i-1]+1;
                }else {
                    max[i] = i - last;
                }
            }
            map.put(c,i); // 存下索引
            res = Math.max(res,max[i]);
        }
        return res;
    }
}
