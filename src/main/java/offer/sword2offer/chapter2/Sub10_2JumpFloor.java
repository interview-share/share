package offer.sword2offer.chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/31 16:15
 * @description God Bless, No Bug!
 *
 *  一只青蛙每次可以跳上 1级或2级 台阶,
 *  求跳上n级台阶有几种跳法
 */
public class Sub10_2JumpFloor {

    public static void main(String[] args) {
        Integer result = getFibonacci(3);
        System.out.println(result);
    }

    private static Integer getFibonacci(int target) {

        if (target<=0) {
            return -1;
        }
        if (target<=2) {
            return target;
        }

        int pre = 1;
        int next = 2;
        int result = 0;
        for (int i=3;i<=target;i++){
            result = pre+next;
            pre = next;
            next = result;
        }

        return result;
    }

    /**
     * 变态跳台阶,一次可以跳 1--n级台阶
     *  f(n) = 1 + f(n-1) + f(n-2) +...+ f(1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
