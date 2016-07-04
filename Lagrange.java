/**
*@ author StormMaybin
*@ Date 2016-07-04
*@ descrption: 这个程序是用来练习拉格朗日插值算法
*/
import java.util.Scanner;
class  Lagrange
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//表示n组数据来拟合曲线
		int n;
		System.out.println("请输入数据对数：");
		n = scan.nextInt();
		double p = 0.0, l;
		//存储要计算的x的值
		double ans;
		//存储已知数据
		double [] x = new double [n];
		double [] y = new double [n];
		System.out.println("请输入对应组数的x和y值（格式：x0,y0）");
		for (int i = 0; i < n; i++)
		{
			x[i] = scan.nextDouble();
			y[i] = scan.nextDouble();
		}
		System.out.println("请输入要计算的x的值");
		ans = scan.nextDouble();
		for (int k = 0; k < n; k++)
		{
			//这里面的逻辑是这样的：
			//外循环（k循环）是累加
			//而内循环（j循环）是起到累乘的作用
			//因为j不能等于k，所以内循环要分成两部分来完成
			l = 1.0;
			for (int j = 0; j < k; j++)
			{
				l = l * (ans - x[j]) / (x[k] - x[j]);
			}
			for (int j = k+1; j < n; j++)
			{
				l = l * (ans - x[j]) / (x[k] - x[j]);
			}
			p = p + l * y[k];
		}
		//输出求解结果
		System.out.println("当x="+ans+"时，y为"+p);
	}
	
}
