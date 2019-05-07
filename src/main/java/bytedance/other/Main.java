package bytedance.other;

import java.util.*;
/**
 * @author LRK
 */
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] nums=new int[str.length];
        for (int i=0;i<str.length;++i){
            nums[i]=Integer.parseInt(str[i]);
        }
        System.out.println(getMax(nums));
    }
    
    private static int getMax(int[] arr){
        
        PriorityQueue<Integer> max = new PriorityQueue<>((x,y) ->y-x);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            max.offer(arr[i]);
            min.offer(arr[i]);
        }
        int a = max.poll();
        int b = max.poll();
        int c = max.poll();
        int d = min.poll();
        int e = min.poll();
        return Math.max(a*b*c,a*d*e);
    }
}