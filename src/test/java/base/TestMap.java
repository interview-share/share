package base;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name base
 * @date 2019/3/7 19:52
 * @description God Bless, No Bug!
 */
public class TestMap {

    @Test
    public void test(){

        Map<Integer,Integer> map = Collections.synchronizedMap(new HashMap<>());// new TreeMap<>();
        map.put(9,9);
        map.put(7,7);
        map.put(8,8);
        map.put(6,6);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(5,5);
        map.put(4,4);

        System.out.println(map);
    }
    @Test
    public void test2(){

        Map<String,String> map = new HashMap<>();
        map.put(new String("aaa"),"aaa1");
        map.put(new String("aaa"),"aaa2");
        System.out.println(map);

        int x = 8,count=0;
        while (x>0){
            x = x &(x-1); // 110 & 101 =100 6&5 = 4 1000 & 0111  = 0000
            ++count;
        }
        System.out.println(count);
    }
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        Thread thread;
        Callable callable;
        ExecutorService executors = Executors.newFixedThreadPool(4);

        class CallableTest implements Callable<String>{

            @Override
            public String call() throws Exception {
                return "hello world";
            }
        }
        Thread thread1 = new Thread(()-> System.out.println("Lambda Thread Start..."));
        thread1.start();
        thread1.wait(20,2);

//        Future result = executors.submit(() ->{
//            return "hello world";
//        });
        Future<String> result = executors.submit(new CallableTest());
        System.out.println(result.get());
    }

    static class ThreadDemo extends Thread implements Runnable{

        @Override
        public void run() {
            super.run();
        }
    }

    @Test
    public void testMap(){
        Map<Integer,Integer> map = new HashMap<>();
        System.out.println(map.get(0));
    }
}
