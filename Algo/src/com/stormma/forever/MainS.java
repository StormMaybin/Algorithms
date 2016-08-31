package com.stormma.forever;
import java.util.Scanner;
public class MainS
{
	Scanner scan = new Scanner(System.in);
	public MainS()
	{
		while (scan.hasNext())
		{
			StringBuilder sb = new StringBuilder();
			String [] ss = new String [10001];
			int n = scan.nextInt();
			for (int i = 0; i < n; i++)
			{
				String str = scan.next();
				ss[i] = str;
				sb.append(str);
			}
			System.out.println(sb);
//			for (int i = 0; i < n; i++)
//			{
//				int first = sb.indexOf(ss[i]);
//				int last = sb.lastIndexOf(ss[i]);
//				if (first == last)
//				{
//					System.out.println(ss[i]+" 1");
//				}
//			}
			int len = sb.length();
			while ((len--) > 0)
			{
				int first = sb.indexOf(ss[0]);
				int last = sb.lastIndexOf(ss[0]);
				if (first == last)
				{
					System.out.println(ss[0]);
					break;
				}
				sb.deleteCharAt(first);
				sb.deleteCharAt(last);
			}
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainS();
	}

}
