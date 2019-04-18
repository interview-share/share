package offer.sword2offer.chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/4/2 15:49
 * @description God Bless, No Bug!
 *
 * 不修改数组找出重复的数字
 * 题目描述
 *  在一个长度为 n+1 的数组里的所有数字都在 1 到 n 的范围内，所以数组中至少有一个数字是重复的。
 *  请找出数组中任意一个重复的数字，但不能修改输入的数组。
 *  例如，如果输入长度为 8 的数组 {2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字 2 或者 3。
 *
 * 解法
 * 解法一
 *  创建长度为 n+1 的辅助数组，把原数组的元素复制到辅助数组中。
 *  如果原数组被复制的数是 m，则放到辅助数组第 m 个位置。
 *  这样很容易找出重复元素。空间复杂度为 O(n)。
 *
 * 解法二
 *  数组元素的取值范围是 [1, n]，对该范围对半划分，分成 [1, middle], [middle+1, n]。
 *  计算数组中有多少个(count)元素落在 [1, middle] 区间内，
 *  如果 count 大于 middle-1+1，那么说明这个范围内有重复元素，否则在另一个范围内。
 *  继续对这个范围对半划分，继续统计区间内元素数量。
 *
 * 时间复杂度 O(n * log n)，空间复杂度 O(1)。
 *
 * 注意，此方法无法找出所有重复的元素。
 */
public class Sub03_2DuplicationInArrayNoEdit {

    private static int getDuplication(int[] data) {

        if (data == null || data.length < 1) {
            return -1;
        }

        int start = 1;
        int end = data.length - 1;
        while (end >= start) {

            int middle = start + ((end - start) >> 1);

            // 计算有多少个数字位于[start,middle]之间
            int count = countRange(data, start, middle);
            if (start == end) { // 已经搜索到最后一个数字
                if (count > 1) { // 如果count>1则表示start是重复的数字
                    return start;
                }
                break;
            }
            if (count > (middle - start) + 1) {
                // [start,middle]之间的count > 一半,表示重复数字在前半段,middle作为新的end
                end = middle;
            } else {
                // [start,middle]之间的count < 一半,表示重复数字在后半段,middle+1作为新的start
                start = middle + 1;
            }

        }
        return -1;
    }

    /**
     * 计算数组中有多少个数在[start,middle]之间
     * 时间复杂度 O(n)
     *
     * @param datas
     * @param start
     * @param middle
     * @return
     */
    private static int countRange(int[] datas, int start, int middle) {

        if (datas == null) {
            return 0;
        }
        int count = 0;
        for (int i : datas) {
            if (i >= start && i <= middle) {
                count++;
            }
        }
        return count;
    }
}
