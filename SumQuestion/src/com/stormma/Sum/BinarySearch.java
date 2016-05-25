/**
 *@author StormMaybin
 *@Date 2016-05-25
 */
package com.stormma.Sum;

public class BinarySearch
{
	public static int binarySearch(int key, int [] a)
	{
		int start = 0;
		int end = a.length - 1;
		int middle;
		while (start <= end)
		{
			middle = (start + end) / 2;
			if (a[middle] > key)
			{
				end = middle - 1;
			}
			else if (a[middle] < key)
			{
				start = middle + 1;
			}
			else
			{
				return middle;
			}
		}
		return -1;
	}
}
