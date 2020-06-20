package offer.algorithm;

import java.util.Arrays;
/**
 * @author LRK
 * @date 2019/5/23 12:18
 * @project LeetCode
 * @description: God Bless, No Bug!
 */
public class _06Greedy {

    public static void main(String[] args) {
        Integer[][] nums = {{10,35},{40,30},{30,60},{50,50},{35,40},{40,10},{30,25}};
        getMaxValue(nums,150);
    }

    /**
     *
     * @param nums 效益和重量数组 nums[i][0]--效益 nums[i][1]--重量
     * @param capacity 背包容量
     */
    public static void getMaxValue(Integer[][] nums,int capacity){

        int n = nums.length;

        // 1.按效益值由大到小取物品
        int curWeight = 0;
        int curValue = 0;
        Arrays.sort(nums, (p,q) -> p[0].equals(q[0]) ?p[1]-q[1]:q[0]-p[0]);
        for(int i = 0; i < n; i++) {
            if (curWeight+nums[i][1]>capacity){
                System.out.println("效益优先最大收益为: "+curValue);
                break;
            }else {
                curWeight +=nums[i][1];
                curValue += nums[i][0];
            }
        }


        // 2.按重量值由小到大取物品
        curWeight = 0;
        curValue = 0;
        Arrays.sort(nums,(p,q) -> p[1].equals(q[1])?q[0]-p[0]:p[1]-q[1]);
        for (int i = 0; i < n; i++) {
            if (curWeight+nums[i][1]>capacity){
                System.out.println("重量优先最大收益为: "+curValue);
                break;
            }else {
                curWeight+=nums[i][1];
                curValue += nums[i][0];
            }
        }

        // 3.按效益/重量的值由大到小取物品
        curWeight = 0;
        curValue = 0;
        Arrays.sort(nums,(p,q) -> {
            // 先比较商,商相同则比较模
            int resP = p[0]/p[1];
            int resQ = q[0]/q[1];
            int remP = p[0]%p[1];
            int remQ = q[0]%q[1];
            return resP==resQ?remQ-remP:resQ-resP;
        });

        for (int i = 0; i < n; i++) {
            if (curWeight+nums[i][1]>capacity){
                System.out.println("比值优先最大收益为: "+curValue);
                break;
            }else {
                curWeight+=nums[i][1];
                curValue += nums[i][0];
            }
        }
    }
}
