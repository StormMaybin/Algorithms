package com.stormma.uva;
import java.io.IOException;
import java.util.Scanner;
/**
 * Corporative network LA 3027
 * @author StormMaybin
 * shia
 */
public class Main2
{
	Scanner scan = new Scanner (System.in);
	public final static int maxn = 20010;
	int time;
	int n, u, v;
	char c;
	int [] fa = new int [maxn];
	int [] dis = new int [maxn];//被维护的距离数组
	public Main2()
	{
		time = scan.nextInt();
		while ((time --) > 0)
		{
			n = scan.nextInt();
			init (n);
			try
			{
				while ((c = (char)System.in.read()) != 'O')
				{
					if (c == 'E')
					{
						u = scan.nextInt();
						find (u);
						System.out.println(dis[u]);
					}
					else if (c == 'I')
					{
						u = scan.nextInt();
						v = scan.nextInt();
						fa[u] = v;
						dis[u] = Math.abs(u-v) % 1000;
					}
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	public int find (int x)
	{
		if (x != fa[x])
		{
			int root = find (fa[x]);
			//开始更新距离dis;
			dis[x] += dis[fa[x]];
			return fa[x] = root;
		}
		else
			return x;
	}
	public void init (int n)
	{
		for (int i = 0; i <= n; i++)
		{
			fa[i] = i;
			dis[i] = 0;
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main2();
	}

}
