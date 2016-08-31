package com.stormma.day5;
import java.util.Arrays;
import java.util.Scanner;
public class MainD2
{

	/**
	 * @param args
	 */
	int T;
	int [][] arr = new int [110][110];
	int [][] dp = new int [110][110];
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainD2().work();
	}
	public void work ()
	{
		T = scan.nextInt();
		while ((T--) > 0)
		{
			int n;
			n = scan.nextInt();
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= i; j++)
				{
					arr[i][j] = scan.nextInt();
				}
			for (int i = 0; i < 110; i++)
				Arrays.fill(dp[i], -1);
			int ans = dfs (1, 1, n);
			System.out.println(ans);
		}
	}
	/***
	 * 除此记忆化搜索之外，这个题还可以用递归来做
	 * int i, int j;
	 * for (int i = 1; i <= n; i++)先进行最底层的赋值操作
	 *		d[n][j] = a[n][j];
	 *开始递归
	 *for (int i = n-1; i >= 1; i++)
	 *{
	 *		for (int j = 1; j <= i; j++)
	 *		{
	 *			d[i][j] = a[i][j] + Math.max(d[i+1][j], d[i+1][j+1]);
	 *		}
	 *}
	 */
	/****
	 * 
	 * @param i
	 * @param j
	 * @param n
	 * @return
	 */
	public int dfs (int i, int j, int n)
	{
		if (dp[i][j] >= 0)
			return dp[i][j];
		else
		{
			return dp[i][j] = arr[i][j]+(i == n ? 0 : Math.max(dfs(i+1, j, n),dfs(i+1, j+1, n)));
		}
	}
}
