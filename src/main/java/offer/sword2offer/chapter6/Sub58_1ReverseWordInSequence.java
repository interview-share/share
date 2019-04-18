package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/9 20:58
 * @description God Bless, No Bug!
 */
public class Sub58_1ReverseWordInSequence {
    public static void main(String[] args) {
        Sub58_1ReverseWordInSequence test = new Sub58_1ReverseWordInSequence();
        System.out.println(test.ReverseSentence(" "));
    }

    public String ReverseSentence(String str) {

        if (str == null || str.length() < 2) return str;
        String[] arr = str.split(" ");
        int p = 0, q = arr.length - 1;
        while (p < q) {
            swap(arr, p++, q--);
        }
        return String.join(" ", arr);
    }

    private void swap(String[] arr, int p, int q) {
        String temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}
