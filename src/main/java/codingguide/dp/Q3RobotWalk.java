package codingguide.dp;

/**
 * @author LRK
 * @date 2019/5/15 16:39
 * @project LeetCode
 * @description: God Bless, No Bug!
 */
public class Q3RobotWalk {
    static int cnt=0;
    public static void main(String[] args) {

        System.out.println(new Q3RobotWalk().walkDP(5, 2, 3, 3));
    }

    /**
     * dp[cur][rest]
     * dp[i][j]---表示当前在 i 位置,走 rest 步可到达 dest 的方法数
     *  cur==1:
     *      等于右上角
     *  cur==n:
     *      等于左上角
     *  else:
     *      等于左上加右上
     * @param n
     * @param cur
     * @param rest
     * @param dest
     * @return
     */
    public int walkDP(int n,int cur,int rest,int dest){

        int[][] dp = new int[rest+1][n];
        dp[0][dest-1]=1;

        for (int i = 1; i <= rest; i++) {

            for (int j = 0; j < n; j++) {

                if (j==0){
                    dp[i][j] = dp[i-1][j+1];
                }else if (j==n-1){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j+1] + dp[i-1][j-1];
                }
            }
        }
        return dp[rest][cur-1];
    }

    /**
     * 有排成一行的 n 个位置,记为 1~n
     * 机器人从 cur 出发, rest 步能走到 dest 的方法有多少种
     * 1只能向右走,n只能向左走,其他位置可以向左或向右走
     * @param n
     * @param cur
     * @param rest
     * @param dest
     * @return
     */
    public int walk(int n,int cur,int rest,int dest){

        if (rest==0){
            return cur==dest?1:0;
        }
        if (cur==1){
            return walk(n,cur+1,rest-1,dest);
        }
        if(cur==n){
            return walk(n,cur-1,rest-1,dest);
        }
        return walk(n,cur+1,rest-1,dest)+walk(n,cur-1,rest-1,dest);
    }


    public void walk2(int n,int cur,int rest,int dest){

        if (rest==0){
            if (cur==dest){
                cnt++;
            }
            return;
        }
        if (cur==1){
            walk2(n,cur+1,rest-1,dest);
        }else if(cur==n){
            walk2(n,cur-1,rest-1,dest);
        }else {
            walk2(n,cur+1,rest-1,dest);
            walk2(n,cur-1,rest-1,dest);
        }
    }
}
