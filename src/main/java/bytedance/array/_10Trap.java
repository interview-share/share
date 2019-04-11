package bytedance.array;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name PACKAGE_NAME
 * @date 2019/4/10 20:32
 * @description God Bless, No Bug!
 *
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class _10Trap {
    public int trap(int[] height) {

        int left = 0,right = height.length-1;
        int sum = 0;
        while (left<right){
            int min = Math.min(height[left],height[right]);
            if (min == height[left]){
                left++;
                while (left<right && height[left]<min){
                    sum += min - height[left++];
                }
            }
            if (min == height[right]){
                right--;
                while (left<right && height[right]<min){
                    sum += min - height[right--];
                }
            }
        }
        return sum;
    }
}
