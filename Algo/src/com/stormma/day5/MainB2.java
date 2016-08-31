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
			int flag = 0;//這裏的MAX是最終的答案，而ans是當前的
			if (isOk (arr, n) == false)  
			{
				System.out.println("0"+" "+arr[0]+" "+arr[n-1]);
				continue;
			}
			ans = arr[0];
			for (int i = 1; i < n; i++)
			{
				if (ans < 0)//如果上一個序列小於0，那麽肯定不是最好解了，那麽丟棄這個值
				{
					ans = arr[i];
					flag = arr[i];//這個flag是記錄left的值，但不一定是最後的left
				}
				else//如果此時的ans還是大於等於0的，那麽這個序列有可能稱爲最好解
					ans += arr[i];
				if (ans > MAX)
				{
					MAX = ans;
					right = arr[i];
					left = flag;//衹有大於上一個最大的時候才更新這個left值
				}
			}
			if (MAX < 0)
				System.out.println("0"+" "+arr[0]+" "+arr[n-1]);
			else
				System.out.println(MAX + " " + left + " " + right);
		}
	}
	public boolean isOk (int [] arr, int n)//小優化
	{
		for (int i = 0; i < n; i++)
			if (arr[i] >= 0)
				return true;
		return false;
	}
}
