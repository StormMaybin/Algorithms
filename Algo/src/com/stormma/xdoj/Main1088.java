package com.stormma.xdoj;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class Main1088
{
	Scanner scan = new Scanner(System.in);
	ArrayList<String> list = new ArrayList<String>();
	int t;

	public Main1088()
	{
		while (scan.hasNext())
		{
			list.clear();
			t = scan.nextInt();
			for (int i = 0; i < t; i++)
			{
				list.add(scan.next());
			}
			Collections.sort(list, new Comparator<String>()
			{

				@Override
				public int compare(String o1, String o2)
				{
					// TODO Auto-generated method stub
					String str1 = o1 + o2;
					String str2 = o2 + o1;
					return -(str1.compareTo(str2));
				}
			});
			for (int i = 0; i < t; i++)
			{
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main1088();
	}
}
