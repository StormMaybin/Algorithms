package com.stormma.forever;
import java.util.Scanner;
public class MainH
{
	Scanner scan = new Scanner (System.in);
	int T, n, k;
	String [] str;
	int [][] arr;
	public MainH()
	{
		T = scan.nextInt();
		while ((T--) > 0)
		{
			n = scan.nextInt();
			k = scan.nextInt();
			str = new String [21];
			arr = new int [21][21];
			for (int i = 0; i < n; i++)
				str[i] = scan.next();
			
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainH();
	}

}
