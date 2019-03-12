package base;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name base
 * @date 2019/3/6 20:43
 * @description God Bless, No Bug!
 */
public interface TestInterface {
    static void method() {
        System.out.println("woaini");
    }


    int a = 7; //    int a; // 默认public static final 必须初始化


    //    public final double method2(); // 只能public abstract default static 后两项需要有方法体
    default void method3() {

    }

}
