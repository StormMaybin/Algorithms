package com.stormma.xdoj;
import java.util.Arrays;
import java.util.Scanner;
public class Main
{
	int n;
	Person [] acmer;
	class Person implements Comparable<Person>
	{
		String id;
		int rating;
		public Person (String id, int rating)
		{
			this.id = id;
			this.rating = rating;
		}
		@Override
		public int compareTo(Person o)
		{
			// TODO Auto-generated method stub
			if (this.rating != o.rating)
				return -(this.rating - o.rating);
			else
				return this.id.compareTo(o.id);
		}
	}
	public Main()
	{
		Scanner scan = new Scanner (System.in);
		while (scan.hasNext())
		{
			n = scan.nextInt();
			acmer = new Person [n];
			for (int i = 0; i < n; i++)
			{
				acmer[i] = new Person(scan.next(), scan.nextInt());
			}
			Arrays.sort(acmer);
			for (Person p : acmer)
			{
				System.out.println(p.id+" "+p.rating);
			}
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main();
	}

}
