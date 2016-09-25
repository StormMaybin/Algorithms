package com.stormma.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main1028
{
	/**
	 * @param args
	 */
	private Scanner scan;
	public Main1028()
	{
		scan = new Scanner(new BufferedInputStream(System.in));
		while (scan.hasNext())
		{
			int n = scan.nextInt();
			int [][] dp = new int [n+1][n+1];
			//dp[i][j]表示把i分成不大于j的数的种数。
			dp[n][1] = 1;
			init(dp, n);
		    for(int i=2; i <= n; i++)
		    {
		        for(int j=2; j <= n; j++)
		        {
		            if(i < j) 
		            	dp[i][j] = dp[i][i];
		            else if(i == j)
		            	dp[i][j]= 1+dp[i][j-1];
		            else if(i > j) 
		            	dp[i][j]=dp[i-j][j]+dp[i][j-1];
		        }
		    }
		    System.out.println(dp[n][n]);
		}
	}
	private void init(int [][] dp, int n)
	{
		for (int i = 1; i <= n; i++)
			dp[1][i] = dp[i][1] = 1;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main1028();
	}

}
