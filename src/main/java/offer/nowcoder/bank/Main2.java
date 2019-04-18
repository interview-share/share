package offer.nowcoder.bank;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int w = in.nextInt();

            int minA = Integer.MAX_VALUE;
            int minB = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int tmp = in.nextInt();
                if (minA> tmp){
                    minA = tmp;
                }
            }
            for (int i = 0; i < n; i++) {
                int tmp = in.nextInt();
                if (minB> tmp){
                    minB = tmp;
                }
            }
            BigDecimal bigMinA = new BigDecimal(minA);
            BigDecimal bigMinB = new BigDecimal(minB);

            // 以B为准
            if (bigMinA.compareTo(bigMinB.multiply(new BigDecimal(2)))>0){
                BigDecimal v = bigMinB.multiply(BigDecimal.valueOf(3.0 * n));
                if (v.compareTo(BigDecimal.valueOf(w))<0){
                    System.out.println(String.format("%.6f", v.doubleValue()));
                }else {
                    System.out.println(String.format("%.6f",(double)w));
                }
            }else {
                BigDecimal v = bigMinA.multiply(BigDecimal.valueOf(1.5* n));
                if (v.compareTo(BigDecimal.valueOf(w))<0){
                    System.out.println(String.format("%.6f", v.doubleValue()));
                }else {
                    System.out.println(String.format("%.6f",(double)w));
                }
            }
        }
    }
}