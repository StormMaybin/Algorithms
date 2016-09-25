package com.stormma.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main2039
{
	private static Scanner scan = null;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		scan = new Scanner(new BufferedInputStream(System.in));
		int n = scan.nextInt();
		while ((n--) > 0)
		{
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			if ((a + b) > c && (a + c) > b && (b + c) > a)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
