package com.stormma.day9;
import java.util.Scanner;
public class MainA
{
	int [] F;
	int [] sum;
	Scanner scan = null;
	int n, m;
	int l, r, s;//l:left左区间，r:right右区间，s:sum和
	public MainA()
	{
		scan = new Scanner (System.in);
		while (scan.hasNext())
		{  	
			n = scan.nextInt();
			m = scan.nextInt();
			F = new int [n+2];
			sum = new int [n+2];
			//init
			for (int i = 0; i <= n; i++)
			{
				F[i] = i;
				sum[i] = 0;
			}
			//计数
			int count = 0; 
			while ((m--) > 0)
			{
				l = scan.nextInt();
				r = scan.nextInt();
				s = scan.nextInt();
				l--;//从l到r的和，等于0-r的和减去0--（l-1）的和
				int ra = find (l);
				int rb = find (r);
				if (ra == rb)
				{
					if (sum[l] - sum[r] != s)
						count ++;
				}//合并
				else //ra != rb说明两个不是同一个集合的，开始合并
				{
					if (ra > rb)//比较它们 的父节点的大小    小的和大的合并在一起
					{
						F[rb] = ra;//改变父节点
						sum[rb] = sum[l] - s - sum[r];//开始更新他的距离值;
					}
					else
					{
						F[ra] = rb;
						sum[ra] = s + sum[r] - sum[l];
					}
				}
			}
			System.out.println(count);
//			for (int i = 0; i <= n; i++)
//				System.out.print(sum[i]+" ");
//			System.out.println();
//			for (int i = 0; i <= n; i++)
//				System.out.print(F[i]+" ");
//			System.out.println("\n___________________________");
//			System.out.println("0  1  2  3  4  5  6  7  8  9  10");
		}
	}
	public static void main(String[] args)
	{
		new MainA();
	}	
	public int find (int x)
	{
		if (x != F[x])
		{
			int f = F[x];//先保存父节点
			F[x] = find (F[x]);//改变了父亲节点
			sum[x] += sum[f];//那么对应的距离也要改变 ，变成到新的父亲结点之间的距离
		}
		return F[x];//如果本身就是自己的父节点  那么直接返回
	}
}
