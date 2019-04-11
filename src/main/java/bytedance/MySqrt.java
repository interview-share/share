package bytedance;

/**
 * @author LRK
 * @date 2019/4/11 20:46
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 */
public class MySqrt {

    public int mySqrt(int x) {

        Math.sqrt(x);
        long mid = x>>1;
        while (mid>0){

            if (mid*mid<=x){
                break;
            }
            mid >>=1;
        }
        while (mid*mid<=x){
            mid++;
        }
        return (int) (mid-1);
    }
}
