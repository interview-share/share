package base;

import org.junit.Test;

import java.util.*;

/**
 * @author LRK
 * @date 2019/4/7 19:18
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 */
public class TestSet {

    @Test
    public void test() {

        Set<List<Integer>> set = new HashSet<>();

        set.add(Arrays.asList(3,2,1));
        System.out.println(set);
    }
}
