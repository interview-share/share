package algorithm.math_bit;

/**
 * @author LRK
 * @date 2019/4/5 19:57
 * project_name LeetCode
 * package_name algorithm.math_bit
 * description:
 * God Bless, No Bug!
 *
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *  示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class _07CountPrimes {
    public static void main(String[] args) {

        System.out.println(new _07CountPrimes().countPrimes2(10));
    }

    public int countPrimes2(int n){

        if(n<=2){
            return 0;
        }
        int[] flag = new int[n];
        // 2是第一个质数
        flag[1] = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 没去掉,则该数是下一个质数
            if (flag[i]==0){

                for (int j = i*i; j < n; j+=i) {
                    flag[j]=1;
                }
            }
        }
        int cnt=0;
        for (int i = 1; i < n; i++) {
            if (flag[i]==0){
                cnt++;
            }
        }
        return cnt;
    }

    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        if (n<5){
            return n-2;
        }
        int cnt = 2;
        for (int i = 5; i < n; i+=2) {

            if (isPrimes(i)){
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isPrimes(int n){
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
