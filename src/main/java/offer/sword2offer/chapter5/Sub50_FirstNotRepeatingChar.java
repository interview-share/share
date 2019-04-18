package offer.sword2offer.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/8 21:24
 * @description God Bless, No Bug!
 */
public class Sub50_FirstNotRepeatingChar {
    public static void main(String[] args) {
        Sub50_FirstNotRepeatingChar test = new Sub50_FirstNotRepeatingChar();
        System.out.println(test.FirstNotRepeatingChar("abcedsafjkshkjd"));
    }

    public int FirstNotRepeatingChar(String str) {

        if (str==null || str.length()==0) return -1;
        char[] chars = str.toCharArray();

        Map<Character,Integer> charMap = new HashMap<>();
        for (char c : chars) {

            if (!charMap.containsKey(c)){
                charMap.put(c,1);
            }else {
                charMap.put(c,charMap.get(c)+1);
            }
        }
        for (int i = 0; i < chars.length; i++) {

            if (charMap.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }
    private StringBuilder builder = new StringBuilder();
    Map<Character,Integer> charMap = new HashMap<>();
    public void Insert(char ch)
    {
        builder.append(ch);
        charMap.put(ch,charMap.getOrDefault(ch,0)+1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (int i = 0; i < builder.length(); i++) {
            if (charMap.get(builder.charAt(i))==1){
                return builder.charAt(i);
            }
        }
        return '#';
    }
}
