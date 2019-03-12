package solution;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name solution
 * @date 2019/3/5 16:15
 * @description God Bless, No Bug!
 */
public class _06Convert {

    public static void main(String[] args) {
//        System.out.println(new _06Convert().convert("PAYPALISHIRING", 1));
        System.out.println(new String(""+-2));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int len = s.length(); //
        int dis = 2 * numRows - 2; // 间隔之和
        StringBuilder builder = new StringBuilder();
        for (int j = dis,i= 0; j >= 0&& i<numRows; j-= 2,i++) {
            int z = i;
            int interval = dis - j;
            while (z <len) {
                builder.append(s.charAt(z));
                interval = (dis - interval);
                if (interval == 0) interval = dis;
                z += interval;
            }
        }
        return builder.toString();
    }

}

