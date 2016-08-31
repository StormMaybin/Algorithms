package com.stormma.day10;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 题目：给一个序列，每次可以把开头接到结尾去，然后求这个序列的最小逆序数
 * @author StormMaybin
 *
 */
public class MainD
{
	Scanner scan = new Scanner(System.in);
	int[] tree = new int[100000];
	int[] num = new int[100000];
	int n;
	public MainD()
	{
		while (scan.hasNext())
		{
			n = scan.nextInt();
			//进行初始化
			Arrays.fill(num, 0);
			Arrays.fill(tree, 0);
			//标记答案
			int ans = 0;
			for (int i = 1; i <= n; i++)
			{
				num[i] = scan.nextInt();
				ans += qury (num[i], n - 1, 0, n - 1, 1);//计算原来的区间树里面有几个比num[i]的数
				update(num[i], 0, n - 1, 1);//把num[i]这个数字更新到0--n-1这个区间树中去
			}
			int min = ans;
			for (int i = 1; i <= n; i++)
			{
				ans = ans + n - 2 * num[i] - 1;
				if (min > ans)
					min = ans;
			}
			System.out.println(min);
			System.out.println("____________________________");
			for (int i = 1; i <= 19; i++)
				System.out.print(tree[i]+" ");
		}
	}
	/**
	 * @param x 要更新的数字
	 * @param l 左区间
	 * @param r 右区间
	 * @param k id
	 */
	public void update(int x, int l, int r, int k)
	{
		if (l == r)//如果找到那个点
		{
			tree[k] = 1;
			return;
		}
		int mid = (l + r) >> 1;
		if (x <= mid)
			update(x, l, mid, k << 1);
		else
			update(x, mid + 1, r, k << 1 | 1);
		tree[k] = tree[k << 1] + tree[k << 1 | 1];
	}
	/**
	 * @param x
	 * @param y (x, y)区间//给x - y这个区间全部更新
	 * @param l
	 * @param r (l, r)区间
	 * @param k
	 * @return
	 */
	public int qury (int x, int y, int l, int r, int k)
	{
		if (l == x && r == y)
		    return  tree[k];
		int mid = (l + r) >> 1;
		if (y <= mid)
			return qury (x, y, l, mid, k << 1);
		if (x > mid)
			return qury (x, y, mid+1, r, k << 1 | 1);
		else
			return qury (x, mid, l, mid, k << 1) + qury (mid + 1, y, mid+1, r, k << 1 | 1);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainD();
	}
}
