package com.stormma.uva;
import java.util.Scanner;
/***
 * 并查集：易爆物
 * @author StormMaybin
 *	思路：将两个元素组成的化合物看成是一条以a点开始b点结束的一条边，
 *	如果组成的这个图没有形成圆环，那么就没有危险，为什么呢？因为圆环的
 *	点的个数和边的个数恰好相等，所以有危险，所以采用并查集来实现;
 */
public class Main
{
	Scanner scan = new Scanner (System.in);
	int [] fa = new int [100010];
	int x, y;
	public Main ()
	{
		while (scan.hasNext())
		{
			init();
			int ans = 0;
			x = scan.nextInt();
			while (x != -1)
			{
				y = scan.nextInt();
				int xx = find(x);
				int yy = find(y);
				if (xx == yy)
					ans++;
				else
					fa[xx] = yy;//合并
				x = scan.nextInt();
			}
			System.out.println(ans);
		}
	}
	public void init ()
	{
		for (int i = 0; i < 100010; i++)
			fa[i] = i;
	}
	public int find (int x)
	{
		if(x != fa[x])
			fa[x] = find (fa[x]);
		return fa[x];
	}
	public static void main(String[] args)
	{
		new Main();
	}

}
