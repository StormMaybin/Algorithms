package com.stormma.day_1;

import java.util.Scanner;

public class MainF
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int n;
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		while (scan.hasNext())
		{
			int start = -1;
			int end = -1;
			n = scan.nextInt();
			int [] arr = new int [n];
			for (int i = 0; i < n; i++)
			{
				arr[i] = scan.nextInt();
			}
			/***
			 * 开始操作
			 */
			for (int i = 0; i < n-1; i++)
			{
				//标记开始递减的下标
				if (arr[i] > arr[i+1])
				{
					if (start == -1)
						start = i;
				}
				//标记开始递增的下标
				if (arr[i] < arr[i+1])
				{
					if (start != -1)
					{
						end = i;
						break;
					}
				}
			}
			if (start != -1 && end == -1)
				end = n-1;
//			System.out.println(start+"---- "+end);
			if (isDijian(arr))
			{
				System.out.println("yes");
				System.out.println("1"+" "+arr.length);
			}
			else if (isIncrease(arr))
			{
				System.out.println("yes");
				System.out.println(1+" "+1);
			}
//			else if (end < start)
//			{
//				System.out.println("no");
//			}
			else
			{
				reverse(arr, start, end);
				if (isIncrease(arr))
				{
					System.out.println("yes");
					System.out.println((start+1)+" "+(end+1));
				}
				else
				{
					System.out.println("no");
				}
			}
		}
	}
	public static void reverse (int [] arr, int start, int end)
	{
		if (start != -1 && end != -1)
		{
			for (; start < end; start++,end--)
			{
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
	}
	public static boolean isIncrease(int [] arr)
	{
		for (int i = 0; i < arr.length-1; i++)
		{
			if (arr[i] > arr[i+1])
			{
				return false;
			}
		}
		return true;
	}
	public static boolean isDijian (int [] arr)
	{
		for (int i = 0; i < arr.length-1; i++)
		{
			if (arr[i] < arr[i+1])
			{
				return false;
			}
		}
		return true;
	}
}
