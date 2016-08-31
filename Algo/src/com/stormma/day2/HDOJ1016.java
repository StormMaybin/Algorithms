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
			//�������
			//0-41
			//�������,��ʼ��Ϊ0
			int [] visit = new int [21];
			int [] a = new int [21];
			System.out.println("Case"+" "+count+":");
			a[0] = 1;
			dfs(visit,a,1,n);
			//�������
			System.out.println();
		}
	}
	public static void dfs (int [] visit, int [] a, int num, int n)
	{
		//�����������
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
		           if(visit[i] == 0)//�Ƿ��ù���
		           {
		               if(prime[i+a[num-1]] == 1) //�Ƿ�����ڵļ�����������
		               {
		                   visit[i] = -1;//�����
		                   a[num++] = i;//�Ž�����
		                   dfs(visit,a,num,n); //�ݹ����
		                   visit[i]=0; //��ȥ���
		                   num--;
		               }
		           }
		       }
		   }
		}
}
