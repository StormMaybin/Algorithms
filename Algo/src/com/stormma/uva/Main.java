package com.stormma.uva;
import java.util.Scanner;
/***
 * ���鼯���ױ���
 * @author StormMaybin
 *	˼·��������Ԫ����ɵĻ����￴����һ����a�㿪ʼb�������һ���ߣ�
 *	�����ɵ����ͼû���γ�Բ������ô��û��Σ�գ�Ϊʲô�أ���ΪԲ����
 *	��ĸ����ͱߵĸ���ǡ����ȣ�������Σ�գ����Բ��ò��鼯��ʵ��;
 */
public class Main
{
	Scanner scan = new Scanner (System.in);
	int [] fa = new int [100010];
	int x, y;
	public Main ()
	{
		while (scan.hasNext())
		{
			init();
			int ans = 0;
			x = scan.nextInt();
			while (x != -1)
			{
				y = scan.nextInt();
				int xx = find(x);
				int yy = find(y);
				if (xx == yy)
					ans++;
				else
					fa[xx] = yy;//�ϲ�
				x = scan.nextInt();
			}
			System.out.println(ans);
		}
	}
	public void init ()
	{
		for (int i = 0; i < 100010; i++)
			fa[i] = i;
	}
	public int find (int x)
	{
		if(x != fa[x])
			fa[x] = find (fa[x]);
		return fa[x];
	}
	public static void main(String[] args)
	{
		new Main();
	}

}
