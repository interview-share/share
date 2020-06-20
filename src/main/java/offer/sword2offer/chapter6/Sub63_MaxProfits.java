package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/10 15:39
 * @description God Bless, No Bug!
 */
public class Sub63_MaxProfits {

    public static void main(String[] args) {
        Sub63_MaxProfits test = new Sub63_MaxProfits();
        System.out.println(test.getMaxProfit(new int[]{9,11,8,5,7,12,16,14}));
    }

    public int getMaxProfit(int[] price){
        if (price==null || price.length<2) {
            return 0;
        }

        int min = price[0];
        int maxProfit = price[1]-price[0];

        for (int i = 2; i < price.length; i++) {

            if (price[i-1]<min){
                min = price[i-1];
            }
            int curProfit = price[i]- min;
            if (curProfit>maxProfit){
                maxProfit = curProfit;
            }
        }
        return maxProfit;
    }
}
