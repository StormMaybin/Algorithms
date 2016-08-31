package com.stormma.day5;
import java.util.Scanner;

public class MainH 
{
    int l;
    int[] a;//‘≠–Ú¡–
    int[] left;
    int[] right;
    int max = 0;
    int temp;
    public MainH()
    {
    	Scanner scan = new Scanner (System.in);
    	while (scan.hasNext())
    	{
    		l = scan.nextInt();
    		a = new int [l];
    		left = new int[l];
    		right = new int[l];
    		for (int i = 0; i < l; i++)
    			a[i] = scan.nextInt();
    		search();
    		System.out.println(max);
    	}
    }

    public void search()
    {
        temp = a[0];
        left[0] = temp;
        for (int i = 1; i < l; i++)
        {
            if (temp < 0)
            {
                temp = 0;
            }
            temp += a[i];
            if (temp > left[i - 1])
            {
                left[i] = temp;
            } 
            else 
            {
                left[i] = left[i - 1];
            }
        }
        temp = a[l - 1];
        right[0] = temp;
        for (int i = l - 2, k = 1; i >= 0; i--, k++)
        {
            if (temp < 0) 
            {
                temp = 0;
            }
            temp += a[i];
            if (temp > right[k - 1])
            {
                right[k] = temp;
            } 
            else
            {
                right[k] = right[k - 1];
            }
        }
        max = left[0] + right[l - 2];
        for (int i = 0; i < l - 1; i++)
        {
            if (left[i] + right[l - i - 2] > max)
            {
                max = left[i] + right[l - i - 2];
            }
        }
    }

    public int getLength(int m, int n) 
    {
        max = Integer.MIN_VALUE;
        temp = 0;
        for (int i = m; i < n; i++) 
        {
            temp += a[i];
            if (temp > max)
            {
                max = temp;
            }
            if (temp < 0) 
            {
                temp = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) 
    {
        new MainH();
    } 
}