package algorithm.dp;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.dp
 * @date 2019/4/1 23:41
 * @description God Bless, No Bug!
 *
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class _05NumSquares {

    public static void main(String[] args) {
        System.out.println(new _05NumSquares().numSquares(61));
    }

    /**
     *  解题思路:
     *  从平方数的开平方开始,递减计算 比如要求12的最小个数,
     *      比 12 小的最大平方数是 9(9=3*3)
     *      所以从 3 开始循环 result = 1 +  numSquaresHelper(res, 12 - 9);
     *      中间有很多重复计算的结果,所以用一个数组缓存中间结果,避免大量重复计算
     *      依次计算 从2,1 开始递归的结果,找出最小值
     */
    public int numSquares(int n) {
        // 用数组缓存下中途求得的值,避免大量重复计算
        int[] res = new int[n+1];
        return numSquaresHelper(res,n);
    }
    public int numSquaresHelper(int[] res,int n){
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n){
            res[sqrt*sqrt] = 1;
            return 1;
        }
        int min = n;
        for (int j = sqrt; j > 0; j--) {
            int remain = n - j * j;
            int count=0;
            if (res[remain]==0){
                int tmp = numSquaresHelper(res,remain);
                res[remain] = tmp;
                count = 1 + tmp;
            }else {
                count = 1 + res[remain];
            }
            if (count <min){
                min = count;
            }
        }
        return min;
    }

    private int getMinCount(int[] res, int num) {
        int i = getSubSquare(num);
        if (i*i == num) {
            return 1;
        }
        int min = num;
        for (int j = i; j > 0; j--) {
            int square = j * j;
            int count = res[square]+getMinCount(res,num- square);
            if (count < min){
                min = count;
            }
        }
        return min;
    }

    /**
     * 找出比n小的最大平方数
     * @param n
     * @return
     */
    public int getSubSquare(int n){
        int sqrt = (int) Math.sqrt(n);
        return sqrt;
    }
}
