package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name test
 * @date 2019/3/14 0:32
 * @description God Bless, No Bug!
 *
 * Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            if (n%3==0 && n%5==0){
                list.add("FizzBuzz");
            }else if (n%3==0){
                list.add("Fizz");
            }else if (n%5==0){
                list.add("Buzz");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
