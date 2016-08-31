package com.stormma.xdoj;
import java.util.Scanner;
/**
 * S=nx²/[4tan(π/n)]
 * 面积公式   套公式的题   
 */
import java.math.*;
public class Main1021
{
	Scanner scan = new Scanner (System.in);
	public Main1021()
	{
		int t = scan.nextInt();
		while ((t--) > 0)
		{
			int n = scan.nextInt();
			double s = scan.nextDouble();
//			double area = 0.5 * Math.sin(2*Math.PI / n) * n * s * s;
			double ss = n * s * s / (4 * Math.tan(Math.PI / n));
//			System.out.printf("%.4f",area);
			System.out.printf("%.4f",ss);
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main1021();
	}

}
