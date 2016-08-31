/***
 * 
 */
package com.stormma.day2;
import java.util.Scanner;
public class HDOJ1016
{

	/**
	 * @param args
	 */
	public static int [] prime = {0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0};
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		int count = 0;
		while (scan.hasNext())
		{
			count ++;
			int n = scan.nextInt();
			//素数打表
			//0-41
			//标记数组,初始化为0
			int [] visit = new int [21];
			int [] a = new int [21];
			System.out.println("Case"+" "+count+":");
			a[0] = 1;
			dfs(visit,a,1,n);
			//打个空行
			System.out.println();
		}
	}
	public static void dfs (int [] visit, int [] a, int num, int n)
	{
		//满足条件输出
		if (num == n && prime [a[num-1]+a[0]] == 1)
		{
			for (int j = 0; j < num-1; j++)
			{
				System.out.print(a[j]+" ");
			}
			System.out.println(a[num-1]);
		}
		else
		{
			for(int i=2;i<=n;i++)
		       {
		           if(visit[i] == 0)//是否用过了
		           {
		               if(prime[i+a[num-1]] == 1) //是否和相邻的加起来是素数
		               {
		                   visit[i] = -1;//标记了
		                   a[num++] = i;//放进数组
		                   dfs(visit,a,num,n); //递归调用
		                   visit[i]=0; //退去标记
		                   num--;
		               }
		           }
		       }
		   }
		}
}
