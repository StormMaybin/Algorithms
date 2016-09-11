package com.stormma.string;

import java.io.BufferedInputStream;
import java.nio.channels.Pipe;
import java.util.Scanner;

public class Main1
{
	private Scanner scan;

	/**
	 * @param args
	 */
	public Main1()
	{
		scan = new Scanner(new BufferedInputStream(System.in));
		while (scan.hasNext())
		{
			int n;
			n = scan.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = scan.nextInt();
			int target = scan.nextInt();
			int position = 0;
			boolean flag = false;
			for (int i = 0; i < n; i++)
			{
				if (target <= arr[i])
				{
					position = i;
					flag = true;
					break;
				}
			}
			if (!flag)
				position = arr.length;
			System.out.println(position);
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main1();
	}

}
