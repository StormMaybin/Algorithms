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
			if (A.length() > B.length())//������
				System.out.println("Poor LoveZx");
			else if (A.length() < B.length())
				System.out.println(0);
			else if (bigb.compareTo(biga) > 0)//����ʹ�
				System.out.println(0);
			else//ʣ�µľ���size��ȣ�
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
