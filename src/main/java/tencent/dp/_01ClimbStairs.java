package tencent.dp;

/**
 * @author LRK
 * @date 2019/4/13 16:06
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 */
public class _01ClimbStairs {

    public int climbStairs(int n) {

        if(n<3){
            return n;
        }
        int[] fibonacci = new int[n+1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        for (int i = 3; i <= n; i++) {
            fibonacci[i] = fibonacci[i-1]+fibonacci[i-2];
        }
        return fibonacci[n];
    }
}
