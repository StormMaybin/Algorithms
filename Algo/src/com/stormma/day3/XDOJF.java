package com.stormma.day3;
import java.util.Arrays;
import java.util.Scanner;
public class XDOJF
{
	Scanner scan = null;
	int [][] arr = new int [3][3];
	int [][] visit = new int [3][3];
	int [][] map = new int [3][3];
	int count;
	public static void main(String[] args)
	{
		new XDOJF().work();
	}
	public void work ()
	{
		scan = new Scanner (System.in);
		while (scan.hasNext())
		{
			count = 0;//初始化个数
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++)
					arr[i][j] = scan.nextInt();
			for (int i = 0; i < 3; i++)
			{
				Arrays.fill(visit[i], 0);//标记使用过了没
				Arrays.fill(map[i], 0);//初始化格子
			}   
			if (!isOk(arr))//剪枝如果全是偶数的话
				System.out.println(0);
			else
			{
				DFS(1);
				System.out.println(count);
			}
		}
		scan.close();
	}
	public void DFS (int k)
	{
		//如果填完最后一个数字就结束搜索，结束条件
		if (k == 10)
		{
			count++;
			return;
		}
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
			{
				if (visit[i][j] == 0)//如果这个数还没有用过
				{
					//第一个格子
					if (k == 1)
					{
						visit[i][j] = 1;
						map[0][0] = arr[i][j];
						DFS(k+1);
						visit[i][j] = 0;
					}
					//2 3
					else if (k <= 3)
					{
						if (gcd (map[0][k-2],arr[i][j]) == 1) 
						{
							visit[i][j] = 1;
							map[0][k-1] = arr[i][j];
							DFS(k+1);
							visit[i][j] = 0;
						}
					}
					//6 9 
					else if (k % 3 == 0 && k / 3 > 1)
					{
						if ((gcd (map[k/3-1][1],arr[i][j]) == 1) && gcd ( map[k/3-2][2],arr[i][j]) == 1)
						{
							visit[i][j] = 1;
							map[k/3-1][2] = arr[i][j];
							DFS(k+1);
							visit[i][j] = 0;
						}
					}
					//4  7 
					else if (k % 3 == 1)
					{
						if (gcd(map[k/3-1][0],arr[i][j]) == 1)
						{
							visit[i][j] = 1;
							map[k/3][0] = arr[i][j];
							DFS(k+1);
							visit[i][j] = 0;
						}
					}
					//5 8 
					else if (k % 3 == 2)
					{
						if ((gcd (map[k/3][0], arr[i][j]) == 1) && gcd (map[k/3-1][1], arr[i][j]) == 1)
						{
							visit[i][j] = 1;
							map[k/3][1] = arr[i][j];
							DFS(k+1);
							visit[i][j] = 0;
						}
					}
				}
			}
	}
	public int gcd (int a, int b)
	{
		return a % b == 0 ? b : gcd (b, a % b);
	}
	public boolean isOk (int [][] arr)
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (arr[i][j] % 2 == 1)
					return true;
		return false;
	}
}
