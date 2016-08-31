package com.stormma.day_1;

import java.util.Scanner;
import java.util.ArrayList;
import java.math.*;
public class MainC
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int a, b, c;
		ArrayList list = new ArrayList();
		Scanner scan = new Scanner (System.in);
		while (scan.hasNext())
		{
			list.clear();
			a = scan.nextInt();
			b = scan.nextInt();
			c = scan.nextInt();
			for (int i = 1; i <= 81; i++)
			{
				long x = (long)(b * Math.pow((double)i, (double)a) + c);
				if (func (x) == i)
				{
					if (x > 0 && x < 1000000000)
					{
						list.add(x);
					}
				}
			}
			int count = list.size();
			System.out.println(count);
			for(int i = 0; i < count; i++)
			{
				System.out.print(list.get(i)+" ");
			}
//			System.out.println(list.get(0));
			System.out.println();
		}
	}
	public static int func (long x)
	{
		int sum = 0;
		while (x!=0)
		{
			int c = (int)x % 10;
			x = x / 10;
			sum += c;
		}
		return sum;
	}
}
