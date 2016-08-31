package com.stormma.day11;
import java.io.BufferedInputStream;
import java.util.Scanner;
public class MainA3
{

	/**
	 * @param args
	 */
	Scanner scan = new Scanner (new BufferedInputStream(System.in));
	int [] sum = new int [231];
	int [] arr = new int [50005];
	int time;
	int n;
	public final static int block = 230;
	public MainA3()
	{
		time = scan.nextInt();
		for (int t = 1; t <= time; t++)
		{
			n = scan.nextInt();
			for (int i = 1; i <= n; i++)
			{
				arr[i] = scan.nextInt();
				int belong = i / block;
				sum[belong] += arr[i];
			}
			System.out.println("Case "+t+":");
			while (true)
			{
				String str = scan.next();
				if (str.equals("End"))
					break;
				int u = scan.nextInt();
				int v = scan.nextInt();
				if (str.equals("Query"))
					System.out.println(query(u, v));
				else if (str.equals("Add"))
					add(u, v);
				else if (str.equals("Sub"))
					add(u, -v);
			}
		}
	}
	public void add (int x, int y)
	{
		int belong = x / block; 
		sum[belong] += y;//更新块的值
		arr[x] += y;//更新要更新的值
	}
	public int query (int x, int y)//查询x-y的和
	{
		int l = 0;
		int r = block - 1;//0-229
		int ans = 0;
		for (int i = 0; i < block; i++, l+=block, r+= block)
		{
			int L, R;
			L = Math.max(l, x);
			R = Math.min(r, y);
			if (L > R)//l必定是小于r的，x也是小于y的
				continue;
			if (L == l && R == r)
				ans += sum[i];
			else
			{
				for (int j = L; j <= R; j++) 	
					ans += arr[j];
			}
		}
		return ans;
	}
	public static void main(String[] args)
	{
		new MainA3();
	}
}
