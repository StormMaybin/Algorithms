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
			f[i] = -1;//树根标记
			dp[i][0] = 0;//初始化
			dp[i][1] = 0;
		}
		while (scan.hasNext())
		{
			a = scan.nextInt();
			b = scan.nextInt();//b 是a 的上级，数据太坑爹，和正常人的思维不一样，为什么不是a是b的上级？
			if (a == 0 && b == 0)
				break;
			f[a] = b;
			vector[b].add(a);//代表b的绝对下一级是a
		}
		a = 1;
		while (f[a] != -1)//意思就是找不到这个人的上级，那么这个人必然是绝对的上级，绝对的强者哈哈哈
			a = f[a];//找树根结点
//		System.out.println(a);
//		System.out.println("___________________");
//		for (int i = 1; i < n+2; i++)
//			System.out.print(f[i]+" ");
//		System.out.println();
		dfs (a);//其实是从底层开始搜索的，我们知道dfs是递归调用的，那么我们现在开始从root结点开始找
		System.out.println(Math.max(dp[a][1], dp[a][0]));
	}
	public void dfs (int root)
	{
		int len = vector[root].size();//表示根节点有几个儿子
//		System.out.println(len);
	    dp[root][1] = hap[root];//如果这个人去了，那么他得到的欢乐值就是hap[i]
	    for(int i = 0; i < len; i++)//这个根节点的len个儿子都去不了了 因为他的上级去了
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
