package com.stormma.cf;

import java.util.Scanner;

public class Main1
{

	/**
	 * @param args
	 */
	private Scanner scan;
	public Main1 ()
	{
		scan = new Scanner(System.in);
		while (scan.hasNext())
		{
			int n = scan.nextInt();
			int c = scan.nextInt();
			int [] a = new int [n];
			for (int i = 0; i < n; i++)
			{
				a[i] = scan.nextInt();
			}
			int [] b = new int [n];
			for (int i = 1; i < n; i++)
			{
				b[i-1] = a[i] - a[i-1];
			}
			int ans = 0;
			for (int i = b.length-1; i >= 0; i--)
			{
				if (b[i] <= c)
					ans++;
				else
					break;
			}
			System.out.println(ans);
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main1 ();
	}

}
