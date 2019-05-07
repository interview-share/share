package bytedance.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author LRK
 * @date 2019/4/8 23:24
 * @project LeetCode
 * @description:
 * God Bless, No Bug!
 *
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class _09Merge {


    public List<Interval> merge(List<Interval> intervals) {

        if (intervals==null || intervals.size() < 2) {
            return intervals;
        }
        PriorityQueue<Interval> min = new PriorityQueue<>(intervals.size(),
                Comparator.comparingInt(x -> x.start));

        min.addAll(intervals);
        List<Interval> res = new ArrayList<>();
        Interval pre = min.poll();
        while (!min.isEmpty()) {
            Interval cur = min.poll();
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);
        return res;
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
