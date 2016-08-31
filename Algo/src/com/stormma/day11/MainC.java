package com.stormma.day11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

import com.stormma.day11.MainB;

public class MainC
{
	IOTest scan = new IOTest();
	public final static int maxn = 100005;
	int[][]digit;
	int[][][] block;// �ֳ��İٿ�
	int X, Y, L, R, D, P;
	int time;
	int n, m;

	public MainC()
	{
		try
		{
			input();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void input () throws IOException
	{
		int x;
		scan.init();
		time = scan.nextInt();
		while ((time --) > 0)
		{
			n = scan.nextInt();
			m = scan.nextInt();
			block =  new int [400][10][10];
			digit = new int [maxn][10];
			for(int i=1;i<=n;i++)
			{
				x = scan.nextInt();
		        int b = (i >> 8); 
		        for (int j = 1; j <= 10; j++)
		        {
		        	digit[i][j] = x % 10;
		        	block [b][j][x % 10] ++;//ͳ��һ���ֿ��ڵ�ÿλ���ֵĸ���
		        	x /= 10;
		        }
		    }
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainC();
	}

}
/**
 * ���������
 * 
 * @author StormMaybin
 * 
 */
/*
 * class IOTest { public static final boolean DEBUG = false;
 * 
 * 	public StreamTokenizer tokenizer; // ��� public BufferedReader cin; public
 * PrintWriter cout;
 * 
 * public void init() { try { if (DEBUG) cin = new BufferedReader(new
 * InputStreamReader( new FileInputStream("in.txt"))); else cin = new
 * BufferedReader(new InputStreamReader(System.in)); cout = new PrintWriter(new
 * OutputStreamWriter(System.out)); tokenizer = new StreamTokenizer(cin); }
 * catch (Exception e) { e.printStackTrace(); } }
 * 
 * public String next() throws IOException {
 * 
 * tokenizer.nextToken(); if (tokenizer.ttype == StreamTokenizer.TT_EOF) return
 * null; else if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) { return
 * String.valueOf((int) tokenizer.nval); } else if (tokenizer.ttype ==
 * StreamTokenizer.TT_WORD) { return tokenizer.sval; } else return null; }
 * public int nextInt() throws IOException { tokenizer.nextToken(); if
 * (tokenizer.ttype == StreamTokenizer.TT_NUMBER) { return (int) tokenizer.nval;
 * } else return Integer.MAX_VALUE; } }
 */
