package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/9 23:06
 * @description God Bless, No Bug!
 *
 *  n颗骰子可能的点数和的次数
 */
public class Sub60_PrintProbability {
    private int maxDiceValue = 6; // 骰子最大点数

    public static void main(String[] args) {
        Sub60_PrintProbability test = new Sub60_PrintProbability();
        test.printProbability3(3);
    }

    private void printProbability3(int n) {
        if (n < 1) return;
        int maxValue = maxDiceValue * n; // 6*n
        int[][] sumTimes = new int[2][maxValue+1];

        // 第一颗骰子
        int flag = 0;
        for (int i = 1; i <= maxDiceValue; i++) {
            sumTimes[flag][i] = 1;
        }
        for (int diceCount = 2; diceCount <= n; diceCount++) { // 增加骰子

            for (int sum= diceCount;sum<=maxDiceValue*diceCount;sum++){ // 增加骰子后可能的点数和
                int s = 0;
                for (int k=1;k<=maxDiceValue&& sum>k;k++){ // 当前骰子可能的点数
                    s += sumTimes[flag][sum-k];
                }
                sumTimes[1-flag][sum]=s;
            }
            flag = 1-flag;
        }
        for (int sum = n; sum <= maxValue; sum++) {
            System.out.println("点数和为"+sum+"的次数为:" + sumTimes[flag][sum]);
        }
    }

    public void printProbability2(int n) {
        if (n < 1) return;
        int maxValue = maxDiceValue * n;
        int[][] sumTimes = new int[n + 1][maxValue + 1];

        // 第一颗骰子
        for (int i = 1; i <= maxDiceValue; i++) {
            sumTimes[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) { // 增加骰子

            for (int sum= i;sum<=maxDiceValue*i;sum++){ // 增加骰子后可能的点数和

                for (int k=1;k<=maxDiceValue&& sum>k;k++){
                    sumTimes[i][sum] += sumTimes[i-1][sum-k];
                }
            }
        }
        for (int sum = n; sum <= maxValue; sum++) {
            System.out.println("点数和为"+sum+"的次数为:" + sumTimes[n][sum]);
        }
    }


    public void printProbability(int n) {

        if (n < 1) return;
        int maxValue = maxDiceValue * n;
        int[] probability = new int[maxValue - n + 1];
        getProbability(n, n, 0, probability);
        for (int i = 0; i < probability.length; i++) {
            System.out.println("点数和为" + (i + n) + "的次数:" + probability[i]);
        }
    }

    /**
     * 求出各点数可能出现的次数
     * @param n           骰子数目
     * @param remain      还剩多少颗骰子
     * @param sum         当前的点数之和
     * @param probability 可能出现的点数之和的次数,索引为(点数之和-n)
     */
    private void getProbability(int n, int remain, int sum, int[] probability) {

        if (remain == 0) {
            probability[sum - n]++;
            return;
        }
        for (int i = 1; i <= maxDiceValue; i++) {
            getProbability(n, remain - 1, sum + i, probability);
        }
    }
}
