package com.stormma.day9;
import java.util.Scanner;
public class MainA
{
	int [] F;
	int [] sum;
	Scanner scan = null;
	int n, m;
	int l, r, s;//l:left�����䣬r:right�����䣬s:sum��
	public MainA()
	{
		scan = new Scanner (System.in);
		while (scan.hasNext())
		{  	
			n = scan.nextInt();
			m = scan.nextInt();
			F = new int [n+2];
			sum = new int [n+2];
			//init
			for (int i = 0; i <= n; i++)
			{
				F[i] = i;
				sum[i] = 0;
			}
			//����
			int count = 0; 
			while ((m--) > 0)
			{
				l = scan.nextInt();
				r = scan.nextInt();
				s = scan.nextInt();
				l--;//��l��r�ĺͣ�����0-r�ĺͼ�ȥ0--��l-1���ĺ�
				int ra = find (l);
				int rb = find (r);
				if (ra == rb)
				{
					if (sum[l] - sum[r] != s)
						count ++;
				}//�ϲ�
				else //ra != rb˵����������ͬһ�����ϵģ���ʼ�ϲ�
				{
					if (ra > rb)//�Ƚ����� �ĸ��ڵ�Ĵ�С    С�ĺʹ�ĺϲ���һ��
					{
						F[rb] = ra;//�ı丸�ڵ�
						sum[rb] = sum[l] - s - sum[r];//��ʼ�������ľ���ֵ;
					}
					else
					{
						F[ra] = rb;
						sum[ra] = s + sum[r] - sum[l];
					}
				}
			}
			System.out.println(count);
//			for (int i = 0; i <= n; i++)
//				System.out.print(sum[i]+" ");
//			System.out.println();
//			for (int i = 0; i <= n; i++)
//				System.out.print(F[i]+" ");
//			System.out.println("\n___________________________");
//			System.out.println("0  1  2  3  4  5  6  7  8  9  10");
		}
	}
	public static void main(String[] args)
	{
		new MainA();
	}	
	public int find (int x)
	{
		if (x != F[x])
		{
			int f = F[x];//�ȱ��游�ڵ�
			F[x] = find (F[x]);//�ı��˸��׽ڵ�
			sum[x] += sum[f];//��ô��Ӧ�ľ���ҲҪ�ı� ����ɵ��µĸ��׽��֮��ľ���
		}
		return F[x];//�����������Լ��ĸ��ڵ�  ��ôֱ�ӷ���
	}
}
