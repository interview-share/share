package hash;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name hash
 * @date 2019/3/13 0:44
 * @description God Bless, No Bug!
 *
 *  Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 */
public class _01TitleToNumber {

    public int titleToNumber(String s) {

        int n = s.length();
        int res=0;
        for (int i = 0; i < n; i++) {
            res = res*26+(s.charAt(i)-'A'+1);
        }
        return res;
    }
}
