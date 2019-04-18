package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/10 15:55
 * @description God Bless, No Bug!
 */
public class Sub64_SumWithNoLoop {
    public static void main(String[] args) {

        Sub64_SumWithNoLoop test = new Sub64_SumWithNoLoop();
        System.out.println(test.getSum(10));
    }

    public int getSum(int n){

        int ans = n;
        boolean flag =(n!=0)&&(ans +=getSum(n-1))==0;
        return ans;
    }
}

