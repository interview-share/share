package string;

/**
 * @author LRK
 * @project_name LeeCode
 * @package_name string
 * @date 2019/3/3 20:33
 * @description God Bless, No Bug!
 */
public class _01IsPalindrome {

    public static void main(String[] args) {

        System.out.println("abc".substring(1,2));
//        System.out.println(new _01IsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i<j){
            if(!isLegal(s,i)){
                ++i;
                continue;
            }
            if(!isLegal(s,j)){
                --j;
                continue;
            }
            if(!equalsIgnoreCase(s,i,j)){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
    public boolean equalsIgnoreCase(String s,int i,int j){

        char c1 = s.charAt(i);
        char c2 = s.charAt(j);
        if(c1 == c2) return true;
        // (((c1-c2) == 32) && ( c1>='a' && c1<='z'))  || (((c2-c1) == 32) && ( c2>='a' && c2<='z'))
        // 'a' = 97 'A' = 65
        if( ((c1-'a'+32)%32) != ((c2-'a'+32)%32) ){
            return true;
        }
        return false;
    }

    public boolean isLegal(String s,int index){
        char c = s.charAt(index);
        if( (c>='a' && c<='z') || (c>='A' && c<='Z') || ( c>='0' && c<='9')){
            return true;
        }
        return false;
    }
}
