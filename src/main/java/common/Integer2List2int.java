package common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * list int[] Integer[] 之间的转换
 */
public class Integer2List2int {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};

        /**
         * int[] 转 Integer[] List 都需要stream().boxed()
         */
        // int[] 转 List<Integer>
        List<Integer> Int2List = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // int[] 转 Integer[]
        Integer[] Int2Integer= Arrays.stream(arr).boxed().toArray(Integer[]::new);



        // List<Integer> 转 Integer[]
        Integer[] List2Integer= Int2List.toArray(new Integer[0]);
        // Integer[] 转 List<Integer>
        List<Integer> Integer2List = Arrays.asList(Int2Integer);

        /**
         * List Integer[] --> int[] 最后都需要stream().mapToInt().toArray()
         */
        // List<Integer> 转 int[]
        int[] List2Int = Int2List.stream().mapToInt(Integer::intValue).toArray();
        // Integer[] 转 int[]
        int[] Integer2Int = Arrays.stream(Int2Integer).mapToInt(Integer::intValue).toArray();




        // 同理
        String[] strings1 = {"a", "b", "c"};
        // String[] 转 List<String>
        List<String> list3 = Arrays.asList(strings1);
        // List<String> 转 String[]
        String[] strings2 = list3.toArray(new String[0]);
    }
}