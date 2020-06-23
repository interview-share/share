package offer.sword2offer.chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/2/1 15:50
 * @description God Bless, No Bug!
 *
 * 剪绳子
 * 题目描述
 * 给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]k[1]…*k[m]可能的最大乘积是多少？
 * 例如当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到最大的乘积18。
 */
public class Sub14_CuttingRope {
    public static void main(String[] args) {

        int max = getMaxProduct2(14);
        System.out.println(max);
    }

    /**
     * 贪心算法
     *  时间复杂度O(1)，空间复杂度O(1)。
     *
     * 贪心策略：
     *
     *  当 n>=5 时，尽可能多地剪长度为 3 的绳子
     *  当剩下的绳子长度为 4 时，就把绳子剪成两段长度为 2 的绳子。
     * 证明：
     *
     *  当 n>=5 时，可以证明 2(n-2)>n，并且 3(n-3)>n。
     *      也就是说，当绳子剩下长度大于或者等于 5 的时候，可以把它剪成长度为 3 或者 2 的绳子段。
     *  当 n>=5 时，3(n-3)>=2(n-2)，因此，应该尽可能多地剪长度为 3 的绳子段。
     *  当 n=4 时，剪成两根长度为 2 的绳子，其实没必要剪，只是题目的要求是至少要剪一刀。
     * @param number
     * @return
     */
    private static int getMaxProduct2(int number) {

        if (number<2){
            return 0;
        }
        if (number <4) {
            return number-1;
        }
        int timesOf3 = number/3;
        // 如果最后剩下4米
        if (number%3 == 1){
            timesOf3 -= 1;
        }
        int timesOf2 = (number-timesOf3*3)/2;
        return (int) (Math.pow(3,timesOf3)*Math.pow(2,timesOf2));
    }

    /**
     * 动态规划法
     *  时间复杂度O(n²)，空间复杂度O(n)。
     *
     *     长度为 2，只可能剪成长度为 1 的两段，因此 f(2)=1
     *     长度为 3，剪成长度分别为 1 和 2 的两段，乘积比较大，因此 f(3) = 2
     *     长度为 n，在剪第一刀的时候，有 n-1 种可能的选择，剪出来的绳子又可以继续剪，
     *     可以看出，原问题可以划分为子问题，子问题又有重复子问题。
     * @param target
     * @return
     */
    private static int getMaxProduct(int target) {

        if (target<2){
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        // 子问题的最优解,保存下来避免重复计算
        int[] product = new int[target+1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
        int max=0;
        for (int i=4;i<=target;i++){
            max = 0;
           for (int j=1;j<=i/2;j++){
               product[i] = Math.max(max,product[j]*product[i-j]);
           }
        }
        return product[target];
    }
}
