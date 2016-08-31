package com.stormma.xdoj;
import java.util.Arrays;
import java.util.Scanner;
public class Main1035
{
	public Main1035()
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while ((t--) > 0)
		{
			int arr[][] = new int [10][10];;
			for (int i = 1; i <= 9; i++)
				for (int j = 1; j <= 9; j++)
					arr[i][j] = scan.nextInt();
			if (isOk(arr))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
	public boolean isOk(int [][] arr)
	{
		//开始判断行
		for (int i = 1; i <= 9; i++)
		{
			int [] a = new int[10];
			Arrays.fill(a, 0);
			for (int j = 1; j <= 9; j++)
			{
				if (a[arr[i][j]] == 0)
					a[arr[i][j]] = 1;
				else
					return false;
			}
		}
		//开始判断列
		for (int i = 1; i <= 9; i++)
		{
			int [] a = new int[10];
			Arrays.fill(a, 0);
			for (int j = 1; j <= 9; j++)
			{
				if (a[arr[j][i]] == 0)
					a[arr[j][i]] = 1;
				else
					return false;
			}
		}
		//开始判断格子
		int b[] = new int [10];
		int c[] = new int [10];
		int d[] = new int [10];
		int e[] = new int [10];
		int f[] = new int [10];
		int g[] = new int [10];
		int h[] = new int [10];
		int i[] = new int [10];
		int j[] = new int [10];
		Arrays.fill(b, 0);
		Arrays.fill(c, 0);
		Arrays.fill(d, 0);
		Arrays.fill(e, 0);
		Arrays.fill(f, 0);
		Arrays.fill(g, 0);
		Arrays.fill(h, 0);
		Arrays.fill(i, 0);
		Arrays.fill(j, 0);
		//1
		for (int x = 1; x <= 3; x++)
		{
			for (int y = 1; y <= 3; y++)
			{
				if (b[arr[x][y]] != 0)
					b[arr[x][y]] = 1;
				else
					return false;
			}
		}
		//2
		for (int x = 1; x <= 3; x++)
		{
			for (int y = 4; y <= 6; y++)
			{
				if (c[arr[x][y]] != 0)
					c[arr[x][y]] = 1;
				else
					return false;
			}
		}
		//3
		for (int x = 1; x <= 3; x++)
		{
			for (int y = 7; y <= 9; y++)
			{
				if (d[arr[x][y]] != 0)
					d[arr[x][y]] = 1;
				else
					return false;
			}
		}
		//4
		for (int x = 4; x <= 6; x++)
		{
			for (int y = 1; y <= 3; y++)
			{
				if (e[arr[x][y]] != 0)
					e[arr[x][y]] = 1;
				else
					return false;
			}
		}
		//5
		for (int x = 4; x <= 6; x++)
		{
			for (int y = 4; y <= 6; y++)
			{
				if (f[arr[x][y]] != 0)
					f[arr[x][y]] = 1;
				else
					return false;
			}
		}
		//6
		for (int x = 4; x <= 6; x++)
		{
			for (int y = 7; y <= 9; y++)
			{
				if (g[arr[x][y]] != 0)
					g[arr[x][y]] = 1;
				else
					return false;
			}
		}
		//7
		for (int x = 7; x <= 9; x++)
		{
			for (int y = 1; y <= 3; y++)
			{
				if (h[arr[x][y]] != 0)
					h[arr[x][y]] = 1;
				else
					return false;
			}
		}
		//8
		for (int x = 7; x <= 9; x++)
		{
			for (int y = 4; y <= 6; y++)
			{
				if (i[arr[x][y]] != 0)
					i[arr[x][y]] = 1;
				else
					return false;
			}
		}
		//9
		for (int x = 7; x <= 9; x++)
		{
			for (int y = 7; y <= 9; y++)
			{
				if (j[arr[x][y]] != 0)
					j[arr[x][y]] = 1;
				else
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main1035();
	}
}
