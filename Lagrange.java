/**
*@ author StormMaybin
*@ Date 2016-07-04
*@ descrption: ���������������ϰ�������ղ�ֵ�㷨
*/
import java.util.Scanner;
class  Lagrange
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//��ʾn���������������
		int n;
		System.out.println("���������ݶ�����");
		n = scan.nextInt();
		double p = 0.0, l;
		//�洢Ҫ�����x��ֵ
		double ans;
		//�洢��֪����
		double [] x = new double [n];
		double [] y = new double [n];
		System.out.println("�������Ӧ������x��yֵ����ʽ��x0,y0��");
		for (int i = 0; i < n; i++)
		{
			x[i] = scan.nextDouble();
			y[i] = scan.nextDouble();
		}
		System.out.println("������Ҫ�����x��ֵ");
		ans = scan.nextDouble();
		for (int k = 0; k < n; k++)
		{
			//��������߼��������ģ�
			//��ѭ����kѭ�������ۼ�
			//����ѭ����jѭ���������۳˵�����
			//��Ϊj���ܵ���k��������ѭ��Ҫ�ֳ������������
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
		//��������
		System.out.println("��x="+ans+"ʱ��yΪ"+p);
	}
	
}
