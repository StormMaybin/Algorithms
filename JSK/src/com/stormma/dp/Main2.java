package com.stormma.dp;
import java.util.Scanner;
public class Main2
{

	/**
	 * @param args
	 */
	public Main2()
	{
		Scanner scan = new Scanner (System.in);
		while (scan.hasNext())
		{
			int n;
			n = scan.nextInt();
			int [] a = new int [n];
			/**
			 * dp[i]代表下标i到n-1的最小步数
			 * 递归方程:
			 * dp[i] = min(dp[i], dp[j]+1)其中{ i<=j<=i+a[i]}
			 */
			int [] dp = new int [n];
			//下标n-1到n-1不用跳  那么最小步數就是0
			dp[n-1] = 0;
			for (int i = 0; i < n; i++)
				a[i] = scan.nextInt();
			System.out.println(solve(a, dp, n));
		}
		scan.close();
	}
	public int solve (int [] a, int [] dp, int n)
	{
		for (int i = n-2; i >= 0; i--)
		{
			dp[i] = n;
			//i-(i+a[i])之间的任何值都有可能是最优解
			for (int j = i; j < n && j <= i + a[i]; j++)
			{
				 dp[i] = Math.min(dp[i],dp[j]+1); 
			}
		}
		return dp[0];
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main2 ();
	}
}
