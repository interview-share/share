package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 18:43
 * @description God Bless, No Bug!
 */
public class Sub49_UglyNumber {
    public static void main(String[] args) {

        Sub49_UglyNumber test = new Sub49_UglyNumber();
        System.out.println(test.GetUglyNumber_Solution(7));
    }

    public int GetUglyNumber_Solution(int index) {

        if (index < 1) return 0;
        if (index == 1) return 1;

        int[] result = new int[index];
        result[0] = 1;
        int T2 = 0, T3 = 0, T5 = 0;
        int M2, M3, M5;

        for (int i = 1; i < index; i++) {

            M2 = result[T2] * 2;
            M3 = result[T3] * 3;
            M5 = result[T5] * 5;
            result[i] = Math.min(Math.min(M2, M3), M5);
            if (result[i] == M2) {
                T2++;
            }
            if (result[i] == M3) {
                T3++;
            }
            if (result[i] == M5) {
                T5++;
            }
        }
        return result[index - 1];
    }
}
