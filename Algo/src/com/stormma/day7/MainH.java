package com.stormma.day7;
import java.util.Scanner;
import java.util.Vector;
public class MainH
{
	Scanner scan = new Scanner(System.in);
	Vector<Integer> [] vector = new Vector [6050];
	int a, b, n;
	int [] hap;
	int [] f;
	int [][] dp;
	public MainH()
	{
		while (scan.hasNext())
		{
			work();
		}
	}
	public void work ()
	{
		n = scan.nextInt();
		hap = new int [n+2];
		f = new int [n+2];
		dp = new int [n+2][2];
		for (int i = 1; i <= n; i++)
		{
			vector[i] = new Vector<Integer>();
		}
		for (int i = 1; i <= n; i++)
		{
			hap[i] = scan.nextInt();
			vector[i].clear();
			f[i] = -1;//�������
			dp[i][0] = 0;//��ʼ��
			dp[i][1] = 0;
		}
		while (scan.hasNext())
		{
			a = scan.nextInt();
			b = scan.nextInt();//b ��a ���ϼ�������̫�ӵ����������˵�˼ά��һ����Ϊʲô����a��b���ϼ���
			if (a == 0 && b == 0)
				break;
			f[a] = b;
			vector[b].add(a);//����b�ľ�����һ����a
		}
		a = 1;
		while (f[a] != -1)//��˼�����Ҳ�������˵��ϼ�����ô����˱�Ȼ�Ǿ��Ե��ϼ������Ե�ǿ�߹�����
			a = f[a];//���������
//		System.out.println(a);
//		System.out.println("___________________");
//		for (int i = 1; i < n+2; i++)
//			System.out.print(f[i]+" ");
//		System.out.println();
		dfs (a);//��ʵ�Ǵӵײ㿪ʼ�����ģ�����֪��dfs�ǵݹ���õģ���ô�������ڿ�ʼ��root��㿪ʼ��
		System.out.println(Math.max(dp[a][1], dp[a][0]));
	}
	public void dfs (int root)
	{
		int len = vector[root].size();//��ʾ���ڵ��м�������
//		System.out.println(len);
	    dp[root][1] = hap[root];//��������ȥ�ˣ���ô���õ��Ļ���ֵ����hap[i]
	    for(int i = 0; i < len; i++)//������ڵ��len�����Ӷ�ȥ������ ��Ϊ�����ϼ�ȥ��
	       dfs(vector[root].get(i));
	    for(int i = 0; i < len; i++)
	    {
	        dp[root][0] += Math.max(dp[vector[root].get(i)][1],dp[vector[root].get(i)][0]);
	        dp[root][1] += dp[vector[root].get(i)][0];
	    }
	}
	public static void main(String[] args)
	{
		new MainH();
	}

}
