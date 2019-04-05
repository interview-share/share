package bytedance.string;

/**
 * @author LRK
 * @date 2019/4/5 23:25
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 *  示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class _04Multiply {

    public static void main(String[] args) {

        System.out.println(new _04Multiply().multiply("123", "456"));
    }
    public String multiply(String num1, String num2) {
        if ( "0".equals(num1)|| "0".equals(num2)){
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1+n2];

        for (int i = n1-1; i >= 0; i--) {
            for (int j = n2-1; j >= 0; j--) {
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int high = i+j;
                int low = i+j+1;
                int sum = mul + res[low];
                res[low] = sum%10;
                res[high] += sum/10;
            }
        }
        StringBuilder builder = new StringBuilder();
        // 去掉高位的0
        int begin = 0;
        while (res[begin]==0){
            begin++;
        }
        for (int i = begin; i <= res.length-1; i++) {
            builder.append(res[i]);
        }
        return builder.length()==0?"0":builder.toString();
    }
}
