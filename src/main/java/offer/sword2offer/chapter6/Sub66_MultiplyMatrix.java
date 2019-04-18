package offer.sword2offer.chapter6;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/10 16:50
 * @description God Bless, No Bug!
 */
public class Sub66_MultiplyMatrix {
    public static void main(String[] args) {
        Sub66_MultiplyMatrix test = new Sub66_MultiplyMatrix();
        System.out.println(Arrays.toString(test.multiply(new int[]{1,2,3,4,5})));
    }

    public int[] multiply(int[] A) {
        int n =  A.length;
        int[] B = new int[n];
        if (n < 1) return B;

        B[0] = 1;
        for (int i = 1; i < n; i++) {// 计算下三角
            B[i] = B[i-1]*A[i-1];
        }
        int temp = 1;
        for (int j=n-2;j>=0;j--){ // 计算上三角
            temp *= A[j+1];
            B[j] *= temp;
        }
        return B;
    }
}
