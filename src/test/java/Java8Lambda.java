import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name PACKAGE_NAME
 * @date 2019/3/4 19:26
 * @description God Bless, No Bug!
 *
 *  测试Lambda表达式的使用
 */
public class Java8Lambda {

    @Test
    public void test(){

//        new Thread(() -> System.out.println("启动线程:Lambda表达式...")).start();
        List<String> list = Arrays.asList("Hello","World","I","am","a","graduate");

        List<String> stringList = testPredicate(list, (x) -> x.length() > 2);

        stringList.forEach(System.out::println);
        stringList.forEach((x) -> {
            System.out.println(x + " plus");
        });

    }

    @Test
    public void test2(){
        Integer sum = testBiFunction(56, 44, (x, y) -> x + y);
        System.out.println(sum);
    }

    @Test
    public void test3(){
//        testConsumer(5,System.out::println);
        testConsumer(5,(x) ->{
            System.out.println(x%2==1);
        });
    }

    @Test
    public void test4(){

        int random = testSupplier(() -> (int)(Math.random()*100));
        System.out.println(random);
    }

    // 消费型表达式 单参数 无返回值
    private void testConsumer(Integer a, Consumer<Integer> consumer){
        consumer.accept(a);
    }

    // 供给型表达式
    private Integer testSupplier(Supplier<Integer> supplier){
        return supplier.get();
    }

    // BiFunction 双参数带返回值 Function 单参数带返回值
    private Integer testBiFunction(Integer a, Integer b, BiFunction<Integer, Integer, Integer> bf){

        return bf.apply(a,b);
    }
    // 断言表达式 单参数返回boolean
    private List<String> testPredicate(List<String> list, Predicate<String> predicate){
        List<String> result = new ArrayList<>();

        list.forEach((str) -> {
            if (predicate.test(str)) {
                result.add(str);
            }
        });
        return result;
    }
}
