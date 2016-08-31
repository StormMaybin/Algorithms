package com.stormma.day9;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;
public class MainB2
{
	Scanner scan = new Scanner (System.in);
	private static Reader reader = new InputStreamReader(System.in);
	private static Writer writer = new OutputStreamWriter(System.out);
	private 
	int [] f;
	int n, m;
	int [] x;
	int [] y;
	int ans [];
	int count;
	public MainB2 () throws IOException
	{
		while ((n = reader.read()) != 0 && (m = reader.read()) != 0)
		{
			System.out.println(n+" "+m);
			init();
			input();
			for (int i = 0; i < m; i++)
				System.out.println(x[i]);
			solve ();
		}
	}
	public void input() throws IOException
	{
		for (int i = 0; i < m; i++)
		{
			x[i] = reader.read();
			reader.read();
			y[i] = reader.read();
			reader.read();
		}
	}
	public void init ()
	{
		f = new int [n];
		x = new int [m];
		y = new int [m];
		ans = new int[m];
		for (int i = 0; i < n; i++)
			f[i] = i;
	}
	public void solve () throws IOException
	{
		count = n;
		for (int i = m - 1; i >= 0; i--)
		{
			ans[i] = count;
			int xx = getFatcher(x[i]);
			int yy = getFatcher(y[i]);
			if (xx != yy)
			{
				f[xx] = yy;
				count--;
			}
		}	
//		for (int i = 0; i < m; i++)
//		{
//			if (i != m-1)
//			{
//				writer.write(ans[i]);
//				writer.write("\r\n");
//				writer.flush();
//			}
//		}
//		for (int i = 0; i < m; i++)
//			System.out.println(ans[i]);
	}
	public int getFatcher (int x)
	{
		return x == f[x] ? x : (f[x] = getFatcher(f[x]));
	}
	public static void main(String[] args)
	{
		try
		{
			new MainB2();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
