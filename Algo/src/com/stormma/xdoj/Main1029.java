package com.stormma.xdoj;
import java.math.BigInteger;
import java.util.Scanner;
public class Main1029
{
	public Main1029()
	{
		Scanner scan = new Scanner (System.in);
		BigInteger big = new BigInteger("2");
		int t = scan.nextInt();
		while ((t--) > 0)
		{
			int n = scan.nextInt();
			BigInteger bigint = big.pow(n);
			String str = bigint.toString();
			System.out.println(str.charAt(0)+" "+str.charAt(str.length()-1));
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main1029();
	}
}
