/**
 *@author StormMaybin
 *@Date 2016-05-25
 */
package com.stormma.Sum;
import java.util.Scanner;
/**
 * 这个类是三数和的暴力模拟算法
 * 算法的复杂度是立方级
 */
public class ThreeSum
{
	public static void main (String [] arguments)
	{
		int count = 0;
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int [] a = new int [N];
		for (int i = 0;i < N; i++)
		{
			a[i] = scan.nextInt();
		}
		for (int i = 0; i < N; i++)
		{
			for (int j = i + 1; j < N; j++)
			{
				for (int k = j + 1; k < N; k++)
				{
					if (a[i] + a[j] + a[k] == 0)
					{
						count++;
					}
				}
			}
		}
		System.out.println(count);
		scan.close();
	}
}