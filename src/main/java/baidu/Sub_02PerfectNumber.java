package baidu;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name baidu
 * @date 2019/4/1 19:29
 * @description God Bless, No Bug!
 *
 * 判断一个整数是否是完全数
 *  完全数:完全数等于其所有因数的和,不包含自身,但包含1
 *  例如:
 *      28 = 1+2+4+7+14
 */
public class Sub_02PerfectNumber {

    public static void main(String[] args) {

        for (int i = 1; i < 1000; i++) {

            int num = perfectNumberCheck(i);
            if (num == 1){
                System.out.println(i+" 是完全数");
            }
        }
    }

    public static int perfectNumberCheck(int n){
        if (n==1) {
            return 1;
        }
        int sum = 1;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {

            if (n%i==0){
                sum += i;
                if (i!=n/i){
                    sum += n/i;
                }
            }
        }
        return sum==n?1:0;
    }
}
