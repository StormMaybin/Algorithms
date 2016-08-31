package com.stormma.xdoj;
import java.util.Scanner;
import java.math.*;
/**
 * TLE下次再看
 * @author StormMaybin
 *
 */
public class Main1066
{
	Scanner scan = new Scanner (System.in);
	int time;
	public Main1066()
	{
		time = scan.nextInt();
		while ((time--) > 0)
		{
			String str = scan.next();
			BigDecimal bi = new BigDecimal(str);
			int n = scan.nextInt();
			int B0 = scan.nextInt();
			for (int i = 0; i < n; i++)
			{
				bi = bi.pow(B0);
				B0 = B0^2 - 1;
			}
			BigInteger big = bi.toBigInteger();
			big.mod(new BigInteger("1000000007"));
			System.out.println(big.toString());
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main1066();
	}
}
