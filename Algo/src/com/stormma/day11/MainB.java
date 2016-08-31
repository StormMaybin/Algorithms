package com.stormma.day11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
public class MainB
{
	IOTest scan = new IOTest();
	int n;
	int m;
	int[] k;
	int[] t = new int[400005];
	int[] s = new int[400005];
	public final static int block = 450;
	public MainB()
	{
		try
		{
			input();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void input() throws Exception
	{
		scan.init();
		n = scan.nextInt();//n��װ��
		k = new int[n + 10];
		for (int i = 0; i < n; i++)
			k[i] = scan.nextInt();//�洢ki����i��װ�õľ���ϵ��
		work();
		m = scan.nextInt();
		while ((m--) > 0)
		{
			int x, y;
			x = scan.nextInt();
			y = scan.nextInt();
			if (x == 1)
				System.out.println(cal(y));
			else
			{
				k[y] = scan.nextInt();
				update(y);
			}
		}
		for (int i = 0; i < n; i++)
			System.out.print(t[i]+" ");
		System.out.println();
		for (int i = 0; i < n; i++)
			System.out.print(s[i]+" ");
	}//
	public void work()
	{
		for (int i = 0; i < n; i++)
		{
			int R = (i / block + 1) * block;// ����һ���е�����λ�õ���һ��
			R = Math.min(R, n);//�Ƚ�װ����n�ͷֿ�������Ĵ�С
			int now = i;
			int step = 0;
			while (now < R)
			{
				now += k[now];//����������Ǹ�װ��
				step++;//��������
			}
			t[i] = now;//�����Ă��b��
			s[i] = step;//�����Ĳ���
		}
	}
	public int cal(int x)
	{
		int ans = 0;
		while (x < n)
		{
			ans += s[x];
			x = t[x];
		}
		return ans;
	}
	public void update(int x)
	{
		int now = x;
		int R = (x / block + 1) * block;//�ҵ�Ҫ�޸ĵ��Ǹ�װ�����ڵ��Ǹ�������һ��λ�õ���һ��λ��
		R = Math.min(R, n);//ʼ��ȡn��R�е���С���Ǹ�
		for (int i = now; i >= 0; i--)
		{
			int nex;
			nex = i + k[i];
			if (nex >= R)
			{
				t[i] = nex;
				s[i] = 1;
			} 
			else
			{
				t[i] = t[nex];
				s[i] = s[nex] + 1;
			}
			if (i % block == 0)//�޸�һ�������ڵ�
				break;
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainB();
	}
}

/**
 * @author StormMaybin
 */
class IOTest
{
	public static final boolean DEBUG = false;

	public StreamTokenizer tokenizer; // ���
	public BufferedReader cin;
	public PrintWriter cout;

	public void init()
	{
		try
		{
			if (DEBUG)
				cin = new BufferedReader(new InputStreamReader(
						new FileInputStream("in.txt")));
			else
				cin = new BufferedReader(new InputStreamReader(System.in));
			cout = new PrintWriter(new OutputStreamWriter(System.out));
			tokenizer = new StreamTokenizer(cin);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String next() throws IOException
	{

		tokenizer.nextToken();
		if (tokenizer.ttype == StreamTokenizer.TT_EOF)
			return null;
		else if (tokenizer.ttype == StreamTokenizer.TT_NUMBER)
		{
			return String.valueOf((int) tokenizer.nval);
		} 
		else if (tokenizer.ttype == StreamTokenizer.TT_WORD)
		{
			return tokenizer.sval;
		} 
		else
			return null;
	}
	public int nextInt() throws IOException
	{
		tokenizer.nextToken();
		if (tokenizer.ttype == StreamTokenizer.TT_NUMBER)
		{
			return (int) tokenizer.nval;
		} 
		else
			return Integer.MAX_VALUE;
	}
}
