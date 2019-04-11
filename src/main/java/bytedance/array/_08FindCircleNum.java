package bytedance.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LRK
 * @date 2019/4/8 22:54
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 * <p>
 * 朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 * <p>
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 */
public class _08FindCircleNum {

    public static void main(String[] args) {

        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new _08FindCircleNum().findCircleNum(M));
    }

    public int findCircleNum(int[][] M) {

        int rows = M.length;
        int cnt =0;
        for (int i = 0; i < rows; i++) {
            if (M[i][i]==1){
                cnt++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                helper(M,queue);
            }
        }
        return cnt;
    }

    private void helper(int[][] m, Queue<Integer> queue) {

        while (!queue.isEmpty()){
            int i = queue.poll();
            m[i][i] = 2;
            for (int j = 0; j < m.length; j++) {
                if (m[i][j]==1){
                    queue.offer(j);
                    m[i][j] = 2;
                    m[j][i] = 2;
                }
            }
        }
    }
}
