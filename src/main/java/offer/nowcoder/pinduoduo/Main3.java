package offer.nowcoder.pinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LRK
 * @project_name Offer
 * @package_name nowcoder.pinduoduo
 * @date 2019/4/3 19:51
 * @description God Bless, No Bug!
 */

public class Main3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNextLine()) {
            String strA = in.nextLine();
            String strB = in.nextLine();

            List<Character> a =new ArrayList<>();
            List<Character> b =new ArrayList<>();
            for (char c : strA.toCharArray()) {
                a.add(c);
            }
            int len = a.size();

            for (char c : strB.toCharArray()) {
                b.add(c);
            }
            int cnt=0;
            a.retainAll(b);
            cnt += (len-a.size());
            int incnt = 0;
            while (a.size()>0){
                if (!a.get(0).equals(b.get(0))){
                    incnt++;
                }
                a.remove(0);
                b.remove(0);
            }
            System.out.println(cnt+incnt>>1);
        }
    }
}
