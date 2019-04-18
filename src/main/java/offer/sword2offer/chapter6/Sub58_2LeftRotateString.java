package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/9 21:19
 * @description God Bless, No Bug!
 */
public class Sub58_2LeftRotateString {

    public String LeftRotateString(String str,int n) {
        if (str==null || n<0) return str;
        String pre = str.substring(0,n);
        String next = str.substring(2);
        return next+pre;
    }
}
