package algorithm.tree;

import java.util.*;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name algorithm.tree
 * @date 2019/3/25 19:58
 * @description God Bless, No Bug!
 */
public class _04GetSkyLine {
    public static void main(String[] args) {
        List<int[]> skyline = new _04GetSkyLine().getSkyline(new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}});
        skyline.forEach(arr ->{
            System.out.println(Arrays.toString(arr));
        });
    }

    /**
     *
     * 利用大根堆max保存当前最高的建筑物,所以需要区分建筑物的左右边界
     *  因此新建List<int[]> height 存储建筑物高度,左边界存储高度负值,右边界存正值
     *  height排序,先左边界递增,再右边界递增;
     *  max.offer(0); int pre = 0; // 初始地平线
     *  遍历height:
     *      高度为负值 ==> 存入大根堆;
     *      高度为负值 ==> 从大根堆移除;
     *      如果当前最大值与前一最大值不同,说明遇到"关键点",存入结果集
     *
     */
    public List<int[]> getSkyline2(int[][] buildings) {

        List<int[]> height = new ArrayList<>(); // 高度
        List<int[]> res = new ArrayList<>();

        for (int[] building : buildings) {
            int high = building[2];
            height.add(new int[]{building[0], -high});
            height.add(new int[]{building[1], high});
        }
        Collections.sort(height, (o1, o2) -> {

            if (o1[0]==o2[0]){

                return o1[1] - o2[1];
            }else {
                return o1[0] - o2[0];
            }
        });
        // 大根堆
        PriorityQueue<Integer> max = new PriorityQueue<>((x, y) -> y - x);
        max.offer(0); // 加入地平线
        int pre = 0;
        for (int[] arr : height) {
            if (arr[1] < 0) { // 小于零 ==> 左边界
                max.offer(-arr[1]);
            } else { // >0 ==> 右边界
                max.remove(arr[1]);
            }
            int cur = max.peek();
            if (pre != cur) {
                res.add(new int[]{arr[0], cur});
                pre = cur;
            }
        }
        return res;
    }
    public List<int[]> getSkyline(int[][] buildings) {

        int len = buildings.length;
        int tail = 0;
        Map<Integer,Integer> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int left = buildings[i][0];
            int right = buildings[i][1];
            int height = buildings[i][2];
            if (right>tail) tail = right;
            for (int j = left;j<right;j++){
                if (!map.containsKey(j)){
                    map.put(j,height);
                }else {
                    if (map.get(j)<height){
                        map.put(j,height);
                    }
                }
            }
        }
        int pre = 0;
        for (int i = 0; i < tail; i++) {

            if (map.containsKey(i) && map.get(i) !=pre){
                int val = map.get(i);
                int[] tmp = new int[2];
                tmp[0] = i;
                tmp[1] = val;
                res.add(tmp);
                pre = val;
            }else if (!map.isEmpty() && !map.containsKey(i) && 0!=pre){
                int[] tmp = new int[2];
                tmp[0] = i;
                tmp[1] = 0;
                res.add(tmp);
                pre = 0;
            }
        }
        res.add(new int[]{tail,0});
        return res;
    }
}
