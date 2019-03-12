package solution;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name solution
 * @date 2019/3/5 18:54
 * @description God Bless, No Bug!
 */
public class _07Reverse {
    public static void main(String[] args) {
        System.out.println(new _07Reverse().reverse2(1534236469));
        System.out.println((-19) % 10);
    }
    public int reverse3(int x) {

        StringBuilder builder = new StringBuilder();
        boolean flag = x>=0;
        builder.append(Math.abs(x));
        try {

            int res = Integer.parseInt(builder.reverse().toString());
            if (flag){
                return res;
            }else {
                return -res;
            }
        }catch (Exception e){
            return 0;
        }
    }

    public int reverse2(int x) {

        int rev = 0;
        while (x != 0) {
            int mod = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && mod > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && mod < -8)) {
                return 0;
            }
            rev = rev * 10 + mod;
        }
        return rev;
    }

    public int reverse(int x) {
        if (x == 0) return 0;
        boolean pos = x >= 0;

        int unSignX = pos ? x : -x;

        while (unSignX % 10 == 0) {
            unSignX /= 10;
        }

        // 123
        long res = unSignX;
        long rev = 0;
        long mod = 0;
        while (res > 0) {
            mod = res % 10; //3 余数
            rev = rev * 10 + mod;
            res = res / 10;
        }
        rev = pos ? rev : -1 * rev;
        if (rev > Integer.MAX_VALUE / 2 || rev < Integer.MIN_VALUE) return 0;
        return (int) rev;
    }
}
