package algorithm.math_bit;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LRK
 * @date 2019/4/5 16:19
 * project_name LeetCode
 * package_name algorithm.math_bit
 * description:
 * God Bless, No Bug!
 * <p>
 * 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * <p>
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class _02MaxPoints {
    /**
     * 这道题给了我们一堆二维点，然后让我们求最大的共线点的个数，
     * 根据初中数学我们知道，两点确定一条直线，而且可以写成y = ax + b的形式，所有共线的点都满足这个公式。
     * 所以这些给定点两两之间都可以算一个斜率，每个斜率代表一条直线，
     * 对每一条直线，带入所有的点看是否共线并计算个数，这是整体的思路。
     * 但是还有两点特殊情况需要考虑，二是当两个点重合时，无法确定一条直线，但这也是共线的情况，需要特殊处理。
     * 二是斜率不存在的情况，
     * 由于两个点(x1, y1)和(x2, y2)的斜率k表示为(y2 - y1) / (x2 - x1)，
     * 那么当x1 = x2时斜率不存在，这种共线情况需要特殊处理。
     * 我们需要用到哈希表来记录斜率和共线点个数之间的映射，
     * 其中第一种重合点的情况我们假定其斜率为INT_MIN，第二种情况我们假定其斜率为INT_MAX，这样都可以用map映射了。
     * 我们还需要顶一个变量duplicate来记录重合点的个数，最后只需和哈希表中的数字相加即为共线点的总数
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Map<Integer, Integer>, Integer> m = new HashMap<>(points.length);
            int duplicate = 1;
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    ++duplicate; continue;
                }

                int dx = points[j].x - points[i].x;
                int dy = points[j].y - points[i].y;
                // 最大公约数
                int d = gcd(dx, dy);
                Map<Integer, Integer> t = new HashMap<>();
                // 最简比,如 [4,8],[2,4],[1,2] 最终都存在key为[1,2]的映射中
                t.put(dx / d, dy / d);
                m.put(t, m.getOrDefault(t, 0) + 1);
            }
            res = Math.max(res, duplicate);
            for (Map.Entry<Map<Integer, Integer>, Integer> e : m.entrySet()) {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }

    /**
     * 求最大公约数
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    class Point {
        int x;
        int y;
        Point() {
            x = 0;
            y = 0;
        }
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
