package offer.sword2offer.chapter5;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter5
 * @date 2019/2/7 16:01
 * @description God Bless, No Bug!
 */
public class Sub47_MaxValueOfGifts {
    public static void main(String[] args) {

        Sub47_MaxValueOfGifts test = new Sub47_MaxValueOfGifts();
        int[][] matrix = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(test.getMaxValue(matrix));
    }

    public int getMaxValue(int[][] matrix){

        if (matrix == null || matrix.length==0) return 0;
        int[] max = new int[matrix[0].length]; // 保留一行的最大值,逐行更新
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
