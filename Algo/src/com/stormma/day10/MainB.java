package com.stormma.day10;
import java.util.Arrays;
import java.util.Scanner;
public class MainB
{
	int [] c;
	int [] count;
	Scanner scan = null;
	int temp;
	int x, y;
	public final static int N = 32001;
	public MainB()
	{
		scan = new Scanner (System.in);
		while (scan.hasNext())
		{
			temp = scan.nextInt();
			c = new int [N];
			count = new int [N];
			Arrays.fill(c, 0);
			Arrays.fill(count, 0);
			for (int i = 1; i <= temp; i++)
			{
				x = scan.nextInt();
				y = scan.nextInt();
				add(x+1, 1);
				int flag = getSum(x+1)-1;
				count[flag]++;
				//单点插值  返回的是和
			}			
			for (int i = 0; i < temp; i++)
				System.out.println(count[i]);
		}
		scan.close();
	}
	public int lowBit(int x)
	{
		return x & (-x);
	}
	public void add (int x, int value)
	{
		while (x <= N)
		{
			c[x] += value;
			x += lowBit(x);
		}
	}
	public int getSum (int x)
	{
		int ans = 0;
		while (x > 0)
		{
			ans += c[x];
			x -= lowBit(x);
		}
		return ans;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainB();
	}
}
