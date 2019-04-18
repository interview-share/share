package offer.leetcode.chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name leetcode.chapter2
 * @date 2019/2/16 23:47
 * @description God Bless, No Bug!
 */
public class Sub03_LengthOfLastWord {

    public static void main(String[] args) {
        Sub03_LengthOfLastWord test = new Sub03_LengthOfLastWord();
        System.out.println(test.getLength("hello world"));
    }
    public int getLength(String str){
        if (str==null || "".equals(str.trim()) || str.split(" ").length==1) return 0;
        String[] split = str.split(" ");
        return split[split.length-1].length();
    }
}
