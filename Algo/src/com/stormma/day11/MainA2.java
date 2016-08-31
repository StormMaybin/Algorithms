package com.stormma.day11;
import java.util.Scanner;
public class MainA2
{
	Tree [] tree = new Tree[50000*2+10];
	Scanner scan = new Scanner (System.in);
	int ans;
	int time;
	int n;
	String str;
	public class Tree
	{
		int l;
		int r;
		int sum;//维护区间和
		int mid ()
		{
			return (l + r) >> 1;
		}
	}
	public MainA2()
	{
		time = scan.nextInt();
		for (int t = 1; t <= time; t++)
		{
			n = scan.nextInt();
			for (int i = 0; i <= 2 * n + 5; i++)
				tree[i] = new Tree();
			buildTree(1, n, 1);
			System.out.println("Case "+t+":");
			while (true)
			{
				str = scan.next();
				if (str.equals("End"))
					break;
				int u = scan.nextInt();
				int v = scan.nextInt();
				if (str.equals("Add"))
					update(1, n, 1, u, v);
				if (str.equals("Sub"))
					update (1, n, 1, u, -v);
				if (str.equals("Query"))
				{
					ans = 0;
					query(1,n,1,u,v); 
					System.out.println(ans);
				}
			}
		}
	}
	public void buildTree (int l, int r, int nd)
	{
		tree[nd].l = l;
		tree[nd].r = r;
		if (l == r)
		{
			tree[nd].sum = scan.nextInt();
			return;
		}
		int mid = tree[nd].mid();
		buildTree(l, mid, nd << 1);
		buildTree(mid+1, r, nd << 1 | 1);
		tree[nd].sum = tree[nd << 1].sum + tree[nd << 1 | 1].sum;
	}
	public void query (int l, int r, int nd, int u, int v)//区间求和
	{
		if (u <= l && v >= r)
		{
			ans += tree[nd].sum;
			return;
		}
		int mid = tree[nd].mid();
		if (u > mid)
			query(mid + 1, r, nd << 1 | 1, u, v);
		else if (u <= mid)
			query(l, mid, nd << 1, u, v);
		else
		{
			query (l, mid, nd << 1, u, v);
			query (mid+1, r, nd << 1 | 1, u, v);
		}
	}
	public void update (int l, int r, int nd, int u, int v)//单点更新u的值加v
	{
		if (l == r)
		{
			tree[nd].sum += v;
			return;
		}
		int mid = tree[nd].mid();
		if (u <= mid)
			update (l, mid, nd << 1, u, v);
		else if (u > mid)
			update (mid+1, r, nd << 1 | 1, u, v);
		tree[nd].sum = tree[nd << 1].sum + tree[nd << 1 | 1].sum;
	}
	public static void main(String[] args)
	{
		new MainA2();
	}
}
