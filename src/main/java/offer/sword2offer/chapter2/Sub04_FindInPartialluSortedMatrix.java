package offer.sword2offer.chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter2
 * @date 2019/1/30 14:50
 * @description God Bless, No Bug!
 *
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 从二维数组的右上方开始查找：
    若元素值等于 target，返回 true；
    若元素值大于 target，砍掉这一列，即 --j；
    若元素值小于 target，砍掉这一行，即 ++i。
    也可以从二维数组的左下方开始查找。

    注意，不能选择左上方或者右下方的数字，因为这样无法缩小查找的范围。
 */
public class Sub04_FindInPartialluSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(7, matrix));
    }
    private static boolean find(int target,int[][] array){

        boolean flag = false;
        if (array == null){
            return flag;
        }
        int rows = array.length;
        int columns = array[0].length;
        int row = 0;
        int column = columns-1;
       while (row < rows && column >=0){
           if (array[row][column] == target){
               System.out.println("target位置: ["+row+","+column+"]:"+target);
               flag = true;
               break;
           }else if (array[row][column]>target){
               column--;
           }else {
               row++;
           }
       }
       if (!flag){
           System.out.println("数组不包含target");
       }
        return flag;
    }
}
