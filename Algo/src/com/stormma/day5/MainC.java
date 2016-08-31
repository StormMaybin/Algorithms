package com.stormma.day5;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 状态转化方程：f[i][v]=max{f[i-1][v-k*c[i]]+k*w[i]|0<=k<=n[i]} 
 * @author StormMaybin
 *
 */
public class MainC
{

	/**
	 * @param args
	 */
	class Node 
	{
		int value;
		int weight;
		int count;
		public Node(int value, int weight, int count)
		{
			this.value = value;
			this.weight = weight;
			this.count = count;
		}
	}
	int C;
	int n, m;
	Node [] arr = new Node[101];
	int [][] dp = new int [101][101];
	Scanner scan = null;
	public static void main(String[] args)
	{
		new MainC().work();
	}
	public void work ()
	{
		scan = new Scanner (System.in);
		while (scan.hasNext())
		{
			C = scan.nextInt();
			while ((C--) > 0)
			{
				n = scan.nextInt();
				m = scan.nextInt();
				init();
				System.out.println(multi_back());
			}
		}
		scan.close();
	}
	public int multi_back ()
	{
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], 0);//进行初始化操作
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				for (int k = 0; k <= arr[i].count; k++)
				{
					if(j >= k*arr[i].value)
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-k*arr[i].value]+k*arr[i].weight);
				}
		return dp[m][n];
	}
	public void init ()
	{
		for (int i = 1; i <= m; i++)
			arr[i] = new Node (scan.nextInt(),scan.nextInt(),scan.nextInt());
	}
}
