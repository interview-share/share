package test;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name test
 * @date 2019/3/14 0:45
 * @description God Bless, No Bug!
 *
 * 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明:
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 *
 * 示例 1:
 *
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * 输出: 3
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        System.out.println(new CanCompleteCircuit().canCompleteCircuit(
                new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}
        ));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        boolean flag;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            flag = true;
            int j = i;
            do {
                if (sum+gas[j]<cost[j]){
                    flag = false;
                    break;
                }else {
                    sum += (gas[j]-cost[j]);
                    j = (j+1)%n;
                }
            }while (j!=i);
            if (flag) return i;
        }
        return -1;
    }

    /**
     * 首先什么情况下车能够环绕一周？
     *
     *      在每一个加油站的消耗和所加的油的总和的累加大于0的时候，说明能环绕一周，也就是rest>=0的时候，车刚好能环绕一周。
     *
     * 如何确定从哪一站出发？
     *
     *      假设在第k站没油了，那么就从下一站出发，说明这一站耗油较大，那么当遍历结束后，并且rest>=0时，
     *      按照题目说法，肯定有一个答案，那么就是最后的那个start。
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int total = 0;
        int rest = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if (total < 0) {
                start = i + 1;
                total = 0;
            }
        }
        return rest < 0 ? -1 : start % gas.length;
    }
}
