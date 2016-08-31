package com.stormma.day10;
import java.util.Scanner;
public class MainA
{
	int [] c;
	int n;
	Scanner scan = new Scanner (System.in);
	int a, b;
	public MainA()
	{
		while (scan.hasNext())
		{
			n = scan.nextInt();
			if (n == 0)
				System.exit(0);
			c = new int [n+1];
			for (int i = 1; i <= n; i++)
			{
				a = scan.nextInt();
				b = scan.nextInt();
				add(a, 1);//这两个add就是给区间加1
				add(b+1, -1);
			}
			for (int i = 1; i <= n; i++)
				System.out.print(getSum(i)+((i == n) ? "\r\n":" "));
		}
	}
	public int lowBit (int x)
	{
		return x & (-x);
	}
	//求和
	public int getSum(int x)
	{
		int ans = 0;
		while (x > 0)
		{
			ans += c[x];
			x -= lowBit(x);
		}
		return ans;
	}
	public void add(int x, int vlaue)
	{
		while (x <= n)
		{
			c[x] += vlaue;
			x += lowBit(x);
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainA();
	}
}
