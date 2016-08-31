package com.stormma.day9;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class MainB
{
	Scanner scan = new Scanner(System.in);
	private static Reader reader = new InputStreamReader(System.in);
	private static Writer writer = new OutputStreamWriter(System.out);
	int[] f;
	int n, m;
	int[] x;
	int[] y;
	int ans[];
	int count;

	public MainB() throws IOException
	{
		while ((n = getInt()) != 0 && (m = getInt()) != 0)
		{
			init();
			input();
			solve();
		}
	}

	public void input() throws IOException
	{
		for (int i = 0; i < m; i++)
		{
			x[i] = getInt();
			y[i] = getInt();
		}
	}

	public void init()
	{
		f = new int[n];
		x = new int[m];
		y = new int[m];					
		ans = new int[m];
		for (int i = 0; i < n; i++)
			f[i] = i;
	}

	public void solve() throws IOException
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
		for (int i = 0; i < m; i++)
		{
			int temp = ans[i];
			writer.write("" + temp);
			writer.write("\r\n");
		}
		writer.flush();
	}

	public int getFatcher(int x)
	{
		return x == f[x] ? x : (f[x] = getFatcher(f[x]));
	}

	public static void main(String[] args)
	{
		try
		{
			new MainB();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static int getInt()
	{
		int read;
		int res = 0;
		boolean isNegative = false;
		try
		{
			while ((read = reader.read()) != -1)
			{
				if ((char) read == '-')
				{
					res = 0;
					isNegative = true;
					break;
				} 
				else if (isNumber((char) read))
				{
					res = read - '0';
					break;
				}
			}
			while ((read = reader.read()) != -1)
			{
				char ch = (char) read;
				if (isNumber(ch))
				{
					res = res * 10 + (read - '0');
				} 
				else
				{
					break;
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if (isNegative == true)
		{
			res = -1 * res;
		}
		return res;
	}

	public static boolean isBlank(char ch)
	{
		if (ch == '\r' || ch == '\n' || ch == ' ')
		{
			return true;
		}
		return false;
	}

	public static boolean isNumber(char ch)
	{
		if (ch <= '9' && ch >= '0')
		{
			return true;
		}
		return false;
	}
}
