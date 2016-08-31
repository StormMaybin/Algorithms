package com.stormma.day_1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class MainB
{

	/**
	 * @param args
	 */
	class Node implements Comparator<Integer>
	{
		int a;
		int b;
		@Override
		public int compare(Integer o1, Integer o2)
		{
			// TODO Auto-generated method stub
			return o1 - o2;
		}
	}
	public MainB()
	{
		Scanner scan = new Scanner (System.in);
		int n;
		n = scan.nextInt();
		Node [] arr = new Node[n];
		for (int i = 0; i < n; i++)
			arr[i] = new Node();
		for (int i = 0; i < n; i++)
		{
			arr[i].a = scan.nextInt();
			arr[i].b = scan.nextInt();
		}
		Arrays.sort(arr);
		int MAX = Integer.MIN_VALUE;
		int flag = 0;
		for (int i = 0; i < n; i++)
		{
			if (MAX > arr[i].b)
			{
				flag = 1;
				System.out.println("Happy Alex");
				break;
			}
			MAX = Math.max (arr[i].b, MAX); 
		}
		if (flag == 0)
			System.out.println("Poor Alex");
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainB();
	}

}
