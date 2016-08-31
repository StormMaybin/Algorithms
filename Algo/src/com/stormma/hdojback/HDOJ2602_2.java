package com.stormma.hdojback;
import java.util.Arrays;
import java.util.Scanner;
/**
 * ״̬ת������
 * dp[i][v] = max {dp[i-1][v],dp[i-1][v-v[i]]+w[i]};
 * ѹ����һά����dp[j] =  max{dp[j],dp[j-w[i]]+v[i]};
 * @author StormMaybin
 */
public class HDOJ2602_2
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
	int []dp = new int [1001];
	Node [] arr = new Node [1001];
	
	
	public static void main(String[] args)
	{
		new HDOJ2602_2().work();
	}
	
	
	public void work ()
	{
		T = scan.nextInt();
		while ((T--) > 0)
		{
			init();
			System.out.println(zeroOneBack());
			
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
			Arrays.fill(dp, 0);
	}
	//��������	
	public long zeroOneBack ()
	{
		//��Ϊ����ÿһ����ͷֻ�����ֽ����Ҫôװ��Ҫô��װ
		for (int i = 1; i <= N; i++)
		{
			for (int j = V; j >= arr[i].volume; j--)
			{
				dp[j] = Math.max(dp[j], dp[j-arr[i].volume]+arr[i].value);
//				System.out.println(dp[j]);
			}
//			System.out.println();
		}
		return getMax(dp);
	}
	public int getMax (int [] dp)
	{
		int Max = 0;
		for (int i = 1; i <= V+1; i++)
				if (Max <= dp[i])
					Max = dp[i];
		return Max;
	}
}
