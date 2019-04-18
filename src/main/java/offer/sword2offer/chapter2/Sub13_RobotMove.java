package offer.sword2offer.chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/2/1 15:10
 * @description God Bless, No Bug!
 *
 * 机器人的移动范围
 *  题目描述
 *      地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 *      每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *      例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *      但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 解法
 * 从坐标(0, 0) 开始移动，当它准备进入坐标(i, j)，判断是否能进入，如果能，再判断它能否进入 4 个相邻的格子 (i-1, j), (i+1, j), (i, j-1), (i, j+1)。
 */
public class Sub13_RobotMove {

    public static void main(String[] args) {

        int n = movingCount(18, 40, 40);
        System.out.println(n);
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int count = countCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private static int countCore(int threshold, int rows, int cols, int i, int j, boolean[] visited) {

        int count = 0;
        int index = i * cols + j;
        if (!visited[index] && i >= 0 && i < rows && j >= 0 && j < cols &&
                (getSum(i) + getSum(j)) <= threshold ) {

            visited[index] = true;
            // 递归调用,判断上下左右四个点是否满足条件
            count = 1 +
                    countCore(threshold, rows, cols, i - 1, j, visited) +
                    countCore(threshold, rows, cols, i + 1, j, visited) +
                    countCore(threshold, rows, cols, i, j - 1, visited) +
                    countCore(threshold, rows, cols, i, j + 1, visited);
        }
        return count;
    }

    private static int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }
}
