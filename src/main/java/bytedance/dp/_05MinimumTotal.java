package bytedance.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author LRK
 * @date 2019/4/7 0:25
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 *
 * 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 *  例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class _05MinimumTotal {
    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(new _05MinimumTotal().minimumTotal(triangle));
    }
    int min = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {

        // 从倒数第二层开始统计路径和,每个节点的值表示从当前节点到最底层的最短路径长度
        // 即 triangle[i][j] = triangle[i][j] + Min{triangle[i+1][j],triangle[i+1][j+1]}
        for (int i = triangle.size() - 2; i >= 0; i--){
            for (int j = 0; j < triangle.get(i).size(); j++){

                triangle.get(i).set(j,triangle.get(i).get(j)+ Math.min(triangle.get(i+1).get(j),triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    private void helper(List<List<Integer>> triangle, int level, int idx, int sum) {

        if (level==triangle.size()-1){
        //  int res = sum+triangle.get(level).get(idx)
            if (sum < min){
                min = sum;
            }
            return;
        }
        helper(triangle,level+1,idx,sum+triangle.get(level+1).get(idx));
        helper(triangle,level+1,idx+1,sum+triangle.get(level+1).get(idx+1));
    }
}
