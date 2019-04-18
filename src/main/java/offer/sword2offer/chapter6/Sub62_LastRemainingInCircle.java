package offer.sword2offer.chapter6;

import java.util.ArrayList;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/10 14:34
 * @description God Bless, No Bug!
 */
public class Sub62_LastRemainingInCircle {
    public static void main(String[] args) {
        Sub62_LastRemainingInCircle test = new Sub62_LastRemainingInCircle();
        System.out.println(test.LastRemaining_Solution2(5, 3));
    }

    private int LastRemaining_Solution2(int n, int m) {
        if (n<1|| m<1) return -1;

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last+m)%i;
        }
        return last;
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n<1|| m<1) return -1;
        ArrayList<Integer> circle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        int index = (m-1)%n;
        while (circle.size()>1){

            circle.remove(index);
            index +=(m-1);
            index %= circle.size();
        }
        return circle.get(0);
    }

}
