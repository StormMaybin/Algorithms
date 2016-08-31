package com.stormma.day_1;
import java.util.Scanner;
import java.util.Stack;
public class Main
{

	/**
	 * @param args
	 */
	public Main()
	{
		Scanner scan = new Scanner (System.in);
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<String> stack2 = new Stack<String>();
		int n;
		n = scan.nextInt();
		int num = n * (n + 1) / 2;
		init(stack1, num);
		for (int i = 1; i <= n; i++)
		{
			String str = "";
			for (int j = 1; j <= i; j++)
			{
				if (j != i)
				{
					System.out.print(stack1.peek()+"*");
					str = str + stack1.peek()+"*";
					stack1.pop();
				}
				else
				{
					System.out.println(stack1.peek());
					str = str + stack1.peek();
					stack1.pop();
				}
			}
			stack2.add(str);
		}
		while (!stack2.empty())
		{
			System.out.println(stack2.pop());
		}
	}
	public void init(Stack stack1, int n)
	{
		for (int i = n; i >= 1; i--)
			stack1.add(i);
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new Main();
	}
}
