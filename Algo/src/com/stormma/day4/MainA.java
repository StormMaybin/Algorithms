package com.stormma.day4;
import java.util.Scanner;
import java.util.LinkedList;
public class MainA
{
	class Point
	{
		int x;
		int y;
		public Point (int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	int n, m;
	int r1, c1, r2, c2;
	char [][] map = new char [505][505];
	int dx[]= { 1, -1, 0, 0 };
	int dy[]= { 0, 0, 1, -1 };//方向数组
	Scanner scan = null;
	LinkedList<Point> list = new LinkedList<Point>();
	public static void main(String[] args)
	{
		new MainA().work();
	}
	public void work ()
	{
		scan = new Scanner(System.in);
		while (scan.hasNext())
		{
			list.clear();
			n = scan.nextInt();
			m = scan.nextInt();
			for (int i = 0; i < n; i++)
			{
				String str = scan.next();
				map[i] = str.toCharArray();
			}
			r1 = scan.nextInt();
			c1 = scan.nextInt();
			r2 = scan.nextInt();
			c2 = scan.nextInt();
			r1--;
			c1--;
			r2--;
			c2--;
			if (BFS() == 1)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
	}
	public int BFS ()
	{
		Point p = new Point (r1,c1);
		list.add(p);
		map[r1][c1] = 'X';
		while (!list.isEmpty())
		{
			r1 = list.peek().x;
			c1 = list.peek().y;	
			list.poll();
			for (int i = 0; i < 4; i++)
			{
				int xx = r1 + dx[i];
				int yy = c1 + dy[i];
				if (isOk(xx, yy) == 0)
					continue;
				if (map[xx][yy] == 'X')
				{
					if (xx == r2 && yy == c2)
						return 1;
					else
						continue;
				}
				map[xx][yy] = 'X';
				list.add(new Point (xx,yy));
			}
		}
		return 0;
	}
	//判断越界没有
	public int isOk (int x, int y)
	{
		if (x < 0 || x >= n || y < 0 || y >= m)
			return 0;
		return 1;
	}
}
