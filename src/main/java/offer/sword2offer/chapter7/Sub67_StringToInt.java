package offer.sword2offer.chapter7;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter7
 * @date 2019/2/10 18:48
 * @description God Bless, No Bug!
 */
public class Sub67_StringToInt {
    public static void main(String[] args) {
        Sub67_StringToInt test = new Sub67_StringToInt();
        System.out.println(test.StrToInt("123"));
    }

    public int StrToInt(String str) {

        if (str ==null || str.length()==0) return 0;
        char[] chars = str.toCharArray();
        int len = chars.length;
        boolean minus = false;
        int start = 0;
        if (chars[0]=='+'||chars[0]=='-'){
            if (len==0){
                return 0;
            }
            if (chars[0]=='-'){
                minus = true;
            }
            start = 1;
        }
        int value = 0;
        for (int i = start; i < len; i++) {
            if (chars[i]<'0'||chars[i]>'9'){
                return 0;
            }
            value = (value<<1)+(value<<3)+(chars[i]&0xf);
        }
        return minus?-1*value:value;
    }

}
