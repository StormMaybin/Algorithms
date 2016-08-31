package com.stormma.day5;
import java.util.Scanner;
public class MainA
{
	int [][] map = new int [101][101];
	int R, C;
	Scanner scan = null;
	int [][] count = new int [101][101];
	int ans;
	int [] dx = {-1, 1, 0, 0};//��������
	int [] dy = {0, 0, -1, 1};
	public static void main(String[] args)
	{
		new MainA().work();
	}
	public void work ()
	{
		scan = new Scanner (System.in);
		while (scan.hasNext())
		{
			R = scan.nextInt();
			C = scan.nextInt();
			ans = 0;
			for (int i = 0; i < R; i++)
				for (int j = 0; j < C; j++)
				{
					map[i][j] = scan.nextInt();
					count[i][j] = 0;
				}
			for (int i = 0; i < R; i++)
				for (int j = 0; j < C; j++)
				{
					int num = DFS(i, j, 10001);
					if (num > ans)
						ans = num;
				}
			System.out.println(ans);
		}
	}
	//���仯����
	public int DFS (int i, int j, int pre)
	{
		if (i < 0  || i >= R || j < 0 || j >= C || map[i][j] >= pre)
			return 0;
		if (count [i][j] != 0)//�������Ѿ��������ˣ��Ͳ����ټ��������ˣ����Ǽ��仯��������Ҫ��һ������
			return count[i][j];//ֱ�ӷ��ش��������ж���·����
		int xx, yy;
		int max = 1;
		for (int t = 0; t < 4; t++)//�ı䷽���������
		{
			int temp = 1;
			xx = i + dx[t];
			yy = j + dy[t];
			temp += DFS(xx, yy, map[i][j]);//����map[i][j]��������Ϊ������һ�����Ҫ�������С�������ж�
			if (temp  > max)
				max = temp;
		}
		count[i][j] = max;
		return max;
	}
}
