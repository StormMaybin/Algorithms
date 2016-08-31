package com.stormma.day10;
import java.util.Scanner;
/**
 * 2016年8月11日20:48:29
 * @author StormMaybin
 *
 */
public class MainD2
{
	Scanner scan = new Scanner (System.in);
	Tree [] tree= new Tree[5000*2+10];
	int n;
	int [] a ;
//	int cc = 1;
	public class Tree
	{
		int l;
		int r;
		int num;
	}
	public MainD2()
	{
		while (scan.hasNext())
		{
			n = scan.nextInt();
			for (int i = 0; i < 5000*2+10; i++)
				tree[i] = new Tree();
			a = new int [n+1];
			//开始建立线段树
			build_tree(0, n-1, 1);
			int ans = 0;
			for (int i = 1; i <= n; i++)
			{
				a[i] = scan.nextInt();
				ans += query (a[i], n-1, 1);//找到比a[i]大的数
				update (a[i], 1);
			}
			//开始更新最小的答案
			int min = ans;
			for (int i = 1; i <= n; i++)
			{
				ans += n - 2 * a[i] - 1;
				if (min > ans)
					min = ans;
			}
			System.out.println(min);
		}
	}
	/**
	 * 递归建树
	 * @param l
	 * @param r
	 * @param nd
	 */
	public void build_tree(int l, int r, int nd)//nd代表编号
	{
		tree[nd].l = l;
		tree[nd].r = r;
		tree[nd].num = 0;
//		System.out.println("Good"+"     "+(cc++)+"l:  "+tree[nd].l+"r:  "+tree[nd].r+"num:  "+tree[nd].num);
		if (l == r)//已经到达叶子结点
			return ;
		int mid = (l + r) >> 1;
		build_tree(l, mid, nd << 1);
		build_tree(mid+1,r, nd << 1 | 1);
	}
	/**
	 * 查询
	 * @param l
	 * @param r
	 * @param nd
	 * @return
	 */
	public int query (int l, int r, int nd)
	{
//		System.out.println("我是id"+nd);
		int mid = (tree[nd].l + tree[nd].r) >> 1;
//		System.out.println("我是mid"+mid);
		if (tree[nd].l == l && tree[nd].r == r)
			return tree[nd].num;
		else if (r <= mid)
			return query(l, r, nd << 1);
		else if (l > mid)
			return query (l, r, (nd << 1) | 1);
		else 
			return query (l, mid, nd << 1) + query (mid+1, r, (nd << 1) | 1);
	}
	/**
	 * 更新
	 * @param pos
	 * @param nd
	 */
	public void update (int pos, int nd)
	{
		if (tree[nd].l == tree[nd].r)//说明是叶子结点
		{
			tree[nd].num ++;
			return ;
		}
		int mid = (tree[nd].l + tree[nd].r) >> 1;
		if (pos <= mid)//说明pos在左子树
			update (pos, nd << 1);
		else
			update (pos, (nd << 1) | 1);
		//继续更新父节点
		tree[nd].num = tree[nd << 1].num + tree[(nd << 1) | 1].num;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainD2();
	}

}
