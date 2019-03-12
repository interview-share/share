package base;

import org.junit.Test;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name base
 * @date 2019/3/6 22:16
 * @description God Bless, No Bug!
 */
public class TestAssert {

    @Test
    public void testAssert(){

        assert 1+1==2;
        System.out.println("assert1 OK");
        assert 1+1==3:"assert2 failed,exit";
        System.out.println("assert2 OK");
    }
}
