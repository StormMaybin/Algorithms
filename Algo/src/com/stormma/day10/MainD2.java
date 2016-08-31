package com.stormma.day10;
import java.util.Scanner;
/**
 * 2016��8��11��20:48:29
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
			//��ʼ�����߶���
			build_tree(0, n-1, 1);
			int ans = 0;
			for (int i = 1; i <= n; i++)
			{
				a[i] = scan.nextInt();
				ans += query (a[i], n-1, 1);//�ҵ���a[i]�����
				update (a[i], 1);
			}
			//��ʼ������С�Ĵ�
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
	 * �ݹ齨��
	 * @param l
	 * @param r
	 * @param nd
	 */
	public void build_tree(int l, int r, int nd)//nd������
	{
		tree[nd].l = l;
		tree[nd].r = r;
		tree[nd].num = 0;
//		System.out.println("Good"+"     "+(cc++)+"l:  "+tree[nd].l+"r:  "+tree[nd].r+"num:  "+tree[nd].num);
		if (l == r)//�Ѿ�����Ҷ�ӽ��
			return ;
		int mid = (l + r) >> 1;
		build_tree(l, mid, nd << 1);
		build_tree(mid+1,r, nd << 1 | 1);
	}
	/**
	 * ��ѯ
	 * @param l
	 * @param r
	 * @param nd
	 * @return
	 */
	public int query (int l, int r, int nd)
	{
//		System.out.println("����id"+nd);
		int mid = (tree[nd].l + tree[nd].r) >> 1;
//		System.out.println("����mid"+mid);
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
	 * ����
	 * @param pos
	 * @param nd
	 */
	public void update (int pos, int nd)
	{
		if (tree[nd].l == tree[nd].r)//˵����Ҷ�ӽ��
		{
			tree[nd].num ++;
			return ;
		}
		int mid = (tree[nd].l + tree[nd].r) >> 1;
		if (pos <= mid)//˵��pos��������
			update (pos, nd << 1);
		else
			update (pos, (nd << 1) | 1);
		//�������¸��ڵ�
		tree[nd].num = tree[nd << 1].num + tree[(nd << 1) | 1].num;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainD2();
	}

}
