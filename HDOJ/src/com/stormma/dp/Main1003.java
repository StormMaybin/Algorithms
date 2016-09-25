package com.stormma.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main1003
{

	/**
	 * @param args
	 */
	private Scanner scan;
	public Main1003()
	{
		scan = new Scanner (new BufferedInputStream(System.in));
		int n = scan.nextInt();
		int c = n;
		int count = 0;
		while ((n--) > 0)
		{
			int num = scan.nextInt();
			int [] a = new int [num];
			for (int i = 0; i < num; i++)
				a[i] = scan.nextInt();
			int sum = 0;
			int left = 0;
			int right = 0;
			int t = 0;
			count ++;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < num; i++)
			{
				if (sum >= 0)
					sum += a[i];
				else
				{
					sum = a[i];
					t = i;
				}
				if (sum > max)
				{
					max = sum;
					left = t;
					right = i;
				}
			}
			System.out.println("Case "+count+":");
			System.out.println(max+" "+(left+1)+" "+(right+1));
			if (count != c)
				System.out.println();
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main1003();
	}

}
