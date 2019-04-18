package offer.sword2offer.chapter6;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter6
 * @date 2019/2/10 16:18
 * @description God Bless, No Bug!
 */
public class Sub65_AddWithNoSymbol {
    public static void main(String[] args) {
        Sub65_AddWithNoSymbol test = new Sub65_AddWithNoSymbol();
        System.out.println(test.Add(12, 13));
        test.exchange2(2,3);
    }

    private void exchange2(int a, int b) {
        System.out.println(a+","+b);
        a = a^b; // temp = a^b
        b = a^b; // b = temp^b=a^b^b=a
        a = a^b; // a = temp^b=a^b^a=b
        System.out.println(a+","+b);
    }

    public int Add(int num1, int num2) {

        int sum = 0, carry = 0;
        do {
            sum = num1^num2; // 不包含进位的和
            carry = (num1 & num2)<<1; // 进位
            num1 = sum;
            num2 = carry;

        } while (carry != 0);
        return num1;
    }
    private void exchange(int a,int b){
        System.out.println(a+","+b);
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a+","+b);
    }
}
