package com.stormma.day7;

import java.util.Arrays;
import java.util.Scanner;

public class MainA
{
	int n;
	Scanner scan = new Scanner (System.in);
	int [][][][] dp;
	int [] bit;
	int [] pow ;
	int length;
	public MainA()
	{
		while (scan.hasNext())
		{
			n = scan.nextInt();
			int len = 0;
			bit = new int [15];
			int arr [] = new int [15];
			Arrays.fill(arr, -1);
			Arrays.fill(bit, -1);
			init();
			while (n != 0)//存储这个数字的各个位，并且开始是最高位
			{
				arr[len++] = n % 10;
				n = n / 10;
			}
			int len2 = 0;
			for (int i = 0; i <= 14; i++)
			{
				if (arr[arr.length-i-1] != -1)
					bit[len2++] = arr[arr.length-i-1];
			}
			length = 0;
			for (int i = 0; i <= 14; i++)
			if (bit [i] != -1)
			{
				length++;
			}
			System.out.println(solve());
		}
	}
	public void init ()
	{
		pow = new int [11];
		pow[0]=1;//
		for (int i = 1;i <= 10; i++)
			pow[i] = pow[i-1] * 10 % 13;
	}
	public int solve ()
	{
		dp = new int [16][14][3][2];
		dp [0][0][0][1] = 1;
		//下面的k可取0,1,2那么0表示不是13结尾
		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j <= 12; j++)
			{
				for (int k = 0; k <= 2; k++)
				{
					for (int l = 0; l <= 1; l++)
					{
						int r = (l == 1) ? bit[i] : 9;
						for (int x = 0; x <= r; x++)
						{
							int flag = 0;
							if (k == 2 || (k == 1 && x == 3))
								flag = 2;
							else if (k != 2 && x == 1)
								flag = 1;
							else if (k != 2 && x != 1)
								flag = 0;
							dp[i+1][(j + cal(x, length-i-1, 13)) % 13][flag][(l == 1 && x == r) ? 1 : 0]
										+= dp[i][j][k][l];
							
						}
					}
				}
			}
		}
		return (dp[length][0][2][0] + dp[length][0][2][1]);
	}
	public int cal (int x, int wei, int p)
	{
		return  x * pow[wei] % p; 
	}
	public static void main(String[] args)
	{
		new MainA();
	}
	
}
