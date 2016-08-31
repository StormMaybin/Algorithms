package com.stormma.day9;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
/***
 * ���������:����ջ
 * @author StormMaybin
 *
 */
public class MainJ
{
	int n;
	Scanner scan = null;
	int [] height;
	long MAX_AREA;
	long sum;
	LinkedList<Integer> list = null;
	int temp = 0;
	public MainJ()
	{
		scan = new Scanner (System.in);
		list = new LinkedList<Integer>();
		while (scan.hasNext())
		{
			n = scan.nextInt();
			if (n == 0)
				System.exit(0);
			height = new int [n+10];
			Arrays.fill(height, 0);
			for (int i = 0; i < n; i++)
				height[i] = scan.nextInt();
			MAX_AREA = Long.MIN_VALUE;
			sum = 0;
			for (int i = 0; i <= n; i++)//���һ����Ϊ0�ľ���
			{
				if (list.isEmpty() || (height[list.peekLast()] <= height[i]))//�����ʱ��ջΪ�գ������ǿ����Ԫ��
					{list.addLast(i);
//					System.out.println(i);
					}
				
				else if (height[list.peekLast()] > height[i])//�����ʱ���������
				{
					while ((!list.isEmpty() && height[list.peekLast()] > height[i]))
					{
						sum = (i - list.peekLast()) * height[list.peekLast()];
						if (sum > MAX_AREA)
							MAX_AREA =  sum;
						temp = list.peekLast();
//						System.out.println("_temp"+temp);
						//�Ƴ�Ԫ��
//						System.out.println(list);
						list.pollLast();
					}
					list.addLast(i);
				}
			}
			System.out.println(MAX_AREA);
		}
		
	}
	public static void main(String[] args)
	{
		new MainJ();
	}   

}
