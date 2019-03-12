package test;

import java.util.Hashtable;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name test
 * @date 2019/3/6 22:18
 * @description God Bless, No Bug!
 */
public class Test1 {
    private static int a = 10;

    static {
        a = 2;
        System.out.println(a);
    }
    public static void main(String[] args) {

        Hashtable hashtable;
        System.out.println(a);

        assert 1+1==2;
        System.out.println("assert1 OK");
        assert 1+1==3:"assert2 failed,exit";
        System.out.println("assert2 OK");

        String str = "abc";
        double d = 5;

        switch (str){

            case "abc":
                System.out.println(str);
                break;
                default:
                    System.out.println("null");
        }
    }


}
