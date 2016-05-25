/**
 *@author StormMaybin
 *@Date 2016-05-25
 */
package com.stormma.Sum;
import java.util.Scanner;
import java.util.Arrays;
/**
 *这个类是对暴力算法的一个优化，原理就是先排序，
 *然后进行二分查找
 */
public class TwoSumFast
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
		//先进行排序，这个是归并排序，算法复杂度是N线性
		Arrays.sort(a);
		for (int i = 0; i < N; i++)
		{
			if (BinarySearch.binarySearch(-a[i], a) > i)
			{
				count++;
			}
		}
		System.out.println(count);
		scan.close();
	}

}
