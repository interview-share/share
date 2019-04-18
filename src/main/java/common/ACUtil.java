package common;
/**
 *
 求排列数组合数
 */
public class ACUtil
{
    /**
     *
     *  求排列数 A(n,m) n>m
     * @return
     */
	public static long A(int n, int m)
	{
		long result = 1;
		// 循环m次,如A(6,2)需要循环2次，6*5
		for (int i = m; i > 0; i--)
		{
			result *= n;
			n--;// 下一次减一
		}
		return result;
	}
	/**
     *
     * 求组合数，这个也不需要了。定义式，不使用互补率
     */
	public static long C2(int n, int m)
	{
		// int denominator=factorial(up);//分母up的阶乘
		// 分母
		// A(6,6)就是求6*5*4*3*2*1,也就是求6的阶乘
		long denominator = A(m, m);
		// 分子
		// 分子的排列数
		long numerator = A(n, m);
		return numerator / denominator;
	}
	public static long C(int n, int m)// 应用组合数的互补率简化计算量
	{
		int half = n / 2;
		if (m > half)
		{
			System.out.print(m + "---->");
			m = n - m;
			System.out.print(m + "\n");
		}
		// 分子的排列数
		long numerator = A(n, m);
		// 分母的排列数
		long denominator = A(m, m);
		return numerator / denominator;
	}

    public static void main(String[] args) {

        System.out.println(C(18,9));
    }
}