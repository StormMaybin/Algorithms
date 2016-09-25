package com.stormma.cf;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main
{

	/**
	 * @param args
	 */
	private Scanner scan;
	public Main ()
	{
		scan = new Scanner(new BufferedInputStream(System.in));
		while (scan.hasNext())
		{
			String string = new String(scan.next());
			String str = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			int i;
			boolean flag = false;
			for (i = 0; i <= string.length()-26; i++)
			{
				String sb = string.substring(i, i+26);
				flag = true;
				for (int j = 0; j < 26; j++)
				{
					if (sb.charAt(j) != '?')
					{
						if (sb.indexOf(sb.charAt(j)) != sb.lastIndexOf(sb.charAt(j)))
						{
							flag = false;
							break;
						}
					}
				}
				if (flag == true)
				{
					String s = "";
					for (int t = 0; t < 26; t++)
					{
						if (sb.indexOf(str.charAt(t)) == -1)
							s += str.charAt(t)+"";
					}
					int num = s.length()-1;
					for (int t = 0; t < 26; t++)
					{
						if (sb.charAt(t) != '?')
							System.out.print(sb.charAt(t));
						else
							System.out.print(s.charAt(num--));
					}
					System.out.println();
					break;
				}
			}
			if (flag == false)
				System.out.println(-1);
		}
	}
	public static void main(String[] args)
	{
		new Main ();
	}
}
