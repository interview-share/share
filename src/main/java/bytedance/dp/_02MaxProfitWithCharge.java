package bytedance.dp;

/**
 * @author LRK
 * @date 2019/5/16 20:47
 * @project LeetCode
 * @description: God Bless, No Bug!
 *
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；
 * 非负整数 fee 代表了交易股票的手续费用。
 *
 *  你可以无限次地完成交易，但是你每次交易都需要付手续费。
 *  如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */
public class _02MaxProfitWithCharge {

    public static void main(String[] args) {

        int[] prices = {1,3,7,5,10,3};
        System.out.println(new _02MaxProfitWithCharge().maxProfit(prices,3));
    }

    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        if (n<2){
            return 0;
        }
        // 没有股票时: min初始化为新的交易的最低价
        // 持有股票时: min表示上次交易的卖出额-fee,相当于无手续费时的卖出额
        int min = prices[0];
        int sum = 0;
        for (int i = 1; i < n; i++) {

            if (prices[i]<min){
                // 新的买入价-旧的买入价 < fee 表示上一次交易成功,重新初始化min
                min = prices[i];
            }else if (prices[i]-fee>min){
                sum += prices[i]-fee-min;
                min = prices[i]-fee;
            }
        }
        return sum;
    }

    public int maxProfit2(int[] prices, int fee) {

        int min = prices[0];
        int sum = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {

            if (prices[i]<min){
                min = prices[i];
            }else if (prices[i]-fee>min){
                sum += prices[i]-fee-min;
                min = prices[i]-fee;
            }
        }
        return sum;
    }
}
