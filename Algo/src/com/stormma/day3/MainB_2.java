package com.stormma.day3;
import java.util.Scanner;
public class MainB_2
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner (System.in);
		int n;
		while (scan.hasNext())
		{
			int count = 0;
			n = scan.nextInt();
			if ((n*(n+1)/2) % 2 == 1)
				System.out.println(0);
			else
			{
				count =  0;
				//¿ªÊ¼ÉîËÑ
//				dfs (0);
				System.out.println(count);
			}
		}
	}
	public static int count = 0;
////	public static int dfs (int i, int n)
//	{
//		if (i == n)
//			return count;
//		else
//		{
//			
//		}
//	}
}
