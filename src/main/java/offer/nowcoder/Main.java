package offer.nowcoder;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            isEquals(nums);
        }
    }

    private static void isEquals(int[] nums) {

        if (nums.length == 1){
            System.out.println("YES");
            return;
        }
        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (max>nums[i]){

                if (max % nums[i]==0){
                    int rem = max/nums[i];
                    if (rem%2!=0){
                        System.out.println("NO");
                        return;
                    }
                }else {
                    System.out.println("NO");
                    return;
                }
            }else {
                if (nums[i]==max ||(nums[i]%max==0 && (nums[i]/max)%2==0)){
                    max = Math.max(max,nums[i]);
                }else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}