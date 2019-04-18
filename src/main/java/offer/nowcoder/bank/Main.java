package offer.nowcoder.bank;

/**
 * @author LRK
 * @date 2019/4/9 19:35
 * @project Offer
 * description:
 * God Bless, No Bug!
 *
 * int n = in.nextInt();
 *             if (n<6){
 *                 System.out.println(0);
 *                 continue;
 *             }
 *              long res = (long) Math.pow(2, n - 6);
 *             System.out.println(res%999999999);
 */
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n<6){
                System.out.println(0);
                continue;
            }
            BigDecimal res = new BigDecimal(1);
            BigDecimal two = new BigDecimal(2);
            for (int i = 0; i < n - 6; i++) {
                res = res.multiply(two);
            }
            System.out.println(res.divideAndRemainder(new BigDecimal("666666666"))[1]);
//            long res = (long) Math.pow(2, n - 6);
//            System.out.println(res%999999999);
        }
    }

}
