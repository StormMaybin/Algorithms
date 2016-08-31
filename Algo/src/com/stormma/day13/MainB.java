package com.stormma.day13;
import java.util.Scanner;
public class MainB
{
	long k;
	String str = null;
	public final static int mod = 1000000007;
	Scanner scan = new Scanner(System.in);
	public MainB()
	{
		while (scan.hasNext())
		{
			str = scan.next();
			k = scan.nextLong();
			long tmp = 0;
			for (int i = 0; i < str.length(); i++)
			{
				if (str.charAt(i) == '0' || str.charAt(i) == '5')
				{
					tmp = ((tmp + myPow(2, i)) % mod);
				}
			}
			System.out.println(tmp * solve(str.length(), k) % mod);
		}
	}
	public long myPow (long n, long m)
	{
		long ans = 1;
		while (m > 0)
		{
			if ((m & 1) != 0)
				ans = (ans * n) % mod;
			n = (n * n) % mod;
			m >>= 1;
		}
		return ans;
	}
	public long solve (long len, long k)
	{
		long b = myPow(2, len);
		long a = myPow(b, k);
		a = (1 - a + mod) % mod;
		b = (1 - b + mod) % mod;
		return a * myPow(b, mod-2) % mod;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainB();
	}

}
