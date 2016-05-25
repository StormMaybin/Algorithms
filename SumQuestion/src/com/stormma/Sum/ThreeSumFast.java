/**
 *@author StormMaybin
 *@Date 2016-05-25
 */
package com.stormma.Sum;
import java.util.Scanner;
import java.util.Arrays;
/**
 * 这个类是优化的算法，先开始对数组进行排序
 * 然后双重循环进行二分查找，这个算法的复杂度
 * 是NlgN
 */
public class ThreeSumFast
{

	public static void main(String[] args)
	{
		int count = 0;
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int [] a = new int [N];
		for (int i = 0; i < N; i++)
		{
			a[i] = scan.nextInt();
		}
		Arrays.sort(a);
		
		for (int i = 0; i < N; i++)
		{
			for (int j = i + 1; j < N; j++)
			{
				if (BinarySearch.binarySearch(-a[i] - a[j], a) > j)
				{
					count++;
				}
			}
		}
		System.out.println(count);
		scan.close();
	}
}
