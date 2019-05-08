package huawei;

/**
 * @author LRK
 * @date 2019/5/8 23:20
 * @project LeetCode
 * @description: God Bless, No Bug!
 *
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 *  horse -> rorse (将 'h' 替换为 'r')
 *  rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class EditMinDistance {



    /**
     * 动态规划:
     * 表	1: 构建数组 dp[i][j] 表示 word1 的前 i 个字符转换为 word2 的前 j 个字符所需要的最少操作次数(增删改)
     *
     *       null c o f f e e
     *
     * null   0   1 2 3 4 5 6
     * c	　1　	　　	　　	　　	　　	　　	　　
     * a	　2　	　　	　　	　　	　　	　　	　　
     * f	　3	　　	　　	　　	　　	　　	　　
     * e	　4
     *
     *      dp[i][j] 的值为以下三个的最小值:
     *          1.若 word1[i]==word2[j] 则为左上角的值,否则为左上角值+1
     *          2.左边值+1 // 先变为左边再添加一个字符
     *          3.上边值+1 // 先变为上边再删除一个字符
     *          　　	　　	　　	　　
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        char[] from = word1.toCharArray();
        char[] to = word2.toCharArray();
        int m = from.length;
        int n = to.length;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                int match = from[i-1]==to[j-1]?dp[i-1][j-1]:dp[i-1][j-1]+1;
                int left = dp[i-1][j]+1;
                int up = dp[i][j-1]+1;
                dp[i][j] = Math.min(match,Math.min(left,up));
            }
        }

        return dp[m][n];
    }
}
