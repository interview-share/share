package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 16:56
 * @description God Bless, No Bug!
 */
public class Sub48_LongestSubStringWithoutDuplication {
    public static void main(String[] args) {

        Sub48_LongestSubStringWithoutDuplication test = new Sub48_LongestSubStringWithoutDuplication();
        System.out.println(test.getLongestCount("arabcacfr"));
    }

    public int getLongestCount(String str){

        if (str==null || str.length()==0) return 0;

        int[] index = new int[26];
        for (int i = 0; i < index.length; i++) {
            index[i] = -1;
        }
        char[] chars = str.toCharArray();
        int[] result = new int[chars.length]; // result[i] 表示 以第i个字符结尾 的最长不重复子字符串长度
        result[0] = 1;
        index[chars[0]-'a'] = 0;
        int max = result[0];
        for (int i = 1; i < chars.length; i++) {
            if (index[chars[i]-'a']==-1){ // 表示之前没出现过
                result[i] = result[i-1]+1;
            }else { // 之前出现过
                int dis = i - index[chars[i]-'a']; // 与前一个相同字符的距离
                if (dis<=result[i-1]){ // 距离小于result[i-1],说明前一个相同字符位于前一个最大不相同字符之间:如 abcb
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
