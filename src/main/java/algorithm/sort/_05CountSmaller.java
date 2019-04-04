package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.sort
 * @date 2019/3/28 21:51
 * @description God Bless, No Bug!
 *
 *  计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。
 * 数组 counts 有该性质：
 *      counts[i] 的值是 nums[i]右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class _05CountSmaller {

    public static void main(String[] args) {
        _05CountSmaller test = new _05CountSmaller();
        System.out.println(test.countSmaller2(new int[]{5, 2, 6, 1}));

        int[] nums = {5, 1, 6, 6, 7, 3, 6};
        test.BinaryInsertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    class Node{
        public int val,smaller;
        public Node left,right;
        public Node(int val,int smaller){
            this.val = val;
            this.smaller = smaller;
        }
    }
    public int insert(Node root,int num){
        if (root.val == -1) {
            root.val = num;
            root.smaller = 0;
            root.left = new Node(-1,0);
            root.right = new Node(-1,0);
            return 0;
        }
        if (root.val>num){
            root.smaller = root.smaller+1;
            return insert(root.left,num);
        }else {
            return root.smaller+ (root.val<num?1:0) +insert(root.right,num);
        }
    }

    /**
     * 构造二叉搜索树
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int n = nums.length;
        Node root = new Node(-1,0);
        for (int i = n-1; i >= 0; i--) {
            res.addFirst(insert(root,nums[i]));
        }
        return res;
    }

    /**
     * 二分法插入已排序数组
     * @param nums
     * @return
     */
    public List<Integer> countSmaller2(int[] nums){
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> res = new LinkedList<>();
        int n = nums.length;
        for (int i = n-1; i >= 0; i--) {
            int left = 0,right = list.size()-1;
            while (left<=right){
                int mid = left+(right-left)/2;
                if (nums[i]<=list.get(mid)){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
            res.addFirst(left);
            list.add(left,nums[i]);
        }
        return res;
    }
    /**
     * 暴力
     * @param nums
     * @return
     */
    public List<Integer> countSmaller3(int[] nums){
        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i+1; j < n; j++) {
                if (nums[i]>nums[j]){
                    cnt++;
                }
            }
            res.add(cnt);
        }
        return res;
    }

    public void BinaryInsertSort(int[] nums){
        int n = nums.length;
        int low=0,high=0,mid=0,key=0;

        for (int i = 0; i < n; i++) {
            key = nums[i];
            low=0;
            high=i-1;
            while (low<=high){
                mid = (low+high)>>1;
                if (key<=nums[mid]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
            //high 即为key插入的位置
            int j=i-1;
            for (;j>=high+1;j--){
                nums[j+1]=nums[j];
            }
            nums[j+1]=key;
        }
    }
}
