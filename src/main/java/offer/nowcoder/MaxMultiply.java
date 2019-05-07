package offer.nowcoder;

import java.util.*;
/**
 * @author LRK
 *
 * 求数组的三个数的最大乘积
 */
public class MaxMultiply {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){

            String[] str = in.nextLine().split(" ");
            long[] nums= new long[str.length];
            for (int i=0;i<str.length;++i){
                nums[i]=Long.parseLong(str[i]);
            }
            System.out.println(getMax(nums));
        }
    }
    
    private static long getMax(long[] arr){
        
        PriorityQueue<Long> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> min = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            max.offer(arr[i]);
            min.offer(arr[i]);
        }
        long a = max.poll();
        long b = max.poll();
        long c = max.poll();
        long d = min.poll();
        long e = min.poll();
        return Math.max(a*b*c,a*d*e);
    }
}