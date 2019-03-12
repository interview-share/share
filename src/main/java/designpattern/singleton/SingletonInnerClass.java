package designpattern.singleton;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name designpattern
 * @date 2019/3/6 22:45
 * @description God Bless, No Bug!
 *
 * 通过静态内部类的机制使得单例对象可以延迟加载，
 * 同时内部类相当于是外部类的静态部分，所以可以通过jvm来保证其线程安全。
 * 这种形式比较推荐。
 */
public class SingletonInnerClass {

    private static class SingletonHolder{
        private static SingletonInnerClass singleton = new SingletonInnerClass();
    }

    private SingletonInnerClass() {
    }

    public static SingletonInnerClass getInstance() {

        return SingletonHolder.singleton;
    }
}
