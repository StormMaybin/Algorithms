package com.stormma.day5;
import java.util.Scanner;
public class MainB2
{
	Scanner scan = new Scanner (System.in);
	public static void main(String[] args)
	{
		new MainB2().work();
	}
	public void work ()
	{
		while (scan.hasNext())
		{
			int n = scan.nextInt();
			if (n == 0)
				System.exit(0);
			int [] arr = new int [n];
			for (int i = 0; i < n; i++)
				arr[i] = scan.nextInt();
			int left = arr[0], right = arr[0], ans = arr[0], MAX = arr[0];
			int flag = 0;//�@�Y��MAX����K�Ĵ𰸣���ans�Ǯ�ǰ��
			if (isOk (arr, n) == false)  
			{
				System.out.println("0"+" "+arr[0]+" "+arr[n-1]);
				continue;
			}
			ans = arr[0];
			for (int i = 1; i < n; i++)
			{
				if (ans < 0)//�����һ������С�0������϶�������ý��ˣ�����G���@��ֵ
				{
					ans = arr[i];
					flag = arr[i];//�@��flag��ӛ�left��ֵ������һ���������left
				}
				else//����˕r��ans߀�Ǵ�춵��0�ģ������@�������п��ܷQ����ý�
					ans += arr[i];
				if (ans > MAX)
				{
					MAX = ans;
					right = arr[i];
					left = flag;//�}�д����һ�����ĕr��Ÿ����@��leftֵ
				}
			}
			if (MAX < 0)
				System.out.println("0"+" "+arr[0]+" "+arr[n-1]);
			else
				System.out.println(MAX + " " + left + " " + right);
		}
	}
	public boolean isOk (int [] arr, int n)//С����
	{
		for (int i = 0; i < n; i++)
			if (arr[i] >= 0)
				return true;
		return false;
	}
}
