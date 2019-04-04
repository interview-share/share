package algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name string
 * @date 2019/3/9 0:59
 * @description God Bless, No Bug!
 *
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */
public class _08FirstUniqueChar {
    public int firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,i);
            }else{
                map.put(c,-1);
            }
        }
        for(Character key : map.keySet()){
            if( map.get(key)!=-1){
                return map.get(key);
            }
        }
        return -1;
    }
}
