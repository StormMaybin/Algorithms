package com.stormma.dp;
import java.util.*;
public class Main3
{

	/**
	 * @param args
	 */
	public Main3()
	{
		int [][] dp = new int [210][110];
		Scanner scan = new Scanner (System.in);
		while (scan.hasNext())
		{
			int n, k;
			n = scan.nextInt();
			k = scan.nextInt();
			init (dp, k);
			for(int j = 2; j <= k; j++)
				for(int i = 2; i <= n; i++)
					for(int m = 1; m <= i-1; m++)
						dp[i][j]=(dp[i][j] + dp[m][j-1] * dp[i-1-m][j-1]) % 9901;//µÝ¹éÇó½â
			System.out.println((dp[n][k] - dp[n][k-1] + 9901) % 9901);
		}
		scan.close();
	}
	public void init (int [][] dp, int k)
	{
		for (int i = 0; i <= k; i++)
			dp[1][i] = 1;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main3();
	}

}
