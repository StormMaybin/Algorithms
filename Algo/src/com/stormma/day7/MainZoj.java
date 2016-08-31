package com.stormma.day7;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 划分整数
 * @author StormMaybin
 *
 */
public class MainZoj
{
	Scanner scan = new Scanner (System.in);
	int [][] dp;
	int n, k;//表示把n划分成k个整数的和
	public static void main(String[] args)
	{
		new MainZoj();
	}
	public MainZoj ()
	{
		while (scan.hasNext())
		{
			n = scan.nextInt();
			k = scan.nextInt();
			dp = new int [n+1][k+1];
			for (int i = 1; i <= n; i++)
				Arrays.fill(dp[i], 0);
			dp[0][0] = 1;
			for (int i = 1; i <= n; i++)
				dp[i][1] = 1;
			for (int i = 0 ; i <= n; i++)
			{
				for (int t = 0; t <= k; t++)
					System.out.print(dp[i][t]+" ");
				System.out.println();
			}
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= k; j++)
				{
					if (i >= j)
						dp[i][j] = dp[i-1][j-1] + dp[i-j][j];
				}
			System.out.println(dp[n][k]);
			for (int i = 0 ; i <= n; i++)
			{
				for (int t = 0; t <= k; t++)
					System.out.print(dp[i][t]+" ");
				System.out.println();
			}
		}
	}
}
