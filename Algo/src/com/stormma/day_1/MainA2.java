package com.stormma.day_1;
import java.util.Arrays;
import java.util.Scanner;
public class MainA2
{
	Scanner scan = new Scanner (System.in);
	public MainA2()
	{
		while (scan.hasNext())
		{
			long [] mp = new long [3];
			for (int i = 0; i < 3; i++)
				mp[i] = scan.nextLong();
			Arrays.sort(mp);
			//���ڿ�ʼmp[0]�����ٵģ�mp[2]������
			if ((mp[0] + mp[1]) * 2 <= mp[2])
				System.out.println(mp[0]+mp[1]);
			else
				System.out.println((mp[0]+mp[1]+mp[2]) / 3);
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainA2();
	}

}
