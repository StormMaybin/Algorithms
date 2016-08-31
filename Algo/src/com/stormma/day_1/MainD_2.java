package com.stormma.day_1;

import java.util.Arrays;
import java.util.Scanner;

public class MainD_2
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		long a, b;
		Scanner scan = new Scanner (System.in);
		long [] flag = new long [26];
		
		for (int i = 0; i < 26; i++)
			flag[i] = 0;
		while (scan.hasNext())
		{
			a = scan.nextLong();
			b = scan.nextLong();
			String str = scan.next();
			StringBuffer stringBuffer = new StringBuffer (str);
			for (int i = 0; i < str.length(); i++)
			{
				flag[stringBuffer.charAt(i)-'A']++;
			}
			Arrays.sort(flag);
			long ans = 0;
			for ( int i = 25; i >= 0; i-- )
			{
				if ( b > flag [ i ] )
				{
					ans += flag [ i ] * flag [ i ];
					b -= flag [ i ];
				}
				else
				{
					ans += b * b;
					break;
				}
			}
			System.out.println(ans);
		}
	}

}
