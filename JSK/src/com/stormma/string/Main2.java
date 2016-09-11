package com.stormma.string;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main2
{
	private Scanner scan = null;

	/**
	 * @param args
	 */
	public Main2()
	{
		scan = new Scanner(new BufferedInputStream(System.in));
		while (scan.hasNext())
		{
			String str = scan.nextLine();
			if (str.isEmpty())
				System.out.println(0);
			else
			{
				String [] string = str.split(" ");
				System.out.println(string[string.length-1].length());
			}
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main2();
	}

}
