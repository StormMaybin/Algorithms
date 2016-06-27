/**
*@ author StormMaybin
*@ Date 2016-06-27
*@ descrption: 这个程序是用来练习秦九韶算法
*/
import java.util.Scanner;
public class SumTest
{
	public static void main (String [] rags)
	{
		int n;
		int x;
		int sum;
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入多项式的项数");
		n = scan.nextInt();
		int [] arr = new int[n+1];
		System.out.println("请输入x的值");
		x = scan.nextInt();
		System.out.println("请输入每一项的系数");
		for (int i = 0; i <= n; i++)
		{
			arr[i] = scan.nextInt();
		}
		/*
		秦九韶算法说明a0+a1x+a2x^2+......+anx^n
		=(...(((anx+an-1)*x+an-2)*x+an-3)...)
		*/
		//开始求和
		//原理就是上面那个公式，从里向外开始求和
		sum = arr[n];
		for (int i = n-1; i >= 0; i--)
		{
			sum = sum * x + arr[i];
		}
		System.out.println("多项式的和是"+sum);
	}
}