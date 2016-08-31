package com.stormma.day3;
import java.util.Scanner;

public class MainA_3
{

	/**
	 * @param args
	 */
	public static int [][] visit = new int [1005][1005];
	public static int [][] map = new int [1005][1005];
	public static int ax, ay, bx, by;
	public static int n, m;
	public static int time;
	public static boolean flag = false;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner (System.in);
		while (scan.hasNext())
		{
			n = scan.nextInt();
			m = scan.nextInt();
			if (n == 0 && m == 0)
				System.exit(0);
			inputArr(scan, map, n, m);
			time = scan.nextInt();
			while ((time--) > 0)
			{
				int [][] vis = new int [1005][1005];
				flag = false;
				ax = scan.nextInt();
				ay = scan.nextInt();
				bx = scan.nextInt();
				by = scan.nextInt();
				if (ax == bx && ay == by || map[ax][ay] == 0 || map[ax][ay] != map[bx][by])
					System.out.println("NO");
				else
				{
					//分为四个方向开始搜索
				}
			}
		}
		scan.close();
	}
	//输入数组
	public static void inputArr(Scanner scan,int [][] map, int n, int m)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				map[i][j] = scan.nextInt();
			}
		}
	}
	public static void dfs(int x, int y, int dir, int count,int [][] vis)
	{
		//如果是已经找到了，或者是转弯次数已经大于2，又或者这个坐标是不存在的，都不处理
		if (flag || count > 2 || x <= 0 || y <= 0 || x > n || y > m)
			return;
		if (x == bx && y == by && count <= 2)
		{
			flag = true;
			return;
		}
		else if (count == 2)//剪枝操作
		{
			if(!(dir == 1 && x > bx && y == by || dir == 2 && x < bx && y == by || dir == 3 && y > by && x == bx || dir == 4 && y < by && x == bx))  
		        return;  
		}
		else if(vis[x][y] != 0) //如果已经搜索过了
	    	return ;  
	}
}
