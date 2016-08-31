package com.stormma.day11;
import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * 2016Äê8ÔÂ12ÈÕ11:50:56
 * @author StormMaybin
 */
public class MainA
{
	int time;
	int count;
	String str;
	Scanner scan = new Scanner(new BufferedInputStream(System.in));
	int [] c;
	int u, v;
	public MainA()
	{
		time = scan.nextInt();
		int num = time;
		while ((time --) > 0)
		{
			count = scan.nextInt();
			c = new int [count+1];
			for (int i = 1; i <= count; i++)
			{
				add(i, scan.nextInt());
			}
			System.out.println("Case "+(num-time)+":");

			while ((str = scan.next()) != null && !str.equals("End"))
			{
				u = scan.nextInt();
				v = scan.nextInt();
				if (str.equals("Query"))
					System.out.println(getSum(v)-getSum(u-1));
				else if (str.equals("Add"))
					add(u, v);
				else if (str.equals("Sub"))
					add(u, -v);
			}
			
		}
	}
	public int lowBit (int x)
	{
		return x & (-x);
	}
	public void add (int pos, int value)
	{
		while (pos <= count)
		{
			c[pos] += value;
			pos += lowBit(pos);
		}
	}
	public int getSum(int pos)
	{
		int ans = 0;
		while (pos > 0)
		{
			ans += c[pos];
			pos -= lowBit(pos);
		}
		return ans;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainA();
	}
}
