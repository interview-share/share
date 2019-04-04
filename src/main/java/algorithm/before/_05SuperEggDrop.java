package algorithm.before;

/**
 * @author LRK
 * @project_name LeeCode
 * @package_name before
 * @date 2019/3/3 15:51
 * @description God Bless, No Bug!
 */
public class _05SuperEggDrop {
    public static void main(String[] args) {

    }

    /**
     * 我们可以改变一下求解的思路，求 k 个鸡蛋在 m 步内可以测出多少层：
     * 假设: dp[k][m] 表示k个鸡蛋在m步内最多能测出的层数。
     * 那么，问题可以转化为当 k <= K 时，找一个最小的m，使得dp[k][m] >= N。
     *
     * 我们来考虑下求解dp[k][m]的策略：
     * 假设我们有 k 个鸡蛋第 m 步时，在第 X 层扔鸡蛋。这时候，会有两种结果，鸡蛋碎了，或者没碎。
     * 如果鸡蛋没碎，我们接下来会在更高的楼层扔，最多能确定 X + dp[k][m-1] 层的结果；
     * 如果鸡蛋碎了，我们接下来会在更低的楼层扔，最多能确定 Y + dp[k-1][m-1]层的结果 (假设在第X层上还有Y层)。
     * 因此，这次扔鸡蛋，我们最多能测出 dp[k-1][m-1](摔碎时能确定的层数) + dp[k][m-1] (没摔碎时能确定的层数) + 1 (本层) 层的结果。
     * 另外，我们知道一个鸡蛋一次只能测一层，没有鸡蛋一层都不能测出来。
     * 因此我们可以列出完整的递推式:
     *
     * dp[k][0] = 0
     * dp[1][m] = m (m > 0)
     * dp[k][m] = dp[k-1][m-1] + dp[k][m-1] + 1 (k > 0, m>0)
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        if(K==0) return 0;
        if(K==1) return N;

        // dp[m][k] 表示 k 个鸡蛋 m 步最多能测出多少层里的结果(临界层)
        int[][] dp = new int[N+2][K+2];
        dp[0][0]=0;
        for(int i=1;i<=N;++i)
        {
            dp[i][0]=0;
            for(int j=1;j<=K;++j)
            {
                dp[i][j]=dp[i-1][j]+dp[i-1][j-1]+1;
                if(dp[i][j]>=N)
                    return i;
            }
        }
        return N;
    }
    public int countMinStep(int egg,int floor){
        if(egg < 1 || floor < 1) return 0;
        int[][] f = new int[egg+1][floor+1];//代表egg个鸡蛋，从floor楼层扔下来所需的最小的次数
        for(int i=1;i<=egg; i++){
            for(int j=1; j<=floor; j++)
                f[i][j] = j;//初始化，最坏的步数
        }

        for(int n=2; n<=egg; n++){
            for(int m=1; m<=floor; m++){
                for(int k=1; k<m; k++){
                    //这里的DP的递推公式为f[n][m] = 1+max(f[n-1][k-1],f[n][m-k]) k属于[1,m-1]
                    //从1-m层中随机抽出来一层k
                    //如果第一个鸡蛋在k层碎了，那么我们将测试1~k-1层，就可以找出来，也即1+f[1][k-1]
                    //如果第一个鸡蛋在k层没有碎，那么我们将测试k+1~m也即m-k层，
                    //      这里也是重点！！！！
                    //      现在我们手里有2个鸡蛋，要测试m-k层，那么我想问，此时和你手里有2个鸡蛋要测试1~m-k层有什么区别？
                    //      没有区别！是的在已知k层不碎的情况下，测试k+1~m层的方法和测试1~m-k没区别，所以可以写成 1+f[n][m-k] 其中1表示为 在k层的那一次测试
                    f[n][m] = Math.min(f[n][m],1+Math.max(f[n-1][k-1],f[n][m-k]));
                }
            }
        }
        return f[egg][floor];
    }

}
