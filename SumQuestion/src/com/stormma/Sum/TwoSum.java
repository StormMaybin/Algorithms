/**
 *@author StormMaybin
 *@Date 2016-05-25
 */
/**
 * 这个类是暴力算法求一个有序数组和为零的对数
 * 算法复杂度是平方级
 */
package com.stormma.Sum;
import java.util.Scanner;
public class TwoSum
{
	public static void main(String[] arguments)
	{
		int count = 0;
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int [] a = new int [N];
		for (int i = 0; i < N; i++)
		{
			a[i] = scan.nextInt();
		}
		for (int i = 0; i < N; i++)
		{
			for (int j = i + 1; j < N; j++)
			{
				if (a[i] + a[j] == 0)
				{
					count++;
				}
			}
		}
		System.out.println(count);
		scan.close();
	}

}
