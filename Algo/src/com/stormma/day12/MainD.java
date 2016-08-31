package com.stormma.day12;
import java.util.Scanner;
public class MainD
{
	Scanner scan = new Scanner(System.in);
	long xx;
	public MainD()
	{
		while (scan.hasNext())
		{
			xx = scan.nextLong();
			while (xx % 3 == 0)
			{
				xx /= 3;
			}
			System.out.println(xx / 3 + 1);
		}
		scan.close();
	}
	public static void main(String[] args)
	{
		new MainD();
	}
}
