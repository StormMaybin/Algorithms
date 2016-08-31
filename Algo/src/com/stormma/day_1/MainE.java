package com.stormma.day_1;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MainE
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);	
		
		Comparator<Long> cmp = new Comparator<Long>()
		{
			
			@Override
			public int compare(Long o1, Long o2)
			{
				// TODO Auto-generated method stub
				return (int) (o2 - o1);
			}
		};
		PriorityQueue<Long> r = new PriorityQueue<Long>(1,cmp);
		PriorityQueue<Long> c = new PriorityQueue<Long>(1,cmp);
		long n, m, k;
		long p;
		while (scan.hasNext())
		{
			r.clear();
			c.clear();
			n = scan.nextLong();
			m = scan.nextLong();
			k = scan.nextLong();
			p = scan.nextLong();
			long [][] arr = new long [(int) n][(int) m];
			long [] a = new long [1000005];
			long [] b = new long [1000005];
			//存储枚举的答案的值
			/***
			 * 求行和，并把每一行的值存储到优先队列里面
			 */
			for (int i = 0; i < n; i++)
			{
				long sum_r = 0;
				for (int j = 0; j < m; j++)
				{
					arr[i][j] = scan.nextInt();
					sum_r += arr[i][j];
				}
				r.add(sum_r);
			}
//			for(int i = 0; i < n; i++)
//			{
//				for (int j = 0; j < m; j++)
//				{
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
			/**
			 * 求列和，并把每一列的和存储到优先队列中去
			 */
			for (int i = 0; i < m; i++)
			{
				long sum_c = 0;
				for(int j = 0; j < n; j++)
				{
					sum_c += arr[j][i];
				}
				//入队列
				c.add(sum_c);
			}
			/***
			 * 
			 * 行和预处理
			 * 列和预处理
			 */
			a[0] = 0;
			for (int i = 1; i <= k; i++)
			{
				a[i] = a[i-1] + r.peek();
				r.add((long)(r.peek() - m*p));
				r.poll();
			}
			b[0] = 0;
			for (int j = 1; j <= k; j++)
			{
				b[j] = b[j-1] + c.peek();
				c.add((long)(c.peek() - n*p));
				c.poll();
			}
			/**
			 * 开始枚举
			 */
			long max = Long.MIN_VALUE;
			for (int s = 0; s <= k; s++)
			{
				long ans = 0;
				ans = a[s] + b[(int) (k-s)] - (k-s)*s*p;
				max = Math.max(max, ans);
			}
			System.out.println(max);
		}
		scan.close();
	}
}
