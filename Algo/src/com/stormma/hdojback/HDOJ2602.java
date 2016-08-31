package com.stormma.hdojback;
import java.util.Arrays;
import java.util.Scanner;
/**
 * ״̬ת������
 * dp[i][v] = max {dp[i-1][v],dp[i-1][v-v[i]]+w[i]};
 * @author StormMaybin
 *
 */
public class HDOJ2602
{
	class Node 
	{
		int value;//��ֵ
		int volume;//���
		public Node (int value, int volume)
		{
			this.volume = volume;
			this.value = value;
		}
	}
	
	Scanner scan = new Scanner (System.in);
	int N, V;
	int T;
	int [][] dp = new int [1001][1001];
	Node [] arr = new Node [1001];
	
	
	public static void main(String[] args)
	{
		new HDOJ2602().work();
	}
	
	
	public void work ()
	{
		T = scan.nextInt();
		while ((T--) > 0)
		{
			init();
			System.out.println(zeroOneBack());
			for(int i = 0; i <= N; i++)
			{
				for (int j = 0; j <= V; j++)
					System.out.print(dp[i][j]+" ");
				System.out.println();
			}
		}
	}
	//��ʼ������
	public void init ()
	{
		N = scan.nextInt();
		V = scan.nextInt();
		int [] f = new int [N+1];
		int [] s = new int [N+1];
		for (int i = 1; i <= N; i++)
			f[i] = scan.nextInt();//��ֵ
		for (int i = 1; i <= N; i++)
			s[i] = scan.nextInt();//���
		//�ӵ�����һ�����캯��˳��д����waһ�Σ�ԩ��
		for (int i = 1; i <= N; i++)
			arr[i] = new Node (f[i],s[i]);
		for (int i = 0; i <= 1000; i++)
			Arrays.fill(dp[i], 0);
	}
	//��������	
	public long zeroOneBack ()
	{
		//��Ϊ����ÿһ����ͷֻ�����ֽ����Ҫôװ��Ҫô��װ
		for (int i = 1; i <= N; i++)
			for (int j = 0; j <= V; j++)
			{
				if ( j >= arr[i].volume)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i].volume]+arr[i].value);
				else
					dp[i][j] = dp[i-1][j];
			}
//		return dp[N][V];
		return getMax(dp);
	}
	public int getMax (int [][] dp)
	{
		int max = 0;
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= V; j++)
				if (max <= dp[i][j])
					max = dp[i][j];
		return max;
	}
}
