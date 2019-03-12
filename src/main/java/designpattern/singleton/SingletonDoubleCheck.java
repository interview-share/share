package designpattern.singleton;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name designpattern
 * @date 2019/3/6 22:43
 * @description God Bless, No Bug!
 */
public class SingletonDoubleCheck {
    private static SingletonDoubleCheck singleton = null;
    private SingletonDoubleCheck(){}
    public static SingletonDoubleCheck getInstance(){

        if (singleton == null){
            synchronized (SingletonDoubleCheck.class){
                if (singleton == null){
                    singleton = new SingletonDoubleCheck();
                }
            }
        }
        return singleton;
    }
}
