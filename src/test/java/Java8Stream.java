import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name PACKAGE_NAME
 * @date 2019/3/5 20:19
 * @description God Bless, No Bug!
 */
public class Java8Stream implements Cloneable {


    /**
     * Stream的操作三个步骤：
     *
     * （1）创建Stream，一个数据源（如：集合、数组），获取一个流；
     * （2）中间操作，一个中间操作链，对数据源的数据进行处理；
     * （3）终止操作，一个终止操作，执行中间操作链，并产生结果。
     *
     * 1 创建Stream。
     *
     * （1）可以通过Collection系列集合提供的Stream() 顺序流或 ParallelStream()并行流；
     * （2）通过 Arrays 中的 stream() 获取一个数组流；
     * （3）通过 Stream 类中静态方法 of()；
     * （4）创建无限流。
     *
     *
     * 2 中间操作
     *
     * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，
     * 否则中间操作不会执行任何的处理！而在终止操作时一次性全部处理，
     * 这种方式称为“惰性求值”。
     *  （1）筛选与切片
     *      filter——接收 Lambda ，从流中排除某些元素。
     *      limit——截断流，使其元素不超过给定数量及当数量满足条件时停止循环。
     *      skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。
     *      distinct——筛选去重，通过流所生成元素的 hashCode() 和 equals() 去除重复元素，因此需要实体类中有这两个方法的实现。
     *  （2）映射
     *      ①map——接收 Lambda ，将元素转换成其他形式或提取信息。
     *      接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     *      ②flatMap——接收一个函数作为参数，将函数返回的流{a,a,a}中的每个值都换成另一个流{a}{a}{a}，然后把所有流连接成一个流。
     *  （3）排序 sorted()——自然排序。 sorted(Comparator com)——定制排序。
     *
     * 3 终止操作
     *
     * （1）查找与匹配
     *      allMatch——检查是否匹配所有元素
     *      anyMatch——检查是否至少匹配一个元素
     *      noneMatch——检查是否全都不匹配
     *      findFirst——返回第一个元素
     *      findAny——返回当前流中的任意元素
     *      count——返回流中元素的总个数
     *      max——返回流中最大值
     *      min——返回流中最小值
     */
    @Test
    public void test() {

        // 创建流
        List<String> list = new ArrayList<>();
        Stream<String> streams1, streams2, streams3, streams4, streams5;

        // 1 Collection系列的stream() parallelStream()
        streams1 = list.stream();
        streams2 = list.parallelStream();

        // 2 Arrays 中的 stream() 获取一个数组流
        String[] str = new String[10];
        streams3 = Arrays.stream(str);

        // 3 Stream 类中静态方法 of(T t) of(T...t)
        streams4 = Stream.of("a", "b", "c");

        // 4 创建无限流。
        streams5 = Stream.iterate("iPhone", (x) -> x + "plus");
    }

    private Stream<Integer> stream = Stream.iterate(1, (x) -> x + 1);
    private Stream<String> alpha = Arrays.asList("aaa","bbb","ccc","ddd","eee").stream();

    // Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
    @Test
    public void test2() {
        /**
         * （1）筛选与切片
         *      filter——接收 Lambda ，从流中排除某些元素。
         *      limit——截断流，使其元素不超过给定数量及当数量满足条件时停止循环。
         *      skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。
         *      distinct——筛选去重，通过流所生成元素的 hashCode() 和 equals() 去除重复元素，因此需要实体类中有这两个方法的实现。
         */
        stream
                .filter((num) -> num % 2 == 1)
                .skip(5)
                .limit(5)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test3(){
        /**
         * （2）映射
         *      ①map——接收 Lambda ，将元素转换成其他形式或提取信息。
         *      接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
         *      ②flatMap——接收一个函数作为参数，将函数返回的流{a,a,a}中的每个值都换成另一个流{a}{a}{a}，然后把所有流连接成一个流。
         */
        alpha.map((str) ->str.split(""))
                .forEach((str) ->{
                    System.out.println(Arrays.toString(str));
                });
        System.out.println("==============================");
        // alpha.flatMap(Java8Stream::filterCharacter)
//        alpha.flatMap((str) -> Java8Stream.filterCharacter(str))
//                .forEach(System.out::println);
    }

    private static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     * （3）排序 sorted()——自然排序。 sorted(Comparator com)——定制排序。
     */
    @Test
    public void test4(){

    }

    @Test
    public void test5(){
        Stream<Integer> stream = Stream.of(1,5,9,7,6,3,4,8);
//        Optional<Integer> max = stream.max((x,y) -> x-y);
        Optional<Integer> max = stream.max(Comparator.comparingInt(x -> x));
        System.out.println(max.get());
    }

    @Test
    public void test6() {
        // 求单词长度之和
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        // 初始值　// (1)
        // 累加器 // (2)
        // 部分和拼接器，并行执行时才会用到 // (3)
        Integer lengthSum = stream.reduce(0,(sum, str) -> sum+str.length(),(a,b)->a+b);
        // int lengthSum = stream.mapToInt(str -> str.length()).sum();
        System.out.println(lengthSum);
    }

    @Test
    public void test7() {

        // 将Stream转换成容器或Map
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(Collectors.toList());
        Set<String> set = stream.collect(Collectors.toSet());
        // Collectors.toMap(k,v)
        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println("=======end=======");
    }

    @Test
    public void test8() {
        // 使用toCollection()指定规约容器的类型
        Stream<String> stream = Stream.of("I", "love", "you", "too");
////        ArrayList<String> arrayList = stream.collect(Collectors.toCollection(() ->new ArrayList<>()));// (3)
//        ArrayList<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        HashSet<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));// (4)

        // 分为两部分,即是否满足指定的条件,如字符串的长度是否大于3
//        Map<Boolean, List<String>> mapTF = stream.collect(Collectors.partitioningBy((x) -> x.length() > 3));

        // 根据不同返回结果进行分类,如根据字符串的长度分组
//        Map<Integer, List<String>> mapGroup = stream.collect(Collectors.groupingBy(String::length));

        /**
         * // 使用下游收集器统计每个部门的人数
         * Map<Department, Integer> totalByDept = employees.stream()
         *                     .collect(Collectors.groupingBy(Employee::getDepartment,
         *                                                    Collectors.counting()));// 下游收集器
         */
        Map<Integer, Long> countMap = stream.collect(Collectors.groupingBy(String::length,Collectors.counting()));

        System.out.println("=======end=======");
    }

    /**
     * 使用collect()做字符串join
     */
    @Test
    public void test9() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        String collect = stream.collect(Collectors.joining(",", "{", "}"));
        System.out.println(collect);
    }
}
