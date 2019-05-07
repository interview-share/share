package offer.nowcoder;

import java.util.Scanner;

/**
 * @author LRK
 * @date 2019/5/3 17:42
 * @project LeetCode
 * @description: God Bless, No Bug!
 */
public class BigMultiply {

    public static void  main(String[] args){
        Scanner in = new Scanner(System.in);
        String num1 = in.next();
        String num2 = in.next();
        String res = getMultiply(num1,num2);
        System.out.println(res);
    }
    private static String getMultiply(String num1,String num2){
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        // 结果可能有 n1+n2 位或者 n1+n2-1 位
        int[] res = new int[n1+n2];
        for(int i = n1-1;i>=0;i--){
            for(int j= n2-1;j>=0;j--){

                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int high = i+j;
                int low = i+j+1;
                int sum = mul +res[low];
                res[low] = sum%10;
                res[high] += sum/10;
            }
        }
        int i = 0;
        while(res[i]==0){
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for(;i<res.length;i++){
            builder.append(res[i]);
        }
        return builder.toString();
    }
}
