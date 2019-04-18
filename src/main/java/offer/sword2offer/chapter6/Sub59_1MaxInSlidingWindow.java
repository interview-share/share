package offer.sword2offer.chapter6;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/9 21:50
 * @description God Bless, No Bug!
 */
public class Sub59_1MaxInSlidingWindow {
    public static void main(String[] args) {
        Sub59_1MaxInSlidingWindow test = new Sub59_1MaxInSlidingWindow();
        System.out.println(test.maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3));
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (num==null||size<1||size>num.length) {
            return result;
        }

        Deque<Integer> deque = new LinkedList<>();
//        int[] res = new int[num.length-size+1];
        for (int i = 0; i < size; i++) { // 先填满滑动窗口

            if (deque.isEmpty()){
                deque.addLast(i);
            }else {
                if (num[deque.getFirst()]<num[i]){
                    while (!deque.isEmpty()){
                        deque.removeFirst();
                    }
                }else {
                    while (num[deque.getLast()]<num[i]){
                        deque.removeLast();
                    }
                }
                deque.addLast(i);
            }
        }
        for (int i = size; i < num.length; i++) { // 边移动边判断

//            res[i-size] = num[deque.getFirst()]; // 获取当前最大值
            result.add(num[deque.getFirst()]);
            if (num[i] < num[deque.getFirst()]){ // 如果比当前最大值小
                while (num[deque.getLast()]<num[i]){
                    deque.removeLast();
                }
            }else {
                while (!deque.isEmpty()){ // 如果比当前最大值大
                    deque.removeFirst();
                }
            }
            deque.addLast(i);
            if (i-deque.getFirst()==size){
                deque.removeFirst();
            }
        }
        result.add(num[deque.getFirst()]);
        return result;
    }
}
