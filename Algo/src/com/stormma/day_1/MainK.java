package com.stormma.day_1;
import java.util.Scanner;

public class MainK
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		long [] a = new long [1400000];
		long [] b = new long [1400000];
		int t;
		init(a, b);
		/**
		 * l:层数
		 * r:行数
		 * c:列数
		 */
		int l, r, c;
			t = scan.nextInt();
			for (int i = 1; i <= t; i++)
			{
				//那个数字
				long n = scan.nextLong();
				l = er_fen1(n, b);
				if (b[l] == n)
				{
					System.out.println(l+" "+l+" "+l);
				}
				else
				{
					if(b[l] < n)
					l++;
					long temp = n - b[l-1];
					r = er_fen2(temp, l, a);
					if(a[r] == temp)
					{
						System.out.println(l+" "+r+" "+r);
					}
					else
					{
						if(a[r] < temp)
							r++;
						c = (int) (temp - a[r-1]);
						System.out.println(l+" "+r+" "+c);
					}
				}
			}
		}
	public static void init (long [] a, long [] b)
	{
		a[0] = 0;
		for (int i = 1; i < 1400000; i++)
		{
			a[i] = a[i-1] + i;
		}
		b[0] = 0;
		for (int i = 1; i < 1400000; i++)
		{
			b[i] = b[i-1] + a[i];
		}
	}
	/***
	 * 二分查找层数
	 * @param n
	 * @param b
	 * @return
	 */
	public static int er_fen1(long n, long [] b)
	{
		int low,high,mid;
		low = 1;
		high = 1400000;
		while(low+1 != high)
		{
			mid = (low+high) / 2;
			if(b[mid] < n)
				low = mid;
			else if(b[mid] > n)
				high = mid;
			else
			{
				return mid;
			}
		}
		return low;
	}
	/***
	 * 二分查找行数
	 * @param n
	 * @param m
	 * @param a
	 * @return
	 */
	public static int er_fen2(long n, int m, long [] a)
	{
		int low, high, mid;
		low = 1;
		high = m;
		while(low+1 != high)
		{
			mid = (low+high) / 2;
			if(a[mid] < n)
				low = mid;
			else if(a[mid] > n)
				high = mid;
			else
			{
				return mid;
			}
		}
		return low;
	}
}
