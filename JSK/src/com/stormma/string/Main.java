package com.stormma.string;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main
{

	/**
	 * @param args
	 */
	private Scanner scan;
	public Main()
	{
		scan = new Scanner(new BufferedInputStream(System.in));
		while (scan.hasNext())
		{
			int n = scan.nextInt();
			String [][] str = {
		            {"","I","II","III","IV","V","VI","VII","VIII","IX"},
		            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
		            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
		            {"","M","MM","MMM"}};
			StringBuffer string = new StringBuffer();
			string.append(str[3][n / 1000 % 10]);
			string.append(str[2][n / 100 % 10]);
			string.append(str[1][n / 10 % 10]);
			string.append(str[0][n % 10]);
			System.out.println(string);
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main();
	}

}
