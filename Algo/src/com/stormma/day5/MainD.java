package com.stormma.day5;
import java.util.Scanner;
import java.util.HashMap;
public class MainD
{

	/**
	 * @param args
	 */
	HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
	Scanner scan = new Scanner(System.in);
	int n;
	int [] length;
	int [] cost;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	}
	public MainD ()
	{
		init();
	}
	public void init ()
	{
		while (scan.hasNext())
		{
			dp.clear();
			dp.put(0, 0);
			n = scan.nextInt();
			length = new int [n+1];
			cost = new int [n+1];
			for (int i = 0; i < n; i++)
				length[i] = scan.nextInt();
			for (int i = 0; i < n; i++)
				cost[i] = scan.nextInt();
		}
	}
	public void work ()
	{
		for (int i = 0; i < n; i++)
		{
//			Iterator it = dp.
		}
	}
	public int gcd (int a, int b)
	{
		return b == 0 ? a : gcd(b, a % b);
	}
}
