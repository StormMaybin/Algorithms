package com.stormma.day3;
import java.util.Scanner;
public class MainB
{
	public static void main(String[] args)
	{
		int [] arr = {0,0,4,6,0,0,12,40,0,0,171,410,0,0,1896,5160,0,0,32757,59984,0,0,431095,822229};
		Scanner scan = new Scanner (System.in);
		int n;
		while (scan.hasNext())
		{
			n = scan.nextInt();
			if (n == 0)
				System.exit(0);
			System.out.println(n+" "+arr[n-1]);
		}
	}
}
