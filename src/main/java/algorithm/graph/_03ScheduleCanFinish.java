package algorithm.graph;

import java.util.*;

/**
 * @author LRK
 * @date 2019/4/4 22:32
 * project_name LeetCode
 * package_name algorithm.graph
 * description:
 * God Bless, No Bug!
 *
 * 课程表
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 *  在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 */
public class _03ScheduleCanFinish {

    public static void main(String[] args) {

        int[][] data = {{1,0}};
        System.out.println(new _03ScheduleCanFinish().canFinish2(2, data));
    }

    /**
     * 深度搜索 dfs
     * @param numCourses
     * @param prerequisites
     * @return
     */
    /**
     * 是否没有环
     */
    private boolean isDAG = true;
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] colors = new int[numCourses];
        if (prerequisites.length==0){
            return true;
        }
        int[][] graph = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            graph[p[0]][p[1]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (colors[i]==-1){
                continue;
            }
            dfs(i,graph,colors);
            if (!isDAG){
                break;
            }
        }
        return isDAG;
    }

    /**
     * 深度遍历
     * @param i 第 i 个节点
     * @param graph 二维数组表示的有向图
     * @param colors 标记数组 -1 --已访问过; 0 -- 未访问过; 1 -- 当前正在访问
     */
    private void dfs(int i, int[][] graph, int[] colors) {
        // 当前节点标识为 已访问
        colors[i] = 1;
        int n = colors.length;

        for (int j = 0; j < n; j++) {
            // 当前节点有指向的边 i-->j
            if (graph[i][j]!=0){
                if (colors[j]==1){
                    isDAG = false;
                    break;
                }else if (colors[j]==-1){
                    continue;
                }else {
                    dfs(j,graph,colors);
                }
            }
        }
        // 标识当前节点之后的节点均已访问
        colors[i] = -1;
    }

    /**
     * 拓扑排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 构建有向图
        // 求出入度为 0 的点加入队列
        // 从入度为 0 的节点开始,删掉该节点(即其指向的节点入度 减1,如果产生入度为 0 的节点,加入队列)
        // 直到队列为空,若仍存在入度不为 0 的节点,表明有向图存在环

        // 有向图,key==>节点 value==>节点指向的其他节点
        Map<Integer, List<Integer>> map = new HashMap<>(numCourses);
        // 存储各节点入度的数组
        int[] inDegree = new int[numCourses];
        // 构造有向图和入度数组
        for (int[] p : prerequisites) {
            if (map.containsKey(p[1])){
                map.get(p[1]).add(p[0]);
            }else {
                List<Integer> node = new ArrayList<>();
                node.add(p[0]);
                map.put(p[1],node);
            }
            inDegree[p[0]]++;
        }
        // 统计入度为 0 的节点加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i]==0){
                queue.offer(i);
            }
        }

        // 依次删掉入度为 0 的节点,期间若产生新的入度为 0 的节点,入队
        while (!queue.isEmpty()){
            int del = queue.poll();
            List<Integer> delList = map.get(del);
            if (delList==null){continue;}
            delList.forEach((node) ->{
                inDegree[node]--;
                if (inDegree[node]==0){
                    queue.offer(node);
                }
            });
        }
        // 若仍存在入度不为0的节点,表明有向图中存在环
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i]!=0){
                return false;
            }
        }
        return true;
    }
}
