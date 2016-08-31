package com.stormma.forever;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
public class MainM
{
	Scanner scan = new Scanner (System.in);
	public MainM()
	{
		int T = scan.nextInt();
		while ((T--) > 0)
		{
			String A = scan.next();//ZX
			String B = scan.next();//LoveZX
			BigInteger biga = new BigInteger(A);
			BigInteger bigb = new BigInteger(B);
			int ans = 0;
			if (A.length() > B.length())//不可行
				System.out.println("Poor LoveZx");
			else if (A.length() < B.length())
				System.out.println(0);
			else if (bigb.compareTo(biga) > 0)//本身就大
				System.out.println(0);
			else//剩下的就是size相等，
			{
				for (int i = 0; i < 10000; i++)
				{
					char c = A.charAt(i);
					int j;
					for (j = 9; j >= 0; j++)
					{
						if (B.contains(j+""))
							break;
					}
					if ((j - c -'0') > 0)
						System.out.println(ans);
					else 
						ans ++;
				}
			}
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainM();
	}
}
