package com.stormma.day_1;
import java.util.Scanner;
import java.util.LinkedList;

public class MainH
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int n, m;
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext())
		{
			LinkedList<Integer> list = new LinkedList<Integer>();
			n = scan.nextInt();
			m = scan.nextInt();
			int [] w = new int [n];
			int [] b = new int [m];
			for (int i = 0; i < n; i++)
			{
				w[i] = scan.nextInt();
			}
			/**
			 * 看书顺序
			 */
			for (int i = 0; i < m; i++)
			{
				b[i] = scan.nextInt();
			}
			/*
			 * 确定序列
			 */
			for (int i = 0; i < m; i++)
			{
				if (!list.contains(b[i]))
					list.offerLast(b[i]);
			}
			long ans = 0;
			/*
			 * 开始模拟
			 */
			for (int i = 0; i < m; i++)
			{
				if (b[i] == list.peek())
					continue;
				else//更新解的值
				{
					int index = list.indexOf(b[i]);
					int value = list.get(index);
					for (int j = 0; j < index; j++)
					{
						//质量叠加
						ans += list.get(w[j]);
					}
					list.remove(index);
					list.offerFirst(value);
				}
			}
			System.out.println(ans);
		}
	}
}
