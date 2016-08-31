package com.stormma.day_1;
import java.util.Scanner;
public class MainA
{
	Scanner scan = new Scanner(System.in);
	public MainA()
	{
		while (scan.hasNext())
		{
			long r = scan.nextLong();
			long g = scan.nextLong();
			long b = scan.nextLong();
			Long ans = Math.min((r+g+b)/3, Math.min(r+g, Math.min(g+b, r+b)));
			System.out.println(ans);
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainA();
	}

}
