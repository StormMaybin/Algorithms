package com.stormma.day11;

import java.util.Scanner;
import java.util.TreeSet;

import java.util.Iterator;

public class MainD
{
	TreeSet<Integer> tree1 = new TreeSet<Integer>();
	TreeSet<Integer> tree2 = new TreeSet<Integer>();
	Scanner scan = new Scanner(System.in);
	int n;

	public MainD()
	{
		while (scan.hasNext())
		{
			n = scan.nextInt();
			tree1.clear();
			tree2.clear();
			for (int i = 0; i < n; i++)
				tree1.add(scan.nextInt());
			for (int i = 0; i < n; i++)
				tree2.add(scan.nextInt());

			System.out.println((isSetEqual(tree1, tree2)) ? "YES" : "NO");

		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MainD();
	}

	public static boolean isSetEqual(TreeSet set1, TreeSet set2)
	{

		if (set1 == null && set2 == null)
		{
			return true; // Both are null
		}

		if (set1 == null || set2 == null || set1.size() != set2.size())
		{
			return false;
		}
		Iterator ite1 = set1.iterator();
		Iterator ite2 = set2.iterator();

		boolean isFullEqual = true;

		while (ite2.hasNext())
		{
			if (!set1.contains(ite2.next()))
			{
				isFullEqual = false;
			}
		}

		return isFullEqual;
	}
}
