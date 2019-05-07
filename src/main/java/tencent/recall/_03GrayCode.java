package tencent.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name tencent.recall
 * @date 2019/4/28 21:30
 * @description God Bless, No Bug!
 *
 * 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 示例 2:
 *
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 */
public class _03GrayCode {

    /**
     *  i ^(i-1)
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < Math.pow(2,n); i++) {
            res.add((i>>1)^i);
        }
        return res;
    }

    /**
     * 镜像对称
     * @param n
     * @return
     */
    public List<Integer> grayCode2(int n) {

        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            // 当前list中的数据作为前一半,在后一半的前面添加'1'(即 |(1<<i) )
            int size = res.size();
            for (int j = size-1; j >= 0; j--) {
                res.add(res.get(j) | (1<<i));
            }
        }
        return res;
    }
}
