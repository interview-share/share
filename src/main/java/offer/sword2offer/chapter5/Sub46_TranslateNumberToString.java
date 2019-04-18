package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 15:29
 * @description God Bless, No Bug!
 */
public class Sub46_TranslateNumberToString {

    public static void main(String[] args) {
        Sub46_TranslateNumberToString test = new Sub46_TranslateNumberToString();
        System.out.println(test.getTranslateCount("12258"));
    }

    public int getTranslateCount(String str){

        if (str==null || str.length()<1){
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] result = new int[len];
        result[0]=1;
        result[1]=isCombination(chars[0],chars[1])?2:1;

        for (int i = 2; i < len; i++) {
            if (isCombination(chars[i-1],chars[i])){

                result[i]= result[i-1]+result[i-2];
            }else {
                result[i]= result[i-1];
            }
        }
        return result[len-1];
    }

    private boolean isCombination(char i, char j) {
        int num = (i-'0')*10+(j-'0');
        return num>=10 && num<=25;
    }
}
