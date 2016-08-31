package com.stormma.day9;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
/***
 * 最大矩形面积:单调栈
 * @author StormMaybin
 *
 */
public class MainJ
{
	int n;
	Scanner scan = null;
	int [] height;
	long MAX_AREA;
	long sum;
	LinkedList<Integer> list = null;
	int temp = 0;
	public MainJ()
	{
		scan = new Scanner (System.in);
		list = new LinkedList<Integer>();
		while (scan.hasNext())
		{
			n = scan.nextInt();
			if (n == 0)
				System.exit(0);
			height = new int [n+10];
			Arrays.fill(height, 0);
			for (int i = 0; i < n; i++)
				height[i] = scan.nextInt();
			MAX_AREA = Long.MIN_VALUE;
			sum = 0;
			for (int i = 0; i <= n; i++)//多加一个高为0的矩形
			{
				if (list.isEmpty() || (height[list.peekLast()] <= height[i]))//如果此时的栈为空，或者是可添加元素
					{list.addLast(i);
//					System.out.println(i);
					}
				
				else if (height[list.peekLast()] > height[i])//如果此时不满足情况
				{
					while ((!list.isEmpty() && height[list.peekLast()] > height[i]))
					{
						sum = (i - list.peekLast()) * height[list.peekLast()];
						if (sum > MAX_AREA)
							MAX_AREA =  sum;
						temp = list.peekLast();
//						System.out.println("_temp"+temp);
						//移除元素
//						System.out.println(list);
						list.pollLast();
					}
					list.addLast(i);
				}
			}
			System.out.println(MAX_AREA);
		}
		
	}
	public static void main(String[] args)
	{
		new MainJ();
	}   

}
