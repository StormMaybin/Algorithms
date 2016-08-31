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
			//现在开始mp[0]是最少的，mp[2]是最大的
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
