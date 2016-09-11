package com.stormma.dp;
import java.util.Scanner;
public class Main1
{

	/**
	 * @param args
	 */
	int [] dp;
	public Main1 ()
	{
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext())
		{
			int n = scan.nextInt();
			dp = new int [n+5];
			init();
			System.out.println(cal(n));
		}
		scan.close();
	}
	public int cal (int n)
	{
		for (int i = 3; i <= n; i++)
			dp[i] = dp[i-1] + dp[i-2];
		return dp[n];
	}
	public void init ()
	{
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main1();
	}
}
