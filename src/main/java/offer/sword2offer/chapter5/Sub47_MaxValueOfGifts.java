package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 16:01
 * @description God Bless, No Bug!
 *
 * 礼物的最大价值
 * 题目描述
 * 在一个 m×n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 *
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格直到到达棋盘的右下角。
 *
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 *
 * 解法
 * 写出递推式，res 表示获得的最大礼物。
 *
 * res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]) + grid[i][j];
 *
 */
public class Sub47_MaxValueOfGifts {
    public static void main(String[] args) {

        Sub47_MaxValueOfGifts test = new Sub47_MaxValueOfGifts();
        int[][] matrix = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(test.getMaxValue(matrix));
    }

    public int getMaxValue(int[][] matrix){

        if (matrix == null || matrix.length==0) {
            return 0;
        }
        // 保留一行的最大值,逐行更新
        int[] max = new int[matrix[0].length];
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){

                int up=0,left=0;
                if (i>0){
                    up = max[j];
                }
                if (j>0){
                    left = max[j-1];
                }
                max[j] = Math.max(up,left)+matrix[i][j];
            }
        }
        return max[matrix[0].length-1];
    }
}
