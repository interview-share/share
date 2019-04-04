package algorithm.sort;

import java.util.*;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.sort
 * @date 2019/3/21 21:26
 * @description God Bless, No Bug!
 *
 * 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class _01LargestNumber {
    public static void main(String[] args) {

        System.out.println(new _01LargestNumber().largestNumber2(new int[]{3, 30, 34, 5, 9}));
    }

    public String largestNumber(int[] nums) {
        StringBuilder builder = new StringBuilder();
        int max = 0;
        for (int num : nums) {
            if (num > max){
                max = num;
            }
        }
        int len = 0; // 算出最大数的位数
        while (max!=0){
            ++len;
            max /=10;
        }
        int[] sort = new int[nums.length]; // 排序的数组
        int[] supplement = new int[nums.length]; // 补位长度数组
        for (int i = 0; i < nums.length; i++) {

            int cnt = String.valueOf(nums[i]).length();
            supplement[i] = len-cnt;
            int tail = String.valueOf(nums[i]).charAt(0)-'0';
            int num = nums[i];
            while (cnt < len){
                num = num*10+tail;
                cnt++;
            }
            sort[i] = num;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i,j) ->{
            if (sort[i] == sort[j]){
                int num = sort[i];
                int tail = num %10;
                int pre = (num/10)%10;
                while (tail == pre&& num!=0){
                    num /= 10;
                    pre = num%10;
                }
                if (pre<tail) {
                    return supplement[i]-supplement[j];
                } else {
                    return supplement[j]-supplement[i];
                }
            }else {
                return sort[j] - sort[i];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(i);
        }
        while (!maxHeap.isEmpty()){
            builder.append(nums[maxHeap.poll()]);
        }
        String res = builder.toString();
        return res.startsWith("0")?"0":res;
    }

    public String largestNumber2(int[] nums) {


        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1)+o2;
                String s2 = String.valueOf(o2)+o1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (Integer integer : integers) {
            builder.append(integer);
        }
        String s = builder.toString();
        return s.startsWith("0")?"0": s;
    }
}
